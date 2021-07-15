import java.awt.*;
import java.io.*;
import java.util.*;

public class Template {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    final static int mod = 1000000007;

    public static void main(String[] args) {

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] {0, 1, 2, 3});

    }

    static void sort() {

        Arrays.sort(cel, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
                else return Integer.compare(o1[1],o2[1]);
            }
        });

    } // 정렬 변경

    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
        System.out.println("]");
    } // 배열 출력

    static void prime () {

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

    } // 소수 찾기

    static boolean checkPrime (long n) {
        for (int i=2; i<=Math.sqrt(n); i++) if (n%i==0) return false;
        return true;
    } // 소수 검사

    static void BFS (int r, int c) {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));

        visit[r][c] = true;

        while (!q.isEmpty()) {

            int x = q.peek().x;
            int y = q.poll().y;

            for (int i=0; i<4; i++) {

                if (0<=x+dx[i] && x+dx[i]<N && 0<=y+dy[i] && y+dy[i]<M && space[x+dx[i]][y+dy[i]]==1) {
                    contact[x+dx[i]][y+dy[i]]++;
                }

                else if (0<=x+dx[i] && x+dx[i]<N && 0<=y+dy[i] && y+dy[i]<M && space[x+dx[i]][y+dy[i]]==0 &&!visit[x + dx[i]][y + dy[i]]) {
                    visit[x + dx[i]][y + dy[i]]=true;
                    q.offer(new Node(x+dx[i], y+dy[i]));
                }

            }

        }

    } // BFS

    static int GCD (int p, int q) {

        if(q == 0) return p;
        else return GCD(q, p%q);

    } // 최대 공약수

    static void binarySearch (int left, int right) {

        int mid=(left+right)/2;

        if (left>right) {
            sb.append(mid);
            return;
        }

        else if (tree(mid)>=M) binarySearch(mid+1,right);

        else if (tree(mid)<M) binarySearch(left,mid-1);


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

    static int CCW (int x1, int y1, int x2, int y2, int x3, int y3) {

        int tmp = x1*y2 + x2*y3 + x3*y1;
        int tmp2 = x2*y1 + x3*y2 + x1*y3;

        int S = tmp-tmp2;

        if (S<0) return -1;
        else if (S==0) return 0;
        else return 1;


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

    } // KMP

    static void backTracking () {

        if (stack.size()==n) {
            int sum = 0;
            for (int i = 0; i < n-1; i++) sum+=Math.abs(stack.get(i)-stack.get(i+1));
            if (sum > max) max = sum;
            return;
        }

        for (int i=0; i<n; i++) {

            if (used[i]) continue;

            stack.push(A[i]);
            used[i] = true;
            backTracking();
            stack.pop();
            used[i] = false;

        }

    } // 백 트래킹



    static int readInt() {
        return in.nextInt();
    }

    static long readLong() {
        return in.nextLong();
    }

    static double readDouble() {
        return in.nextDouble();
    }

    static String readLine() {
        return in.nextLine();
    } // Fast Reader

}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

} // Fast IO

class Node {

    Node(int r, int c, int t) {

        this.r = r;
        this.c = c;
        this.t = t;

    }

    int r;
    int c;
    int t;

} 정점
