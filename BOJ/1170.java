import java.io.*;
import java.util.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int min = 500001;

    static boolean[] broken = new boolean[10];

    static Stack<Integer> stack = new Stack<>();

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        N = readInt();
        min = Math.abs(N-100);

        int M = readInt();
        for (int i=0; i<M; i++) broken[readInt()] = true;
        for (int i=1; i<=6; i++) backTracking(i);

        sb.append(min);

    }


    static void backTracking (int max) {

        if (stack.size()==max) {
            String s="";
            for (int i = 0; i < max; i++) s+=Integer.toString(stack.get(i));
            if (Math.abs(Integer.parseInt(s)-N)+max < min) min = Math.abs(Integer.parseInt(s)-N)+max;
            return;
        }

        for (int i=0; i<=9; i++) {

            if (broken[i]) continue;

            stack.push(i);
            backTracking(max);
            stack.pop();

        }

    } // 백 트래킹

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
