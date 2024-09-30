package trabalhoEstacio;

import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String nome;
    private double preco;

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: R$ " + preco;
    }
}

public class CatalogadorDeItens {
    private static ArrayList<Item> itens = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- Catalogador de Itens Do Plinio---");
            System.out.println("1. Adicionar item a Loja");
            System.out.println("2. Listar itens da Loja");
            System.out.println("3. Remover item da Loja");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarItem();
                    break;
                case 2:
                    listarItens();
                    break;
                case 3:
                    removerItem();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 4);
    }

    private static void adicionarItem() {
        System.out.print("Digite o nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do item: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        itens.add(new Item(nome, preco));
        System.out.println("Item adicionado com sucesso!");
    }

    private static void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item no catálogo.");
        } else {
            System.out.println("\n--- Itens no Catálogo da Loja ---");
            for (int i = 0; i < itens.size(); i++) {
                System.out.println((i + 1) + ". " + itens.get(i));
            }
        }
    }

    private static void removerItem() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item para remover.");
        } else {
            listarItens();
            System.out.print("Digite o número do item a ser removido: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Limpar o buffer

            if (index >= 0 && index < itens.size()) {
                itens.remove(index);
                System.out.println("Item removido com sucesso!");
            } else {
                System.out.println("Índice inválido, tente novamente.");
            }
        }
    }
}
