package life;

import java.io.IOException;

public class Field {
    private final boolean[][] matrix;
    private final int size;

    Field(boolean[][] matrix, int size) {
        this.matrix = matrix;
        this.size = size;
    }

    void outputMatrix () {
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

    int getAliveAmount() {
        int amount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (getMatrix()[i][j]) amount++;
            }
        }
        return amount;
    }

    void clean() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException ignored) {}
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public int getSize() {
        return size;
    }
}
