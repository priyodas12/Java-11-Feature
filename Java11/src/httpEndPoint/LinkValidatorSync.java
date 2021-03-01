package httpEndPoint;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class LinkValidatorSync {

    private static HttpClient client;

    public static String validateLink(String link){

       HttpRequest request=
               HttpRequest.newBuilder(URI.create(link))
                .GET()
                .build();
        try{
            HttpResponse<Void> response=client.send(request, HttpResponse.BodyHandlers.discarding());
            return responseToString(response);
        }catch(IOException | InterruptedException e){
            return String.format("%s->(isValid: %s)(status: %s)",request.uri(),false,404);
        }
    }

    public static String responseToString(HttpResponse<Void> response){
        int status=response.statusCode();
        boolean success=status>=200 && status <=299;
        return String.format("%s->(isValid: %s)(status: %s)",response.uri(),success,status);
    }

    public static void main(String[] args) throws IOException {

        client=HttpClient.newHttpClient();

        Files.lines(Path.of("C:\\Users\\Priyo\\IdeaProjects\\Java-11-Feature\\Java11\\src\\httpEndPoint\\urls.txt"))
                .map(LinkValidatorSync::validateLink)
                .forEach(System.out::println);

    }
}
