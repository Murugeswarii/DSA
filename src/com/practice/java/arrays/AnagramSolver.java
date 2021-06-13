package com.practice.java.arrays;

import java.util.ArrayList;
import java.util.List;

public class AnagramSolver {
	public static void main(String[] args) {
		AnagramSolver anagramSolver = new AnagramSolver();
		List<String> anagrams = anagramSolver.getValidAnagrams("AbbcdE", new String[] {"Ab", "bbAcdE", "EDcAbb"});
		anagramSolver.printAnagrams(anagrams);
	}

	private void printAnagrams(List<String> validAnagrams) {
		for (String string : validAnagrams) {
			System.out.println(string);
		}
	}

	private List<String> getValidAnagrams(String originalText, String[] args) {
		List<String> anagrams = new ArrayList<>();
		int[] asciiSymbolsInOrginalText = new int[256];
		for (int i=0; i<originalText.length(); i++) {
			asciiSymbolsInOrginalText[originalText.charAt(i)] += 1;
		}
		for (String string : args) {
			if(string.length() != originalText.length()) {
				continue;
			}
			int[] argSymbols = new int[256];
			for (int i=0; i<string.length(); i++) {
				argSymbols[string.charAt(i)] += 1;
			}
			boolean isAnagram = true;
			for (int i=0; i<asciiSymbolsInOrginalText.length; i++) {
				if(asciiSymbolsInOrginalText[i] != argSymbols[i]) {
					isAnagram = false;
					break;
				}
			}
			if(isAnagram)
				anagrams.add(string);
		}
		return anagrams;
	}
}
