package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMain {


    public static void main(String[] args) {

        System.out.println("CLIENT: avvio del client");

        try {
            Socket socket = new Socket("localhost", 3000);

            //Stream scrittura
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            );

            //Stream lettura
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            out.println("CLIENT: Aggiungi un prodotto al carrello!");

            String invio = in.readLine();
            System.out.println("ClIENT: risposta = " + invio);

            in.close();
            out.close();
            socket.close();

            System.out.println("CLIENT: chiusura della comunicazione");



        } catch (IOException e) {
            System.err.println("Errore nella connesione del server");

        }
    }

    }
