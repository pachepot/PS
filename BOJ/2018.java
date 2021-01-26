import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, ans;

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        n = Integer.parseInt(br.readLine());
        twoPointer();

        sb.append(ans);

    }

    static void twoPointer () {

        int back=0, front=1, sum=1;

        while (true) {

            if (front==n) {
                ans++;
                break;
            }

            if (sum==n) ans++;

            if (sum<=n) sum += ++front;
            else sum -= back++;

        }

    }

    static void exit (String s) {

        System.out.println(s);
        System.exit(0);

    }

}
