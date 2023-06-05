package enuns;

public enum PessoaProps {
    CPF(0),
    RG(1),
    NOME(2),
    DATA_NASCIMENTO(3),
    CIDADE_NASCIMENTO(4);

    private final int valor;

    PessoaProps(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
