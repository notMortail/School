// This is the implementation of big integer
public class BigInt {
    private char[] values;
    private int length;
    public BigInt(int value, int length) {
        this.length = length;
        values = new char[length];
        values[0] = '1';
        values[1] = toChar(value);
    }

    public BigInt(char[] values) {
        this.values = values;
        this.length = values.length;
    }

    public char[] getValues() {
        return values;
    }

    public int getLength() {
        return values[0] - '0';
    }

    public BigInt add(BigInt b) {
        char[] A = values;
        char[] B = b.getValues();
        int len1 = getLength(),  len2 = b.getLength();
        int divisor = 0;
        int len = len1 >= len2 ? len1 : len2;
        int tmp;
        for (int i = 1; i <= len; i++) {
            if (i > len1) {
                tmp = toInt(B[i]) + divisor;
            }
            else if (i > len2) {
                tmp = toInt(A[i]) + divisor;
            }
            else {
                tmp = toInt(A[i]) + toInt(B[i]) + divisor;
            }
            divisor = tmp / 10;
            B[i] = toChar(tmp % 10);
        }
        while (divisor > 0) {
            B[++len] = toChar(divisor % 10);
            divisor /= 10;
        }
        B[0] = toChar(len);

        return new BigInt(B);
    }

    public String toString() {
        int len = toInt(values[0]);
        String s = "";
        for (int i = len; i >= 1; i--) {
            s = s + toInt(values[i]);
        }
        return s;
    }

    public static int toInt(char c) {
        int r = c - '0';
        return r;
    }

    public static char toChar(int c) {
        int r = c + '0';
        return (char)r;
    }
}





