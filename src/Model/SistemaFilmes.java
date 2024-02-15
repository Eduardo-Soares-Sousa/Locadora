package Model;

import java.util.List;
import java.util.ArrayList;

public class SistemaFilmes {
    List<Diretor> diretores;
    List<Ator> atores;
    List<Filme> filmes;

    public SistemaFilmes() {
        this.diretores = new ArrayList<>();
        this.atores = new ArrayList<>();
        this.filmes = new ArrayList<>();
    }

    public void adicionarFilme(String titulo, String nomeDiretor, List<String> nomesAtores, int anoLancamento, double nota) {
        Diretor diretor = buscarDiretor(nomeDiretor);
        if (diretor == null) {
            diretor = new Diretor(nomeDiretor);
            diretores.add(diretor);
        }

        List<Ator> elenco = new ArrayList<>();
        for (String nomeAtor : nomesAtores) {
            Ator ator = buscarAtor(nomeAtor);
            if (ator == null) {
                System.out.println("Ator não encontrado: " + nomeAtor);
                continue;
            }
            elenco.add(ator);
        }

        Filme novoFilme = new Filme(titulo, diretor, elenco, anoLancamento, nota);
        filmes.add(novoFilme);
    }

    private Diretor buscarDiretor(String nomeDiretor) {
        for (Diretor diretor : diretores) {
            if (diretor.nome.equals(nomeDiretor)) {
                return diretor;
            }
        }
        return null;
    }

    private Ator buscarAtor(String nomeAtor) {
        for (Ator ator : atores) {
            if (ator.nome.equals(nomeAtor)) {
                return ator;
            }
        }
        return null;
    }

    public void listarTodosFilmes() {
        for (Filme filme : filmes) {
            System.out.println("Título: " + filme.titulo + ", Diretor: " + filme.diretor.nome + ", Ano: " + filme.anoLancamento + ", Nota: " + filme.nota);
        }
    }

    public void listarTodosDiretores() {
        for (Diretor diretor : diretores) {
            System.out.println("Diretor: " + diretor.nome);
        }
    }

    public void listarTodosAtores() {
        for (Ator ator : atores) {
            System.out.println("Ator: " + ator.nome);
        }
    }

    public void listarFilmesPorDiretor(String nomeDiretor) {
        Diretor diretor = buscarDiretor(nomeDiretor);
        if (diretor == null) {
            System.out.println("Diretor não encontrado: " + nomeDiretor);
            return;
        }

        for (Filme filme : filmes) {
            if (filme.diretor.equals(diretor)) {
                System.out.println("Título: " + filme.titulo + ", Ano: " + filme.anoLancamento + ", Nota: " + filme.nota);
            }
        }
    }

    public void listarFilmesPorAtor(String nomeAtor) {
        Ator ator = buscarAtor(nomeAtor);
        if (ator == null) {
            System.out.println("Ator não encontrado: " + nomeAtor);
            return;
        }

        for (Filme filme : filmes) {
            if (filme.elenco.contains(ator)) {
                System.out.println("Título: " + filme.titulo + ", Diretor: " + filme.diretor.nome + ", Ano: " + filme.anoLancamento + ", Nota: " + filme.nota);
            }
        }
    }

    public void listarFilmesPorNota(double notaMinima) {
        for (Filme filme : filmes) {
            if (filme.nota >= notaMinima) {
                System.out.println("Título: " + filme.titulo + ", Diretor: " + filme.diretor.nome + ", Ano: " + filme.anoLancamento + ", Nota: " + filme.nota);
            }
        }
    }
}

