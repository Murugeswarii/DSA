package com.practice.java.arrays;

public class TimeToTypeOnKeyboard {
	//Keys are placed in a single row, so calculate time need needed to type a word
	//time taken to type a letter at index e from distance s is abs(s, e)
	public static void main(String[] args) {
		TimeToTypeOnKeyboard  timeToTypeOnKeyboard = new TimeToTypeOnKeyboard();
		String keyboard = "qwertyuioplkjhgfdaszxcvbnm";
		System.out.println(timeToTypeOnKeyboard.calculateTime(keyboard, "hello"));
		System.out.println(timeToTypeOnKeyboard.calculateTime(keyboard, "hi"));
		System.out.println(timeToTypeOnKeyboard.calculateTime(keyboard, "cool"));
	}

	private int calculateTime(String keyboard, String text) {
		//Ascii characters size 
		int[] invertedIndex = new int[256];
		for(int i=0; i<keyboard.length(); i++) {
			invertedIndex[keyboard.charAt(i)] = i;
		}
		int totalTime = 0;
		for(int i=1; i< text.length(); i++) {
			int currentIndex = invertedIndex[text.charAt(i)];
			int prviousIndex = invertedIndex[text.charAt(i-1)];
			totalTime += Math.abs(prviousIndex-currentIndex);
		}
		return totalTime;
	}
}
