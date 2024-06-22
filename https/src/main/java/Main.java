import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args) {
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.out.println("Lo  gs from your program will appear here!");

    // Uncomment this block to pass the first stage
    //
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    String response = "fehiwfw";
    
    try {
      serverSocket = new ServerSocket(4221);
    
      // Since the tester restarts your program quite often, setting SO_REUSEADDR
      // ensures that we don't run into 'Address already in use' errors
      serverSocket.setReuseAddress(true);
     // System.out.println("erversocket");
      
      clientSocket = serverSocket.accept(); // Wait for connection from client.
      BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      String requestLine = reader.readLine();
      String[] HttpRequest = requestLine.split(" ");
      String[] str = HttpRequest[1].split("/");
      System.out.println("STR: "+ requestLine);




      
      reader.readLine();
        String useragent = reader.readLine().split("\\s+")[1];
        System.out.println("Useragent"+ useragent);
     // System.out.println(requestLine);
      String[] arrOfStr = requestLine.split(" ", 5);
      String path = arrOfStr[1];
      String path2 = arrOfStr[1];
      String[] arrOfPath = requestLine.split("/", 5);
      String pathstring = arrOfPath[1];
      String pathstring2 = arrOfPath[2];
      String[] arrOfFruit = pathstring2.split(" ", 5);
      String p = arrOfFruit[0];
      System.out.println("path :" + path);
      
      if (pathstring.equals("echo")){
        if(pathstring2!=null){
          String reply = "HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\nContent-Length: " + p.length() + "\r\n\r\n" + p;
        clientSocket.getOutputStream().write(reply.getBytes());
        }
      }
      if (path.equals("/")) {
        clientSocket.getOutputStream().write(
          "HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\nContent-Length: 3\r\n\r\nabc".getBytes());
          System.out.println("///");
      }
      clientSocket.getOutputStream().write(
          "HTTP/1.1 404 Not Found\r\n\r\n".getBytes());
      System.out.println("accepted new connection");
      
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    }
  }
}
