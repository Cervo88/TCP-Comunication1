package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClientMain {

    public static void main(String[] args) {

        Client client = new Client("Client1");

        if(client.connetti("localhost", 3000) == 0) {

            BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

            try {
                String messaggio;

                while (true) {
                    System.out.print("Scrivi messaggio: ");
                    messaggio = tastiera.readLine();

                    client.scrivi(messaggio);

                    if (messaggio.equalsIgnoreCase("fine"))
                        break;

                    client.leggi();
                }

                client.chiudi();

            } catch (Exception e) {
                System.err.println("Errore: " + e.getMessage());
            }

        } else {
            System.out.println("Impossibile connettersi al server.");
        }
    }
}

