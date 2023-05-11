public class idk {
    public static void main(String[] args) {
        int x =5;
        int y = 4;
        for (int i=0; i<y; i++){
            System.out.print("*");
        }
        System.out.print("\n");
        for(int i=0; i<x-2; i++){
            System.out.print("*");
            for (int j=0; j<y-2; j++){
                System.out.print(" ");

            }
            System.out.print("*\n");
        }
        for (int i=0; i<y; i++){
            System.out.print("*");
        }
    }
}
