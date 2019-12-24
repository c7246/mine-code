package mine.test.question;

import org.junit.Test;

public class 丑数II {
	@Test
	public void resrelt() {
		int n = 103;
		System.out.println(nthreglyNrember(n));
	}

	public int nthreglyNrember(int n) {
		int re[] = new int[n];
		int index_2 = 0;
		int index_3 = 0;
		int index_5 = 0;
		re[0] = 1;
		for (int i = 1; i < n; i++) {
			int a = 2 * re[index_2];
			int b = 3 * re[index_3];
			int c = 5 * re[index_5];
			re[i] = Math.min(Math.min(a, b), c);
			if (re[i] == a)
				index_2++;
			if (re[i] == b)
				index_3++;
			if (re[i] == c)
				index_5++;
		}
		return re[n - 1];
	}
}