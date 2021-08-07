import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int N, M;

    static int landCount = 0;

    static int[][] land;
    static int[][] square;
    static int[][] value;

    static boolean[][] visit;

    public static void main (String[] args) throws Exception {

        solve();

        bw.write(sb.toString());
        bw.flush();

    }

    static void solve () throws Exception {

        N = readInt();
        M = readInt();

        square = new int[N][M];
        value = new int[N][M];
        land = new int[N][M];
        visit = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String s = readLine();
            for (int j=0; j<M; j++) square[i][j] = s.charAt(j)-48;
        }

        for (int i=0; i<N; i++) for (int j=0; j<M; j++) BFS(i, j);

        for (int i=0; i<N; i++) {

            for (int j=0; j<M; j++) {

                ArrayList<Integer> landCheck = new ArrayList<>();

                int sum = 0;

                if (square[i][j]==0) {
                    sb.append("0");
                    continue;
                }

                else {
                    for (int k=0; k<4; k++) {
                        if (0<=i+dx[k] && i+dx[k]<N && 0<=j+dy[k] && j+dy[k]<M && !landCheck.contains(land[i+dx[k]][j+dy[k]])) {
                            landCheck.add(land[i+dx[k]][j+dy[k]]);
                            sum += value[i+dx[k]][j+dy[k]];
                        }
                    }
                }

                sb.append((sum+1)%10);

            }

            sb.append("\n");

        }

    }


    static void BFS (int r, int c) {

        if (square[r][c]==1 || visit[r][c]) return;

        landCount++;
        int count = 1;

        Queue<Point> q = new LinkedList<>();
        Queue<Point> piston = new LinkedList<>();
        q.offer(new Point(r, c));
        piston.offer(new Point(r, c));

        visit[r][c] = true;

        while (!q.isEmpty()) {

            int x = q.peek().x;
            int y = q.poll().y;

            for (int i=0; i<4; i++) {

                if (0<=x+dx[i] && x+dx[i]<N && 0<=y+dy[i] && y+dy[i]<M && square[x+dx[i]][y+dy[i]]==0 && !visit[x+dx[i]][y+dy[i]]) {
                    visit[x+dx[i]][y+dy[i]] = true;
                    count++;
                    q.offer(new Point(x+dx[i], y+dy[i]));
                    piston.offer(new Point(x+dx[i], y+dy[i]));
                }

            }

        }

        while (!piston.isEmpty()) {
            int x = piston.peek().x;
            int y = piston.poll().y;
            value[x][y] = count;
            land[x][y] = landCount;
        }

    } // BFS

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
    }

    static String read() {
        return in.next();
    }

    static void exit (String s) {

        System.out.println(s);
        System.exit(0);

    }

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

}
