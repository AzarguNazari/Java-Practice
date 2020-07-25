package com.examples.java11.http;

import com.google.gson.Gson;
import org.junit.Test;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

public class Example {

    @Test
    public void syncGet(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    @Test
    public void asyncGet(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        CompletableFuture<HttpResponse<String>> responseCompletableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        responseCompletableFuture.whenComplete((resp, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println(resp.body());
                System.out.println(resp.statusCode());
            }
        }).join();
    }

    @Test
    public void asyncPost() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        Gson gson = new Gson();
        Foo  foo  = new Foo();
        foo.name = "nice name";
        foo.url = "https://github.com/AzarguNazari";

        String jsonBody = gson.toJson(foo);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://httpbin.org/post"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .whenComplete((resp, t) -> {
                    if (t != null) {
                        t.printStackTrace();
                    } else {
                        System.out.println(resp.body());
                        System.out.println(resp.statusCode());
                    }
                }).join();
    }

    @Test
    public void downloadFile() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://labs.consol.de/"))
                .GET()
                .build();

        Path               tempFile = Files.createTempFile("consol-labs-home", ".html");
        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(tempFile));
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    @Test
    public void uploadFile() throws Exception {
        HttpClient client = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/upload/"))
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("/tmp/files-to-upload.txt")))
                .build();

        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        System.out.println(response.statusCode());
    }

    @Test
    public void proxy() throws Exception {
        HttpClient client = HttpClient.newBuilder()
                .proxy(ProxySelector.of(new InetSocketAddress("127.0.0.1", 1080)))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://www.google.com"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    @Test
    public void basicAuth() throws Exception {
        HttpClient client = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("username", "password".toCharArray());
                    }
                })
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://labs.consol.de"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    @Test
    public void http2() throws Exception {
        HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .version(HttpClient.Version.HTTP_2)
                .build()
                .sendAsync(HttpRequest.newBuilder()
                                .uri(new URI("https://http2.akamai.com/demo"))
                                .GET()
                                .build(),
                        HttpResponse.BodyHandlers.ofString())
                .whenComplete((resp, t) -> {
                    if (t != null) {
                        t.printStackTrace();
                    } else {
                        System.out.println(resp.body());
                        System.out.println(resp.statusCode());
                    }
                }).join();
    }

    @Test
    public void getURIs(List<URI> uris) {
        HttpClient client = HttpClient.newHttpClient();
        List<HttpRequest> requests = uris.stream()
                .map(HttpRequest::newBuilder)
                .map(HttpRequest.Builder::build)
                .collect(toList());

        CompletableFuture.allOf(requests.stream()
                .map(request -> client.sendAsync(request, HttpResponse.BodyHandlers.ofString()))
                .toArray(CompletableFuture<?>[]::new))
                .join();
    }
}
