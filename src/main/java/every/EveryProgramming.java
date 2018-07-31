package every;

import java.util.List;

public class EveryProgramming {

	private EveryProgramming(){};
	
	public static int solution1(int[] arr){
		// 정수 배열(int array)가 주어지면 가장 큰 이어지는 원소들의 합을 구하시오. 단, 시간복잡도는 O(n).
		// [-1, 3, -1, 5] => 7 (3 + (-1) + 5)
		int curSum = arr[0];
		int maxSum = arr[0];
		
		for(int i=1; i<arr.length; i++){
			curSum = Math.max(arr[i], curSum + arr[i]);
			maxSum = Math.max(curSum, maxSum);
		}
		return maxSum;
	}
	
	public static int solution2(int num){
		// 피보나치 배열은 0과 1로 시작하며, 다음 피보나치 수는 바로 앞의 두 피보나치 수의 합이 된다. 정수 N이 주어지면, N보다 작은 모든 짝수 피보나치 수의 합을 구하여라.
		// 0, 1, 1, 2, 3, 5, 8 ...
		int first = 0;
		int second = 1;
		int next = first + second;
		int sum = 0;
		while(next < num){
			if(next % 2 == 0){
				sum += next;
			}
			first = second;
			second = next;
			next = first + second;
		}
		return sum;
	}
	
	public static void solution3(List<String> ans, String cur, int open, int close, int num){
		if(cur.length() == (num * 2)){
			ans.add(cur);
			return;
		}
		
		if(open < num){
			solution3(ans, cur + "(", open +1, close, num);
		}
		
		if(open > close){
			solution3(ans, cur + ")", open, close+1, num);
		}
	}
	
	public static boolean solution4(int input){
		// 12345, 11111, 12421
		// palindrome 체크
		int revertedHalf = 0;
		if(input <0 || (input % 10 == 0 && input != 0)){
			return false;
		}
		
		while(input > revertedHalf){
			revertedHalf = (input % 10) + (revertedHalf * 10);
			input = input/10;
		}
		
		return (input == revertedHalf) || (input == revertedHalf/10);
	}
}
