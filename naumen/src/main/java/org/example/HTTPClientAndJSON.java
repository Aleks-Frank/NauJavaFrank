package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class HTTPClientAndJSON {

    private static final String url = "https://httpbin.org/anything";

    public static void connect(){

        try (HttpClient client = HttpClient.newHttpClient()){
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Map<String, List<String>> headers = response.headers().map();
            List<String> acceptValues = headers.get("Accept");
            if (acceptValues != null){
                for (String acceptValue : acceptValues){
                    System.out.println(acceptValue);
                }
            } else {
                System.out.println("Поле не найдено");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
