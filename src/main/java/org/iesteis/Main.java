package org.iesteis;

import org.iesteis.model.Response;
import org.iesteis.model.ResultsItem;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static HttpResponse<String> readAPIRest() {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;

        try{
            HttpRequest request = HttpRequest.newBuilder()
                                             .uri(URI.create("https://rickandmortyapi.com/api/character"))
                                             .GET()
                                             .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    static void getCharactersStatus() {
        ObjectMapper mapper = new ObjectMapper();
        HttpResponse<String> response = readAPIRest();

        Response r = mapper.readValue(response.body(), Response.class);
        r.getResults().forEach(resultsItem -> System.out.println("Nombre: " + resultsItem.getName() + "\n\tEstado: " + resultsItem.getStatus() + "\n\tImagen: " + resultsItem.getImage()));
    }

    static void getOriginsDemographic() {
        ObjectMapper mapper = new ObjectMapper();
        HttpResponse<String> response = readAPIRest();

        Response r = mapper.readValue(response.body(), Response.class);
        Map<String, Long> personajesPais = r.getResults().stream()
                                                         .collect(Collectors.groupingBy(resultsItem -> resultsItem.getOrigin().getName(), Collectors.counting()));

        personajesPais.forEach((key, value) -> System.out.println("País: " + key + " --- cantindad de personajes: " + value));
    }

    static void getGenderDemographic() {
        ObjectMapper mapper = new ObjectMapper();
        HttpResponse<String> response = readAPIRest();

        Response r = mapper.readValue(response.body(), Response.class);
        Map<String, Long> personajesGenero = r.getResults().stream()
                                                           .collect(Collectors.groupingBy(ResultsItem::getGender, Collectors.counting()));

        personajesGenero.forEach((key, value) -> System.out.println("Género: " + key + " --- cantindad de personajes: " + value));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder mensaje = new StringBuilder();
        boolean continuar = true;

        mensaje.append("Eliga qué quiere hacer:\n");
        mensaje.append("1: Mostrar los nombres de personajes junto a su estado e imagen.\n");
        mensaje.append("2: Mostrar la demográfica de orígenes.\n");
        mensaje.append("3: Mostrar la demográfica de géneros.\n");
        mensaje.append("4: Salir.\n");
        System.out.print(mensaje);

        while(continuar) {

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    getCharactersStatus();
                    break;
                case "2":
                    getOriginsDemographic();
                    break;
                case "3":
                    getGenderDemographic();
                    break;
                case "4":
                    continuar = false;
                    System.out.println("Entendido. Que tenga un buen día ( ^-^)/");
                    break;
                default:
                    System.out.println("Opción invalida, por favor, eliga una opción disponible");
                    break;
            }
        }
    }
}
