import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.exception.ConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;

public class Principal {
    public static void main(String[] args) {

        try {
            List<Titulo> titulos = new ArrayList<>();
            Scanner leitor = new Scanner(System.in);
            String filme = "";

            while (!filme.equalsIgnoreCase("sair")) {
                filme = leitor.nextLine();
                if(filme.equalsIgnoreCase("sair")){
                    break;
                }
                String endereco = "https://omdbapi.com/?t=" + filme.replace(" ", "+") + "&apikey=667e4b0f";

                HttpClient httpClient = HttpClient.newHttpClient();
                HttpRequest httpReuqest = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = httpClient.send(httpReuqest, HttpResponse.BodyHandlers.ofString());
                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .create();

                TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                titulos.add(meuTitulo);
                
            }
            Gson gson = new Gson();
            String json = gson.toJson(titulos);
            FileWriter escrita = new FileWriter("filmes.txt");
                escrita.write(json);
                escrita.close();
            leitor.close();
        } catch (IOException | NumberFormatException | InterruptedException | ConversaoDeAnoException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}