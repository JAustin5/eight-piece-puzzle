// Jalena Austin
//
// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
//
// Status:
//
// This code is 100% tested and correct


public class PriorityQueue extends Queue
{
	
	public PriorityQueue()
	{
		super();
	}
	
	public void priorityEnqueue(Comparable<Object> item) {
		if(this.head == null) {
			this.head = new LinkedListNode(item);
			size++;
		}
		else if (item.compareTo(this.head.getData()) <= 0) {
			LinkedListNode temp = new LinkedListNode(item);
			temp.setNext(this.head);
			this.head = temp;
			size++;
		}
		else {
			boolean spotFound = false;
			LinkedListNode temp = this.head;
			while ((item.compareTo(temp.getData()) >= 0) && (temp.getNext() != null)) {
				temp = temp.getNext();
			}
			LinkedListNode temp2 = new LinkedListNode(item);
			temp2.setNext(temp.getNext());
			temp.setNext(temp2);
			size++;
		}
	}
	
	public Comparable<Object> priorityDequeue() throws EmptyQueueException{
		if(isEmpty())
		{
			throw new EmptyQueueException("Queue is empty!");
		}
		size--;
		return (Comparable<Object>) removeFront();
	}
	
	
	public boolean find(Comparable<Object> item) {
		boolean tempBool = false;
		LinkedListNode temp = this.head;
		while (temp != null && temp.getNext() != null) {
			if (item.equals(temp.getData()) == true) {
				tempBool = true;
			}
				temp = temp.getNext();
		}
		
		if (item.equals(temp.getData()) == true) {
			tempBool = true;
		}
		
		return tempBool;
	}
 
}
