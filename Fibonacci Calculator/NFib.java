
public class NFib {
    public static BigInt fibA(int n) {
        // return 2 for n <= 1
        if (n <= 1) {
            return new BigInt(2, 12);
        }
        // recursively call the method based on the definition of NFib
        return (fibA(n-1)).add(fibA(n-2));
    }

    public static BigInt[] fibB(int n) {
        // we start from G1
        BigInt[] result = {new BigInt(2, 106), new BigInt(2, 106)};
        // if n is 0 or 1, just return the result 2
        if (n <= 1) {
            return result;
        }
        // calculate NFib number
        calculateNFib(result, n);
        // return the result which is held in the first item of the array
        return result;
    }

    private static void calculateNFib(BigInt[] result, int n) {
        // We don't need to calculate when n is 0 or 1.
        // The result for these two case is handled in the caller of this method
        if (n == 1) {
            return;
        }
        // call the method recursively to get the result of next G array (n-1)
        calculateNFib(result, n - 1);

        // calculate the result of n from the result of (n-1)
        // 1. assign the first item of array (n-1) to the second item of array n
        // 2. add two items of array (n-1) and assign to the first item of array n
        BigInt x = result[0].add(result[1]);
        BigInt y = result[0];

        result[0] = x;
        result[1] = y;
    }
}
