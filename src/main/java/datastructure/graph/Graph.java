package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean visit; 
		Node(int data){
			this.data = data;
			this.visit = false;
			adjacent = new LinkedList<Node>();
		}
	}
	
	Node[] nodes;
	
	Graph(int size){
		nodes = new Node[size];
		for(int i=0; i < size; i++){
			nodes[i] = new Node(i);
		}
	}
	
	// 두 노드의 관계를 정의
	void addEdge(int i1, int i2){ 
		Node n1 = nodes[i1]; 
		Node n2 = nodes[i2];
		// 두개의 노드에 인접한 노드를 서로 추가
		if(!n1.adjacent.contains(n2)){
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)){
			n2.adjacent.add(n1);
		}
	}
	
	void dfs(){
		dfs(0);
	}
	
	void dfs(int startIndex){
		Node root = nodes[startIndex];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.visit = true;
		while(!stack.isEmpty()){
			Node r = stack.pop();
			for(Node n : r.adjacent){
				if(n.visit == false){
					n.visit = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}
	
	void bfs(){
		bfs(0);
	}
	
	void bfs(int startIndex){
		Node root = nodes[startIndex];
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		root.visit = true;
		while(!queue.isEmpty()){
			Node r = queue.poll();
			for(Node n : r.adjacent){
				if(n.visit == false){
					n.visit = true;
					queue.add(n);
				}
			}
			visit(r);
		}
	}
	
	// 재귀함수를 이용한 dfs
	void dfsR(Node r){
		if(r == null) return;
		r.visit = true;
		visit(r);
		for(Node n : r.adjacent){
			dfsR(n);
		}
	}
	
	void dfsR(int startIndex){
		Node r = nodes[startIndex];
		dfsR(r);
	}
	
	void visit(Node n){
		System.out.print(n.data + " ");
	}
	
	void initVisit(){
		for(Node n : nodes){
			n.visit = false;
		}
	}
	
	boolean search(int n1, int n2){
		return search(nodes[n1], nodes[n2]);
	}
	
	// 두 지점의 경로 찾기
	boolean search(Node start, Node end){
		initVisit();
		// bfs를 사용
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(start);
		while(!queue.isEmpty()){
			Node root = queue.poll();
			if(root == end){
				return true;
			}
			
			for(Node n : root.adjacent){
				if(n.visit == false){
					n.visit = true;
					queue.add(n);
				}
			}
		}
		return false;
	}
	
	/*
	 * ------------------
	 *    0
	 *   /
	 *  1 -- 3    7
	 *  |  / | \ / 
	 *  | /  |  5
	 *  2 -- 4   \
	 *            6 - 8
	 *--------------------
	 * DFS(0)
	 * 0 1 3 5 7 6 8 4 2
	 * BFS(0)
	 * 0 1 2 3 4 5 6 7 8
	 * DFS(0) - Recursive
	 * 0 1 2 4 3 5 6 8 7
	 */
	
	public static void main(String[] args){
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		//g.dfs();
		//g.bfs();
		System.out.println(g.search(1, 8));
	}
}
