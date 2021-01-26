import java.io.*;
import java.util.*;

public class Main {

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

        String s = br.readLine();
        char[] num = s.toCharArray();

        int sum=0;
        boolean includeZero = false;

        int[] count = new int[10];


        for (int i=0; i<num.length; i++) {

            if (num[i]=='0') includeZero = true;
            sum+=num[i];
            count[num[i]-48]++;

        }

        if (sum%3!=0 || !includeZero) exit("-1");

        StringBuilder ans = new StringBuilder();

        for (int i=9; i>=0; ) {

            if (count[i]<=0) {
                i--;
                continue;
            }

            ans.append(i);
            count[i]--;

        }

        sb.append(ans);

    }

    static void exit (String s) {

        System.out.println(s);
        System.exit(0);

    }

}
