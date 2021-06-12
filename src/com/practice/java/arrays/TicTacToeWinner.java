package com.practice.java.arrays;

import java.util.*;
public class TicTacToeWinner {

	int[] rows_X = new int[3];
	int[] colums_X = new int[3];
	int principalDiagonal_X = 0; 
	int antiDiagonal_X = 0;
	int[] rows_O = new int[3];
	int[] colums_O = new int[3];
	int principalDiagonal_O = 0; 
	int antiDiagonal_O = 0;	
	char player = 'X';
	int positonsOccupied = 0;

	public void playGame() {
		Scanner sc= new Scanner(System.in);
		while(true) {
			char currentPlayer = player;
			System.out.println(currentPlayer + ": Enter position: ");
			int row = sc.nextInt();
			int column = sc.nextInt();
			markPosition(row, column);
			boolean isGameOver = whoIsWinner(currentPlayer, row, column);
			if(isGameOver || positonsOccupied == 9) {
				if(positonsOccupied == 9)
					System.out.println("Game is draw!!!");
				System.out.println("Do you want to play again?");
				int choice = sc.nextInt();

				if(choice == 1) {
					initializeBoard();
				} else {
					System.out.println("Game Ends...");
					break;
				}
			}
		}
	}

	public void printBoard() {
		//Does not work in this logic
		System.out.println("   ---      ---      ---   ");
		for (int i=0; i<3; i++) {
			for (int j=0; j< 3; j++) {
				if(rows_X[i] > 0 && colums_X[j] > 0) 
					System.out.print("  | X |  ");
				else if (rows_O[i] > 0 && colums_O[j] > 0) 
					System.out.print("  | O |  ");
				else 
					System.out.print("  |   |  ");
			}
			System.out.println("\n   ---      ---      ---   ");
		}
		System.out.println();
	}

	public boolean whoIsWinner(char player, int row, int column) {
		if(player == 'X' && (rows_X[row-1] == 3 || colums_X[column-1] == 3 || principalDiagonal_X == 3 || antiDiagonal_X == 3)) {
			System.out.println("X Won!!!");
			return true;
		} else if(player == 'O' && (rows_O[row-1] == 3 || colums_O[column-1] == 3 || principalDiagonal_O == 3 || antiDiagonal_O == 3)) {
			System.out.println("O Won!!!");
			return true;
		}
		return false;
	}

	public void initializeBoard() {
		rows_X = new int[3];
		colums_X = new int[3];
		principalDiagonal_X = 0; 
		antiDiagonal_X = 0;
		rows_O = new int[3];
		colums_O = new int[3];
		principalDiagonal_O = 0; 
		antiDiagonal_O = 0;	
		player = 'X';
		positonsOccupied = 0;

	}
	public void markPosition(int row, int column) {
		if(player == 'X') {
			rows_X[row-1] +=1 ;
			colums_X[column-1] += 1;
			if(row == column) 
				principalDiagonal_X += 1;
			if(row+column == 4) {
				antiDiagonal_X += 1;
			}
			player = 'O';
		} else if(player == 'O') {
			rows_O[row-1] +=1 ;
			colums_O[column-1] += 1;
			if(row == column) 
				principalDiagonal_O += 1;
			if(row+column == 4) {
				antiDiagonal_O += 1;
			}
			player = 'X';
		}
		positonsOccupied++;
	}
	public static void main(String[] args) {
		TicTacToeWinner ticTacToeWinner = new TicTacToeWinner();
		ticTacToeWinner.playGame();
	}
}
