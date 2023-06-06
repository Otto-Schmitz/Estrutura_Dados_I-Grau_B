package arvore;

import java.util.ArrayList;

import static arvore.Avl.*;

public class AvlNome implements Avl{
    private No raiz;

    public AvlNome() {
        raiz = null;
    }

    @Override
    public void inserir(String propriedade, int index) {
        this.raiz = inserirAux(this.raiz, propriedade, index);
    }

    private No inserirAux(No no, String propriedade, int index) {
        if(no == null) {
            return new No(index, propriedade);
        }

        int comparacao = propriedade.compareTo(no.getPropriedade());

        if (comparacao < 0) {
            no.setNoEsquerdo(inserirAux(no.getNoEsquerdo(), propriedade, index));
        }
        else if (comparacao > 0) {
            no.setNoDireito(inserirAux(no.getNoDireito(), propriedade, index));
        }
        else {
            return no;
        }

        no.setAltura(1 + Math.max(getAltura(no.getNoEsquerdo()), getAltura(no.getNoDireito())));

        int balanceamento = calcularBalanceamento(no);
        if (balanceamento > 1) {
            if (propriedade.compareTo(no.getNoEsquerdo().getPropriedade()) < 0) {
                return rotacionarDireita(no);
            } else {
                no.setNoEsquerdo(rotacionarEsquerda(no.getNoEsquerdo()));
                return rotacionarDireita(no);
            }
        }

        if (balanceamento < -1) {
            if (propriedade.compareTo(no.getNoDireito().getPropriedade()) > 0) {
                return rotacionarEsquerda(no);
            } else {
                no.setNoDireito(rotacionarDireita(no.getNoDireito()));
                return rotacionarEsquerda(no);
            }
        }

        return no;
    }

    @Override
    public ArrayList<Integer> buscar(String propriedade) {
        return null;
    }

    public ArrayList<Integer> buscarAux(String propriedade, No no) {
        return null;
    }
}
