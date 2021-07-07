import java.io.*;
import java.util.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static char[][] chess;
    static int min = 100000007;

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        int N = readInt();
        int M = readInt();

        chess = new char[N][M];

        for (int i=0; i<N; i++) {
            String str = readLine();
            for (int j=0; j<M; j++) chess[i][j] = str.charAt(j);
        }

        for (int i=0; i<N-7; i++) {
            for (int j=0; j<M-7; j++) {
                check(i, j, 'B');
                check(i, j, 'W');
            }
        }

        sb.append(min);

    }

    static void check (int n, int m, char flag) {

        int count = 0;

        for (int i=n; i<n+8; i++) {
            for (int j=m; j<m+8; j++) {
                if (chess[i][j]!=flag) count++;
                flag = changeFlag(flag);
            }
            flag = changeFlag(flag);
        }

        if (count<min) min = count;

    }

    static char changeFlag (char flag) {
        if (flag == 'W') return 'B';
        else return 'W';
    }

    static int readInt() {
        return in.nextInt();
    }

    static long readLong() {
        return in.nextLong();
    }

    static Double readDouble() {
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
