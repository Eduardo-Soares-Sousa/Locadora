package View;

import java.util.List;
import java.util.Scanner;

import Model.Ator;
import Model.Diretor;
import Model.Filme;
import Model.SistemaFilmes;

public class Main {
    public static void main(String[] args) {
        SistemaFilmes sistema = new SistemaFilmes();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Adicionar Filme");
            System.out.println("2. Listar Todos os Filmes");
            System.out.println("3. Listar Todos os Diretores");
            System.out.println("4. Listar Todos os Atores");
            System.out.println("5. Listar Filmes por Diretor");
            System.out.println("6. Listar Filmes por Ator");
            System.out.println("7. Listar Filmes por Nota");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Adicionar Filme ---");
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Nome do Diretor: ");
                    String nomeDiretor = scanner.nextLine();
                    System.out.print("Nomes dos Atores (separados por vírgula): ");
                    String[] nomesAtores = scanner.nextLine().split(",");
                    System.out.print("Ano de Lançamento: ");
                    int anoLancamento = scanner.nextInt();
                    System.out.print("Nota: ");
                    double nota = scanner.nextDouble();

                    sistema.adicionarFilme(titulo, nomeDiretor, List.of(nomesAtores), anoLancamento, nota);
                    break;
                case 2:
                    System.out.println("\n--- Listar Todos os Filmes ---");
                    sistema.listarTodosFilmes();
                    break;
                case 3:
                    System.out.println("\n--- Listar Todos os Diretores ---");
                    sistema.listarTodosDiretores();
                    break;
                case 4:
                    System.out.println("\n--- Listar Todos os Atores ---");
                    sistema.listarTodosAtores();
                    break;
                case 5:
                    System.out.println("\n--- Listar Filmes por Diretor ---");
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Nome do Diretor: ");
                    String nomeDiretorConsulta = scanner.nextLine();
                    sistema.listarFilmesPorDiretor(nomeDiretorConsulta);
                    break;
                case 6:
                    System.out.println("\n--- Listar Filmes por Ator ---");
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Nome do Ator: ");
                    String nomeAtorConsulta = scanner.nextLine();
                    sistema.listarFilmesPorAtor(nomeAtorConsulta);
                    break;
                case 7:
                    System.out.println("\n--- Listar Filmes por Nota ---");
                    System.out.print("Informe uma nota para listar filmes: ");
                    double notaMinimaConsulta = scanner.nextDouble();
                    sistema.listarFilmesPorNota(notaMinimaConsulta);
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }
}