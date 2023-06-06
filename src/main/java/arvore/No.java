package arvore;

public class No {
    private int index;
    private No noEsquerdo;
    private No noDireito;
    private int altura;
    private String propriedade;

    public No() {}

    public No(int index, String propriedade) {
        this.index = index;
        this.propriedade = propriedade;
    }

    public No(int index, No noEsquerdo, No noDireito, int altura, String propriedade) {
        this.index = index;
        this.noEsquerdo = noEsquerdo;
        this.noDireito = noDireito;
        this.altura = altura;
        this.propriedade = propriedade;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

}
