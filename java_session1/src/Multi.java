public class Multi {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 9; i++){
            for(int j = 2; j <= 9; j++){
                System.out.printf("%d * %d = %d\t", j, i, i * j);
            }
            System.out.println();
        }
    }
}