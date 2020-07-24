import java.util.List;
import java.util.stream.Collectors;

public class HTTP2AndProcess {

    public static void main(String[] args) throws Exception{

         // Handle process
//
//        new Process();
//
//        ProcessHandle processHandle = new Process().toHandle();
//
//        ProcessHandle.of(123); // get processHander of process 123

//        ProcessHandle.current().pid();

//        ProcessHandle.allProcesses().forEach(pid -> {
//            System.out.println(pid.info());
//        });

//         ProcessHandle.allProcesses()
//                 .map(ProcessHandle::info)
//                 .sorted(Comparator.comparing(info -> info.startInstant().orElse(Instant.MAX)))
//                 .forEach(HTTP2AndProcess::printInfo);

//        ProcessHandle textEditorHandler = ProcessHandle.allProcesses()
//                .filter(h -> h.info().commandLine().map(cmd -> cmd.contains("TextEdit")).orElse(false))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("No matching handle found"));
//
//        System.out.println(textEditorHandler.info());
//        textEditorHandler.onExit().thenAccept(h -> System.out.println("Textedit was kiled by java!"))
//
//                boolean shutdown = textEditorHandler.destroy();
//
//        textEditorHandler.onExit().join();
//
//        System.out.println("Shutdown " + shutdown);


//        final HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("http://www.google.com")).GET().build();
//        HttpClient client = HttpClient.newHttpClient();
//
//
//        HttpResponse<String> send = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//
//        if(send.statusCode() == 200){
//            System.out.println(send.headers().map());
//        }

//        HttpClient.Builder builder = HttpClient.newBuilder();
//        builder.version(HttpClient.Version.HTTP_2).followRedirects(HttpClient.Redirect.ALWAYS);
//
//        HttpClient client = builder.build();
//
//        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com")).headers("User-Agent", "Java")
//                .timeout(Duration.ofMillis(500))
//                .GET()
//                .build();
//
//        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
//
//        response.thenAccept(r -> {
//            System.out.println("version: " + r.version());
//            System.out.println(r.body());
//        });
//
//        response.join();


        // StackWalker

        StackWalker walker = StackWalker.getInstance();
        List<Integer> lines = walker.walk(stackStream ->
            stackStream.filter(f -> f.getMethodName().startsWith("m"))
                    .map(StackWalker.StackFrame::getLineNumber)
                    .collect(Collectors.toList())
        );

        System.out.println(lines);


    }

    private static void printInfo(ProcessHandle.Info info){
        if(info.startInstant().isPresent() && info.command().isPresent()){
            System.out.println("Started at: " + info.startInstant().get() + ", Command: " + info.command().get());
        }
    }

}
