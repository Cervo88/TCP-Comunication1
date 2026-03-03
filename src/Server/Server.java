package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;

    public Server(int porta) {

        this.porta = porta;
    }

    public void scrivi(){

    }

    public void leggi() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
            String messaggioDalClient = in.readLine();
            System.out.println("Messaggio ricevuto dal client: " + messaggioDalClient);
        } catch (IOException e) {
            System.err.println("Errore di lettura: " + e.getMessage());
        }
    }

    public void chiudi(){

    }

    public void termina(){

    }
}
