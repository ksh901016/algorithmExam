package sort;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortTest {

	int[] array = {52, 10, 26, 4, 16, 12, 9, 30, 7};
	int[] answer = {4, 7, 9, 10, 12, 16, 26, 30, 52};
	List<Integer> answerList = (List<Integer>) Arrays.asList(4, 7, 9, 10, 12, 16, 26, 30, 52);
	List<Integer> List = Arrays.asList(52, 10, 26, 4, 16, 12, 9, 30, 7);
	Sort sort = new Sort();
	
	@Test
	public void selectionSortTest() {
		System.out.println("SelectionSort");
		assertArrayEquals(answer, sort.selectionSort(array));
	}
	
	@Test
	public void bubbleSortTest(){
		System.out.println("BubbleSort");
		assertArrayEquals(answer, sort.bubbleSort(array));
	}

	@Test
	public void insertionSortTest(){
		System.out.println("InsertionSort");
		assertArrayEquals(answer, sort.insertionSort(array));
		assertArrayEquals(answerList.toArray(), sort.insertionSort2(List).toArray());
	}
	
	@Test
	public void quickSortTest(){
		System.out.println("QuickSort");
		assertArrayEquals(answer, sort.quickSort(array));
	}
	
	@Test
	public void mergeSortTest(){
		System.out.println("MergeSort");
		assertArrayEquals(answer, sort.mergeSort(array));
	}
}
