// Jalena Austin
//
// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
//
// Status:
//
// This code is 100% tested and correct


public class EightPuzzle {
	
	public EightPuzzle(int[] board) {
		boolean checkingBoard = checkReachable(board);
		if (checkingBoard == true) {
			solve(board);
		}
		else {
			System.out.println("The entered goal state is not reachable. Restart to enter another goal state.");
		}
		
	}
	
	
	private static boolean checkReachable(int[] boardCheck) {
		boolean isReachable = true;
		int inversionCount = 0;
		for(int i = 0; i < boardCheck.length - 1; i++) {
			for (int j = i + 1; j < boardCheck.length; j++) {
				if (boardCheck[i] > boardCheck[j]) {
					if ((boardCheck[i] != 0) && (boardCheck[j] != 0)) {
						inversionCount += 1;
					}
				}
				else if (boardCheck[i] < boardCheck[j]) {
					if ((boardCheck[i] != 0) && (boardCheck[j] != 0)) {
						inversionCount += 0;
					}
				}
			}
		}
		int checkInversion = inversionCount % 2;
		if (checkInversion == 0) {
			isReachable = true;
		}
		else {
			isReachable = false;
		}
		return isReachable;
	}
	
	
	private void solve(int[] solvingBoard) {
		int[] startState = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		BoardState goal = new BoardState (solvingBoard, 0, Manhattan(solvingBoard, startState), null);
		PriorityQueue open = new PriorityQueue();
		PriorityQueue close = new PriorityQueue();
		open.priorityEnqueue(new BoardState (startState, 0, Manhattan(solvingBoard, startState), null));
		boolean done = false;
		
		while (!done) {
			BoardState current = (BoardState) open.priorityDequeue();
			
			if (goal.equals(current)) {
				printPath(current);
				done = true;
			}
			
			else {
				LinkedList kids = getChildren(current.getBoard());
				close.priorityEnqueue(current);
				LinkedListNode kidTemp = kids.getHead();
				
				while(kidTemp != null) {
					int[] tempK = (int[]) kidTemp.getData();
					BoardState anotherKid = new BoardState(tempK, current.getG()+1, Manhattan(solvingBoard, tempK), current);
					
					if(!close.find(anotherKid)) {
						open.priorityEnqueue(anotherKid);
						kidTemp = kidTemp.getNext();
					}
					else {
						kidTemp = kidTemp.getNext();
					}
				}
			}
		}
	}
	
	
	private void printPath(BoardState bPrint) {
		if (bPrint != null) {
			printPath(bPrint.getParent());
			System.out.print(bPrint);
		}
	}

	
	private static LinkedList getChildren(int[] aBoard) {
		LinkedList children = new LinkedList();
		int location = 0;
		for (int i = 0; i < aBoard.length; ++i) {
			if(aBoard[i] == 0) {
				location = i;
			}
		}
		
		if (location == 0) {
			int[] child1 = new int[9];
			int[] child2 = new int[9];
			
			for (int i = 0; i < aBoard.length; ++i) {
				child1[i] = aBoard[i];
				child2[i] = aBoard[i];
			}
			
			child1[0] = child1[3];
			child1[3] = 0;
			
			child2[0] = child2[1];
			child2[1] = 0;
			
			children.insertFront(child1);
			children.insertFront(child2);				
		}
		
		else if (location == 1) {
			int[] child = new int[9];
			int[] child2 = new int[9];
			int[] child3 = new int[9];
			
			for (int i = 0; i < aBoard.length; ++i){
				child[i] = aBoard[i];
				child2[i] = aBoard[i];
 				child3[i] = aBoard[i];
			}
			
			child[1] = child[0];
			child[0] = 0;
			
			child2[1] = child2[4];
			child2[4] = 0;
			
			child3[1] = child3[2];
			child3[2] = 0;
			
			children.insertFront(child);
			children.insertFront(child2);
			children.insertFront(child3);
		}
		
		else if (location == 2) {
			int[] child = new int[9];
			int[] child2 = new int[9];
			
			for(int i = 0; i < aBoard.length; ++i) {
				child[i] = aBoard[i];
				child2[i] = aBoard[i];
			}
			
			child[2] = child[1];
			child[1] = 0;
			
			child2[2] = child2[5];
			child2[5] = 0;
			
			children.insertFront(child);
			children.insertFront(child2);
		}
		
		else if (location == 3) {
			int[] child = new int[9];
			int[] child2 = new int[9];
			int[] child3 = new int[9];
			
			for (int i = 0; i < aBoard.length; ++i){
				child[i] = aBoard[i];
				child2[i] = aBoard[i];
				child3[i] = aBoard[i];
			}
			
			child[3] = child[0];
			child[0] = 0;
			
			child2[3] = child2[4];
			child2[4] = 0;
			
			child3[3] = child3[6];
			child3[6] = 0;
			
			children.insertFront(child);
			children.insertFront(child2);
			children.insertFront(child3);
		}
		
		else if (location == 4) {
			int[] child = new int[9];
			int[] child2 = new int[9];
			int[] child3 = new int[9];
			int[] child4 = new int[9];
			
			for (int i = 0; i < aBoard.length; ++i){
				child[i] = aBoard[i];
				child2[i] = aBoard[i];
				child3[i] = aBoard[i];
				child4[i] = aBoard[i];
			}
			
			child[4] = child[3];
			child[3] = 0;
			
			child2[4] = child2[1];
			child2[1] = 0;
			
			child3[4] = child3[7];
			child3[7] = 0;
			
			child4[4] = child4[5];
			child4[5] = 0;
			
			children.insertFront(child);
			children.insertFront(child2);
			children.insertFront(child3);
			children.insertFront(child4);
		}
		
		else if (location == 5) {
			int[] child = new int[9];
			int[] child2 = new int[9];
			int[] child3 = new int[9];
			
			for (int i = 0; i < aBoard.length; ++i){
				child[i] = aBoard[i];
				child2[i] = aBoard[i];
				child3[i] = aBoard[i];
			}
			
			child[5] = child[2];
			child[2] = 0;
			
			child2[5] = child2[4];
			child2[4] = 0;
			
			child3[5] = child3[8];
			child3[8] = 0;
			
			children.insertFront(child);
			children.insertFront(child2);
			children.insertFront(child3);
		}
		
		else if (location == 6) {
			int[] child = new int[9];
			int[] child2 = new int[9];
			
			for(int i = 0; i < aBoard.length; ++i) {
				child[i] = aBoard[i];
				child2[i] = aBoard[i];
			}
			
			child[6] = child[3];
			child[3] = 0;
			
			child2[6] = child2[7];
			child2[7] = 0;
			
			children.insertFront(child);
			children.insertFront(child2);
		}
		
		else if (location == 7) {
			int[] child = new int[9];
			int[] child2 = new int[9];
			int[] child3 = new int[9];
			
			for (int i = 0; i < aBoard.length; ++i){
				child[i] = aBoard[i];
				child2[i] = aBoard[i];
				child3[i] = aBoard[i];
			}
			
			child[7] = child[4];
			child[4] = 0;
			
			child2[7] = child2[6];
			child2[6] = 0;
			
			child3[7] = child3[8];
			child3[8] = 0;
			
			children.insertFront(child);
			children.insertFront(child2);
			children.insertFront(child3);
		}
		
		else {
			int[] child = new int[9];
			int[] child2 = new int[9];
			
			for(int i = 0; i < aBoard.length; ++i) {
				child[i] = aBoard[i];
				child2[i] = aBoard[i];
			}
			
			child[8] = child[5];
			child[5] = 0;
			
			child2[8] = child2[7];
			child2[7] = 0;
			
			children.insertFront(child);
			children.insertFront(child2);
			
		}
		return children;
	}
	
	
	private static int Manhattan (int[] repBrd, int[] otherState) {
		int x1, x2, y1, y2;
		int distanceManhattan = 0;
		for(int i = 0; i < repBrd.length; i++) {
			for (int j = 0; j < repBrd.length; j++) {
				if(repBrd[i] == otherState[j]) {
					if (repBrd[i] == 0 && otherState[j] == 0) {
						continue;
					}
					else {
						x1 = i / 3;
						x2 = j / 3;
						
						y1 = i % 3;
						y2 = j % 3;
					}
					
					distanceManhattan += (Math.abs(x2 - x1)	+ Math.abs(y2 - y1));
				}
			}
		}
		return distanceManhattan;
	}
}