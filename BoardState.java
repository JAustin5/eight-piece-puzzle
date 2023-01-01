// Jalena Austin

// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
//
// Status:
//
// This code is 100% tested and correct


public class BoardState implements Comparable{
	private int[] board;
	private int g;
	private int h;
	private BoardState parent;
	

	public BoardState(int[] board, int g, int h, BoardState parent) {
		super();
		this.board = board;
		this.g = g;
		this.h = h;
		this.parent = parent;
	}
	
	public int compareTo(Object otherBoard) {
		BoardState testBoard = (BoardState)otherBoard;
		int parentDist = this.g + this.h;
		int otherDist = testBoard.getG() + testBoard.getH();
		if (parentDist < otherDist) {
			return -1;
		}
		else if (parentDist > otherDist) {
			return 1;
		}
		else {
			return 0;
		}		
	}
	
	public String toString() {
		String boardPrt = "";
		boardPrt += "\n";
		for (int i = 0; i < this.board.length; ++i) {
			if (i == 2 || i == 5 || i == 8) {
				boardPrt += this.board[i] + "\n";
			}
			else {
				boardPrt += this.board[i] + " ";
			}
		}
		boardPrt += "-----";
		return boardPrt;
	}
	
	public boolean equals(Object equBoard) {
		BoardState equCheckStat = (BoardState) equBoard;
		boolean equalBoards = true;
	    if (this.board.length != equCheckStat.board.length) {
	        equalBoards = false;
	    }
	    for (int i=0; i <=8; i++) {
	      if (this.board[i] != equCheckStat.board[i])  {
	                equalBoards = false;
	       }
	      }
	    return equalBoards;
		}

	
	public int[] getBoard() {
		return board;
	}


	public void setBoard(int[] board) {
		this.board = board;
	}


	public int getG() {
		return g;
	}


	public void setG(int g) {
		this.g = g;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}


	public BoardState getParent() {
		return parent;
	}


	public void setParent(BoardState parent) {
		this.parent = parent;
	}
}
