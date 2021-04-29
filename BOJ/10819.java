import java.io.*;
import java.util.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int index=-1;
    static int max=-1;

    static int[] A;
    static boolean[] used;

    static Stack<Integer> stack = new Stack<>();

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        n = readInt();
        A = new int[n];
        used = new boolean[n];
        for (int i=0; i<n; i++) A[i] = readInt();

        backTracking();
        sb.append(max);

    }

    static void backTracking () {

        if (stack.size()==n) {
            int sum = 0;
            for (int i = 0; i < n-1; i++) sum+=Math.abs(stack.get(i)-stack.get(i+1));
            if (sum > max) max = sum;
            return;
        }

        for (int i=0; i<n; i++) {

            if (used[i]) continue;

            stack.push(A[i]);
            used[i] = true;
            backTracking();
            stack.pop();
            used[i] = false;

        }

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
