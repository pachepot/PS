import java.io.*;
import java.util.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        int N = readInt(); int r = N/2, c = N/2;
        int f = readInt();
        int move = 1;

        int[][] snail = new int[N][N];
        snail[r][c] = 1;

        while (r!=0 && c!=0) {

            for (int i=0; i<move; i++) snail[--r][c] = snail[r+1][c]+1;
            for (int i=0; i<move; i++) snail[r][++c] = snail[r][c-1]+1;
            move++;
            for (int i=0; i<move; i++) snail[++r][c] = snail[r-1][c]+1;
            for (int i=0; i<move; i++) snail[r][--c] = snail[r][c+1]+1;
            move++;

        }

        for (int i=0; i<move-1; i++) snail[--r][c] = snail[r+1][c]+1;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) sb.append(snail[i][j]+" ");
            sb.append("\n");
        }

        for (int i=0; i<N; i++) for (int j=0; j<N; j++) if (snail[i][j]==f) sb.append((i+1)+" "+(j+1));

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
