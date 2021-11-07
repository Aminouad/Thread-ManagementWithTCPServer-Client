package dao;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Model.Compte;

public class Server {
	static List<Compte> Lc;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Server.Lc=new ArrayList<Compte>();

		int port = 6789;
		ServerSocket socket = new ServerSocket(port);
		while (true) {
		Socket sc = socket.accept();
		Traitement Trait = new Traitement(sc);
		Trait.start();
		}

		}
		
	}


