package ui;

import arvore.Avl;
import pessoa.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;

import static leitor.CsvReader.reader;

public class Ui {
        private static final Scanner sc = new Scanner(System.in);
        private static ArrayList<Pessoa> pessoas = new ArrayList<>();
        private static final Avl avlNome = new Avl();
        private static final Avl avlData = new Avl();
        private static final Avl avlCpf = new Avl();


        public static void menu() {
            System.out.println("ARVORE AVL - ESTRUTURAS AVANCADAS DE DADOS I\n");
            System.out.println("1 - Inserir Planilha CSV");
            System.out.println("2 - Buscar por Nome");
            System.out.println("3 - Buscar por CPF");
            System.out.println("4 - Buscar por Data");
            System.out.println("5 - Exibir arvore ordenada por Nome");
            System.out.println("6 - Exibir arvore ordenada por CPF");
            System.out.println("7 - Exibir arvore ordenada por Data de Nascimento");
            System.out.println("8 - Autores");
            System.out.println("10 - Sair\n");
            menuAux(trataIntMenu());

        }

        private static void menuAux(int escolha) {
            System.out.println();
            switch (escolha) {
                case 1 -> inserir();
                case 2 -> buscarPorNome();
                case 3 -> buscarPorCpf();
                case 4 -> buscarPorData();
                case 5 -> mostrarArvore(avlNome);
                case 6 -> mostrarArvore(avlCpf);
                case 7 -> mostrarArvore(avlData);
                case 8 -> mostrarAutores();
                case 10 -> System.out.println("Adeus");

            }
            System.out.println();
            if (escolha != 10)
                menu();
        }

        private static int trataIntMenu() {
            while (true) {
                try {
                    System.out.print("Escolha um item da lista: ");
                    String escolhaAux = sc.nextLine();
                    int escolha = Integer.parseInt(escolhaAux);
                    if (escolha >= 0 && escolha <= 10) {
                        return escolha;
                    }
                } catch (Exception e) {
                    System.out.print("Tente novamente");
                }
            }
        }

        private static void inserir() {
//            System.out.println("Digite o nome do arquivo Csv: ");
//            String arquivo = sc.nextLine();
            String arquivo = "planilha";
            ArrayList<Pessoa> array = reader(arquivo);
            if (!array.isEmpty()) pessoas = array;

            for(int i = 0; i < pessoas.size(); i++) {
                Pessoa pessoa = pessoas.get(i);
                avlNome.inserirNome(pessoa.getNome(), i);
                avlCpf.inserirCpf(pessoa.getCpf(), i);
                avlData.inserirData(pessoa.getDataNascimento(), i);
            }
        }

        private static void buscarPorNome() {
            System.out.println("Digite o nome: ");
            String arquivo = sc.nextLine();
            ArrayList<Integer> set = avlNome.buscarPorNome(arquivo);

            mostrarResultados(set);
        }

        private static void buscarPorCpf() {
            System.out.println("Digite o Cpf: ");
            String arquivo = sc.nextLine();
            ArrayList<Integer> set = avlCpf.buscarPorCpf(arquivo);

            mostrarResultados(set);
        }

        private static void buscarPorData() {
            System.out.println("Digite uma data de Inicio no formato (dd/mm/yyyy): ");
            String dataInicio = sc.nextLine();
            System.out.println("Digite uma data de Fim no formato (dd/mm/yyyy): ");
            String dataFim = sc.nextLine();
            ArrayList<Integer> set = avlData.buscarPorData(dataInicio, dataFim);

            mostrarResultados(set);
        }

        private static void mostrarResultados(ArrayList<Integer> set){
            System.out.println("        RESULTADOS          ");
            for(Integer i : set) {
                System.out.println(pessoas.get(i));
            }
        }

        private static void mostrarArvore(Avl arvore){
            System.out.println(arvore);
        }

        private static void mostrarAutores(){
            System.out.println("Desenvolvido por: Arthur Palma, Caua Festa, Otto Schmitz, Thomaz Ritter");
        }

}
