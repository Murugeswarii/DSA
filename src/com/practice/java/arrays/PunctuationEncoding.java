package com.practice.java.arrays;

import java.util.HashMap;
import java.util.Map;

public class PunctuationEncoding {
	//kala.sraj should be converted to kalaDOTsraj
	//in-place algorithm assuming the source array would have enough space for encoding
	
	public static void main(String[] args) {      
		PunctuationEncoding punctuationEncoding = new PunctuationEncoding();
		System.out.println("s.?              ");
		System.out.println(punctuationEncoding.encode("s.?              ".toCharArray()));
		System.out.println("kala.sraj,kala      ");
		System.out.println(punctuationEncoding.encode("kala.sraj,kala      ".toCharArray()));
		System.out.println(".  ");
		System.out.println(punctuationEncoding.encode(".  ".toCharArray()));
		System.out.println("");
		System.out.println(punctuationEncoding.encode("".toCharArray()));
		System.out.println(".,?-                       ");
		System.out.println(punctuationEncoding.encode(".,?-                       ".toCharArray()));
		
	}

	private char[] encode(char[] cs) {
		if(cs.length == 0) {
			return cs;
		}
		Map<Character, Character[]> punctuations = new HashMap<>();
		punctuations.put('.', new Character[] {'D', 'O', 'T'});
		punctuations.put(',', new Character[] {'C', 'O', 'M', 'M', 'A'});
		punctuations.put('?', new Character[] {'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N', ' ', 'M', 'A', 'R', 'K'});
		punctuations.put('-', new Character[] {'H', 'Y', 'P', 'H', 'E', 'N'});
		int p1 = cs.length-1;
		int p2 = cs.length-1;
		while(p1>=0 && cs[p1] == ' ') {
			p1--;
		}
		while(p1>=0) {
			if(cs[p1] == '.' || cs[p1] == ',' || cs[p1] == '?' || cs[p1] == '-') {
				Character[] punctuationSpelling = punctuations.get(cs[p1]);
				for(int i=0; i<punctuationSpelling.length;i++) {
					cs[p2-(punctuationSpelling.length-i-1)] = punctuationSpelling[i];
				}
				p1--;
				p2=p2-punctuationSpelling.length;
			} else {
				cs[p2--] = cs[p1--];
			}
		}	
		return cs;
	}
}
