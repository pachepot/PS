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

        st = new StringTokenizer(br.readLine());
        int apple = Integer.parseInt(st.nextToken());
        int banana = Integer.parseInt(st.nextToken());

        for (int i=1; i<=Math.max(apple, banana); i++) if ((apple%i==0) && (banana%i==0)) sb.append(i+" "+apple/i+" "+banana/i+"\n");

    }

}
