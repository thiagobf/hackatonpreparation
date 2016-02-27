package utils;

/**
 * @author Thiago Bueno Fernandes
 * @date: 27/02/2016
 * @version: 1.0
 * @category: exemplo socket server
 *  
 */

import java.net.*;
import java.io.*;

public class socketServer extends Thread
{
   private ServerSocket serverSocket;
   
   public socketServer(int porta) throws IOException
   {
      serverSocket = new ServerSocket(porta);
      serverSocket.setSoTimeout(10000);
   }

   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Aguardando conexão do cliente na porta " +
            serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("Conectado "
                  + server.getRemoteSocketAddress());
            DataInputStream in =
                  new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
            DataOutputStream out =
                 new DataOutputStream(server.getOutputStream());
            out.writeUTF("Obrigado por conectar "
              + server.getLocalSocketAddress() + "\nAdeus!");
            server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket time out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
      //int porta = Integer.parseInt(args[0]); 
	   int porta = 6106;
      try
      {
         Thread t = new socketServer(porta);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}