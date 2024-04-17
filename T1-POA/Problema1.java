public class Problema1 {
    public Problema1() {
    }

    boolean hasTrend(String[] S, String[] S_line) {
        //checa se S_line é menor que S, se não já retorna false
        if (S_line.length > S.length) {
            return false;
        }
        //variavel para acessar o S_line, incrementada a medida que as palavras forem correspondendo
        int index = 0;

        //variavel para acessar as palavras do S_line
        String current;
        //percorre o array S
        for (int i = 0;i < S.length; i++) {
            //acessa a palavra atual do S_line (controlando a partir da variavel index)
            current = S_line[index];
            //checa se a palavra é igual a palavra atual do S (controlada pelo i do for)
            if (current.equals(S[i])) {
                //checa se é a ultima palavra do S_line, caso seja retorna true
                if (index + 1 == S_line.length) {
                    return true;
                }
                //incrementa o index (para acessar a proxima palavra de S_line)
                index = index + 1;
            }
        }
        return false;
    }
}


