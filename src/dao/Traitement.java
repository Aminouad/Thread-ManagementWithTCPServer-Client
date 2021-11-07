package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Model.Compte;


public class Traitement extends Thread {
	private Socket connSc;
	
	public Traitement(Socket connSc) {
		super();
		this.connSc = connSc;
	}
	
	public void run(){
		String msgClient;
		while(true) {
			try {	
				Compte Compteclient1 =new Compte();
				
				
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connSc.getInputStream()));
			  int r=0;
			 msgClient=inFromClient.readLine();
             if(msgClient.startsWith("CREATION"))
             { 
 			Compte Compteclient=new Compte(((Server.Lc).size()+1),msgClient.substring(9),0);
            	 if(Server.Lc.contains(Compteclient)) {
            		 PrintWriter outToClient=new PrintWriter(new BufferedWriter(new OutputStreamWriter(connSc.getOutputStream())),true);
                     outToClient.println("Compte exist");
            	 }else {
            		 Server.Lc.add(Compteclient);
                	 PrintWriter outToClient=new PrintWriter(new BufferedWriter(new OutputStreamWriter(connSc.getOutputStream())),true);
                     outToClient.println("Compte est créé avec succés num ="+Compteclient.getId());
            	 }
            	 
            	 
            	 
            	 while(true) {
         			BufferedReader inFromClient2 = new BufferedReader(new InputStreamReader(connSc.getInputStream()));
         			msgClient=inFromClient.readLine();
                    if(msgClient.startsWith("DEBIT")) {
                    	float soldeFinal=(Compteclient.getSolde())-(Float.parseFloat(msgClient.substring(6)));
                    	if(soldeFinal>=0) {
                    		Compteclient.setSolde(soldeFinal);
                    		PrintWriter outToClient=new PrintWriter(new BufferedWriter(new OutputStreamWriter(connSc.getOutputStream())),true);
                            outToClient.println("Compte débité avec succés");
                    		
                    	}else {
                    		
                    		PrintWriter outToClient=new PrintWriter(new BufferedWriter(new OutputStreamWriter(connSc.getOutputStream())),true);
                            outToClient.println("Solde insufisant");
                    	}
                    	
                    }
                    
                    if(msgClient.startsWith("CREDIT")) {
                    	float soldeFinal=Compteclient.getSolde()+Float.parseFloat(msgClient.substring(7));
                    	
                    		Compteclient.setSolde(soldeFinal);
                    		PrintWriter outToClient=new PrintWriter(new BufferedWriter(new OutputStreamWriter(connSc.getOutputStream())),true);
                            outToClient.println("Compte crédité avec succés");
                    		
                    	}
                    
                    if(msgClient.startsWith("SOLDE")) {
                    	float soldeFinal=Compteclient.getSolde();
                    	     
                    		PrintWriter outToClient=new PrintWriter(new BufferedWriter(new OutputStreamWriter(connSc.getOutputStream())),true);
                            outToClient.println("Solde: "+soldeFinal);
                    		
                    	}
                    	
                    }

                    
                    
            	 }
            	 
             }
             
             
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		}
		
		
	

}}
