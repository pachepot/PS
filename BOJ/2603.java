import java.io.*;
import java.util.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int blue, white;

    static int[][] cel;

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        int n = readInt();
        cel = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) for (int j = 1; j <= n; j++) cel[i][j] = readInt();

        divedeConquer(1,1,n,n);

        sb.append(blue+"\n"+white);

    }

    static void divedeConquer (int xStart, int yStart, int xEnd, int yEnd) {

        int b = 0, w = 0, size = (xEnd-xStart+1)*(yEnd-yStart+1);

        for (int i = yStart; i <= yEnd; i++) {
            for (int j = xStart; j <= xEnd; j++) {
                if (cel[i][j]==0) b++;
                else w++;
            }
        }

        if (b==size) blue++;
        else if (w==size) white++;

        else {

            divedeConquer(xStart, yStart, xStart+(xEnd-xStart)/2, yStart+(xEnd-xStart)/2);
            divedeConquer(xStart+(xEnd-xStart+1)/2, yStart, xEnd, yStart+(xEnd-xStart)/2);
            divedeConquer(xStart, yStart+(xEnd-xStart+1)/2, xStart+(xEnd-xStart)/2, yEnd);
            divedeConquer(xStart+(xEnd-xStart+1)/2, yStart+(xEnd-xStart+1)/2, xEnd, yEnd);

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