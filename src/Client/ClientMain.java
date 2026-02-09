package Client;

import java.io.IOException;
import java.net.Socket;

public class ClientMain {


    public static void main(String[] args) {

        System.out.println("CLIENT: avvio del client");

        try {
            Socket socket = new Socket("localhost", 3000);

        } catch (IOException e) {
            System.err.println("Errore nella connesione del server");

        }
    }

    }
