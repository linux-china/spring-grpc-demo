package org.springframework.grpc.sample;

import org.springframework.grpc.sample.proto.HelloReply;
import org.springframework.grpc.sample.proto.HelloRequest;
import org.springframework.grpc.sample.proto.ReactorSimpleGrpc;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveSimpleServiceImpl extends ReactorSimpleGrpc.SimpleImplBase {
    @Override
    public Mono<HelloReply> sayHello(HelloRequest request) {
        return Mono.just(HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
    }

    @Override
    public Flux<HelloReply> streamHello(HelloRequest request) {
        return Flux.just(HelloReply.newBuilder().setMessage("Hello " + request.getName()).build(),
                HelloReply.newBuilder().setMessage("Hello2 " + request.getName()).build());
    }
}
