package com.practice.java.arrays;

public class StringEncodeDecode {
	public static void main(String[] args) {
		StringEncodeDecode stringEncodeDecode = new StringEncodeDecode();
		String encodedString = stringEncodeDecode.encode("hi hello this is text 4,four");
		System.out.println(encodedString);
		String decodedString = stringEncodeDecode.decode(encodedString);
		System.out.println(decodedString);
	}

	private String decode(String encodedString) {
		StringBuilder sb = new StringBuilder();
		String countStr = "";
		for (int i = 0; i < encodedString.length(); i++) {
			if(encodedString.charAt(i) == ',') {
				Integer count = Integer.parseInt(countStr);
				while (count > 0) {
					sb.append(encodedString.charAt(++i));
					count--;
				}
				countStr = "";
				sb.append(" ");
			} else {
				countStr+=encodedString.charAt(i);
			}
		}
		return sb.toString().trim();
	}

	private String encode(String originalString) {
		String[] words = originalString.split("\\ ");
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.append(word.length()+ ",");
			sb.append(word);
		}
		return sb.toString();
	}
}
