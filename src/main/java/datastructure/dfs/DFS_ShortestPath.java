package datastructure.dfs;

import java.util.Scanner;

public class DFS_ShortestPath {
	private static int[][] map;
	private static int min;
	private static int n;
	private static final int VISITED = 0;
	private static final int PATH = 1;
	/*	5
		1 1 1 1 1
		0 0 0 0 1
		1 1 1 1 1
		1 0 1 0 0
		1 1 1 1 1
	 */

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		scan.nextLine();
		min = n * n; // 최소값은 모든경로를 돌아다녔을 때로 초기 설정
		map = new int[n][n];
		for(int i=0; i<n; i++){
			String line = scan.nextLine();
			String[] nums = line.split(" ");
			for(int j=0; j<nums.length; j++){
				map[i][j] = Integer.parseInt(nums[j]);
			}
		}
		printMatrix();
		
		dfs(0, 0, 1);
		System.out.printf("최단 거리 : %d\n", min);
	}
	
	public static void dfs(int x, int y, int l){
		if(x == n-1 && y == n-1){ // 도착
			if(min > l){
				min = l;
			}
			return;
		}
		
		// 방문했음을 표시
		map[x][y] = VISITED;
		
		// 위, 오른쪽, 아래, 왼쪽 순 이동가능하면 이동
		if(x > 0 && map[x-1][y] != 0) dfs(x-1, y, l+1);
		if(y < map.length-1 && map[x][y+1] != 0) dfs(x, y+1, l+1);
		if(x < map.length-1 && map[x+1][y] != 0) dfs(x+1, y, l+1);
		if(y > 0 && map[x][y-1] != 0) dfs(x, y-1, l+1);
		
		map[x][y] = PATH;
	}
	
	
	public static void printMatrix(){
		for(int i=0; i<map.length; i++){
			for(int j=0; j<map[0].length; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
