package sort;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.LinkedList;
import java.util.List;

public class Sort {

	// O(n^2)
	public int[] selectionSort(int[] array){
		int size = array.length;
		int i, j, min;
		
		for(i=0; i<size; i++){
			min = i;
			for(j=i+1; j<size; j++){
				if(array[min] > array[j]){
					min = j;
				}
			}
			
			swap(array, i, min);
		}
		printArray(array);
		return array;
	}
	
	// 최선 O(n), 최악 O(n^2)
	public int[] bubbleSort(int[] array){
		int size = array.length;
		boolean numberSwitched;
		
		do{
			numberSwitched = false;
			for(int i=0; i<size-1; i++){
				if(array[i] > array[i+1]){
					swap(array, i, i+1);
					numberSwitched = true;
				}
			}
		}while(numberSwitched);
		
		printArray(array);
		return array;
	}
	
	// 최선 O(n), 최악O(n^2)
	public int[] insertionSort(int[] array){
		int size = array.length;
		int j;
		for(int i=1; i<size; i++){
			j = i;
			int temp = array[i];
			while((j>0) && (temp < array[j-1])){
				swap(array, j, j-1);
				j--;
			}
		}
		printArray(array);
		return array;
	}
	
	// 중간에 원소 삽입이 늦으므로 LinkedList 사용
	public List<Integer> insertionSort2(final List<Integer> numbers){
		final List<Integer> sortedList = new LinkedList<>();
		
		originalList : for(int num : numbers){
			for(int i=0; i<sortedList.size(); i++){
				if(num < sortedList.get(i)){
					sortedList.add(i, num);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(), num);
		}
		for(int i=0; i<sortedList.size(); i++){
			System.out.printf("%3d", sortedList.get(i));
		}
		System.out.println();
		return sortedList;
	}
	
	// 효율적이고 빠른 방식
	// 1. 기준점 pivot 구하기
	// 2. pivot을 기준으로 left, right
	// 3. 나눠진 left, right 정렬될때까지 분할처리(재귀)
	// 평균 O(nlogn), 최악 O(n^2)
	public int[] quickSort(int[] array){
		quickSort(array, 0, array.length-1);
		printArray(array);
		return array;
	}
	
	private void quickSort(int[] array, int start, int end){
		int part2 = partition(array, start, end);
		if(start < part2 -1){
			quickSort(array, start, part2-1);
		}
		if(part2 < end){
			quickSort(array, part2, end);
		}
	}
	
	private int partition(int[] array, int start, int end){
		int pivot = array[(start+end) / 2];
		while(start <= end){
			while(array[start] < pivot) start++;
			while(array[end] > pivot) end--;
			if(start <= end){
				swap(array, start, end);
				start++;
				end--;
			}
		}
		return start;
	}
	
	// 분할 후 합병(정렬) => 공간필요
	public int[] mergeSort(int[] array){
		int[] temp = new int[array.length];
		mergeSort(array, temp, 0, array.length-1);
		printArray(array);
		return array;
	}
	
	private void mergeSort(int[] array, int[] temp, int start, int end){
		if(start < end){
			int mid = (start + end)/2;
			mergeSort(array, temp, start, mid);
			mergeSort(array, temp, mid+1, end);
			merge(array, temp, start, mid, end);
		}
	}
	// 병합
	private void merge(int[] array, int[] temp, int start, int mid, int end){
		for(int i=start; i<=end; i++){
			temp[i] = array[i];
		}
		int part1 = start;
		int part2 = mid+1;
		int index = start;
		while(part1 <= mid && part2 <= end){
			if(temp[part1] <= temp[part2]){
				array[index] = temp[part1];
				part1++;
			}else{
				array[index] = temp[part2];
				part2++;
			}
			index++;
		}
		// 나머지 데이터 삽입
		for(int i=0; i<=mid -part1; i++){
			array[index + i] = temp[part1 + i];
		}
	}
	
	
	public static void main(String[] args){
		Sort sort = new Sort();
		sort.insertionSort(new int[]{52, 10, 26, 4, 16, 12, 9, 30, 7});
	}
	
	public void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void printArray(int[] array){
		System.out.println("정렬된 값");
		for(int i=0; i<array.length; i++){
			System.out.printf("%3d", array[i]);
		}
		System.out.println();
	}
}
