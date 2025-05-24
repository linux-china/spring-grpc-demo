Spring Boot gRPC Sample
===========================

spring-grpc demo with Reactive gRPC, and friendly with Spring reactive ecosystem.

Observer style:

```java

@Override
public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
    log.info("Hello " + req.getName());
    HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
}
```

Reactive Style:

```java

@Override
public Mono<HelloReply> sayHello(HelloRequest request) {
    final HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
    return Mono.just(reply);
}
```

# How it works?

- Add virtual thread support in `application.properties`:

```properties
spring.threads.virtual.enabled=true
```

- Add `reactor-core` dependency in `pom.xml`:

```xml
  <dependency>
    <groupId>io.projectreactor</groupId>
    <artifactId>reactor-core</artifactId>
  </dependency>
```

- Generator Reactive stub with [Reactive gRPC](https://github.com/salesforce/reactive-grpc):
- Implement service with reactive style, please extend `ReactorSimpleGrpc.SimpleImplBase`

# References

* spring-grpc: https://github.com/spring-projects-experimental/spring-grpc
* Spring GRPC Docs: https://docs.spring.io/spring-grpc/reference/
* reactive-grpc: https://github.com/salesforce/reactive-grpc
* Mocking gRPC in Spring Boot Microservice Integration Tests with WireMock: https://www.infoq.com/articles/mocking-grpc-microservices/
