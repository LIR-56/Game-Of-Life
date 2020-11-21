package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        outputMatrix(generateRandomMatrix(n, s), n);
        
    }

    private static boolean[][] generateRandomMatrix(int size, int seed) {
        Random random = new Random(seed);
        boolean[][] matrix = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextBoolean();
            }
        }
        return matrix;
    }

    private static void outputMatrix (boolean[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j]) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

