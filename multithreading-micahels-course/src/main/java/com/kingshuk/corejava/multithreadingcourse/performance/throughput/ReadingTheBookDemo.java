package com.kingshuk.corejava.multithreadingcourse.performance.throughput;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ReadingTheBookDemo {

    public static void main(String[] args) throws IOException {
        final String bookText = new String(Files.readAllBytes(
                Paths.get("src/main/resources/war_and_peace.txt")));
        startServer(bookText);
    }

    public static void startServer(String theBook) throws IOException {
        //Instantiate a new server with the port 8080 on localhost and with an initial thread pool of 0
        final HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

        //Add a request path called /search which when invoked will be handled by
        //A request handler
        httpServer.createContext("/search", new RequestHandler(theBook));

        //We create an Executor with a single thread
        Executor executor = Executors.newFixedThreadPool(3);

        //Then we set that executor to the http server we have created
        httpServer.setExecutor(executor);

        //Then we start the HTTP Server
        httpServer.start();
    }
}
