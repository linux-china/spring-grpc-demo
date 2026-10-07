build:
  mvn -DskipTests clean package

native-build:
  mvn -DskipTests -Pnative native:compile

list-metadata:
  mvn native:list-libraries-missing-metadata

start:
  mvn -DskipTests spring-boot:run

list-services:
  grpcurl -plaintext "localhost:9090" list

call-say-hello:
  grpcurl  -plaintext -d '{"name": "jackie"}' localhost:9090 Simple/SayHello