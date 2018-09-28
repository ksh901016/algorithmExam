package datastructure.dfs;

import java.util.Scanner;

public class DFS_Graph {
	private static int n; // 정점의 총 개수
	private static int[][] map = new int[30][30]; // 인접 행렬과 방문 여부를 나타내는 배열
	private static int[] visit = new int[30];
	private static int start; // 시작 정점
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] tokens = line.split(" "); 
		n = Integer.parseInt(tokens[0]);
		start = Integer.parseInt(tokens[1]);
		
		while(true){
			String edge = scan.nextLine();
			String[] vertex = edge.split(" ");
			
			if(Integer.parseInt(vertex[0]) == -1 && Integer.parseInt(vertex[1]) == -1){
				break;
			}
			
			int vertex1 = Integer.parseInt(vertex[0]);
			int vertex2 = Integer.parseInt(vertex[1]);
			map[vertex1][vertex2] = map[vertex2][vertex1] = 1; // 정점 vertex1, vertex2가 연결되었다고 표시
		}
		
		// dfs start!
		dfs(start);
		
	}
	
	public static void dfs(int start){
		visit[start] = 1;
		for(int i=1; i<=n; i++){
			if(map[start][i] == 1 && visit[i]!= 1){
				System.out.printf("%d에서 %d로 이동\n", start, i);
				dfs(i);
			}
		}
	}
}
