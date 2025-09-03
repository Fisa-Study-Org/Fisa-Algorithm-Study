package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon11659 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer input =  new StringTokenizer(br.readLine());
		
		int valueLength = Integer.parseInt(input.nextToken());
		int inputLength = Integer.parseInt(input.nextToken());
		int[] sumList = new int[valueLength+1];
		int[] resultList = new int[inputLength];
		

		 StringTokenizer values = new StringTokenizer(br.readLine());
		 for (int i = 1; i <= valueLength; i++) {
			 sumList[i] =  sumList[i - 1] + Integer.parseInt(values.nextToken());
		 }
		 
		 for(int i = 0; i < inputLength; i++) {

			 StringTokenizer panel = new StringTokenizer(br.readLine());
			 int start = Integer.parseInt(panel.nextToken());
			 int end = Integer.parseInt(panel.nextToken());
			 
			 resultList[i] = sumList[end] - sumList[start -1];
		 }
		 
		 for (int i : resultList) {
			System.out.println(i);
		}
		
	}

}
