package com.kingshuk.corejava.multithreadingcourse.performance.throughput;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class RequestHandler implements HttpHandler {
    private final String theBook;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        //We get the query parameter value. This gives us everything
        //after the '?' mark
        final String query = exchange.getRequestURI().getQuery();
        final String[] queryParam = query.split("=");
        String action = queryParam[0];
        String text = queryParam[1];

        if (!"text".equals(action)) {
            exchange.sendResponseHeaders(400, 0);
            return;
        }

        //We match the word sent in the request and count the occurrence
        Matcher matcher = Pattern.compile(text).matcher(theBook);
        long count = 0;

        while (matcher.find()) {
            count++;
        }

        //We create the response in the form of a byte array
        final byte[] bytes = Long.toString(count).getBytes(StandardCharsets.UTF_8);
        //We set the http header with http status and length of the response
        exchange.sendResponseHeaders(200, bytes.length);

        //Finally we write the response to an OutputStream
        final OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(bytes);

        //Closing the output stream will push the response to the client
        //The client in our case being a browser
        responseBody.close();
    }
}
