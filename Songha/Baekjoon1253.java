package algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputNum = Integer.parseInt(br.readLine());
        int[] valueList = new int[inputNum];

        StringTokenizer values = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputNum; i++) {
            valueList[i] = Integer.parseInt(values.nextToken());
        }

        Arrays.sort(valueList);

        int count = 0;

        for (int i = 0; i < inputNum; i++) {
            int left = 0;
            int right = inputNum - 1;

            while (left < right) {
                // 자기 자신 제외
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = valueList[left] + valueList[right];

                if (sum == valueList[i]) {
                    count++;
                    break;
                } else if (sum < valueList[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(count);
    }
}
