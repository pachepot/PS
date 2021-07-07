import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static MathContext mc = new MathContext(60, RoundingMode.HALF_EVEN);
    static BigDecimal PI = new BigDecimal("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231");
    static BigDecimal two = new BigDecimal("2");

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigDecimal a = new BigDecimal(st.nextToken());
        BigDecimal b = new BigDecimal(st.nextToken());
        BigDecimal c = new BigDecimal(st.nextToken());
        BigDecimal down = new BigDecimal("-400000");
        BigDecimal up = new BigDecimal("400000");
        BigDecimal answer = new BigDecimal("0");
        BigDecimal zero = BigDecimal.ZERO;

        for (int i = 0; i < 1000; ++i) {
            answer = down.add(up, mc).divide(two, mc);
            BigDecimal v = a.multiply(answer, mc).add(b.multiply(sin(answer), mc), mc).subtract(c, mc);
            if (v.compareTo(zero) < 0) down = answer;
            else up = answer;
        }

        System.out.println(answer.setScale(6, BigDecimal.ROUND_HALF_UP));

    }

    static BigDecimal sin (BigDecimal x) {

        x = x.remainder(PI.multiply(two), mc);
        BigDecimal back = BigDecimal.ZERO;
        BigDecimal c = x;

        for (int i = 0; i < 50; ++i) {
            back = back.add(c, mc);
            c = c.multiply(x.pow(2, mc), mc).divide(BigDecimal.valueOf(-(2*i+2)*(2*i+3)), mc);
        }

        return back;
    }

}
