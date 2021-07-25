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

    static int N, M, min = Integer.MAX_VALUE;

    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();

    static Stack<Point> stack = new Stack<>();

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        N = readInt();
        M = readInt();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                int n = readInt();
                if (n==1) house.add(new Point(i, j));
                else if (n==2) chicken.add(new Point(i, j));
            }
        }

        backTracking(0);
        sb.append(min);


    }

    static void backTracking (int index) {

        if (stack.size()==M) {
            measure();
            return;
        }

        for (int i=index; i<chicken.size(); i++) {

            stack.push(chicken.get(i));
            backTracking(i+1);
            stack.pop();

        }

    } // 백 트래킹

    static void measure () {

        int range = 0;

        for (int i=0; i<house.size(); i++) {
            int m = Integer.MAX_VALUE;
            for (int j=0; j<M; j++) {
                int abs = Math.abs(house.get(i).x-stack.get(j).x)+Math.abs(house.get(i).y-stack.get(j).y);
                if (abs < m) m = abs;
            }
            range += m;
        }

        if (range<min) min = range;

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
