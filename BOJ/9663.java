import java.io.*;
import java.util.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1};

    static int[][] cantPut;

    static int N = 0;
    static int answer = 0;

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        N = readInt();
        cantPut = new int[N][N];

        backTracking(0);

        sb.append(answer);

    }

    static void backTracking (int r) {

        if (r==N) {
            answer++;
            return;
        }

        for (int i=0; i<N; i++) {

            if (cantPut[r][i]>0) continue;

            cantPutPlus(r, i);
            backTracking(r+1);
            cantPutMinus(r, i);

        }

    } // 백 트래킹

    static void cantPutPlus (int r, int c) {

        for (int j=0; j<N; j++) {
            cantPut[r][j]++;
            cantPut[j][c]++;
        }

        for (int j=1; j<N; j++) {

            for (int k=0; k<4; k++) {

                if (0<=r+dx[k]*j && r+dx[k]*j<N && 0<=c+dy[k]*j && c+dy[k]*j<N) cantPut[r+dx[k]*j][c+dy[k]*j]++;

            }

        }

    }

    static void cantPutMinus (int r, int c) {

        for (int j=0; j<N; j++) {
            cantPut[r][j]--;
            cantPut[j][c]--;
        }

        for (int j=1; j<N; j++) {

            for (int k=0; k<4; k++) {

                if (0<=r+dx[k]*j && r+dx[k]*j<N && 0<=c+dy[k]*j && c+dy[k]*j<N) cantPut[r+dx[k]*j][c+dy[k]*j]--;

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