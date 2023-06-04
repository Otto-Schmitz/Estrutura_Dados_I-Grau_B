package ui;

import java.util.Scanner;

public class Ui {
        private Scanner sc = new Scanner(System.in);


        public void menu() {
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

        private void menuAux(int escolha) {
            System.out.println();
            switch (escolha) {
                case 0 -> System.out.println();
                case 10 -> System.out.println("Adeus");

            }
            System.out.println();
            if (escolha != 10)
                menu();
        }

        private int trataIntMenu() {
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

        private int trataInt() {
            while (true) {
                try {
                    System.out.print("Digite um valor: ");
                    String escolhaAux = sc.nextLine();
                    int escolha = Integer.parseInt(escolhaAux);
                    return escolha;

                } catch (Exception e) {
                    System.out.print("Tente novamente");
                }
            }
        }
}
