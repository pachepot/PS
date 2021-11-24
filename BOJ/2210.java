import java.io.*;
import java.util.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] digit;

    static Stack<Integer> stack = new Stack<>();

    static HashSet<String> set = new HashSet<>();

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        digit = new int[5][5];
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) digit[i][j] = readInt();
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) DFS(i, j);

        sb.append(set.size());

    }

    static void DFS (int r, int c) {

        if (stack.size() == 6) {

            String num = "";
            for (int i = 0; i < 6; i++) num += stack.get(i);
            set.add(num);
            return;

        }

        for (int i = 0; i < 4; i++) {

            if (0 <= r+dx[i] && r+dx[i] < 5 && 0 <= c+dy[i] && c+dy[i] < 5) {

                stack.push(digit[r+dx[i]][c+dy[i]]);
                DFS(r+dx[i], c+dy[i]);
                stack.pop();

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