package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int inputNum = Integer.parseInt(br.readLine());
		int divide = Integer.parseInt(br.readLine());

		int[] valueList = new int[inputNum];

        
		// 데이터 삽입
		StringTokenizer values = new StringTokenizer(br.readLine());
        
		for (int i = 0; i < inputNum; i++) {
			int value = Integer.parseInt(values.nextToken());
			valueList[i]= value;
		}
		
        
		int count = 0;
		
		for (int i = 0; i < inputNum; i++) {
			int value = valueList[i];
			
			for (int j = i+1; j < inputNum; j++) {
				if(value + valueList[j] == divide) {
					count ++;
				}
			}
		}
		System.out.println(count);

	}

}