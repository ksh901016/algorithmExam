package every;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonachi {
	private Fibonachi(){};
	
	public static List<Integer> fibonachi1(int num){
		// 1 에서 n 까지의 피보나치 수열을 반환
		// 0, 1, 1, 2, 3 ...
		if(num < 0){
			throw new IllegalArgumentException();
		}
		if(num == 0)
			return new ArrayList<>();
		if(num == 1)
			return Arrays.asList(0);
		if(num == 2)
			return Arrays.asList(0, 1);
		
		List<Integer> result = new ArrayList<>();
		result.add(0);
		result.add(1);
		
		num = num - 2;
		while(num > 0){
			int a = result.get(result.size() - 2); // 맨뒤에서 첫번째
			int b = result.get(result.size() - 1); // 맨뒤
			result.add(a + b);
			num--;
		}
		
		return result;
	}
	
	public static int fibonachi2(int num){
		// n번째 값을 반환하는 메서드를 정의해라
		// 0, 1, 1, 2, 3, 5, 8 ..
		if(num <= 0){
			throw new IllegalArgumentException();
		}
		if(num == 1)
			return 0;
		if(num == 2)
			return 1;
		
		return fibonachi2(num-1) + fibonachi2(num-2);
	}
	
	public static int fibonachi3(int num){
		// 0, 1, 1, 2, 3, 5, 8 ..
		if(num <= 0){
			throw new IllegalArgumentException();
		}
		if(num == 1)
			return 0;
		if(num == 2)
			return 1;
		int first = 0;
		int second = 1;
		int result = 0;
		
		for(int i=0; i<num-2; i++){
			result = first + second;
			first = second;
			second = result;
		}
		
		return result;
	}
}
