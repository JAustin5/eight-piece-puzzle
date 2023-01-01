// Jalena Austin
//
// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
//
// Status:
//
// This code is 100% tested and correct

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a goal state for the puzzle "
				+ "(Enter numbers 0 - 8 in goal order separated by spaces)");
		
		String[] stringBoard = scan.nextLine().split(" ");
		int[] intBoard = new int[9];
		
		for (int i = 0; i < stringBoard.length; i++) {
			intBoard[i] = Integer.parseInt(stringBoard[i]);
		}
		
		EightPuzzle goalRun = new EightPuzzle (intBoard);
	}
}