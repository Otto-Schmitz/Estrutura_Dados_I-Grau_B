package arvore;

import java.util.ArrayList;

public class No {
    private ArrayList<Integer> index = new ArrayList();
    private No noEsquerdo;
    private No noDireito;
    private int altura;
    private String propriedade;

    public No() {}

    public No(Integer index, String propriedade) {
        this.index.add(index);
        this.propriedade = propriedade;
    }

    public No(int index, No noEsquerdo, No noDireito, int altura, String propriedade) {
        this.index.add(index);
        this.noEsquerdo = noEsquerdo;
        this.noDireito = noDireito;
        this.altura = altura;
        this.propriedade = propriedade;
    }

    public ArrayList<Integer> getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index.add(index);
    }

    public No getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(No noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public No getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(No noDireito) {
        this.noDireito = noDireito;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(String propriedade) {
        this.propriedade = propriedade;
    }

    @Override
    public String toString(){
        return "[ "+propriedade+" ]";
    }


}
