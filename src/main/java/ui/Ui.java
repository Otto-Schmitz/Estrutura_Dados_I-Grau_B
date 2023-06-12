package ui;

import arvore.AvlNome;
import pessoa.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import static leitor.CsvReader.reader;

public class Ui {
        private static Scanner sc = new Scanner(System.in);
        private static ArrayList<Pessoa> pessoas = new ArrayList<>();
        private static AvlNome avlNome = new AvlNome();


        public static void menu() {
            System.out.println("ARVORE AVL - ESTRUTURAS AVANCADAS DE DADOS I\n");
            System.out.println("0 - Arvore de Demonstracao");
            System.out.println("1 - Inserir");
            System.out.println("2 - Remover");
            System.out.println("3 - Pre-ordem");
            System.out.println("4 - Pos-ordem");
            System.out.println("5 - Em ordem");
            System.out.println("6 - Por nivel");
            System.out.println("7 - Excluir Arvore");
            System.out.println("8 - Mostrar Arvore");
            System.out.println("9 - Verificar Número");
            System.out.println("10 - Sair\n");
            menuAux(trataIntMenu());

        }

        private static void menuAux(int escolha) {
            System.out.println();
            switch (escolha) {
                case 1 -> inserir();
                case 2 -> System.out.println(pessoas.get(0).getNome());
                case 3 -> buscar();
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
                avlNome.inserir(pessoa.getNome(), i);
            }
        }

        private static void buscar() {
            System.out.println("Digite o nome: ");
            String arquivo = sc.nextLine();
            Set<Integer> set = avlNome.emOrdem(arquivo);

            for(Integer i : set) {
                System.out.println(pessoas.get(i).getNome());
            }
        }

        private static void verificarNome() {

        }
}
