package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    String nome;
    String colore;
    Socket socket;
    PrintWriter out;
    BufferedReader in;

    // Costruttori
    public Client(String nome) {
        this.nome = nome;
    }

    public Client(String nome, String colore) {
        this.nome = nome;
        this.colore = colore;
    }

    // Connetti al server
    public int connetti(String nomeServer, int portaServer) {
        try {
            socket = new Socket(nomeServer, portaServer);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(nome + " connesso al server " + nomeServer);
            return 0; // successo

        } catch (IOException e) {
            System.err.println("Errore di connessione: " + e.getMessage());
            return -1; // errore
        }
    }

    // Scrivi un messaggio al server
    public void scrivi(String messaggio) {
        out.println(messaggio);
    }

    // Leggi un messaggio dal server
    public void leggi() {
        try {
            String risposta = in.readLine();
            if (risposta != null)
                System.out.println("SERVER: " + risposta);
        } catch (IOException e) {
            System.err.println("Errore di lettura: " + e.getMessage());
        }
    }

    // Chiudi connessione
    public void chiudi() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
            System.out.println("CLIENT: Connessione chiusa.");
        } catch (IOException e) {
            System.err.println("Errore chiusura: " + e.getMessage());
        }
    }
}