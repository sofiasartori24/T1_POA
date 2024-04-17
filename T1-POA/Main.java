import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Main {
    static public void main(String[] args) {
        Problema1 p1 = new Problema1();
        Random random = new Random();
        //lista para guardar a média do tempo de execução dos testes realizados com cada tamanho
        int[] averageForTests = new int[10];
        //variavel para guardar elementos no averageForTests no lugar certo
        int index = 0;
        //tamanhos de S especificados
        int[] sizes = {10, 30, 50, 100, 200, 300, 500, 700, 1000, 1100};
        //executar exemplos para cada tamanho de S
        for (int size : sizes) {
            System.out.println("Exemplos para S de tamanho " + size + ":");
            int average = 0;

            for (int j = 1; j <= 10; j++) { //10 exemplos para cada tamanho de S
                String[] S = generateRandomS(size);
                String[] S_line = generateRandomS_line(S, random.nextInt(size) + 1); //tamanho de S_line variável

                long startTime = System.nanoTime();
                boolean result = p1.hasTrend(S, S_line);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime);
                average += duration;
                //imprimir resultados do teste
                System.out.println("Teste " + j + ":");
                System.out.println("S: " + Arrays.toString(S));
                System.out.println("S_line: " + Arrays.toString(S_line));
                System.out.println("Resultado: " + result);
                System.out.println("Tempo de execução: " + duration + "ns");
                System.out.println();
            }
            average = average/10;
            averageForTests[index] = average;
            index ++;
        }
        System.out.println("Média dos resultados:");
        for (int average : averageForTests) {
            System.out.println(average);
        }

    }

    //função para gerar uma sequência S aleatória
    public static String[] generateRandomS(int size) {
        String[] S = new String[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            S[i] = "buy " + getRandomCompany(random);
        }

        return S;
    }

    //função para gerar uma sequência S_line que está contida em S
    public static String[] generateRandomS_line(String[] S, int maxSize) {
        Random random = new Random();
        int start = random.nextInt(S.length); // Posição inicial aleatória em S
        int length = random.nextInt(maxSize) + 1; // Comprimento aleatório para S_line

        //garante que S_line caiba em S a partir da posição inicial
        if (start + length > S.length) {
            length = S.length - start;
        }

        String[] S_line = new String[length];
        System.arraycopy(S, start, S_line, 0, length); // Copia os elementos de S para S_line
        return S_line;
    }

    //função para gerar um nome de empresa aleatório
    public static String getRandomCompany(Random random) {
        String[] companies = {"Amazon", "Google", "Apple", "Microsoft", "Facebook", "Tesla", "Netflix", "NVIDIA", "Adobe", "IBM"};
        return companies[random.nextInt(companies.length)];
    }

}

