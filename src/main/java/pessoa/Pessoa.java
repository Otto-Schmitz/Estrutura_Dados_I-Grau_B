package pessoa;

public class Pessoa {
    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String cidade;

    public Pessoa() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String toString(){
        return "[  Nome: "+nome+" Cpf: "+cpf+" Rg: "+rg+ " Data Nascimento: "+dataNascimento+ " Cidade: "+cidade + "  ]";
    }

}
