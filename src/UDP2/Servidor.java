package UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Scanner;

public class Servidor {

	public static Scanner sc;
	
	public static String Opcion() {
		Scanner entrada=new Scanner(System.in);
		int opcion;
		System.out.println("1.Lluvioso");
		System.out.println("2.Soleado");
		System.out.println("3.Nublado");
		System.out.println("4.Nuboso");
		System.out.println("5.Tormenta");
		System.out.println("6.Nieve");
		switch(opcion=entrada.nextInt()) {
		
		case 1:
			return "Lluvioso";
		case 2:
			return "Soleado";
		case 3:
			return "Nublado";
		case 4:
			return "Lluvioso";
		case 5:
			return "Tormenta";
		case 6:
			return "Nieve";
			default:
				return "Seleccione una opcion correcta";			
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			byte[] recibir=new byte[1024];
			
			MulticastSocket sck=new MulticastSocket(500);
			InetAddress ip=InetAddress.getByName("255.0.0.1");
			sck.joinGroup(ip);
			
			while(true) {
				byte[] enviar=new byte[1024];
				String clima=Opcion();
				enviar=clima.getBytes();
				DatagramPacket paquete=new DatagramPacket(enviar, enviar.length,ip,500);
				sck.send(paquete);
			}
			
			
			
			
			
			
		} catch (Exception e) {e.printStackTrace();}
		
		
	}

}
