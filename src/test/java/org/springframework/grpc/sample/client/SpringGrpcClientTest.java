package org.springframework.grpc.sample.client;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.grpc.sample.proto.HelloRequest;
import org.springframework.grpc.sample.proto.SimpleGrpc;

@SpringBootTest
public class SpringGrpcClientTest {
    @Autowired
    private SimpleGrpc.SimpleBlockingStub stub;

    @Test
    public void testSayHello() {
        System.out.println(stub.sayHello(HelloRequest.newBuilder().setName("Linux_china").build()).getMessage());
    }
}
