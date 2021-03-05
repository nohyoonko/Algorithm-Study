package com.ssafy.NandM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15656 {
	static int N;
	static int M;
	static int num[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		
		N = Integer.parseInt(in[0]);
		M = Integer.parseInt(in[1]);
		
		num = new int[N];
		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(tmp[i]);
		}
		Arrays.sort(num);
		
		makePermutation(0, new int[M]);
		System.out.println(sb.toString());
	}

	private static void makePermutation(int toSelect, int[] selected) {
		if (toSelect == M) {
			print(selected);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			selected[toSelect] = num[i];
			makePermutation(toSelect + 1, selected);
		}
	}
	
	private static void print(int[] selected) {
		for (int i = 0; i < M; i++) {
			sb.append(selected[i]).append(" ");
		}
		sb.append("\n");
	}

}
