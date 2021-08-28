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

        boolean[] notPrime = new boolean[100001];
        ArrayList<Long> prime = new ArrayList<>();
        ArrayList<Long> primeMulti = new ArrayList<>();

        for (int i=2; i<=100000; i++) {
            if (!notPrime[i]) {
                prime.add((long)i);
                for (int j=i; j+i<=100000;) {
                    j+=i;
                    notPrime[j]=true;
                }
            }
        }

        for (int i=0; i<prime.size(); i++)
            for (int j=i+1; j<prime.size(); j++)
                if ((prime.get(i)*prime.get(j))<=100001)
                    primeMulti.add(prime.get(i)*prime.get(j));


        Collections.sort(primeMulti);

        int t = readInt();
        for (int i=0; i<t; i++) {

            int k = readInt();
            for (Long aLong : primeMulti) {
                if (k <= aLong) {
                    sb.append(aLong + "\n");
                    break;
                }
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