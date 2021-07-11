import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    static int l, deX, deY;

    static char[][] space;

    static boolean[][] visit;

    public static void main (String[] args) throws Exception {

        int t = readInt();
        for (int i=0; i<t; i++) solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        l = readInt();
        int r = readInt(), c = readInt();
        deX = readInt(); deY = readInt();

        if (r==deX && c==deY) {
            sb.append("0\n");
            return;
        }

        space = new char[l][l];
        visit = new boolean[l][l];

        BFS(r, c);

    }

    static void BFS (int r, int c) {

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(r, c, 0));

        visit[r][c] = true;

        loop : while (!q.isEmpty()) {

            int x = q.peek().r;
            int y = q.peek().c;
            int t = q.poll().t;

            for (int i=0; i<8; i++) {

                if (0<=x+dx[i] && x+dx[i]<l && 0<=y+dy[i] && y+dy[i]<l && !visit[x + dx[i]][y + dy[i]]) {

                    if (x+dx[i]==deX && y+dy[i]==deY) {
                        sb.append(t+1+"\n");
                        break loop;
                    }

                    visit[x + dx[i]][y + dy[i]]=true;
                    q.offer(new Node(x+dx[i], y+dy[i], t+1));

                }

            }

        }

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

    Node(int r, int c, int t) {

        this.r = r;
        this.c = c;
        this.t = t;

    }

    int r;
    int c;
    int t;

}
