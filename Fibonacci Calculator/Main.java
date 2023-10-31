public class Main {
    public static void main(String[] args) {

        if (args.length == 0 || args[0].equals("a")) {
            for (int i = 0; i <= 10; i++) {
                int number = i * 5;
                BigInt n = NFib.fibA(number);
                System.out.println("N" + number + " = " + n.toString());
            }
        }

        if (args.length == 0 || args[0].equals("b")) {
            for (int i = 0; i <= 25; i++) {
                int number = i * 20;
                BigInt[] g = NFib.fibB(number);
                System.out.println("N" + number + " = " + g[0].toString());
            }
        }
    }
}