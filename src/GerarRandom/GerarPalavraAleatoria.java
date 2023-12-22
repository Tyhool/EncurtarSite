package GerarRandom;

import java.util.Random;

public class GerarPalavraAleatoria {
    public String gerarPalavraAleatoria(String alfabeto, int tamanho) {
        Random random = new Random();
        StringBuilder palavra = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(alfabeto.length());
            palavra.append(alfabeto.charAt(indice));
        }

        return palavra.toString();
    }
}
