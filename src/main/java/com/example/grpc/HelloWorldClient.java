package com.example.grpc;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class HelloWorldClient {
    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub blockingStub;

    public HelloWorldClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    HelloWorldClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void greet(String name) {
        System.out.println("Will try to greet " + name + " ...");
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try {
            response = blockingStub.sayHello(request);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }
        System.out.println("Greeting: " + response.getMessage());
    }


    public static void main(String[] args) throws Exception {
        String user = "world";
        HelloWorldClient client = new HelloWorldClient("localhost", 50051);
        try {
            client.greet(user);
        } finally {
            client.shutdown();
        }
    }
}
