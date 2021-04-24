package com.github.akboyd88.server;

import com.github.akboyd88.proto.TemplateProtos;
import com.github.akboyd88.proto.TemplateServiceGrpc.TemplateServiceImplBase;
import com.github.akboyd88.services.EchoService;
import com.github.akboyd88.services.MultiplyService;
import io.grpc.stub.StreamObserver;
import lombok.extern.java.Log;
import javax.inject.Inject;

import java.util.logging.Level;

@Log
public class TemplateServiceImpl extends TemplateServiceImplBase {

    private final EchoService echoService;
    private final MultiplyService multiplyService;

    @Inject
    public TemplateServiceImpl(EchoService echoService, MultiplyService multiplyService){
        this.echoService = echoService;
        this.multiplyService = multiplyService;
    }

    @Override
    public void echo(TemplateProtos.EchoMessage request, StreamObserver<TemplateProtos.EchoResponse> responseObserver) {
        log.log(Level.INFO, "Echo Request Received");
        responseObserver
                .onNext(TemplateProtos.EchoResponse.newBuilder().setReply(echoService.echo(request.getMessage()))
                        .build());
        responseObserver.onCompleted();
    }

    @Override
    public void multiply(TemplateProtos.MultiplyMessage request, StreamObserver<TemplateProtos.MultiplyResponse> responseObserver) {
        log.log(Level.INFO, "Multiply Request Received");
        responseObserver.onNext(
                TemplateProtos.MultiplyResponse.newBuilder()
                        .setProduct(multiplyService.multiply(request.getA(), request.getB()))
                        .build());
        responseObserver.onCompleted();
    }
}
