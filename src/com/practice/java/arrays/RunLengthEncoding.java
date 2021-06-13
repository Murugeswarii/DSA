package com.practice.java.arrays;


public class RunLengthEncoding {
	public static void main(String[] args) {
		RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
		System.out.println(runLengthEncoding.checkRLE("A4A3B5C2", "A7B2B3C2")+"\n");
		System.out.println(runLengthEncoding.checkRLE("A4A3B5C2", "A7B2B3C1C2")+"\n");
		System.out.println(runLengthEncoding.checkRLE("A1A1A1A1A3B5C2", "A7B2B3C1C2")+"\n");
		System.out.println(runLengthEncoding.checkRLE("A1", "A1"));
	}

	private boolean checkRLE(String rle1, String rle2) {
		String rle1Encoded = encodeUniformly(rle1);
		System.out.println(rle1Encoded);
		String rle2Encoded = encodeUniformly(rle2);
		System.out.println(rle2Encoded);
		return rle1Encoded.equals(rle2Encoded);
	}

	private String encodeUniformly(String rle) {
		String encodeString = "";
		for(int i=0; i<rle.length();) {
			char letter = rle.charAt(i);
			encodeString += rle.charAt(i);
			int totalCount = 0;
			while(i < rle.length() && rle.charAt(i) == letter) {
				String countStr = "";
				i++;
				while(i < rle.length() && Character.isDigit(rle.charAt(i))) {
					countStr += rle.charAt(i++);
				}
				totalCount += Integer.parseInt(countStr);
			}
			encodeString += totalCount;
		}
		return encodeString;
	}
}
