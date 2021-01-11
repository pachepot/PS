import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        int totalGrade=0, grade=1;

        String quiz = br.readLine();
        quiz = "X"+quiz;
        int len = quiz.length();
        char[] q = quiz.toCharArray();

        for (int i=1; i<len; i++) {

            if (q[i]=='O' && q[i-1]=='O') totalGrade += ++grade;
            else if (q[i]=='O' && q[i-1]=='X') totalGrade += 1;
            else grade=1;

        }

        sb.append(totalGrade+"\n");

    }

}
