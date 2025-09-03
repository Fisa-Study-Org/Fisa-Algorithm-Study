import java.io.*;
import java.util.*;

public class Baekjoon_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] A = br.readLine().toCharArray();

        int[] checkArr = new int[4]; // 최소 요구 개수
        int[] myArr = new int[4];    // 현재 윈도우 개수
        int checkSecret = 0;         // 충족 조건 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) checkSecret++; 
        }

        // 문자 -> index 매핑 배열 ('A'=0, 'C'=1, 'G'=2, 'T'=3)
        int[] map = new int[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        int result = 0;

        // 초기 윈도우
        for (int i = 0; i < P; i++) {
            int idx = map[A[i] - 'A'];
            myArr[idx]++;
            if (myArr[idx] == checkArr[idx]) checkSecret++;
        }
        if (checkSecret == 4) result++;

        // 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            int inIdx = map[A[i] - 'A'];
            int outIdx = map[A[i - P] - 'A'];

            myArr[inIdx]++;
            if (myArr[inIdx] == checkArr[inIdx]) checkSecret++;

            if (myArr[outIdx] == checkArr[outIdx]) checkSecret--;
            myArr[outIdx]--;

            if (checkSecret == 4) result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}