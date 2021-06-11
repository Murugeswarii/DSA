package com.practice.java.arrays;

public class SongRandomizer {

	public void shuffleSong(int[] songs) {
		/* play the songs on loop */
		while(true) {
			/* have two partions in the array pendingSlot and servedSlot, 
				everytime when song is requested 
					generate a random index in the range of 0 to pendingSlot-1 and 
						reduce the pendingSlot Size
			*/
			int pendingSongsCount = songs.length;
			for(int i=0; i< songs.length; i++) {
				int nextSongIndex = (int) Math.random() * pendingSongsCount--;
				System.out.println("SONG: "+ songs[nextSongIndex]);
				swap(songs, nextSongIndex, pendingSongsCount);
			}
		System.out.println("Loading again...");
		}
	}
	
	public void swap(int[] songs, int source, int target) {
		int temp = songs[source];
		songs[source] = songs[target];
		songs[target] = temp;
	}

	public static void main(String[] args) {
		SongRandomizer songRandomizer = new SongRandomizer();
		songRandomizer.shuffleSong(new int[] {10, 20, 30, 40, 50, 60});
	}
}

