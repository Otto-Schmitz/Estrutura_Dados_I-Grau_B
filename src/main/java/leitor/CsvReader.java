package leitor;

import pessoa.Pessoa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

import static enuns.PessoaProps.*;

public class CsvReader {
    public static ArrayList<Pessoa> reader(String planilha) {
        String arquivo = String.format("%s.csv",planilha);
        BufferedReader br = null;
        String linha = "";
        String divisor = ";";
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(arquivo));

            while ((linha = br.readLine()) != null) {
                String[] array = linha.split(divisor);
                pessoas.add(toPessoa(array));
            }
        }catch (Exception e) {
            System.out.println(String.format("Não foi possível localizar o arquivo %s", planilha));
        }

        return pessoas;
    }

    public static Pessoa toPessoa(String[] array) {
        Pessoa pessoa = new Pessoa();
        try {
            pessoa.setCpf(array[CPF.getValor()]);
            pessoa.setRg(array[RG.getValor()]);
            pessoa.setNome(array[NOME.getValor()]);
            pessoa.setDataNascimento(array[DATA_NASCIMENTO.getValor()]);
            pessoa.setCidade(array[CIDADE_NASCIMENTO.getValor()]);
        } catch (Exception e) {
            System.out.println("Não foi possível criar objeto Pessoa.");
        }
        return pessoa;
    }
}
