import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    static int N;
    
    public static class Pair {
    	int digits;
    	int value;
    	Pair(int digits, int value) {
    		this.digits = digits;
    		this.value = value;
    	}
    }
    
    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	
    	Queue<Pair> q = new LinkedList<>();
    	q.add(new Pair(1,2));
    	q.add(new Pair(1,3));
    	q.add(new Pair(1,5));
    	q.add(new Pair(1,7));
    	
    	while(!q.isEmpty()) {
    		
    		Pair now = q.poll();
    		
    		if(now.digits == N) {
    			bw.write(now.value+"\n");
    			continue;
    		}
    		
			for(int i=1; i<=9; i++) {
				int next = now.value*10 + i;
    			if(isPrime(next)) {
    				q.add(new Pair(now.digits+1, next));
    			}
			}
    	}
    	
    	bw.close();
    }
    
    public static boolean isPrime(int n) {
    	for(int i=2; i*i<=n; i++) {
    		if(n%i==0)
    			return false;
    	}
    	return true;
    }
}