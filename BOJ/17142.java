import java.io.*;
import java.util.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int N, M;
    static int min = Integer.MAX_VALUE;

    static int[][] reserch;

    static ArrayList<Point> virus = new ArrayList<>();

    static Stack<Point> stack = new Stack<>();

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        N = readInt();
        M = readInt();

        reserch = new int[N][N];

        int zeroCount=0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                reserch[i][j] = readInt();
                if (reserch[i][j] == 2) virus.add(new Point(i, j));
                if (reserch[i][j] == 0) zeroCount++;
            }
        }

        if (zeroCount==0) exit("0");

        backTracking(0);

        if (min==Integer.MAX_VALUE) sb.append("-1");
        else sb.append(min);

    }

    static void backTracking (int index) {

        if (stack.size()==M) {
            simulation();
            return;
        }

        for (int i=index; i<virus.size(); i++) {

            stack.push(virus.get(i));
            backTracking(i+1);
            stack.pop();

        }

    } // 백 트래킹

    static void simulation () {

        Queue<Point> q = new LinkedList<>();
        Queue<Integer> time = new LinkedList<>();

        int maxTime = 0;

        boolean[][] visit = new boolean[N][N];

        for (int i=0; i<M; i++) {
            int r = stack.get(i).r;
            int c = stack.get(i).c;

            reserch[r][c] = 3;
            visit[r][c] = true;
            q.offer(stack.get(i));
            time.offer(0);
        }

        loop : while (!q.isEmpty()) {

            int r = q.peek().r;
            int c = q.poll().c;
            int t = time.poll();
            maxTime = t;

            for (int i=0; i<4; i++) {

                if (0<=r+dx[i] && r+dx[i]<N && 0<=c+dy[i] && c+dy[i]<N && reserch[r+dx[i]][c+dy[i]]!=1 && !visit[r+dx[i]][c+dy[i]]) {
                    visit[r+dx[i]][c+dy[i]] = true;
                    q.offer(new Point(r+dx[i], c+dy[i]));
                    time.offer(t+1);
                }

            }

            for (int i=0; i<N; i++) for (int j=0; j<N; j++) if (reserch[i][j]==0 && !visit[i][j]) continue loop;

            maxTime++;
            break;

        }

        for (int i=0; i<M; i++) reserch[virus.get(i).r][virus.get(i).c] = 2;

        for (int i=0; i<N; i++) for (int j=0; j<N; j++) if (reserch[i][j]==0 && !visit[i][j]) maxTime = Integer.MAX_VALUE;


        if (maxTime<min) min = maxTime;

    }


    static int readInt() {
        return in.nextInt();
    }

    static long readLong() {
        return in.nextLong();
    }

    static double readDouble() {
        return in.nextDouble();
    }

    static String readLine() {
        return in.nextLine();
    }

    static String read() {
        return in.next();
    }

    static void exit (String s) {

        System.out.println(s);
        System.exit(0);

    }

}

class Point {

    int r;
    int c;

    Point (int r, int c) {

        this.r = r;
        this.c = c;

    }

}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
