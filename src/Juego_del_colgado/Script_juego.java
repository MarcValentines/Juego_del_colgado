package Juego_del_colgado;
import java.util.Scanner;
public class Script_juego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entradaTec = new Scanner(System.in);
		
		String palabraSecreta = "";
		
		System.out.println("--REGLAS DEL JUEGO--");
		System.out.println("El adiministrador va a insertar la palabra secreta");
		System.out.println("Se van a pedir el número de jugadores que van a jugar");
		System.out.println("cada jugador va a tener 6 vidas");
		System.out.println("si un jugador se queda sin vidas se acaba el juego");
		
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
		
		int[] vidasPorJug;
		vidasPorJug = new int[numJds];
		int index = 0;
		
		for (int i = 0; i < vidasPorJug.length; i++) {
			vidasPorJug[i] = vidasPorJug[i] + 6;
		}
		
		//parte donde se empiezan las rondas//
		
		while (true) {
			if (vidasPorJug[index] == 0) {
				break;
			}
			index++;
			for (int i = 0; i < numJugadores.length; i++) {
				
			}
		}
		
		
	}

}
