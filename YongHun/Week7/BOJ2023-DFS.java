import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    static int N;
    
    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	
    	DFS(1, 2);
    	DFS(1, 3);
    	DFS(1, 5);
    	DFS(1, 7);
    	
    	bw.close();
    }
    
    static void DFS(int digits, int value) throws Exception {
    	if(digits == N) {
    		bw.write(value+"\n");
    		return;
    	}
    	
    	for(int i=1; i<=9; i++) {
        	int next = value*10 + i;
        	
        	if(isPrime(next)) {
        		DFS(digits+1, next);
        	}
    	}
    }
    
    public static boolean isPrime(int n) {
    	for(int i=2; i*i<=n; i++) {
    		if(n%i==0)
    			return false;
    	}
    	return true;
    }
}