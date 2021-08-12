package com.example.sep3t3demo;

import com.example.sep3t3demo.socket.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@SpringBootApplication
public class Sep3T2DemoApplication {

    public static void main(String[] args)  throws RemoteException, NotBoundException {

        SpringApplication.run(Sep3T2DemoApplication.class, args);
        Server server = new Server();
        server.communicate();
    }
}
