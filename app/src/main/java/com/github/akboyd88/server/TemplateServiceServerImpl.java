package com.github.akboyd88.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.java.Log;
import javax.inject.Inject;
import java.io.IOException;

@Log
public class TemplateServiceServerImpl {
    private static final int PORT = 50051;
    private Server server;
    private final TemplateServiceImpl templateService;

    @Inject
    public TemplateServiceServerImpl(TemplateServiceImpl templateService) {
        this.templateService = templateService;
    }

    public void start() throws IOException {
        log.info("Starting server");
        server = ServerBuilder.forPort(PORT)
                .addService(templateService)
                .build()
                .start();
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server == null) {
            return;
        }
        log.info("Blocking until server terminates");
        server.awaitTermination();
    }
}
