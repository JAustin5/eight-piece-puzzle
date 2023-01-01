public interface StackInterface {

	public int size();
	public boolean isEmpty();
	public Object top() throws EmptyStackException;
	public Object pop() throws EmptyStackException;
	public void push(Object item);

	
}
