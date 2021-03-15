package source;

public class Node2<E> {
	private E element;
	private Node2<E> next;

	public Node2() { this(null, null); }

	public Node2(E e, Node2<E> n) {
		element = e;
		next = n;
	}
	
	public E getElement() { return element; }

	public Node2<E> getNext() { return next; }

	public void setElement(E newElem) { element = newElem; }

	public void setNext(Node2<E> newNext) { next = newNext; }
}