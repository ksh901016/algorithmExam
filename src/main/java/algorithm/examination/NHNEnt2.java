package algorithm.examination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class NHNEnt2 {
	public static final int WALL = 0;
	public static final int PATH = 1;
	public static final int VISITED = 2;
	public static final int[][] OFFSET = {{-1, 0},{0, 1}, {1, 0}, {0, -1}}; // 북 동 남 서
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		scan.nextLine();
		int[][] matrix = new int[length][length];
		
		// make matrix
		for(int i=0; i<length; i++){
			String line = scan.nextLine();
			String[] rows = line.split(" ");
			for(int j=0; j<rows.length; j++){
				matrix[i][j] = Integer.parseInt(rows[j]);
			}
		}
		
		printMatrix(matrix);
		
		List<Integer> answerList = new ArrayList<>();
		
		// matrix 순회 (이부분 효과적으로 어떻게할까 요~?)
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j] == PATH){
					Position cur = new Position(i, j);
					answerList.add(tourMatrix(cur, matrix));
				}
			}
		}
		System.out.println();
		printMatrix(matrix);
		Collections.sort(answerList);
		System.out.println(answerList.size());
		for(int i=0; i<answerList.size(); i++){
			System.out.print(answerList.get(i));
			if(i != answerList.size() -1){
				System.out.print(" ");
			}
		}
	}
	
	public static void printMatrix(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int tourMatrix(Position cur, int[][] matrix){
		Stack<Position> s = new Stack<Position>();
		int area = 1;
		while(true){
			matrix[cur.x][cur.y] = VISITED; // 방문했음
			boolean movable = true;
			for(int dir=0; dir<4; dir++){
				if(movable(cur, dir, matrix)){
					// move
					s.push(cur);
					cur = moveTo(cur, dir);
					area++;
					movable = true;
					break;
				}else{
					movable = false;
				}
			}
			
			if(!movable){
				if(s.isEmpty()){
					System.out.println("No Path exists");
					break;
				}
				cur = s.pop();
			}
			
		}
		
		return area;
	}
	
	public static Position moveTo(Position cur, int dir){
		Position next = new Position();
		next.x = cur.x + OFFSET[dir][0];
		next.y = cur.y + OFFSET[dir][1];
		return next;
	}
	
	public static boolean movable(Position pos, int dir, int[][] matrix){
		int length = matrix.length;
		if(dir ==0){
			if(pos.x -1 >= 0 && pos.x -1 <= length-1 && matrix[pos.x-1][pos.y] == PATH){
				return true;
			}else{
				return false;
			}
		}else if(dir == 1){
			if(pos.y +1 >= 0 && pos.y +1 <= length-1 && matrix[pos.x][pos.y+1] == PATH){
				return true;
			}else{
				return false;
			}
		}else if(dir == 2){
			if(pos.x +1 >= 0 && pos.x +1 <= length-1 && matrix[pos.x+1][pos.y] == PATH){
				return true;
			}else{
				return false;
			}
		}else{
			if(pos.y -1 >= 0 && pos.y -1 <= length-1 && matrix[pos.x][pos.y-1] == PATH){
				return true;
			}else{
				return false;
			}
		}
	}
	
}

class Position{
	int x;
	int y;
	public Position(){}
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}