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
        final String query = exchange.getRequestURI().getQuery();
        final String[] queryParam = query.split("=");
        String action = queryParam[0];
        String text = queryParam[1];

        if (!"text".equals(action)) {
            exchange.sendResponseHeaders(400, 0);
            return;
        }

        Matcher matcher = Pattern.compile(text).matcher(theBook);
        long count = 0;

        while (matcher.find()) {
            count++;
        }

        final byte[] bytes = Long.toString(count).getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(200, bytes.length);
        final OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(bytes);
        responseBody.close();
    }
}
