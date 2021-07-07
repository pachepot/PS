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

        int N = readInt();
        ArrayList<Integer> num = new ArrayList<>();

        int[] mode = new int[4001];
        int[] modeMinus = new int[4001];

        double sum = 0;

        for (int i=0; i<N; i++) {
            int n = readInt();
            num.add(n);
            sum += n;
            if (n>=0) mode[n]++;
            else modeMinus[-n]++;
        }

        Collections.sort(num);

        int max=0;
        for (int i=0; i<4001; i++) if (mode[i]>max) max = mode[i];
        for (int i=0; i<4001; i++) if (modeMinus[i]>max) max = modeMinus[i];

        ArrayList<Integer> maxes = new ArrayList<>();

        for (int i=0; i<4001; i++) if (mode[i]==max) maxes.add(i);
        for (int i=0; i<4001; i++) if (modeMinus[i]==max) maxes.add(-i);

        Collections.sort(maxes);

        sb.append(Math.round(sum/N)+"\n");
        sb.append(num.get(N/2)+"\n");
        if (maxes.size()==1) sb.append(maxes.get(0)+"\n");
        else sb.append(maxes.get(1)+"\n");
        sb.append(num.get(N-1)-num.get(0));

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
