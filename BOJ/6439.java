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

        int t = readInt();
        for (int i=0; i<t; i++) solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        int xStart = readInt(); int yStart = readInt();
        int xEnd = readInt(); int yEnd = readInt();
        int xLeft = readInt(); int yTop = readInt();
        int xRight = readInt(); int yBottom = readInt();

        if (Math.min(xLeft, xRight) < xStart && xStart < Math.max(xLeft, xRight) &&
                Math.min(xLeft, xRight) < xEnd && xEnd < Math.max(xLeft, xRight) &&
                Math.min(yBottom, yTop) < yStart && yStart < Math.max(yTop, yBottom) &&
                Math.min(yBottom, yTop) < yEnd && yEnd < Math.max(yTop, yBottom)) sb.append("T");

        else if (crossLine(xStart, yStart, xEnd, yEnd, xLeft, yTop, xRight, yTop)) sb.append("T");
        else if (crossLine(xStart, yStart, xEnd, yEnd, xLeft, yBottom, xRight, yBottom)) sb.append("T");
        else if (crossLine(xStart, yStart, xEnd, yEnd, xRight, yTop, xRight, yBottom)) sb.append("T");
        else if (crossLine(xStart, yStart, xEnd, yEnd, xLeft, yTop, xLeft, yBottom)) sb.append("T");

        else sb.append("F");

        sb.append("\n");

    }

    static int CCW (long x1, long y1, long x2, long y2, long x3, long y3) {

        long a = x2 - x1;
        long b = y2 - y1;
        long c = x3 - x1;
        long d = y3 - y1;

        long S = a*d-b*c;

        if (S>0) return 1;
        if (S<0) return -1;
        return 0;

    } // CCW

    static boolean crossLine (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

        int con1 = CCW(x1, y1, x2, y2, x3, y3);
        int con2 = CCW(x1, y1, x2, y2, x4, y4);
        int con3 = CCW(x3, y3, x4, y4, x1, y1);
        int con4 = CCW(x3, y3, x4, y4, x2, y2);

        if (((con1==1 && con2==-1) || (con1==-1 && con2==1)) && ((con3==1 && con4==-1) || (con3==-1 && con4==1))) return true;

        else if (con1==0 && Math.min(x1, x2) <= x3 && x3 <= Math.max(x1, x2) && Math.min(y1, y2) <= y3 && y3 <= Math.max(y1, y2)) return true;
        else if (con2==0 && Math.min(x1, x2) <= x4 && x4 <= Math.max(x1, x2) && Math.min(y1, y2) <= y4 && y4 <= Math.max(y1, y2)) return true;
        else if (con3==0 && Math.min(x3, x4) <= x1 && x1 <= Math.max(x3, x4) && Math.min(y3, y4) <= y1 && y1 <= Math.max(y3, y4)) return true;
        else if (con4==0 && Math.min(x3, x4) <= x2 && x2 <= Math.max(x3, x4) && Math.min(y3, y4) <= y2 && y2 <= Math.max(y3, y4)) return true;

        else return false;

    } // 선분 교차

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