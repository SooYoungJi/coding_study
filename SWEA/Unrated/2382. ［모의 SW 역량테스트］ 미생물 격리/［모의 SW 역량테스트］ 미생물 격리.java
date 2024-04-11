

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution{

	static class Ecoli implements Comparable<Ecoli> {
		int r;
		int c;
		int num;
		int dir;

		public Ecoli(int r, int c, int num, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
		}

		@Override
		public int compareTo(Ecoli o) {
			int temp = this.r - o.r;
			if (temp == 0) {
				temp = this.c - o.c;
				if (temp == 0) {
					temp = o.num - this.num;
					return temp;
				}
			}
			return temp;
		}

		public void changeDir() {
			switch (this.dir) {
			case 0:
				this.dir = 1;
				break;
			case 1:
				this.dir = 0;
				break;
			case 2:
				this.dir = 3;
				break;
			case 3:
				this.dir = 2;
				break;
			}
		}

	}

	static int N, M, K;
	static List<Ecoli> ecoliList;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			ecoliList = new ArrayList<Ecoli>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				ecoliList.add(new Ecoli(r, c, num, dir-1));
			}
			Collections.sort(ecoliList);

			for (int i = 0; i < M; i++) {
				move();
			}
			int total = 0;
			for (int i = 0; i < ecoliList.size(); i++) {
				total += ecoliList.get(i).num;
			}
			sb.append(total).append("\n");
		}
		System.out.println(sb);
	}

	static void move() {
		for (int i = 0; i < ecoliList.size(); i++) {
			Ecoli ecoli = ecoliList.get(i);
			ecoli.r += dr[ecoli.dir];
			ecoli.c += dc[ecoli.dir];

			if (!inBound(ecoli.r, ecoli.c)) {
				ecoli.num /= 2;
				ecoli.changeDir();
				if(ecoli.num == 0) {
					ecoliList.remove(i);
					i--;
				}
			}
		}
		
		Collections.sort(ecoliList);
		
		for (int i = 0; i < ecoliList.size()-1; i++) {
			Ecoli ecoli = ecoliList.get(i);
			Ecoli nextEcoli = ecoliList.get(i+1);
			if(ecoli.r == nextEcoli.r && ecoli.c == nextEcoli.c) {
				ecoli.num += nextEcoli.num;
				ecoliList.remove(i+1);
				i--;
			}
		}
	}

	public static boolean inBound(int nr, int nc) {
		if (1 <= nr && nr < N-1 && 1 <= nc && nc < N-1)
			return true;
		else
			return false;
	}

}
