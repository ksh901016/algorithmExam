package datastructure;

public interface Queue<T> {
	public void add(T item);
	public T remove();
	public T peek();
	public boolean isEmpty();
}
