package arvore;

import java.util.ArrayList;

public interface Avl {
    static int getAltura(No no) {
        if (no == null) {
            return 0;
        }
        return no.getAltura();
    }

    static int calcularBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return getAltura(no.getNoEsquerdo()) - getAltura(no.getNoDireito());
    }

    static No rotacionarDireita(No no) {
        No noNovo = no.getNoEsquerdo();

        no.setNoEsquerdo(noNovo.getNoDireito());
        noNovo.setNoDireito(no);

        no.setAltura(Math.max(getAltura(no.getNoEsquerdo()), getAltura(no.getNoDireito())) + 1);
        noNovo.setAltura(Math.max(getAltura(noNovo.getNoEsquerdo()), getAltura(noNovo.getNoDireito())) + 1);

        return noNovo;
    }

    static No rotacionarEsquerda(No no) {
        No noNovo = no.getNoDireito();

        no.setNoDireito(noNovo.getNoEsquerdo());
        noNovo.setNoEsquerdo(no);

        no.setAltura(Math.max(getAltura(no.getNoEsquerdo()), getAltura(no.getNoDireito())) + 1);
        noNovo.setAltura(Math.max(getAltura(noNovo.getNoEsquerdo()), getAltura(noNovo.getNoDireito())) + 1);

        return noNovo;
    }

    void inserir(String propriedade, int index);

    ArrayList<Integer> buscar(String propriedade);
}
