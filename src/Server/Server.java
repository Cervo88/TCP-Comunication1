package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;
    PrintWriter out;
    BufferedReader in;

    public Server(int porta) {
        this.porta = porta;
    }

    // Avvia il server e accetta un client
    public void avvioServer() {
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("SERVER: in attesa del client...");
            clientSocket = serverSocket.accept();
            System.out.println("SERVER: client connesso");

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

        } catch (IOException e) {
            System.err.println("Errore avvio server: " + e.getMessage());
        }
    }

    // Legge un messaggio dal client e lo restituisce
    public String leggi() {
        try {
            return in.readLine();
        } catch (IOException e) {
            System.err.println("Errore di lettura: " + e.getMessage());
            return null;
        }
    }

    // Scrive un messaggio al client
    public void scrivi(String messaggio) {
        out.println(messaggio);
    }

    // Chiude tutto
    public void chiudi() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();

            System.out.println("SERVER: comunicazione chiusa");

        } catch (IOException e) {
            System.err.println("Errore chiusura: " + e.getMessage());
        }
    }
}