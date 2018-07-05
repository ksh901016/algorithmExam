package datastructure;

import java.util.NoSuchElementException;

public class QueueImpl<T> implements Queue<T>{

	private Node<T> first;
	private Node<T> last;
	
	@Override
	public void add(T item) {
		Node<T> t = new Node<T>(item);
		if(last != null){
			last.next = t;
		}
		
		last = t;
		
		if(first == null){
			first = last;
		}
	}

	@Override
	public T remove() {
		if(last == null){
			throw new NoSuchElementException();
		}
		
		T data = first.data;
		first = first.next;
		
		if(first == null){
			last = null;
		}
		
		return data;
	}

	@Override
	public T peek() {
		if(first == null){
			throw new NoSuchElementException();
		}
		
		return first.data;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}
	
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data){
			this.data = data;
		}
	}


}
