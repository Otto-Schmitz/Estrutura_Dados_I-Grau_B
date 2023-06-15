package arvore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    public ArrayList<Integer> buscarPorNome(String prefixo) {
        ArrayList<Integer> indexesEncontrados = new ArrayList<>();
        buscarPorNomeAux(raiz, prefixo, indexesEncontrados);
        return indexesEncontrados;
    }

    private void buscarPorNomeAux(No no, String prefixo, ArrayList<Integer> indexesEncontrados) {
        if (no == null) {
            return;
        }

        System.out.println(no);

        int comparacao = prefixo.compareTo(no.getPropriedade());

        if (comparacao <= 0 && no.getPropriedade().startsWith(prefixo)) {
            buscarPorNomeAux(no.getNoEsquerdo(), prefixo, indexesEncontrados);
            buscarPorNomeAux(no.getNoDireito(), prefixo, indexesEncontrados);
            indexesEncontrados.addAll(no.getIndex());
        }
        else if (prefixo.compareTo(no.getPropriedade()) < 0) {
            buscarPorNomeAux(no.getNoEsquerdo(), prefixo, indexesEncontrados);
        }
        else{
            buscarPorNomeAux(no.getNoDireito(), prefixo, indexesEncontrados);
        }
    }


    @Override
    public String toString() {
        String result = "";
        if (raiz == null) {
            result += "Raiz nula\n";
            return result;
        }
        int tab = 1;
        result += "[RAIZ]---" + raiz + "\n";
        result += adicionarSubArvoreToString(raiz.getNoEsquerdo(), tab, "ESQ");
        result += adicionarSubArvoreToString(raiz.getNoDireito(), tab, "DIR");
        return result;
    }

    private String adicionarSubArvoreToString(No no, int tab, String lado) {
        String result = "";
        if (no != null) {
            String txt = "";
            for (int i = 0; i < tab; i++) {
                txt += "\t";
            }
            result += txt + "[" + lado + "]" + "---" + no + "\n";
            result += adicionarSubArvoreToString(no.getNoEsquerdo(), tab + 1, "ESQ");
            result += adicionarSubArvoreToString(no.getNoDireito(), tab + 1, "DIR");
        }
        return result;
    }


}
