public class Trynumber {
    public Trynumber(int a, int b) {
    }

    public void tryNumber(int a, int b) {
        if (b == 0) {
            System.out.println("Number must not be 0");
            throw new IllegalArgumentException("Number must not be 0");
        } else {
            int result = a / b;
            System.out.println("Result: " + result);
        }
    }
}
