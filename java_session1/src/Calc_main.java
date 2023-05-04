public class Calc_main {
    public static void main(String[] args) {
        Calc calc = new Calc();
        int n = calc.max(5, 4);
        System.out.println(n);

        Calc_interface calc2 = (a, b) -> a > b ? a : b;
        System.out.println(calc2.max(5, 8));
    }
}
