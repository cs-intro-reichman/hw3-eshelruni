// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
		// System.out.println(plus(2,3));   // 2 + 3 = 5
		// System.out.println(plus(2, -3)); // 2 + -3 = -1
		// System.out.println(plus(2, 0)); // 2 + 0 = 2
		// System.out.println(plus(0, 3)); // 0 + 3 = 3
		// System.out.println(plus(-2, 1)); // -2 + 1 = -1
		// System.out.println(plus(-2, -1)); // -2 + -1 = -3
	    // System.out.println(minus(7,2));  // 7 - 2 = 5
		// System.out.println(minus(2, 7)); // 2 - 7 = -5
		// System.out.println(minus(2,0));  // 2 - 0 = 2
		// System.out.println(minus(2, -7)); // 2 - -7 = 9
		// System.out.println(minus(-2, 7)); // -2 - 7 = -9
		// System.out.println(minus(-2, -7)); // -2 - -7 = 5
		// System.out.println(times(3, 4)); // 3 * 4 = 12
		// System.out.println(times(3, -4)); // 3 * -4 = -12
		// System.out.println(times(-3, 4)); // -3 * 4 = -12
		// System.out.println(times(-3, -4)); // -3 * -4 = 12
		// System.out.println(times(3, 0)); // 3 * 0 = 0
		// System.out.println(times(0, 4)); // 0 * 4 = 0
   		// System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
		// System.out.println(pow(5, 3)); // 5^3 = 125
		// System.out.println(pow(3,5)); // 3^5 = 243
		// System.out.println(pow(-5, 3)); // -5^3 = -125
   		// System.out.println(div(12,3));   // 12 / 3 = 4    
   		// System.out.println(div(5,5));    // 5 / 5 = 1
		// System.out.println(div(25, 7)); // 25 / 7 = 3
		// System.out.println(div(120, -6)); // 120 / -6 = -20
		// System.out.println(div(-120, 6)); // -120 / 6 = -20
		// System.out.println(div(-120, -6)); // -120 / -6 = 20
		// System.out.println(div(0, 6)); // 0 / 6 = 0
		// System.out.println(mod(25, 7)); // 25 % 7 = 4
		// System.out.println(mod(25, -7)); // 25 % -7 = 4
		// System.out.println(mod(-25, 7)); // -25 % 7 = -4
		// System.out.println(mod(-25, -7)); // -25 % -7 = -4
		// System.out.println(mod(120, -6)); // 120 % -6 = 0
		// System.out.println(mod(120, 6)); // 120 % 6 = 0 
   		// System.out.println(sqrt(36)); // sqrt(36) = 6
		// System.out.println(sqrt(263169)); // sqrt(263169) = 513
		// System.out.println(sqrt(76123)); // sqrt(76123) = 275
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				x1--;
			}
			return x1;
		}
		else {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
			return x1;
		}
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				x1++;
			}
			return x1;
		}
		else {
			for (int i = 0; i < x2; i++) {
				x1--;
			}
			return x1;
		}
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0) {
			return 0;
		}
		boolean isNegative = (x1 < 0) ^ (x2 < 0);
		if (x1 < 0) {
			x1 = minus(0, x1);
		}
		if (x2 < 0) {
			x2 = minus(0, x2);
		}
		Integer result = 0;
		for (int i = 0; i < x2; i++) {
			result = plus(result, x1);
		}
		if (isNegative) {
			result = minus(0, result);
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		}
		Boolean isNegative = false;
		Boolean isOdd = mod(n, 2) == 1;
		if (x < 0) {
			isNegative = true;
			x = minus(0, x);
		}

		Integer result = 1;
		for (int i = 1; i < n + 1; i++) {
			result = times(result, x);
		}

		if (isNegative && isOdd) {
			result = minus(0, result);
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x1 == 0) {
			return 0;
		}

		Boolean isnegative = (x1 < 0) ^ (x2 < 0);
		if (x1 < 0) {
			x1 = minus(0, x1);
		}
		if (x2 < 0) {
			x2 = minus(0, x2);
		}

		int quotient = 0;
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			quotient++;
		}
		if (isnegative) {
			quotient = minus(0, quotient);
		}
		return quotient;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divisor = div(x1, x2);
		int result = minus(x1, times(x2, divisor));
		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		int low = 0;
		int high = x;
		int result = 0;
		while (plus(low, 1) < high) {
			int middle = div(plus(high, low), 2);
			int square = times(middle, middle);
			if (square == x) {
				return middle;
			} else if (square < x) {
				low = middle;
				result = middle;
			} else {
				high = middle;
			}
		}
		return result;
	}	  	  
}