package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringAlgorithm {
	// 1. 주어진 문자열의 문자들이 모두 고유한지를 확인하는 함수를 구현
	// 만약 별도의 저장공간을 사용하지 못할 경우?
	
	// ASCII , UNICODE 포함하는지? 
	
	// ASCII 기본값 일때
	private static boolean isUnique(String str){
		if(str.length() > 128) return false; // 16byte
		boolean[] char_set = new boolean[128];
		
		for(int i=0; i<str.length(); i++){
			int val = str.charAt(i);
			
			if(char_set[val]){
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	// UNICODE 라면 1,114,112개
	private static boolean isUnique2(String str){
		Map<Integer, Boolean> hashMap = new HashMap<>();
		
		for(int i=0; i<str.length(); i++){
			int val = str.charAt(i);
			if(hashMap.containsKey(val)){
				return false;
			}
			hashMap.put(val, true);
		}
		
		return true;
	}
	
	// a-z : 26개만 사용하고 별도의 저장공간이 필요없다면 (bit연산자 사용)
	private static boolean isUnique3(String str){
		int checker =0;
		for(int i=0; i<str.length(); i++){
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) >0){
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
	// 2. 주어진 두개의 문자열이 서로 치환되는지를 알아내는 함수를 구현
	// 치환 => ABC, ACB, BAC (종류와 갯수가 같아야함)
	private static String sort(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	// 정렬을 이용한 방법
	private static boolean permutation(String s, String t){
		if(s.length() != t.length()) return false;
		return sort(s).equals(sort(t));
	}
	
	private static boolean permutation2(String s, String t){
		if(s.length() != t.length()) return false;
		int[] letters = new int[128];
		for(int i=0; i<s.length(); i++){
			letters[s.charAt(i)]++;
		}
		for(int i=0; i<t.length(); i++){
			letters[t.charAt(i)]--;
			if(letters[t.charAt(i)] < 0) return false;
		}
		return true;
	}
	
	// 3. 주어진 문자열의 공백을 %20으로 변환하는 함수를 구현하시오.
	// 문자열의 맨 끝에는 변환에 필요한 충분한 공백이 있고, 실제 문자열의 사이즈를 알고있음
	private static String URLify(String str, int len){
		return URLify(str.toCharArray(), len); 
	}
	private static String URLify(char[] str, int len){
		int spaces = 0;
		for(int i=0; i<len; i++){
			if(str[i] == ' ') spaces++;
		}
		
		int index = len + spaces * 2 -1;
		for(int p = len -1; p>=0; p--){
			if(str[p] == ' '){
				str[index--] = '0';
				str[index--] = '2';
				str[index--] = '%';
			}else{
				str[index--] = str[p];
			}
		}
		
		return new String(str);
	}
	
	
	// 4. 주어진 문자열이 회문(palindrome)을 만들 수 있는 문자열의 치환(permutation)인지를 확인하는 함수를 구현
	// 회문뿐만 아니라 만들 수 있는 문자열인지 검사 (mmo, omm)
	// 하나를 제외한 모든 문자들이 짝수개면 회문을 만들 수 잇음
	private static boolean isPermutationOfPalindrome(String s){
		int[] table = buildCharFrequencyTable(s);
		return checkMaxOneOdd(table);
	}
	
	private static int[] buildCharFrequencyTable(String s){
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(char c : s.toCharArray()){
			int x = getCharNumber(c);
			if(x != -1){
				table[x]++;
			}
		}
		return table;
	}
	
	private static int getCharNumber(Character c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a<= val && val <= z){
			return val - a;
		}
		return -1;
	}
	
	private static boolean checkMaxOneOdd(int[] table){
		boolean foundOdd = false;
		for(int count : table){
			if(count % 2 == 1){
				if(!foundOdd){
					foundOdd = true;
				}else{
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(isUnique("abcdefgghijk"));
		System.out.println(isUnique("abcdefghijk"));
		System.out.println(isUnique2("abcdefgghijk"));
		System.out.println(isUnique2("abcdefghijk"));
		System.out.println(isUnique3("abcdefgghijk"));
		System.out.println(isUnique3("abcdefghijk"));
		System.out.println(permutation("ABC", "BCA"));
		System.out.println(permutation("ABC", "BDA"));
		System.out.println(permutation2("ABC", "BCA"));
		System.out.println(permutation2("ABC", "BDA"));
		System.out.println(URLify("Mr John Smith    ",13));
	}
}
