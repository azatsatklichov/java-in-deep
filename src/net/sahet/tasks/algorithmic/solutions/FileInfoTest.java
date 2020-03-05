package net.sahet.tasks.algorithmic.solutions;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import net.sahet.tasks.algorithmic.solutions.FileInfo.FileType;

public class FileInfoTest {

	public static void main(String[] args) {

		/*
		 * 4 lines of Words give
		 */
		var words = "my.song.mp3 11b\n" + "greatSong.flac 1000b\n" + "not3.txt 5b\n" + "video.mp4 200b\n"
				+ "game.exe 100b\n" + "mov!e.mkv 10000b\n";

		extractFileInfoByType(words);

		// words = "song.jpg 11b\n" + "greatSong.flac 1000b\n" + "not3.txt 5b\n" +
		// "video.mp4 200b\n" + "game.exe 100b\nmov!e.mkv 10000b\n";

		// "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe
		// 100b\nmov!e.mkv 10000b"
		words = "song.jpg 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b\n";

		extractFileInfoByType(words);

		words = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b";

		extractFileInfoByType(words);

	}

	private static Map<FileInfo.FileType, List<FileInfo>> groupFileInfoByType(List<FileInfo> fileInfos) {
		return fileInfos.stream().collect(groupingBy(FileInfo::getFileType));
	}

	private static void extractFileInfoByType(String words) {
		List<FileInfo> fileInfos = new ArrayList<>();
		words.lines().forEach(line -> {
			String[] split = line.split(" ");
			fileInfos.add(new FileInfo(split[0], Long.valueOf(split[1].substring(0, split[1].length() - 1))));
		});

		Map<FileType, List<FileInfo>> groupFileInfoByType = groupFileInfoByType(fileInfos);
		Set<FileType> keySet = groupFileInfoByType.keySet();
		for (FileType fileType : keySet) {
			Long totalsize = groupFileInfoByType.get(fileType).stream().map(f -> f.getSize())
					.collect(Collectors.summingLong(Long::longValue));
			System.out.println(fileType + " " + totalsize + "b");
		}

		System.out.println();
	}

}

 