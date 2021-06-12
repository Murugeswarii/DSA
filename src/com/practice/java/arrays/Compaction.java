package com.practice.java.arrays;
public class Compaction {
	//Move all the running process and empty blocks to the end so that continuous blocks can be alloted next
	//Means move all non zero elements to front and zero elements to the back of the array
	
	public int[] doCompaction(int[] blocks) {
		if(blocks.length == 0) {
			return blocks;
		}
		
		//when you find non-zero element swap it with zero element (takes O(n) time and O{1) space)
		int lastZeroPosition = -1;
		for (int i=0; i< blocks.length;i++) {
			if(blocks[i] != 0) {
				swap(blocks, ++lastZeroPosition, i);
			}
		}
		printBlocks(blocks);
		return blocks;
	}
	
	public void swap(int[] array, int source, int target) {
		int temp = array[source];
		array[source] = array[target];
		array[target] = temp;
	}
	
	public void printBlocks(int[] blocks) {
		System.out.println();
		for (int i=0; i< blocks.length;i++) {
			System.out.print(blocks[i]);
		}
	}
	
	public static void main(String[] args) {
		Compaction compaction = new Compaction();
		compaction.doCompaction(new int[] {1, 2, 0, 0, 3, 0, 5});
		compaction.doCompaction(new int[] {1, 2, 3, 4, 5, 6, 7});
		compaction.doCompaction(new int[] {0, 0, 0, 0, 0, 0, 0});
		compaction.doCompaction(new int[] {0, 1, 2, 3, 4, 5, 6});
	}
}
