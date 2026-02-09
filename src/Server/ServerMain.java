package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) {

        System.out.println("SERVER: inizio esecuzione");
        try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("SERVER: in attesa della richiesta del client");
            Socket clientSocket = server.accept();
            System.out.println("SERVER: il client si è connesso");

        } catch (IOException e) {
            System.err.println("porta non disponibile," + "Errore nella creazione del connetion port");
        }

    }
    }
//ciao
