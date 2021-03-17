import java.io.DataInputStream;
import java.io.InputStream;


public class Main {
	static class Parser {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Parser(InputStream in) {
			din = new DataInputStream(in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead =  0;
		}
		public String nextString(int maxSize) {
			byte[] ch = new byte[maxSize];
			int point =  0;
			try {
				byte c = read();
				while (c == ' ' || c == '\n' || c=='\r')
					c = read();
				while (c != ' ' && c != '\n' && c!='\r') {
					ch[point++] = c;
					c = read();
				}
			} catch (Exception e) {}
			return new String(ch, 0,point);
		}
		public int nextInt() {
			int ret =  0;
			boolean neg;
			try {
				byte c = read();
				while (c <= ' ')
					c = read();
				neg = c == '-';
				if (neg)
					c = read();
				do {
					ret = ret * 10 + c - '0';
					c = read();
				} while (c > ' ');

				if (neg) return -ret;
			} catch (Exception e) {}
			return ret;
		}
		public long nextLong() {
			long ret =  0;
			boolean neg;
			try {
				byte c = read();
				while (c <= ' ')
					c = read();
				neg = c == '-';
				if (neg)
					c = read();
				do {
					ret = ret * 10 + c - '0';
					c = read();
				} while (c > ' ');

				if (neg) return -ret;
			} catch (Exception e) {}
			return ret;
		}
		private void fillBuffer() {
			try {
				bytesRead = din.read(buffer, bufferPointer =  0, BUFFER_SIZE);
			} catch (Exception e) {}
			if (bytesRead == -1) buffer[ 0] = -1;
		}

		private byte read() {
			if (bufferPointer == bytesRead) fillBuffer();
			return buffer[bufferPointer++];
		}
	}
    public static void main(String[] args) {
	Parser in = new Parser(System.in);
	int length = in.nextInt();
	int queries = in.nextInt();
	int [] array = new int[length];
	for (int i = 0;i < length;i ++) {
	    array[i] = in.nextInt();
        }
	for (int i = 0; i < queries; i++) {
        int l = -1;
        int mid;
        int r = length;
        int num = in.nextInt();
	    while (l + 1 < r) {
	        mid = (l+r)/2;
	        if (num > array[mid]) l = mid;
	        else r = mid;
        }
		if ((r < length && array[r] == num)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
    }
}
