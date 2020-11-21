package life;

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

    public boolean[][] getMatrix() {
        return matrix;
    }

    public int getSize() {
        return size;
    }
}
