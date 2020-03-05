package net.sahet.algorithmic.solutions;

//you can also use imports, for example:

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FileInfoTestSolution {

	public static void main(String[] args) {

		/*
		 * 4 lines of Words give
		 */
		var words = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b";

		new FileInfoTestSolution().solution(words);

	}

	public String solution(String S) {
		return extractFileInfoByType(S);
	}

	private String extractFileInfoByType(String words) {

		List<FileInfo> fileInfos = new ArrayList<>();

		for (String line : words.split("\n")) {
			String[] split = line.split(" ");
			fileInfos.add(new FileInfo(split[0], Long.valueOf(split[1].substring(0, split[1].length() - 1))));
		}

		// Java 11 way
		/*
		 * words.lines().forEach(line -> { String[] split = line.split(" ");
		 * fileInfos.add(new FileInfo(split[0], Long.valueOf(split[1].substring(0,
		 * split[1].length() - 1)))); });
		 */

		StringBuilder sb = new StringBuilder();

		Map<FileInfo.FileType, List<FileInfo>> groupFileInfoByType = groupFileInfoByType(fileInfos);
		Set<FileInfo.FileType> keySet = groupFileInfoByType.keySet();
		for (FileInfo.FileType fileType : keySet) {
			Long totalsize = groupFileInfoByType.get(fileType).stream().map(f -> f.getSize())
					.collect(Collectors.summingLong(Long::longValue));
			sb.append(fileType + " " + totalsize + "b");
			System.out.println(fileType + " " + totalsize + "b");
		}

		return sb.toString();
	}

	private Map<FileInfo.FileType, List<FileInfo>> groupFileInfoByType(List<FileInfo> fileInfos) {
		return fileInfos.stream().collect(groupingBy(FileInfo::getFileType));
	}
}

class FileInfo {
	private static final String MP3 = "mp3";
	private static final String FLAC = "flac";

	private static final String MP4 = "mp4";
	private static final String MKV = "mkv";

	private static final String JPG = "jpg";
	private static final String PNG = "png";

	private Long size;
	private String fileName;
	private FileType fileType;

	public FileInfo(String fileName, Long size) {
		this.fileName = fileName;
		this.size = size;
		this.fileType = getFileType(fileName);
	}

	private FileType getFileType(String fileName) {
		String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (MP3.equals(fileExtension) || FLAC.equals(fileExtension)) {
			return FileType.MUSIC;
		} else if (MP4.equals(fileExtension) || MKV.equals(fileExtension)) {
			return FileType.MOVIE;
		} else if (JPG.equals(fileExtension) || PNG.equals(fileExtension)) {
			return FileType.IMAGE;
		} else {
			return FileType.OTHER;
		}

	}

	public Long getSize() {
		return size;
	}

	public String getFileName() {
		return fileName;
	}

	public FileType getFileType() {
		return fileType;
	}

	@Override
	public String toString() {
		return "FileInfo [" + fileName + ", size = " + size + "]";
	}

	enum FileType {
		MUSIC, MOVIE, IMAGE, OTHER;
	}

}
