package org.Shiv.API.request;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import org.Shiv.utils.ConfigLoader;
import org.testng.Assert;

public class GeminiAIRequest {
    public HttpResponse getGeminiAIRequest(String prompt)
        throws IOException, URISyntaxException, InterruptedException {

        URI uri = new URI(ConfigLoader.getApiBaseURI() + "v1beta/models/" +
            ConfigLoader.getModel() + ":generateContent?key=" +
            ConfigLoader.getApiKey());

        // Set up HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Create request body
        Map<String, Object> bodyMap = Map.of(
            "contents", List.of(Map.of("parts", List.of(Map.of("text", prompt))))
        );
        String requestBody = new Gson().toJson(bodyMap);

        // Create the POST request
        HttpRequest request = HttpRequest.newBuilder()
            .uri(uri)
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .build();

        // Send the request and get the response
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Log the response details
        System.out.println("API Response - Status Code: " + response.statusCode ());
        System.out.println ("-- "+requestBody);
        // Validate the response status code
        Assert.assertEquals(response.statusCode (), 200);
        //Validate the response body should not null
        Assert.assertTrue (!response.body ().toString ().isEmpty ());
        return response;
    }
}
