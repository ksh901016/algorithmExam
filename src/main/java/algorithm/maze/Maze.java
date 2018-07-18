package algorithm.maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import algorithm.maze.MazeMain.Position;

public class Maze {
    private static final Logger log = LoggerFactory.getLogger(Maze.class);
    
    public static final int PATH = 1; // 지나갈 수 있음 
    public static final int WALL = 0; // 지나갈 수 없음 
    public static final int VISITED = 2; // 이미 방문한 위치 
    public static final int BACKTRACKED = 3; // 방문했다가 되돌아 나온 위치 
    int[][] offset = {{-1, 0},
                      {0, 1},
                      {1, 0},
                      {0, -1}};
          
    int[][] maze;
    
    // .txt 파일을 읽어들여 미로를 만든다. 
    // 16
    // 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ....
    // ......
    public int[][] readMaze(String filePath) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line = "";
            boolean first = true;
            int row = 0;
            while((line = br.readLine()) != null){
                if(first) {
                    int num = Integer.parseInt(line);
                    log.debug("matrix : {}", num);
                    maze = new int[num-1][num-1];
                    first = false;
                    line = br.readLine();
                }
                
                String[] rowStr = line.split(" ");
                for(int i=0; i<rowStr.length; i++) {
                    maze[row][i] = Integer.parseInt(rowStr[i]);
                }
                row++;
            }
        }
        
        return maze;
    }
    
    public void printMaze() {
        if(maze == null) {
            throw new IllegalArgumentException("maze is null");
        }
        
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /** 이동할 수 있는지 검사 **/
    public boolean movable(Position cur, int dir) {
        // 0 ~ n-1사이에 있어야함 , 1이어야함 (PATH 이어야함)
        if(dir == 0) {
            if(cur.y-1 <= maze.length -1 && cur.y-1 >= 0 && maze[cur.y-1][cur.x] == PATH) {
                return true;
            }else {
                return false;
            }
        }else if(dir == 1) {
            if(cur.x+1 <= maze.length -1 && cur.x+1 >= 0 && maze[cur.y][cur.x+1] == PATH) {
                return true;
            }else {
                return false;
            }
        }else if(dir == 2) {
            if(cur.y+1 <= maze.length -1 && cur.y+1 >=0 && maze[cur.y+1][cur.x] == PATH) {
                return true;
            }else {
                return false;
            }
        }else {
            if(cur.x-1 <= maze.length -1 && cur.x-1 >= 0 && maze[cur.y][cur.x-1] == PATH) {
                return true;
            }else {
                return false;
            }
        }
    }
    
    /** dir 방향으로 한 칸 이동한 위치를 새로 cur이라고 함 */
    public Position moveTo(Position cur, int dir) {
        Position next = new Position();
        next.x = cur.x + offset[dir][0];
        next.y = cur.y + offset[dir][1];
        return next;
    }
    
}
