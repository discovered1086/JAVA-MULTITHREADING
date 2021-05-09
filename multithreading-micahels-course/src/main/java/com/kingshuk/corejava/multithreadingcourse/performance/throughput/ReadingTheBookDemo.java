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
        final String bookText = new String(Files.readAllBytes(Paths.get("src/main/resources/Pride And Prejudice.txt")));
        startServer(bookText);
    }

    public static void startServer(String theBook) throws IOException {
        final HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/search", new RequestHandler(theBook));
        Executor executor = Executors.newFixedThreadPool(1);
        httpServer.setExecutor(executor);
        httpServer.start();
    }
}
