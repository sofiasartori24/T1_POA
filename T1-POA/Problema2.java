public class Problema2 {
    public Problema2() {}

    int[][] multiply(int[][] A, int[][] B) {
        //guarda o tamanho da matriz A
        int n = A.length;
        //verifica se as matrizes são de tamanho adequado
        if (n != A[0].length || n != B.length || n != B[0].length) {
            throw new IllegalArgumentException("As matrizes devem ser quadradas do mesmo tamanho.");
        }
        //verifica se a matriz é de tamanho ímpar, caso seja, usa o método de multiplicação normal que é nˆ3
        if (n % 2 != 0 || n == 1) {
            return traditionalMatrixMultiply(A, B);
        }
        //inicializa a matriz resultante
        int[][] C = new int[n][n];
        //divide as matrizes em submatrizes menores
        int[][] A11 = divideMatrix(A, 0, 0, n / 2, n / 2);
        int[][] A12 = divideMatrix(A, 0, n / 2, n / 2, n);
        int[][] A21 = divideMatrix(A, n / 2, 0, n, n / 2);
        int[][] A22 = divideMatrix(A, n / 2, n / 2, n, n);

        int[][] B11 = divideMatrix(B, 0, 0, n / 2, n / 2);
        int[][] B12 = divideMatrix(B, 0, n / 2, n / 2, n);
        int[][] B21 = divideMatrix(B, n / 2, 0, n, n / 2);
        int[][] B22 = divideMatrix(B, n / 2, n / 2, n, n);

        //calcula os produtos intermediários
        int[][] M1 = multiply(addMatrix(A11, A22), addMatrix(B11, B22));
        int[][] M2 = multiply(addMatrix(A21, A22), B11);
        int[][] M3 = multiply(A11, subtractMatrix(B12, B22));
        int[][] M4 = multiply(A22, subtractMatrix(B21, B11));
        int[][] M5 = multiply(addMatrix(A11, A12), B22);
        int[][] M6 = multiply(subtractMatrix(A21, A11), addMatrix(B11, B12));
        int[][] M7 = multiply(subtractMatrix(A12, A22), addMatrix(B21, B22));

        //calcula os elementos da matriz de resultado
        int[][] C11 = subtractMatrix(addMatrix(addMatrix(M1, M4), M7), M5);
        int[][] C12 = addMatrix(M3, M5);
        int[][] C21 = addMatrix(M2, M4);
        int[][] C22 = subtractMatrix(addMatrix(addMatrix(M1, M3), M6), M2);

        //concatena as submatrizes para formar a matriz resultante
        joinMatrix(C11, C, 0, 0);
        joinMatrix(C12, C, 0, n / 2);
        joinMatrix(C21, C, n / 2, 0);
        joinMatrix(C22, C, n / 2, n / 2);

        return C;
    }

    //funções auxiliares para operações de matriz
    private int[][] divideMatrix(int[][] matrix, int rowStart, int colStart, int rowEnd, int colEnd) {
        int n = rowEnd - rowStart;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix[rowStart + i][colStart + j];
            }
        }
        return result;
    }

    private int[][] addMatrix(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    private int[][] subtractMatrix(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    private void joinMatrix(int[][] source, int[][] dest, int rowStart, int colStart) {
        int n = source.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dest[rowStart + i][colStart + j] = source[i][j];
            }
        }
    }

    //função de multiplicação tradicional de matrizes
    int[][] traditionalMatrixMultiply(int[][] A, int[][] B) {
        int n = A[0].length;
        int m = A.length;
        int p = B[0].length;
        int[][] C = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}


