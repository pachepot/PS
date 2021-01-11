import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int answer = 0;

        for (int i=0; i<5; i++) {
            int n = Integer.parseInt(st.nextToken());
            answer+= n*n;
        }

        sb.append(answer%10);
        bw.write(sb.toString());
        bw.flush();

    }

}
