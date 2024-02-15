package Model;

import java.util.List;

public class Filme {
    String titulo;
    Diretor diretor;
    List<Ator> elenco;
    int anoLancamento;
    double nota;

    public Filme(String titulo, Diretor diretor, List<Ator> elenco, int anoLancamento, double nota) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.elenco = elenco;
        this.anoLancamento = anoLancamento;
        this.nota = nota;
    }
}