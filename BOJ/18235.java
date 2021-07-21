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

    static boolean[] five, six;

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        N = readInt();

        five = new boolean[N+1];
        six = new boolean[N+1];

        five[readInt()] = true;
        six[readInt()] = true;

        BFS();

    }

    static void BFS () {

        int day = 0;
        int pow = 1;

        while (true) {

            day++;

            Queue<Integer> fivePlus = new LinkedList<>();
            Queue<Integer> sixPlus = new LinkedList<>();

            for (int i=0; i<=N; i++) {
                if (five[i] && 0<i-pow) fivePlus.offer(i-pow);
                if (five[i] && i+pow<=N) fivePlus.offer(i+pow);
                if (six[i] && 0<i-pow) sixPlus.offer(i-pow);
                if (six[i] && i+pow<=N) sixPlus.offer(i+pow);
            }

            for (int i=0; i<=N; i++) {
                five[i] = false;
                six[i] = false;
            }

            if (fivePlus.isEmpty() || sixPlus.isEmpty()) exit("-1");

            while (!fivePlus.isEmpty()) five[fivePlus.poll()] = true;
            while (!sixPlus.isEmpty()) six[sixPlus.poll()] = true;

            for (int i=0; i<=N; i++) if (five[i] && six[i]) exit(Integer.toString(day));

            pow *= 2;

        }

    } // BFS

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
