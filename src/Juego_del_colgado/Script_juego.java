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
		
		//nombres de los jugadores
		String[] nombres;
		nombres = new String[numJds];
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Inserta el nombre del jugador = ");
			nombres[i] = entradaTec.next();
		}
		
		
		
		//guardar las letras de la palabra clave dentro de un array
		String[] letras;
		letras = new String[palabraSecreta.length()];
		
		for (int i = 0; i < letras.length; i++) {
			char letraEsp = palabraSecreta.charAt(i);
			letras[i] = letraEsp + "";
		}
		
		//las letras que se van a mostrar en pantalla siempre que se termine de escribir la letra
		String[] letrasPrint;
		letrasPrint = new String[letras.length];
		
		for (int i = 0; i < letrasPrint.length; i++) {
			letrasPrint[i] = "_"; //mantener que tengan un _ por defecto
		}
		
		//parte donde se empiezan las rondas
		while (true) {
			//en caso de que las vidas lleguen a 0
			if (vidasPorJug[index] == 0) {
				break;
			}
			
			for (int i = 0; i < numJugadores.length; i++) {
				System.out.println("elección del jugador " + nombres[i]);
				System.out.println("introduce una letra para ver si se encuentra en la palabra = ");
				char letra = entradaTec.next().toLowerCase().charAt(0);
				
				for (int j = 0; j < letras.length; j++) {
					if (letras[j].equals(Character.toString(letra))) { //tenemos que convertir el caracter a un string para poder compararlos
						
					}
					
				}
			}
			
			//en caso de que las vidas lleguen a 0
			if (vidasPorJug[index] == 0) {
				break;
			}
			index++;
		}
		
		
	}

}
