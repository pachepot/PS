import java.awt.*;
import java.io.*;
import java.util.*;

public class Template {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n=0;
    static int m=0;
    final static int mod = 1000000007;
    static int size=0;
    static int[][] map;

    static ArrayList<Integer> x = new ArrayList<>();
    static ArrayList<Integer> y = new ArrayList<>();
    static ArrayList<Integer> bx = new ArrayList<>();
    static ArrayList<Integer> by = new ArrayList<>();
    static ArrayList<Boolean> select = new ArrayList<>();


    public static void main(String[] args) {

        boolean[] notPrime = new boolean[4000001];
        ArrayList<Integer> prime = new ArrayList<>();

        for (int i=2; i<=4000000; i++) {
            if (!notPrime[i]) {
                prime.add(i);
                for (int j=i; j+i<=4000000;) {
                    j+=i;
                    notPrime[j]=true;
                }
            }
        }


        Queue<Point> q = new LinkedList<>();
        int[][] dot = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        int count=1;

        while (!q.isEmpty()) {

            int x = q.peek().x;
            int y = q.poll().y;

            for (int i=0; i<4; i++) {

                if (0<=x+dx[i] && x+dx[i]<n && 0<=y+dy[i] && y+dy[i]<m && !visit[x + dx[i]][y + dy[i]] && dot[x + dx[i]][y + dy[i]]==0) {

                    count++;
                    visit[x + dx[i]][y + dy[i]]=true;
                    q.offer(new Point(x+dx[i], y+dy[i]));

                }

            }

        } // bfs



        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] {0, 1, 2, 3});

    }


    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
        System.out.println("]");
    }

    static void BS (int left, int right) {

        int mid=(left+right)/2;

        if (left>right) {
            sb.append(mid+"\n");
            return;
        }

        if (sigma(mid)<=n) {
            BS(mid+1,right);
        }

        else if (sigma(mid)>n) {
            BS(left,mid-1);
        }


    }


    static long sigma (long n) {

        return n*(n+1)/2;

    }



    static void choose (int q) {

        if (size==m) {

            for (int i=0; i<bx.size(); i++) map[bx.get(i)][by.get(i)]=3;
            //bfs();
            for (int i=0; i<bx.size(); i++) map[bx.get(i)][by.get(i)]=2;

            return;
        }

        for (int i=q; i<x.size(); i++) {

            if (!select.get(i)) {
                select.set(i, true);
                size++;
                bx.add(x.get(i));
                by.add(y.get(i));

                choose(i+1);

                select.set(i, false);
                size--;
                bx.remove(bx.size()-1);
                by.remove(by.size()-1);
            }

        }

    }

    static void Check (char land[][], int startX, int startY) {

        boolean[][] visit = new boolean[n][m];
        visit[startX][startY]=true;

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> qr = new LinkedList<>();

        qx.offer(startX);
        qy.offer(startY);
        qr.offer(0);

        while (!qx.isEmpty()) {

            int x = qx.poll();
            int y = qy.poll();
            int r = qr.poll();

            for (int i=0; i<4; i++) {

                if (0<=x+dx[i] && x+dx[i]<n && 0<=y+dy[i] && y+dy[i]<m && land[x+dx[i]][y+dy[i]]=='L' && !visit[x+dx[i]][y+dy[i]]) {

                    //if (r+1>max) max = r+1;

                    visit[x+dx[i]][y+dy[i]]=true;
                    qx.offer(x+dx[i]);
                    qy.offer(y+dy[i]);
                    qr.offer(r+1);

                }

            }

        }

    }

    static boolean checkPrime (long n) {

        for (int i=2; i<=Math.sqrt(n); i++) if (n%i==0) return false;
        return true;

    }

    static boolean KMP () throws IOException {

        String s = br.readLine();
        String p = br.readLine();

        int n = s.length();
        int m = p.length();

        int[] fail = new int[m];

        for(int i=1, j=0; i<m; i++){
            while(j > 0 && p.charAt(i) != p.charAt(j)) j = fail[j-1];
            if(p.charAt(i) == p.charAt(j)) fail[i] = ++j;
        }

        for (int i=0, j=0; i<n; i++) {

            while (j>0 && s.charAt(i) != p.charAt(j)) j=fail[j-1];

            if (s.charAt(i)==p.charAt(j)) {

                if (j==m-1) {

                    return true;

                }

                else j++;

            }

        }

        return false;

    }

}
