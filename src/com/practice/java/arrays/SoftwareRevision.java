package com.practice.java.arrays;

public class SoftwareRevision {

	public String findGreater(String str1, String str2) {
		String[] str1Array = str1.split("\\.");
		String[] str2Array = str2.split("\\.");
		int length = Math.max(str1Array.length, str2Array.length);

		for (int i=0; i<length; i++) {
			int rev1 = i >=  str1Array.length ? 0 : Integer.parseInt(str1Array[i]);
			int rev2 = i >=  str2Array.length ? 0 : Integer.parseInt(str2Array[i]);

			if(rev1 != rev2) {
				if(rev1 > rev2) return str1; 
				else return str2; 
			}
		}
		return str1;
	}
	public static void main(String[] args) {
		String str1 ="1.2.3.5";
		String str2 ="1.2.3.4";
		String str3 = "1.5";
		String str4 = "1.5.1";
		SoftwareRevision softwareRevision = new SoftwareRevision();
		System.out.println("Max("+str1+", "+str2+"): "+softwareRevision.findGreater(str1, str2));
		System.out.println("Max("+str1+", "+str3+"): "+softwareRevision.findGreater(str1, str3));
		System.out.println("Max("+str3+", "+str4+"): "+softwareRevision.findGreater(str3, str4));
		System.out.println("Max("+str4+", "+str4+"): "+softwareRevision.findGreater(str4, str4));
	}
}
