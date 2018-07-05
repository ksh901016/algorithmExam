package datastructure;

import java.util.EmptyStackException;

public class StackImpl<T> implements Stack<T>{
	private Node<T> top;
	
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data){
			this.data = data;
		}
	}

	@Override
	public void push(T item) {
		Node<T> t = new Node<T>(item);
		t.next = top;
		top = t;
		
	}

	@Override
	public T pop() {
		if(top == null){
			throw new EmptyStackException();
		}
		
		T temp = top.data;
		top = top.next;
		
		return temp;
	}

	@Override
	public T peek() {
		if(top == null){
			throw new EmptyStackException();
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

}
