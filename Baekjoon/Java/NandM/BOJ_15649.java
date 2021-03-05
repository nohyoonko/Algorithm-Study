package com.ssafy.NandM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15649 {
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
		for (int i = 0; i < N; i++)
			num[i] = i + 1;
		
		makePermutation(0, new int[M], new boolean[N]);
		System.out.println(sb.toString());
	}

	private static void makePermutation(int toSelect, int[] selected, boolean[] visited) {
		if (toSelect == M) {
			print(selected);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[toSelect] = num[i];
				makePermutation(toSelect + 1, selected, visited);
				visited[i] = false;
			}
		}
	}
	
	private static void print(int[] selected) {
		for (int i = 0; i < M; i++) {
			sb.append(selected[i]).append(" ");
		}
		sb.append("\n");
	}

}
