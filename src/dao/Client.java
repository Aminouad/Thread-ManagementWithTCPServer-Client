package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
    
		String hostname="127.0.0.1";
		int port = 6789;
		String msgC = null ; 
		String msgRcv ;
		BufferedReader inFromUser= new BufferedReader(new InputStreamReader(System.in));
		
		
		Socket clientSocket=new Socket(hostname,port);
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		
		while(true) {
		
		PrintWriter outToServer=new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())),true);
		msgC=inFromUser.readLine();
		outToServer.println(msgC);
        
		msgRcv=inFromServer.readLine();
		
		
		System.out.println("FROM SERVER "+ msgRcv);
		
		
		}
		
	}

}
