package com.ssafy.IM20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2491번 수열
// 연속해서 커지거나(같은 것 포함), 혹은 연속해서 작아지는(같은 것 포함) 수열 중 가장 긴 길이 구하기

public class BOJ_2491 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연속해서 커지는 수열
		int lenBig = 1;
		int maxBig = Integer.MIN_VALUE;
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] <= arr[i]) lenBig++;
			else {
				if (maxBig < lenBig) maxBig = lenBig;
				lenBig = 1;
			}
		}
		if (maxBig < lenBig) maxBig = lenBig;
		
		// 연속해서 작아지는 수열
		int lenSmall = 1;
		int maxSmall = Integer.MIN_VALUE;
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] >= arr[i]) lenSmall++;
			else {
				if (maxSmall < lenSmall) maxSmall = lenSmall;
				lenSmall = 1;
			}
		}
		if (maxSmall < lenSmall) maxSmall = lenSmall;
		
		System.out.println(Math.max(maxBig, maxSmall));
	}

}
