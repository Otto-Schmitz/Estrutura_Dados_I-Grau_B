package arvore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static arvore.Avl.*;

public class AvlCpf implements Avl{

    private No raiz;

    public AvlCpf() {
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
        Integer comparacaoPropriedade = Integer.parseInt(propriedade);
        Integer comparacaoNo = Integer.parseInt(no.getPropriedade());
        int comparacao = comparacaoNo.compareTo(comparacaoPropriedade);

        if (comparacao < 0) {
            no.setNoEsquerdo(inserirAux(no.getNoEsquerdo(), propriedade, index));
        }
        else if (comparacao > 0) {
            no.setNoDireito(inserirAux(no.getNoDireito(), propriedade, index));
        }
        else {
            no.setIndex(index);
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
        return buscarAux(propriedade, this.raiz, new ArrayList<Integer>());
    }

    public ArrayList<Integer> buscarAux(String propriedade, No no, ArrayList<Integer> arrayList) {
        if(no == null) {
            return arrayList;
        }

        if (no.getPropriedade().startsWith(propriedade)) {
            arrayList.addAll(no.getIndex());
        }

        if (propriedade.compareTo(no.getPropriedade()) < 0) {
            arrayList = buscarAux(propriedade, no.getNoEsquerdo(), arrayList);
        }
        else if (propriedade.compareTo(no.getPropriedade()) > 0) {
            arrayList = buscarAux(propriedade, no.getNoDireito(), arrayList);
        }


//        if(numero < no.getNumero()) {
//            no = verificarNumeroAux(numero, no.getNoEsquerdo());
//        }
//        else if(numero > no.getNumero()) {
//            no = verificarNumeroAux(numero, no.getNoDireito());
//        }
//        else if(numero != no.getNumero()) {
//            no = this.raiz;
//        }
//        return no;


        return arrayList;
    }

    public Set<Integer> emOrdem(String propriedade) {
        return emOrdemAux(this.raiz, new HashSet<>(), propriedade);
    }

    private Set<Integer> emOrdemAux(No no, Set<Integer> ordem, String propriedade) {
        if(no != null) {
            if (no.getPropriedade().startsWith(propriedade)) {
                ordem = emOrdemAux(no.getNoEsquerdo(), ordem, propriedade);
                ordem = emOrdemAux(no.getNoDireito(), ordem, propriedade);
                ordem.addAll(no.getIndex());
            }



//            if (no.getNoDireito() != null) {
//                ordem = emOrdemAux(no.getNoEsquerdo(), ordem, propriedade);
//            }
//
//            if (propriedade.compareTo(no.getPropriedade()) < 0) {
//                ordem = emOrdemAux(no.getNoEsquerdo(), ordem, propriedade);
//            }
//            else if (propriedade.compareTo(no.getPropriedade()) > 0) {
//                ordem = emOrdemAux(no.getNoDireito(), ordem, propriedade);
//            }
//            ordem = emOrdemAux(no.getNoDireito(), ordem, propriedade);
        }
        return ordem;
    }
}
