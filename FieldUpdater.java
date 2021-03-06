package life;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FieldUpdater implements Runnable{

    private final Field field;

    FieldUpdater(Field field) {
        this.field = field;
    }

    static Field generateField(int size) {
        return generateField(size, new Random().nextInt());
    }

    static Field generateField(int size, long seed) {
        Random random = new Random(seed);
        boolean[][] matrix = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextBoolean();
            }
        }
        return new Field(matrix, size);
    }
    @Override
    public void run() {
        update(field, 15);
    }

    void update(Field inputField, long generationAmount) {
        var field = inputField;
        System.out.println("Generation #" + (1));
        System.out.println("Alive: " + field.getAliveAmount());
        field.outputMatrix();
        for (int i = 0; i < generationAmount; i++) {
            field = nextGeneration(field);
            field.clean();
            System.out.println("Generation #" + (i+2));
            System.out.println("Alive: " + field.getAliveAmount());
            field.outputMatrix();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private static Field nextGeneration(Field field) {
        int size = field.getSize();
        var newMatrix = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newMatrix[i][j] = defineNextGenerationStatus(field, i, j);
            }
        }
        return new Field(newMatrix, size);
    }

    private static boolean defineNextGenerationStatus(Field field, int i, int j) {
        int aliveNeighbours = 0;
        var matrix = field.getMatrix();
        int leftCoordinateOfNeighbours = j != 0 ? j - 1 : field.getSize() - 1;
        int upCoordinateOfNeighbours = i != 0 ? i - 1 : field.getSize() - 1;
        int rightCoordinateOfNeighbours = j != (field.getSize() - 1) ? j + 1 : 0;
        int downCoordinateOfNeighbours = i != (field.getSize() - 1) ? i + 1 : 0;
        if (matrix[upCoordinateOfNeighbours][leftCoordinateOfNeighbours]) aliveNeighbours++;
        if (matrix[upCoordinateOfNeighbours][j]) aliveNeighbours++;
        if (matrix[upCoordinateOfNeighbours][rightCoordinateOfNeighbours]) aliveNeighbours++;
        if (matrix[i][leftCoordinateOfNeighbours]) aliveNeighbours++;
        if (matrix[i][rightCoordinateOfNeighbours]) aliveNeighbours++;
        if (matrix[downCoordinateOfNeighbours][leftCoordinateOfNeighbours]) aliveNeighbours++;
        if (matrix[downCoordinateOfNeighbours][j]) aliveNeighbours++;
        if (matrix[downCoordinateOfNeighbours][rightCoordinateOfNeighbours]) aliveNeighbours++;

        if (aliveNeighbours == 3) {
            return true;
        } else if (aliveNeighbours < 2 || aliveNeighbours > 3) {
            return false;
        } else return matrix[i][j];
    }
}
