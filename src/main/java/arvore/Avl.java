package arvore;

import java.util.ArrayList;

public interface Avl {
    int getAltura(No no);

    static int calcularBalanceamento(No no) {
        return 0;
    }

    static No rotacionarDireita(No no) {
        return null;
    }

    static No rotacionarEsquerda(No no) {
        return null;
    }

    void inserir(String propriedade, int index);

    No inserirAux(No no, String propriedade, int index);

    ArrayList<Integer> buscar(String propriedade);

    ArrayList<Integer> buscarAux(String propriedade, No no);
}
