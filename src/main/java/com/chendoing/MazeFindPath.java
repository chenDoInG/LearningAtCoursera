import java.util.Scanner;
import java.util.Stack;

public class MazeFindPath {
    
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        int[][] map;
        Stack<Point> mazestack;
        Point curpos;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int row = in.nextInt();
            int col = in.nextInt();
            mazestack = new Stack<Point>();
            map = new int[row][col];
            
            MazeFindPath mazeFindPath = new MazeFindPath();
            
            curpos = mazeFindPath.new Point(0, 0);
            // 生成迷宫数组
            int i, j;
            for (i = 0; i < row; i++) {
                for (j = 0; j < col; j++) {
                    map[i][j] = in.nextInt();
                }
            }
            // 从起点开始进行搜索
            do {
                if (map[curpos.x][curpos.y] == 0) {
                    // 如果当前位置可通
                    // 把当前位置压入栈中；
                    mazestack.push(curpos);
                    // 把当前位置标记为已经过，不可通过
                    if (curpos.x == col - 1 && curpos.y == col - 1) {
                        // 如果当前位置为终点，则结束算法。返回栈中存储的路径
                        break;
                    }
                    map[curpos.x][curpos.y] = 1;
                    // 依次从上下左右四个方向进行搜索
                    if (curpos.y - 1 >= 0 && map[curpos.x][curpos.y - 1] == 0) {
                        curpos = mazeFindPath.new Point(curpos.x, curpos.y - 1);
                    }// 向上搜索
                    else if (curpos.x + 1 < col
                            && map[curpos.x + 1][curpos.y] == 0) {
                        curpos = mazeFindPath.new Point(curpos.x + 1, curpos.y);
                    }
                    // 向右搜索
                    else if (curpos.y + 1 < row
                            && map[curpos.x][curpos.y + 1] == 0) {
                        curpos = mazeFindPath.new Point(curpos.x, curpos.y + 1);
                    }
                    // 向下搜索
                    else if (curpos.x - 1 >= 0
                            && map[curpos.x - 1][curpos.y] == 0) {
                        curpos = mazeFindPath.new Point(curpos.x - 1, curpos.y);
                    }
                    // 向左搜索
                    else {
                        // 四个方向都不可通过
                        continue;
                    }
                }
                // 当前位置可以通过算法的结束
                else {// 当前位置不可通过
                    if (!mazestack.empty()) {
                        // 如果栈不为空，弹栈
                        mazestack.pop();
                        // 这次弹栈的是四个方向都已经是不可以通过的位置
                    }
                    Point top = mazestack.peek();
                    map[top.x][top.y] = 0;
                    // 先恢复栈顶元素位置为可以通过,
                    // 因为下次对当前位置进行判断时需要可以通过进行搜索
                    curpos = mazeFindPath.new Point(top.x, top.y);
                    mazestack.pop();
                    // 弹出恢复之前的那个位置，因为之后还要把他压入栈一次。
                }
            } while (!mazestack.empty()
                    && !(curpos.x == col - 1 && curpos.y == row - 1));
            // 当栈不为空或者当前位置不为出口位置时，继续搜索下去
            if (mazestack.empty()) {
                // 当栈为空时，表示没有这样的路径
                System.out
                        .println("there is no such a way from these two points!");
            } else {// 找到一条这样的路径。
                Stack<Point> stackout = new Stack<Point>();
                while (!mazestack.empty()) {
                    Point temp = mazestack.peek();
                    stackout.push(temp);
                    mazestack.pop();
                }
                while (!stackout.empty()) {
                    Point temp = stackout.peek();
                    System.out.println("(" + temp.x + "," + temp.y + ")");
                    stackout.pop();
                }
            }
        }
    }
}
/*
 * 迷宫 6 6 
 * 0 1 1 1 1 1
 * 0 0 1 1 1 0
 * 0 0 0 0 1 0 
 * 1 0 0 1 1 1 
 * 1 1 0 0 0 1 
 * 1 1 0 1 0 0
 */
