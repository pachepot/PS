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
    final static int mod = 1000000007;

    static ArrayList<Integer> x = new ArrayList<>();
    static ArrayList<Integer> y = new ArrayList<>();
    static ArrayList<Integer> bx = new ArrayList<>();
    static ArrayList<Integer> by = new ArrayList<>();


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

    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
        System.out.println("]");
    } // 배열 출력

    static boolean checkPrime (long n) {
        for (int i=2; i<=Math.sqrt(n); i++) if (n%i==0) return false;
        return true;
    } // 소수 검사

    static void binarySearch (int left, int right) {

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

    } // 이분 탐색

    static void twoPointer () {

        int back=0, front=1, sum=1;

        while (true) {

            if (front==n) {
                ans++;
                break;
            }

            if (sum==n) ans++;

            if (sum<=n) sum += ++front;
            else sum -= back++;

        }

    } // 투 포인터

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
