import java.util.ArrayList;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme("O poderoso chefao", 1970);
        Serie lost = new Serie("Lost", 2000);
        Filme outroFilme = new Filme("Avatar", 2023);;
        var filmeDoPaulo = new Filme("Dogville", 2003);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(outroFilme);
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(lost);

        for (Titulo titulo : lista) {
            System.out.println(titulo);
        }

        lista.forEach(System.out::println);

    }
}