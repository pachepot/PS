import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static boolean[] check;

    static String X;
    static int num;
    static int answer = 1000000;

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        X = br.readLine();
        check = new boolean[X.length()];

        backTracking(X.length(), 0);

        if (answer == 1000000) sb.append(0);
        else sb.append(answer);

    }

    static void backTracking (int max, int choose) {

        if (choose == max) {
            if (Integer.parseInt(X) < num && num < answer) answer = num;
            return;
        }

        for (int i=0; i<max; i++) {

            if (!check[i]) {
                check[i] = true;
                choose++;
                num = num*10 + X.charAt(i)-48;
                backTracking(max, choose);
                num /= 10;
                check[i] = false;
                choose--;
            }

        }

    }

}
