package org.iesteis;

import org.iesteis.model.Response;
import org.iesteis.model.ResultsItem;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static void readAPIRest() {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();

        try{
            HttpRequest request = HttpRequest.newBuilder()
                                             .uri(URI.create("https://rickandmortyapi.com/api/character"))
                                             .GET()
                                             .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Response r = mapper.readValue(response.body(), Response.class);
            r.getResults().stream().forEach(resultsItem -> System.out.println("Nombre: " + resultsItem.getName() + "\n\tEstado: " + resultsItem.getStatus() + "\n\tImagen: " + resultsItem.getImage()));
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void main() {
        readAPIRest();

    }


}
