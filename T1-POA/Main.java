public class Main {
    static public void main(String[] args) {
        Problema1 p1 = new Problema1();
        String[] S = {"buy Amazon", "buy Google", "buy Apple", "buy Google", "buy Google", "buy NVIDIA"};
        String[] S_line = {"buy Google", "buy Apple", "buy Google", "buy NVIDIA"};
        System.out.println(p1.hasTrend(S, S_line));

        Problema2 p2 = new Problema2();
        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] B = {{17, 18, 19, 20}, {21, 22, 23, 24}, {25, 26, 27, 28}, {29, 30, 31, 32}};

        int[][] C = p2.multiply(A, B);
        int[][] D = p2.traditionalMatrixMultiply(A, B);

        // Imprime a matriz resultante
        for (int[] row : C) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        for (int[] row : D) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

}
