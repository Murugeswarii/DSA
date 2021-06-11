package com.practice.java.arrays;

public class MissingConvict {

	//Array has n numbers starting from 1 to n in unsorted order
	public int findMissingConvict(int[] convicts) {

		for(int i=0; i< convicts.length;i++) {
			while(convicts[i]-1 != i && convicts[i] != convicts.length+1) {
				swap(convicts, i, convicts[i]-1);
			}
		}
		for(int i=0; i< convicts.length;i++) {
			if(convicts[i] != i+1) return i+1;
		}
		return convicts.length+1;
	}

	public void swap(int[] convicts, int source, int target) {
		int temp = convicts[source];
		convicts[source] = convicts[target];
		convicts[target] = temp;
	}
	
	public static void main(String[] args) {
		MissingConvict missingConvict = new MissingConvict();
		System.out.println(missingConvict.findMissingConvict(new int[] {1, 2, 5, 6, 3}));
		System.out.println(missingConvict.findMissingConvict(new int[] {6, 3, 1, 5, 4}));
		System.out.println(missingConvict.findMissingConvict(new int[] {2, 1, 3, 5, 4}));
	}
}
