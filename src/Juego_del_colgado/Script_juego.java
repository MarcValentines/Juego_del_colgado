package Juego_del_colgado;
import java.util.Scanner;
public class Script_juego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entradaTec = new Scanner(System.in);
		
		String palabraSecreta = "";
		
		System.out.println("inserta la palabra secreta = ");
		palabraSecreta += entradaTec.nextLine().toLowerCase();
		
		int[] numJugadores;
		System.out.println("inserte el numero de jugadores que quieras (mínimo 2) = ");
		int numJds = entradaTec.nextInt();
		while (numJds < 2) {
			System.out.println("vuelve a insertar el numero de jugadores = ");
			numJds = entradaTec.nextInt();
		}
		numJugadores = new int[numJds];
		
	}

}
