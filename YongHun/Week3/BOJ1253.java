import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;

        for(int target=0; target<N; target++) {
            int front = 0;
            int rear = N-1;

            while(front<rear) {
                if(front == target) {
                    front++;
                } else if(rear == target) {
                    rear--;
                } else {
                    int num = arr[front] + arr[rear];

                    if(num == arr[target]) {
                        answer++;
                        front++;
                        rear--;
                        break;
                    } else if(num < arr[target]) {
                        front++;
                    } else if(num > arr[target]) {
                        rear--;
                    }
                }
            }
        }

        bw.write(answer+"");
        bw.close();
    }
}
