package pilha;

public interface Stack<E> {

	public int size();

	public boolean isEmpty();

	public E top() throws EmptyStackException;

	public void push(E element);

	public E pop() throws EmptyStackException;
	
	@SuppressWarnings("serial")
	public class EmptyStackException extends RuntimeException {

	public EmptyStackException(String err) {
		super(err); }
	}
	
	@SuppressWarnings("serial")

	public class FullStackException extends RuntimeException {
		public FullStackException(String err) {
			super(err); }
	}
}
