package com.example.grpc;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloWorldJsonClient {

    public static void main(String[] args) throws Exception {
        String name = "world";
        if (args.length > 0) {
            name = args[0];
        }

        URL url = new URL("http://localhost:8080/greet");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("name", name);

        OutputStream os = conn.getOutputStream();
        os.write(jsonRequest.toString().getBytes());
        os.flush();

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            JSONObject jsonResponse = new JSONObject(output);
            System.out.println(jsonResponse.getString("message"));
        }

        conn.disconnect();
    }
}
