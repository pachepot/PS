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

    static int[] dx8 = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy8 = {0, -1, -1, -1, 0, 1, 1, 1};

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

    } // Change Sort

    static void copyMultiDimensionArray (boolean[][] a, boolean[][] b, int n) {

        for (int i=0; i<n; i++) for (int j=0; j<n; j++) b[i][j] = a[i][j];

    } // Copy Array

    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
        System.out.println("]");
    } // Print Array

    static void findPrime () {

        int size = 1000000;
        boolean[] notPrime = new boolean[size+1];
        ArrayList<Integer> prime = new ArrayList<>();

        for (int i=2; i<=size; i++) {
            if (!notPrime[i]) {
                prime.add(i);
                for (int j=i; j+i<=size;) {
                    j+=i;
                    notPrime[j]=true;
                }
            }
        }

    } // Find prime

    static boolean checkPrime (long n) {
        for (int i=2; i<=Math.sqrt(n); i++) if (n%i==0) return false;
        return true;
    } // Check Prime

    static int GCD (int p, int q) {

        if(q == 0) return p;
        else return GCD(q, p%q);

    } // GCD

    static void binarySearch (int left, int right) {

        int mid=(left+right)/2;

        if (left>right) sb.append(mid);

        else if (tree(mid)>=M) binarySearch(mid+1,right);

        else binarySearch(left,mid-1);


    } // Binary Search

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

    static void DFS (int r, int c) {

        if (stack.size() == 6) {

            String num = "";
            for (int i = 0; i < 6; i++) num += stack.get(i);
            set.add(num);
            return;

        }

        for (int i = 0; i < 4; i++) {

            if (0 <= r+dx[i] && r+dx[i] < 5 && 0 <= c+dy[i] && c+dy[i] < 5) {

                stack.push(digit[r+dx[i]][c+dy[i]]);
                DFS(r+dx[i], c+dy[i]);
                stack.pop();

            }

        }

    } // DFS

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

    } // Back Tracking

    static void divedeConquer (int xStart, int yStart, int xEnd, int yEnd) {

        int b = 0, w = 0, size = (xEnd-xStart+1)*(yEnd-yStart+1);

        for (int i = yStart; i <= yEnd; i++) {
            for (int j = xStart; j <= xEnd; j++) {
                if (cel[i][j]==0) b++;
                else w++;
            }
        }

        if (b==size) blue++;
        else if (w==size) white++;

        else {

            divedeConquer(xStart, yStart, xStart+(xEnd-xStart)/2, yStart+(xEnd-xStart)/2);
            divedeConquer(xStart+(xEnd-xStart+1)/2, yStart, xEnd, yStart+(xEnd-xStart)/2);
            divedeConquer(xStart, yStart+(xEnd-xStart+1)/2, xStart+(xEnd-xStart)/2, yEnd);
            divedeConquer(xStart+(xEnd-xStart+1)/2, yStart+(xEnd-xStart+1)/2, xEnd, yEnd);

        }

    } // Divide and Conquer

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

    } // Two Pointer

    static int CCW (long x1, long y1, long x2, long y2, long x3, long y3) {

        long a = x2 - x1;
        long b = y2 - y1;
        long c = x3 - x1;
        long d = y3 - y1;

        long S = a*d-b*c;

        if (S>0) return 1;
        if (S<0) return -1;
        return 0;

    } // CCW

    static boolean crossLine (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

        int con1 = CCW(x1, y1, x2, y2, x3, y3);
        int con2 = CCW(x1, y1, x2, y2, x4, y4);
        int con3 = CCW(x3, y3, x4, y4, x1, y1);
        int con4 = CCW(x3, y3, x4, y4, x2, y2);

        if (((con1==1 && con2==-1) || (con1==-1 && con2==1)) && ((con3==1 && con4==-1) || (con3==-1 && con4==1))) return true;

        else if (con1==0 && Math.min(x1, x2) <= x3 && x3 <= Math.max(x1, x2) && Math.min(y1, y2) <= y3 && y3 <= Math.max(y1, y2)) return true;
        else if (con2==0 && Math.min(x1, x2) <= x4 && x4 <= Math.max(x1, x2) && Math.min(y1, y2) <= y4 && y4 <= Math.max(y1, y2)) return true;
        else if (con3==0 && Math.min(x3, x4) <= x1 && x1 <= Math.max(x3, x4) && Math.min(y3, y4) <= y1 && y1 <= Math.max(y3, y4)) return true;
        else if (con4==0 && Math.min(x3, x4) <= x2 && x2 <= Math.max(x3, x4) && Math.min(y3, y4) <= y2 && y2 <= Math.max(y3, y4)) return true;

        else return false;

    } // Line Intersection

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



    static int readInt() {
        return in.nextInt();
    } // Fast Reader

    static long readLong() {
        return in.nextLong();
    } // Fast Reader

    static double readDouble() {
        return in.nextDouble();
    } // Fast Reader

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

} Node
