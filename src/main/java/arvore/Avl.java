package arvore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Avl{
    private No raiz;

    public Avl() {
        raiz = null;
    }

    public void inserirNome(String propriedade, int index) {
        this.raiz = inserirNomeAux(this.raiz, propriedade, index);
    }

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

    private No inserirNomeAux(No no, String propriedade, int index) {
        if(no == null) {
            return new No(index, propriedade);
        }

        int comparacao = propriedade.compareTo(no.getPropriedade());

        if (comparacao < 0) {
            no.setNoEsquerdo(inserirNomeAux(no.getNoEsquerdo(), propriedade, index));
        }
        else if (comparacao > 0) {
            no.setNoDireito(inserirNomeAux(no.getNoDireito(), propriedade, index));
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

    public void inserirCpf( String propriedade, int index) {
        this.raiz = inserirCpfAux(this.raiz,  propriedade, index);
    }

    private No inserirCpfAux(No no, String propriedade, int index) {
        if(no == null) {
            return new No(index, propriedade);
        }

        if (Long.parseLong(propriedade) < Long.parseLong(no.getPropriedade())) {
            no.setNoEsquerdo(inserirCpfAux(no.getNoEsquerdo(), propriedade, index));
        }
        else if (Long.parseLong(propriedade) > Long.parseLong(no.getPropriedade())){
            no.setNoDireito(inserirCpfAux(no.getNoDireito(), propriedade, index));
        }
        else {
            no.setIndex(index);
            return no;
        }

        no.setAltura(1 + Math.max(getAltura(no.getNoEsquerdo()), getAltura(no.getNoDireito())));

        int balanceamento = calcularBalanceamento(no);
        if (balanceamento > 1) {
            if (Long.parseLong(propriedade) < Long.parseLong(no.getNoEsquerdo().getPropriedade())) {
                return rotacionarDireita(no);
            } else {
                no.setNoEsquerdo(rotacionarEsquerda(no.getNoEsquerdo()));
                return rotacionarDireita(no);
            }
        }

        if (balanceamento < -1) {
            if (Long.parseLong(propriedade) > Long.parseLong(no.getNoDireito().getPropriedade())) {
                return rotacionarEsquerda(no);
            } else {
                no.setNoDireito(rotacionarDireita(no.getNoDireito()));
                return rotacionarEsquerda(no);
            }
        }

        return no;

    }

    public static int compararDatas(String data1, String data2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate1 = LocalDate.parse(data1, formatter);
        LocalDate localDate2 = LocalDate.parse(data2, formatter);
        
        if(localDate1.isBefore(localDate2))
            return -1;
        else if (localDate1.isAfter(localDate2)) {
            return 1;
        }
        else{
            return 0;
        }
    }

    public void inserirData( String propriedade, int index) {
        this.raiz = inserirDataAux(this.raiz,  propriedade, index);
    }

    private No inserirDataAux(No no, String propriedade, int index) {
        if(no == null) {
            return new No(index, propriedade);
        }
        int verificarData = compararDatas(propriedade,no.getPropriedade());

        if (verificarData == -1) {
            no.setNoEsquerdo(inserirDataAux(no.getNoEsquerdo(), propriedade, index));
        }
        else if (verificarData == 1){
            no.setNoDireito(inserirDataAux(no.getNoDireito(), propriedade, index));
        }
        else {
            no.setIndex(index);
            return no;
        }

        no.setAltura(1 + Math.max(getAltura(no.getNoEsquerdo()), getAltura(no.getNoDireito())));

        int balanceamento = calcularBalanceamento(no);
        if (balanceamento > 1) {
            if (compararDatas(propriedade,no.getNoEsquerdo().getPropriedade()) == -1) {
                return rotacionarDireita(no);
            } else {
                no.setNoEsquerdo(rotacionarEsquerda(no.getNoEsquerdo()));
                return rotacionarDireita(no);
            }
        }

        if (balanceamento < -1) {
            if (compararDatas(propriedade,no.getNoDireito().getPropriedade()) == 1) {
                return rotacionarEsquerda(no);
            } else {
                no.setNoDireito(rotacionarDireita(no.getNoDireito()));
                return rotacionarEsquerda(no);
            }
        }

        return no;

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

    public ArrayList<Integer> buscarPorCpf(String cpf) {
        ArrayList<Integer> indexesEncontrados = new ArrayList<>();
        buscarPorCpfAux(raiz, cpf, indexesEncontrados);
        return indexesEncontrados;
    }

    private void buscarPorCpfAux(No no, String cpf, ArrayList<Integer> indexesEncontrados) {
        if (no == null) {
            return;
        }

        if (Long.parseLong(cpf) == Long.parseLong(no.getPropriedade())) {
            indexesEncontrados.addAll(no.getIndex());
        }
        else if (Long.parseLong(cpf) < Long.parseLong(no.getPropriedade())) {
            buscarPorNomeAux(no.getNoEsquerdo(), cpf, indexesEncontrados);
        }
        else{
            buscarPorNomeAux(no.getNoDireito(), cpf, indexesEncontrados);
        }
    }

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ArrayList<Integer> buscarPorData(String dataInicio, String dataFim) {
        ArrayList<Integer> indexesEncontrados = new ArrayList<>();
        LocalDate inicio = LocalDate.parse(dataInicio, formatter);
        LocalDate fim = LocalDate.parse(dataFim, formatter);
        buscarPorDataAux(raiz, inicio, fim, indexesEncontrados);
        return indexesEncontrados;
    }

    private void buscarPorDataAux(No no, LocalDate dataInicio, LocalDate dataFim, ArrayList<Integer> indexesEncontrados) {
        if (no == null) {
            return;
        }

        LocalDate propriedade = LocalDate.parse(no.getPropriedade(), formatter);

        if (!propriedade.isBefore(dataInicio) && !propriedade.isAfter(dataFim)) {
            indexesEncontrados.addAll(no.getIndex());
        }

        if (propriedade.isBefore(dataInicio)) {
            buscarPorDataAux(no.getNoDireito(), dataInicio, dataFim, indexesEncontrados);
        } else if (propriedade.isAfter(dataFim)) {
            buscarPorDataAux(no.getNoEsquerdo(), dataInicio, dataFim, indexesEncontrados);
        } else if (propriedade.isEqual(dataInicio)) {
            buscarPorDataAux(no.getNoDireito(),dataInicio, dataFim, indexesEncontrados);
        } else if (propriedade.isEqual(dataFim)) {
            buscarPorDataAux(no.getNoEsquerdo(),dataInicio, dataFim, indexesEncontrados);
        } else{
            buscarPorDataAux(no.getNoEsquerdo(), dataInicio, dataFim, indexesEncontrados);
            buscarPorDataAux(no.getNoDireito(), dataInicio, dataFim, indexesEncontrados);
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
