package UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.SocketException;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte[] enviar=new byte[1024];
		
		
		
		try {
			MulticastSocket sck=new MulticastSocket(500);
			InetAddress ip=InetAddress.getByName("255.0.0.0");
			sck.joinGroup(ip);
			while(true) {
				byte[] recibir=new byte[1024];
				DatagramPacket paquete=new DatagramPacket(recibir, recibir.length);
				sck.receive(paquete);
				recibir=paquete.getData();
				String clima=recibir.toString();
				
				System.out.println("El clima de hoy es: "+clima);
			}
			
		} catch (Exception e) {e.printStackTrace();}
	}

}
