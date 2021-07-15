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

        int n = readInt();
        int[] building = new int[n];
        for (int i=0; i<n; i++) building[i] = readInt();

        int max = -1;

        for (int i=0; i<n; i++) {

            int count = 0;

            loopLeft : for (int j=0; j<i; j++) {

                for (int k=j+1; k<i; k++) if (CCW(j, building[j], k, building[k], i, building[i])!=1) continue loopLeft;

                count++;

            }

            loopRight : for (int j=i+1; j<n; j++) {

                for (int k=i+1; k<j; k++) if (CCW(i, building[i], k, building[k], j, building[j])!=1) continue loopRight;

                count++;

            }

            if (count>max) max = count;

        }

        sb.append(max);

    }

    static int CCW (long x1, long y1, long x2, long y2, long x3, long y3) {

        long tmp = x1*y2 + x2*y3 + x3*y1;
        long tmp2 = x2*y1 + x3*y2 + x1*y3;

        long S = tmp-tmp2;

        if (S<0) return -1;
        else if (S>0) return 1;
        else return 0;


    } // CCW

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