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

        int x1 = readInt(); int y1 = readInt();
        int x2 = readInt(); int y2 = readInt();
        int x3 = readInt(); int y3 = readInt();
        int x4 = readInt(); int y4 = readInt();

        int con1 = CCW(x1, y1, x2, y2, x3, y3);
        int con2 = CCW(x1, y1, x2, y2, x4, y4);
        int con3 = CCW(x3, y3, x4, y4, x1, y1);
        int con4 = CCW(x3, y3, x4, y4, x2, y2);

        if (((con1==1 && con2==-1) || (con1==-1 && con2==1)) && ((con3==1 && con4==-1) || (con3==-1 && con4==1))) sb.append("1");
        else sb.append("0");

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