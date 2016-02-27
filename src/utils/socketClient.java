package utils;
import java.net.*;
import java.io.*;

/**
 * @author Thiago Bueno Fernandes
 * @date: 27/02/2016
 * @version: 1.0
 * @category: exemplo socket cliente
 *  
 */

public class socketClient 
{
	 public static void main(String [] args)
	   {
	      String nomeServidor = "127.0.0.1"; //args[0];
	      
	      //int porta = Integer.parseInt(args[1]);
	      int porta = 6106;
	      try
	      {
	         System.out.println("conectando em " + nomeServidor +
			 " on port " + porta);
	         Socket cliente = new Socket(nomeServidor, porta);
	         System.out.println("Conectado em " 
			 + cliente.getRemoteSocketAddress());
	         OutputStream outToServer = cliente.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         out.writeUTF("Olá "
	                      + cliente.getLocalSocketAddress());
	         InputStream inFromServer = cliente.getInputStream();
	         DataInputStream in =
	                        new DataInputStream(inFromServer);
	         System.out.println("Server says " + in.readUTF());
	         cliente.close();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	   }
}
