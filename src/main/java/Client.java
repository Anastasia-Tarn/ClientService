import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;




public class Client {

    public static void main(String[] args) {

        String host = "127.0.0.1";

        try (Socket clientSocket = new Socket(host,9256);
             BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String name = br.readLine();
            out.println(name+"\n" + "Host: netology.ru\n\n\n");
            out.flush();

            String resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
}
