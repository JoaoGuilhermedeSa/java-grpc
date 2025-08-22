# gRPC Java POC

This is a proof-of-concept project for gRPC in Java. It contains a simple HelloWorld service to demonstrate the basic functionalities of gRPC.

## Project Structure

- `pom.xml`: The Maven project file. It contains all the dependencies and build configurations.
- `src/main/proto/HelloWorld.proto`: The protobuf file that defines the gRPC service and messages.
- `src/main/java/com/example/grpc/HelloWorldServer.java`: The gRPC server implementation.
- `src/main/java/com/example/grpc/HelloWorldClient.java`: The gRPC client implementation.
- `src/main/java/com/example/grpc/HelloWorldJsonServer.java`: The gRPC server implementation with JSON transcoding.
- `src/main/java/com/example/grpc/HelloWorldJsonClient.java`: The gRPC client implementation with JSON transcoding.

## How to run

1. **Compile the project:**

```bash
mvn compile
```

2. **Run the server:**

```bash
mvn exec:java -Dexec.mainClass=com.example.grpc.HelloWorldServer
```

3. **In a separate terminal, run the client:**

```bash
mvn exec:java -Dexec.mainClass=com.example.grpc.HelloWorldClient
```

## JSON Transcoding

This project also includes an example of JSON transcoding. The `HelloWorldJsonServer` serves the same gRPC service, but it also exposes a RESTful JSON API on a different port. The `HelloWorldJsonClient` can communicate with this server using either gRPC or JSON.

### How to run the JSON server and client

1. **Run the JSON server:**

```bash
mvn exec:java -Dexec.mainClass=com.example.grpc.HelloWorldJsonServer
```

2. **In a separate terminal, run the JSON client:**

```bash
mvn exec:java -Dexec.mainClass=com.example.grpc.HelloWorldJsonClient
```

## How to test

To run the tests, execute the following command:

```bash
mvn test
```
