package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServerMain {

    public static void main(String[] args) {

        Server server = new Server(3000);
        server.avvioServer();
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        try {
            String messaggio;
            String risposta;

            while (true) {

                messaggio = server.leggi();

                if (messaggio == null || messaggio.equalsIgnoreCase("fine"))
                    break;

                System.out.println("CLIENT: " + messaggio);

                System.out.print("Risposta SERVER: ");
                risposta = tastiera.readLine();

                server.scrivi(risposta);

                if (risposta.equalsIgnoreCase("fine"))
                    break;
            }

            server.chiudi();

        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}
