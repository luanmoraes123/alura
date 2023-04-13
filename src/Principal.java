import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args) {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpReuqest = HttpRequest.newBuilder()
                            .uri(URI.create("https://omdbapi.com/?t=matrix&apikey=667e4b0f"))
                            .build();

        try {
            HttpResponse<String> response = httpClient.send(httpReuqest, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
}
}