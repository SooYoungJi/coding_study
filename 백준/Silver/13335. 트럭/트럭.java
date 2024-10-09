import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int W;
	public static int L;
	public static Deque<Integer> trucks;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		trucks = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}
		
		int time = 0;
		int currWeight = 0;
		int currNum = 0;
		Deque<Integer> Bridge = new ArrayDeque<>();
		for(int i = 0; i < W; i++) {
			Bridge.add(0);
		}
		// 다리 길이 W
		// 최대 하중 L
		
		while(true) {
			
//			System.out.println("[time] " + time);
			if(!Bridge.isEmpty()) {
				int out = Bridge.poll();
//				System.out.println("out : "+ out);

				if(out > 0) {
					currNum -= 1;
				}
				currWeight -= out;
			}else {
				if(trucks.isEmpty()) break;
				
			}
			if(!trucks.isEmpty() && currWeight + trucks.peek() <= L && currNum < W ) {
				int next = trucks.poll();
//				System.out.println("next : "+ next);
				currNum += 1;
				currWeight += next;
				Bridge.add(next);
			}else {
				if(!trucks.isEmpty()) {					
					Bridge.add(0);
				}
			}
			time += 1;
			
		}
		
		System.out.println(time);
	}

}