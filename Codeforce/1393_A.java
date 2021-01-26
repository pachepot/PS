import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {

            int n = Integer.parseInt(br.readLine());

            if (n==1) sb.append("1");
            else if (n==2) sb.append("2");
            else sb.append(n/2+1);
            sb.append("\n");

        }

        bw.write(sb.toString());
        bw.flush();

    }

}
