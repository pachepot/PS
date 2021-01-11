import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        int[] num = new int[8];

        for (int i=0; i<8; i++) num[i] = Integer.parseInt(st.nextToken());

        if (num[0]==1 && num[1]==2 && num[2]==3 && num[3]==4 && num[4]==5 && num[5]==6 && num[6]==7 && num[7]==8) sb.append("ascending");
        else if (num[0]==8 && num[1]==7 && num[2]==6 && num[3]==5 && num[4]==4 && num[5]==3 && num[6]==2 && num[7]==1) sb.append("descending");
        else sb.append("mixed");

        bw.write(sb.toString());
        bw.flush();

    }

}
