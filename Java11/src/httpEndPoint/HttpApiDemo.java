package httpEndPoint;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.UUID;

public class HttpApiDemo {
    public static void main(String[] args) {
        String uri="https://postman-echo.com/get";

        HttpRequest httpRequest= HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .version(HttpClient.Version.HTTP_2).header("trace_id", UUID.randomUUID().toString())
                .timeout(Duration.ofMillis(100000L))
                .build();

        HttpClient httpClient=HttpClient.newBuilder()
                .build();

        HttpResponse<String> httpResponse= null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(httpResponse.statusCode()+"\n"+httpResponse.body());
    }
}
