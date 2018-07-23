package algorithm.maze;

import java.io.IOException;
import java.util.Stack;

public class MazeMain {

    
    public static void main(String[] args) throws IOException {
        Maze mazeUtil = new Maze();
        int maze[][] = mazeUtil.readMaze("maze.txt");
        int n = maze.length;
        mazeUtil.printMaze();
        
        
        Stack<Position> s = new Stack<Position>();
        
        // 현재 포지션 
        Position cur = new Position(0, 0);
        
        while(true) {
            maze[cur.x][cur.y] = mazeUtil.VISITED; // 현재위치를 방문했다고 표시 
            if(cur.x == n-1 && cur.y == n-1) {
                System.out.println("Found the path.");
                break;
            }
            
            boolean forwarded = false;  // 4방향 중 한 곳으로 전진하는데 성공했는지를 표시한다.
            for(int dir=0; dir<4; dir++) { // 0: N, 1: E, 2: S, 3: W
                if(mazeUtil.movable(cur, dir)) { // dir 방향으로 이동할 수 있는지 검사 
                    s.push(cur);
                    cur = mazeUtil.moveTo(cur, dir);
                    forwarded = true;
                    break;
                }
            }
            
            if(!forwarded) {
                maze[cur.x][cur.y] = mazeUtil.BACKTRACKED;
                if(s.isEmpty()) { // 빈 스택인지 검
                    System.out.println("No path exists.");
                    break;
                }
                cur = s.pop();
            }
            System.out.println();
            mazeUtil.printMaze();
        }
        System.out.println("success!");
        mazeUtil.printMaze();
    }
    
    static class Position{
        int x;
        int y;
        public Position() {}
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
