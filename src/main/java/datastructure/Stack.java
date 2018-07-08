package datastructure;

public interface Stack<T> {
	public void push(T item);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public void clear();
	public void print();
}
