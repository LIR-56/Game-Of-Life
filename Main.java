package life;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //long s = scanner.nextLong();
        //int m = scanner.nextInt();
        var field = FieldUpdater.generateField(n);
        var fieldUpdater = new FieldUpdater(field);
        new Thread(fieldUpdater).start();
    }
}

