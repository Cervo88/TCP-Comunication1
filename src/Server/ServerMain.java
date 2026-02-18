package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true
            );

            //lettura richiesta
            String messsaggio = in.readLine();
            System.out.println("SERVER: richiesta = " + clientSocket + "Ha scritto il messaggio, " + messsaggio);


            out.println("Messaggio ricevuto dal server");

            //chiusura
            in.close();
            out.close();
            clientSocket.close();
            server.close();

            System.out.println("SERVER: chiusura della comunicazione");

        } catch (IOException e) {
            System.err.println("porta non disponibile," + "Errore nella creazione del connetion port");
        }


    }
    }

