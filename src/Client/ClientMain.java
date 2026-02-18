package Client;

import java.io.*;
import java.net.Socket;

public class ClientMain {


    public static void main(String[] args) {

        System.out.println("CLIENT: avvio dei client");

        try {
            Socket socket = new Socket("localhost", 3000);

            //OutputStream outputStream = socket.getOutputStream();

            //Stream scrittura
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            );

            // InputStream inputstream = clientSocket.getInputStream();

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
