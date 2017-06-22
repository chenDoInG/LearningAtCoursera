package com.chendoing.learning;

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
            // �����Թ�����
            int i, j;
            for (i = 0; i < row; i++) {
                for (j = 0; j < col; j++) {
                    map[i][j] = in.nextInt();
                }
            }
            // ����㿪ʼ��������
            do {
                if (map[curpos.x][curpos.y] == 0) {
                    // �����ǰλ�ÿ�ͨ
                    // �ѵ�ǰλ��ѹ��ջ�У�
                    mazestack.push(curpos);
                    // �ѵ�ǰλ�ñ��Ϊ�Ѿ���������ͨ��
                    if (curpos.x == col - 1 && curpos.y == col - 1) {
                        // �����ǰλ��Ϊ�յ㣬������㷨������ջ�д洢��·��
                        break;
                    }
                    map[curpos.x][curpos.y] = 1;
                    // ���δ����������ĸ������������
                    if (curpos.y - 1 >= 0 && map[curpos.x][curpos.y - 1] == 0) {
                        curpos = mazeFindPath.new Point(curpos.x, curpos.y - 1);
                    }// ��������
                    else if (curpos.x + 1 < col
                            && map[curpos.x + 1][curpos.y] == 0) {
                        curpos = mazeFindPath.new Point(curpos.x + 1, curpos.y);
                    }
                    // ��������
                    else if (curpos.y + 1 < row
                            && map[curpos.x][curpos.y + 1] == 0) {
                        curpos = mazeFindPath.new Point(curpos.x, curpos.y + 1);
                    }
                    // ��������
                    else if (curpos.x - 1 >= 0
                            && map[curpos.x - 1][curpos.y] == 0) {
                        curpos = mazeFindPath.new Point(curpos.x - 1, curpos.y);
                    }
                    // ��������
                    else {
                        // �ĸ����򶼲���ͨ��
                        continue;
                    }
                }
                // ��ǰλ�ÿ���ͨ���㷨�Ľ���
                else {// ��ǰλ�ò���ͨ��
                    if (!mazestack.empty()) {
                        // ���ջ��Ϊ�գ���ջ
                        mazestack.pop();
                        // ��ε�ջ�����ĸ������Ѿ��ǲ�����ͨ����λ��
                    }
                    Point top = mazestack.peek();
                    map[top.x][top.y] = 0;
                    // �Ȼָ�ջ��Ԫ��λ��Ϊ����ͨ��,
                    // ��Ϊ�´ζԵ�ǰλ�ý����ж�ʱ��Ҫ����ͨ����������
                    curpos = mazeFindPath.new Point(top.x, top.y);
                    mazestack.pop();
                    // �����ָ�֮ǰ���Ǹ�λ�ã���Ϊ֮��Ҫ����ѹ��ջһ�Ρ�
                }
            } while (!mazestack.empty()
                    && !(curpos.x == col - 1 && curpos.y == row - 1));
            // ��ջ��Ϊ�ջ��ߵ�ǰλ�ò�Ϊ����λ��ʱ������������ȥ
            if (mazestack.empty()) {
                // ��ջΪ��ʱ����ʾû��������·��
                System.out
                        .println("there is no such a way from these two points!");
            } else {// �ҵ�һ��������·����
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
 * �Թ� 6 6 
 * 0 1 1 1 1 1
 * 0 0 1 1 1 0
 * 0 0 0 0 1 0 
 * 1 0 0 1 1 1 
 * 1 1 0 0 0 1 
 * 1 1 0 1 0 0
 */
