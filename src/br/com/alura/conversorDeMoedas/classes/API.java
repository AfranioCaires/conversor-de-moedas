package br.com.alura.conversorDeMoedas.classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    private String apiKey;

    public API(String apiKey) {
        this.apiKey = apiKey;
    }

    public Currency resquetCurrency(String currency) {
        String requestAddress = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/";

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestAddress + currency))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return gson.fromJson(response.body(), Currency.class);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Houve um erro: " + e.getMessage());
        }

        return null;
    }
}
