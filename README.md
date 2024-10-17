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

# References

* spring-grpc: https://github.com/spring-projects-experimental/spring-grpc
* reactive-grpc: https://github.com/salesforce/reactive-grpc