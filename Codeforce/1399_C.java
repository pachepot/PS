import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int cnt=0;

    public static void main(String[] args) throws Exception {

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        int n = Integer.parseInt(br.readLine());
        int max=0;
        int[] arr = new int[n];
        boolean[] check = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int sum=2; sum<=100; sum++) {
            cnt=0;
            Arrays.fill(check, false);
            for (int i=0; i<n-1; i++) choose(arr, check, i, sum);
            if (cnt>max) max=cnt;
        }

        sb.append(max+"\n");

    }

    static void choose (int[] arr, boolean[] check , int index, int sum) {

        for (int i=index+1; i<arr.length; i++) {
            if (arr[index] + arr[i] == sum && !check[index] && !check[i]) {
                check[index] = true;
                check[i] = true;
                cnt++;
            }
        }

    }

}
