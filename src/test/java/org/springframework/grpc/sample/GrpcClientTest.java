package org.springframework.grpc.sample;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.grpc.sample.proto.HelloReply;
import org.springframework.grpc.sample.proto.HelloRequest;
import org.springframework.grpc.sample.proto.ReactorSimpleGrpc;
import org.springframework.grpc.sample.proto.SimpleGrpc;

public class GrpcClientTest {

    @Test
    public void testSayHello() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        final SimpleGrpc.SimpleBlockingStub stub = SimpleGrpc.newBlockingStub(channel);
        final HelloReply reply = stub.sayHello(HelloRequest.newBuilder().setName("Linux_china").build());
        System.out.println(reply.getMessage());
    }

    @Test
    public void testReactiveSayHello() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        ReactorSimpleGrpc.ReactorSimpleStub stub = ReactorSimpleGrpc.newReactorStub(channel);
        final HelloReply reply = stub.sayHello(HelloRequest.newBuilder().setName("Linux_china").build()).block();
        System.out.println(reply.getMessage());
    }
}
