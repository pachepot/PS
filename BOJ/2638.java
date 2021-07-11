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

    static int[][] space;
    static int[][] contact;

    static boolean[][] visit;

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        N = readInt(); M = readInt();

        space = new int[N][M];

        for (int i=0; i<N; i++) for (int j=0; j<M; j++) space[i][j] = readInt();

        int count = 0;

        while (!check(space)) {
            contact = new int[N][M];
            visit = new boolean[N][M];
            BFS(0, 0);
            melt();
            count++;
        }

        sb.append(count);

    }

    static void BFS (int r, int c) {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));

        visit[r][c] = true;

        while (!q.isEmpty()) {

            int x = q.peek().x;
            int y = q.poll().y;

            for (int i=0; i<4; i++) {

                if (0<=x+dx[i] && x+dx[i]<N && 0<=y+dy[i] && y+dy[i]<M && space[x+dx[i]][y+dy[i]]==1) {
                    contact[x+dx[i]][y+dy[i]]++;
                }

                else if (0<=x+dx[i] && x+dx[i]<N && 0<=y+dy[i] && y+dy[i]<M && space[x+dx[i]][y+dy[i]]==0 &&!visit[x + dx[i]][y + dy[i]]) {
                    visit[x + dx[i]][y + dy[i]]=true;
                    q.offer(new Node(x+dx[i], y+dy[i]));
                }

            }

        }

    }

    static boolean check (int [][] space) {

        for (int i=0; i<N; i++) for (int j=0; j<M; j++) if (space[i][j]==1) return false;
        return true;

    }

    static void melt () {

        for (int i=0; i<N; i++) for (int j=0; j<M; j++) if (contact[i][j]>=2) space[i][j] = 0;

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
