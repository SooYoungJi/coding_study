import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static long MOD = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long[] fact = new long[N + 1];

			fact[0] = 0;
			fact[1] = 1;

			for (int i = 2; i <= N; i++) {
				fact[i] = (fact[i - 1] * i) % MOD;
			}
			long bottom = (fact[N - R] * fact[R]) % MOD;
			bottom = myPow(bottom, MOD - 2);

			sb.append((fact[N] * bottom) % MOD).append("\n");
		}
		System.out.println(sb);
	}

	public static long myPow(long a, long b) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a;
		}

		if (b % 2 == 0) {
			long tmp = myPow(a, b / 2);
			return (tmp * tmp) % MOD;
		}
		
		long tmp = myPow(a, b-1) % MOD;
		return (tmp * a) % MOD;
	}

}