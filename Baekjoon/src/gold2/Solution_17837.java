package gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_17837 {
	static int N, K;
    static int[][] map;
    static int[] di={0,0,-1,1},dj={1,-1,0,0};
    static Stack<Point>[][] s;
    static Point[] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        s = new Stack[N][N];
        points = new Point[K+1];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                s[i][j] = new Stack<Point>();
            }
        }

        Queue<Point> q = new LinkedList<>();

        for(int i=1;i<=K;i++){
            st = new StringTokenizer(br.readLine());
            int ii = Integer.parseInt(st.nextToken())-1;
            int jj = Integer.parseInt(st.nextToken())-1;
            int dd = Integer.parseInt(st.nextToken())-1;
            points[i] = new Point(i, ii, jj, dd);
            q.add(points[i]);
            s[ii][jj].add(points[i]);
        }
        //=========================입력 끝===========================
        boolean check = false;
        int answer = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Point u = q.poll();
                if(!go(u, false)){
                    check = true;
                    break;
                }
                q.add(u);
            }
            answer++;
            if(check || answer > 1000) break;
        }
        System.out.println(answer>1000?-1:answer);
    }
    public static boolean go(Point u, boolean blue){
        int ni = u.i+di[u.d];
        int nj = u.j+dj[u.d];

        if(ni >= 0 && ni < N && nj >= 0 && nj < N){
            if(map[ni][nj] == 0){
                white(u, ni, nj);
            }else if(map[ni][nj] == 1){
                red(u, ni,nj);
            }else{ //0-1, 2-3
                if(!blue){
                    if(u.d == 0) u.d = 1;
                    else if(u.d == 1) u.d = 0;
                    else if(u.d == 2) u.d = 3;
                    else u.d = 2;
                    return go(u, true);
                }
            }
        }else{
            if(!blue){
                if(u.d == 0) u.d = 1;
                else if(u.d == 1) u.d = 0;
                else if(u.d == 2) u.d = 3;
                else u.d = 2;
                return go(u, true);
            }
        }

        if(s[u.i][u.j].size() < 4) return true;
        return false;

    }
    public static void white(Point u, int ni, int nj){
        Stack<Point> temp = new Stack<Point>();
        while(!s[u.i][u.j].isEmpty()){
            Point num = s[u.i][u.j].pop();
            temp.add(num);
            if(num.equals(u)) break;
        }
        while(!temp.isEmpty()){
            Point p = temp.pop();
            p.i = ni;
            p.j = nj;
            s[ni][nj].add(p);
        }
    }
    public static void red(Point u, int ni, int nj){
        Queue<Point> temp = new LinkedList<Point>();
        while(!s[u.i][u.j].isEmpty()){
            Point num = s[u.i][u.j].pop();
            temp.add(num);
            if(num.equals(u)) break;
        }
        while(!temp.isEmpty()){
            Point p = temp.poll();
            p.i = ni;
            p.j = nj;
            s[ni][nj].add(p);
        }
    }
    static class Point{
        int num;
        int i, j, d;
        Point(int num, int i, int j, int d){
            this.num = num;
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
}
