package net.sahet.algorithmic.solutions;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class WellStructureWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WellStructureWords w = new WellStructureWords();
		String s = "BAR";

		System.out.println(w.getWellStructuredWordsCount(s));

		s = "AABB";
		System.out.println(w.getWellStructuredWordsCount(s));

		s = "ABBAW";
		System.out.println(w.getWellStructuredWordsCount(s));
	}

	private int getWellStructuredWordsCount(String word) {

		int count = 0;
		for (String s : makeAnagramWords(word)) {
			if (isWellStructured(s)) {
				System.out.println(s);
				count++;
			}
		}
		return count;
	}

	private boolean isWellStructured(String word) {
		String[] letters = word.split("");
		// if not starts with consonant the not well structured
		if (Vowel.isVowel(letters[0])) {
			return false;
		}

		for (int i = 0; i < letters.length - 1; i++) {
			if (consecutiveVowels(letters, i) || consecutiveConsonants(letters, i)) {
				return false;
			}
		}

		return true;
	}

	private Set<String> makeAnagramWords(String s) {
		Set<String> words = new HashSet<>();
		char[] charArray = s.toCharArray();
		for (int i = 0; i < factorial(s.length()); i++) {
			words.add(new String(randomize(charArray)));
		}

		return words;

	}

	private boolean consecutiveVowels(String[] letters, int i) {
		return !isLastIndex(letters, i) && Vowel.isVowel(letters[i]) && Vowel.isVowel(letters[i + 1]);
	}

	private boolean consecutiveConsonants(String[] letters, int i) {
		return !isLastIndex(letters, i) && !Vowel.isVowel(letters[i]) && !Vowel.isVowel(letters[i + 1]);
	}

	private boolean isLastIndex(String[] letters, int i) {
		return i == letters.length - 1;
	}

	private static char[] randomize(char[] arr) {
		Random r = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int j = r.nextInt(i);
			swap(arr, i, j);
		}
		return arr;
	}

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int factorial(int n) {
		return IntStream.rangeClosed(1, n).reduce(1, (int x, int y) -> x * y);
	}

}

enum Vowel {

	A("A"), E("E"), I("I"), O("O"), U("U");

	private String letter;

	private Vowel(String letter) {
		this.letter = letter;
	}

	public String getLetter() {
		return letter;
	}

	public static boolean isVowel(String letter) {
		for (Vowel v : Vowel.values()) {
			if (letter.equals(v.getLetter())) {
				return true;
			}
		}

		return false;
	}

}