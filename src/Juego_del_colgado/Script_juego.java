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
		
		//numero de jugadores en la partida
		int[] numJugadores;
		System.out.println("inserte el numero de jugadores que quieras (mínimo 2) = ");
		int numJds = entradaTec.nextInt();
		while (numJds < 2) {
			System.out.println("vuelve a insertar el numero de jugadores = ");
			numJds = entradaTec.nextInt();
		}
		numJugadores = new int[numJds];
		
		//vidas de los jugadores
		int[] vidasPorJug;
		vidasPorJug = new int[numJds];
		int index = 0;
		
		for (int i = 0; i < vidasPorJug.length; i++) {
			vidasPorJug[i] = vidasPorJug[i] + 6;
		}
		
		//nombres de los jugadores//
		String[] nombres;
		nombres = new String[numJds];
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Inserta el nombre del jugador = ");
			nombres[i] = entradaTec.next();
		}
		
		//parte donde se empiezan las rondas//
		
		while (true) {
			//en caso de que las vidas lleguen a 0
			if (vidasPorJug[index] == 0) {
				break;
			}
			
			for (int i = 0; i < numJugadores.length; i++) {
				System.out.println("elección del jugador " + nombres[i]);
				
			}
			
			//en caso de que las vidas lleguen a 0
			if (vidasPorJug[index] == 0) {
				break;
			}
			index++;
		}
		
		
	}

}
