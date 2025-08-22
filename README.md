# gRPC Java POC

This is a proof-of-concept project for gRPC in Java. It contains a simple HelloWorld service to demonstrate the basic functionalities of gRPC.

## Project Structure

- `pom.xml`: The Maven project file. It contains all the dependencies and build configurations.
- `src/main/proto/HelloWorld.proto`: The protobuf file that defines the gRPC service and messages.
- `src/main/java/com/example/grpc/HelloWorldServer.java`: The gRPC server implementation.
- `src/main/java/com/example/grpc/HelloWorldClient.java`: The gRPC client implementation.

## How to run

1. **Compile the project:**

```bash
mvn -f grpc-java-poc/pom.xml compile
```

2. **Run the server:**

```bash
mvn -f grpc-java-poc/pom.xml exec:java -Dexec.mainClass=com.example.grpc.HelloWorldServer
```

3. **In a separate terminal, run the client:**

```bash
mvn -f grpc-java-poc/pom.xml exec:java -Dexec.mainClass=com.example.grpc.HelloWorldClient
```

## How to test

To run the tests, execute the following command:

```bash
mvn -f grpc-java-poc/pom.xml test
```
