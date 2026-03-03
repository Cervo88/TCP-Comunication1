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

    public Client(String nome) {

        this.nome = nome;
    }

    public Client(String nome, String colore) {
        this.nome = nome;
        this.colore = colore;
    }

    public int connetti(String nomeServer, int portaServer) {
        try {
            this.socket = new Socket(nomeServer, portaServer);
            System.out.println(nome + " connesso al server " + nomeServer);
            return 0; // Successo
        } catch (IOException e) {
            System.err.println("Errore di connessione: " + e.getMessage());
            return -1; // Errore
        }
    }

    String messaggio;

    public void scrivi() {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(messaggio);
            } catch (IOException e) {
                System.err.println("Errore in scrittura: " + e.getMessage());
            }

    }

    public void leggi() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            String messaggioRicevuto = in.readLine();
            System.out.println("Risposta dal server: " + messaggioRicevuto);
        } catch (IOException e) {
            System.err.println("Errore di lettura: " + e.getMessage());
        }
    }

    public void chiudi() {
        try {
            if (socket != null) socket.close();
            System.out.println("Connessione chiusa.");
        } catch (IOException e) {
            System.err.println("Errore chiusura: " + e.getMessage());
        }
    }

    }


