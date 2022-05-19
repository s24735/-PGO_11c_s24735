package src.fourth.tutorial;

public class Matrix {
    private int[][] matrix;

    private static int[][] matrixStatic;
    private static int actualEmptyRow = 0;

    private Matrix(int[][] matrixStatic) {
        matrix = matrixStatic;
        matrixStatic = null;
        actualEmptyRow = 0;
    }

    public static void setUpMatrix(int i, int j) {
        matrixStatic = new int[i][j];
    }

    public static void insertRow(int[] ints) {
        if (ints != null) {
            if (ints.length == 3 && actualEmptyRow <= matrixStatic[0].length) {
                for (int i = 0; i < matrixStatic.length; i++) {
                    matrixStatic[actualEmptyRow][i] = ints[i];
                }
                actualEmptyRow++;
            } else {
                System.out.println("To much integers given.");
            }
        }
        else {
            System.out.println("Invalid value given.");
        }
    }

    public static Matrix create() {
        return new Matrix(matrixStatic);
    }

    public Matrix add(Matrix matrixB) {
        if (matrixB == null) {
            System.out.println("Matrix is null");
            return null;
        }
        for(int row = 0; row < matrix.length; row++) {
            for(int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = matrix[row][column] + matrixB.matrix[row][column];
            }
        }
        return this;
    }

    public static Matrix add(Matrix matrixA, Matrix matrixB) {
        if (matrixB == null || matrixA == null) {
            System.out.println("Matrix is null");
            return null;
        }
        int[][] newMatrix = new int[matrixStatic.length][matrixStatic[0].length];
        for(int row = 0; row < newMatrix.length; row++) {
            for(int column = 0; column < newMatrix[row].length; column++) {
                newMatrix[row][column] = matrixA.matrix[row][column] + matrixB.matrix[row][column];
            }
        }
        return new Matrix(newMatrix);
    }

    public void print() {
        for (int[] ints : matrix) {
            System.out.print("| ");
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public Matrix subtract(Matrix matrixB) {
        if (matrixB == null) {
            System.out.println("Matrix is null");
            return null;
        }
        for(int row = 0; row < matrix.length; row++) {
            for(int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = matrix[row][column] - matrixB.matrix[row][column];
            }
        }
        return this;
    }


//    System.out.println("mnozenie macierzy - do klasy Main");
//    Matrix multiple = matrixA.multiple(matrixB);
//    multiple.print();
    public Matrix multiple(Matrix matrixB) {
        if (matrixB == null || this.matrix == null) {
            System.out.println("Matrix is null");
            return null;
        }
        if (matrixB.matrix.length == matrix[0].length && matrixB.matrix[0].length == matrix.length) {
            int matrixSize = Math.min(matrixB.matrix.length, matrixB.matrix[0].length);
            int[][] newMatrix = new int[matrixSize][matrixSize];
            for(int row = 0; row < this.matrix.length; row++)
                for(int column = 0; column < this.matrix[row].length; column++)
                    newMatrix[row][column] = this.matrix[row][column] * matrixB.matrix[row][column];
            return new Matrix(newMatrix);
        }
        else {
            System.out.println("Invalid data, matrix are different.");
            return null;
        }
    }
}