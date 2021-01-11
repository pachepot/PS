import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static boolean[] bit = new boolean[21];

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {

            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {

                case "add" :
                    add(Integer.parseInt(st.nextToken()));
                    break;

                case "remove" :
                    remove(Integer.parseInt(st.nextToken()));
                    break;

                case "check" :
                    check(Integer.parseInt(st.nextToken()));
                    break;

                case "toggle" :
                    toggle(Integer.parseInt(st.nextToken()));
                    break;

                case "all" :
                    all();
                    break;

                case "empty" :
                    empty();
                    break;

            }

        }

    }

    static void add (int n) { bit[n] = true; }

    static void remove (int n) { bit[n] = false; }

    static void check (int n) {

        if (bit[n]) sb.append("1"+"\n");
        else sb.append("0"+"\n");

    }

    static void toggle (int n) {

        if (bit[n]) bit[n] = false;
        else bit[n] = true;

    }

    static void all () { for (int i=1; i<=20; i++) bit[i] = true; }

    static void empty () { for (int i=1; i<=20; i++) bit[i] = false; }

}
