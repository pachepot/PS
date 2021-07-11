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

    static int N, M, K;

    static int[][] S;

    static boolean[][] visit;

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        N = readInt(); M = readInt(); K = readInt();
        S = new int[N][M];
        for (int i=0; i<N; i++) for (int j=0; j<M; j++) S[i][j] = readInt();
        binarySearch(1, 1000000);

    }

    static void binarySearch (int left, int right) {

        int mid=(left+right)/2;

        if (left>right) {
            sb.append(mid+1);
            return;
        }

        else if (mining(mid)<K) binarySearch(mid+1,right);

        else if (mining(mid)>=K) binarySearch(left,mid-1);


    }

    static int mining (int D) {

        int sum=0;

        visit = new boolean[N][M];

        for (int i=0; i<M; i++) if (!visit[0][i] && S[0][i]<=D) sum+=BFS(0, i, D);
        for (int i=1; i<N; i++) if (!visit[i][0] && S[i][0]<=D) sum+=BFS(i, 0, D);
        for (int i=1; i<N; i++) if (!visit[i][M-1] && S[i][M-1]<=D) sum+=BFS(i, M-1, D);

        return sum;

    }

    static int BFS (int r, int c, int D) {

        int mine = 1;

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(r, c));
        visit[r][c] = true;

        while (!q.isEmpty()) {

            int x = q.peek().x;
            int y = q.poll().y;

            for (int i=0; i<4; i++) {

                if (0<=x+dx[i] && x+dx[i]<N && 0<=y+dy[i] && y+dy[i]<M && S[x+dx[i]][y+dy[i]]<=D && !visit[x + dx[i]][y + dy[i]]) {
                    visit[x + dx[i]][y + dy[i]]=true;
                    mine++;
                    q.offer(new Node(x+dx[i], y+dy[i]));
                }

            }

        }

        return mine;

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

class Node {

    Node(int x, int y) {

        this.x = x;
        this.y = y;

    }

    int x;
    int y;

}
