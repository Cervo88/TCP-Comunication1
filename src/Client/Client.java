package Client;

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



}
