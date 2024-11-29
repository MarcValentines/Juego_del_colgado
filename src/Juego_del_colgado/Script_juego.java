package Juego_del_colgado;
import java.util.Arrays; // Java.util.Arrays sirve para importar la clase Arrays 
//de la biblioteca estándar de Java, la cual contiene métodos útiles 
//para trabajar con arrays
import java.util.Scanner;
public class Script_juego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entradaTec = new Scanner(System.in); //entrada de teclado
		
		int[] numJugadores;
		int[] vidasPorJug;
		
		String[] nombres;
		String[] letras;
		String[] letrasPrint;
		
		//la explicación de las reglas del juego
		System.out.println("--REGLAS DEL JUEGO--");
		System.out.println("El adiministrador va a insertar la palabra secreta");
		System.out.println("Se van a pedir el número de jugadores que van a jugar");
		System.out.println("cada jugador va a tener 6 vidas");
		System.out.println("si un jugador se queda sin vidas se acaba el juego");
		System.out.println("_______________________________________________________");
		
		
		System.out.println("Cuantas rondas vas a querer jugar? "); //numero de rondas (las veces que se va a elegir una palabra secreta nueva)
		int rondas = entradaTec.nextInt(); 
		
		for (int x = 0; x < rondas; x++) {
			entradaTec.nextLine();
			
			//mostrar rondas por pantalla
			int numron = x + 1;
			System.out.println("|| RONDA " + numron + " ||");
			
			boolean palabraEncontrada = false; //se va a usar para continuar el juego o no dependiendo de si se encuentra la palabra
			
			System.out.println("inserta la palabra secreta = ");
			String palabraSecreta = entradaTec.nextLine().toLowerCase(); //se añader lo que inserta el admin al final de el string palabraSecreta
			
			//numero de jugadores en la partida
			
			System.out.println("inserte el numero de jugadores que quieras (min 2, max 5) = ");
			int numJds = entradaTec.nextInt(); //se crea un int para el numero de jugadores que van a participar
			while (numJds < 2 | numJds > 5) { //en caso de que el numero de jugadores sea inferior a 2 se revaloriza el int
				System.out.println("vuelve a insertar el numero de jugadores = ");
				numJds = entradaTec.nextInt();
			}
			numJugadores = new int[numJds]; //la longitud del array depende del valor dentro del int numJds
			
			//vidas de los jugadores
			
			vidasPorJug = new int[numJds]; //la longitud del array depende del int numJds
			int index = 1; //se crea un index que mientras todos los jugadores no lleguen a 0 vidas no termina el juego (el bucle se encuentra abajo)
			
			for (int i = 0; i < vidasPorJug.length; i++) { //se añade un valor dentro de todas las posiciones del array de vidas
				vidasPorJug[i] = vidasPorJug[i] + 6; //se añaden 6 viads a cada array
			}
			
			//nombres de los jugadores
			
			nombres = new String[numJds]; //la longitud del array depende del numero que se encuentra en el int numJds
			
			for (int i = 0; i < nombres.length; i++) { //dentro de cada posicion[i] dentro del bucle se añade el nombre del jugador
				System.out.println("_______________________________________________________");
				System.out.println("Inserta el nombre del jugador = ");
				nombres[i] = entradaTec.next();
			}
			
			
			
			//guardar las letras de la palabra (el string palabraSecreta) clave dentro de un array
			
			letras = new String[palabraSecreta.length()]; //la longitud del array será igual a la longitud de la palabra secreta
			
			for (int i = 0; i < letras.length; i++) { //se separan las letras una a una con un char y se posicionan en el array 
				char letraEsp = palabraSecreta.charAt(i);
				letras[i] = letraEsp + ""; //se añade el (+ "") para que no de error
			}
			
			//las letras que se van a mostrar en pantalla siempre que se termine de escribir la letra
			
			letrasPrint = new String[letras.length]; //este va a depender de la longitud del array letras
			
			for (int i = 0; i < letrasPrint.length; i++) {
				letrasPrint[i] = "_"; //mantener que todas las posiciones del array tengan un _ por defecto
			}
			
			//parte donde se empiezan las rondas
			while (true) {
				//en caso de que las vidas lleguen a 0
				for (int i = 0; i < vidasPorJug.length; i++) {
					if (vidasPorJug[i] == 0) {
						System.out.println("_______________________________________________________");
						System.out.println("Se ha llegado a las 0 vidas, el juego termina");
						System.out.println("|| ...EXITING... ||");
						index--;
						break; //etste vreak termina el este bucle for
					}
				}
				if (index == 0) {
					break; //este rompe el bucle while si el index pasa de 1 a 0
				}
				
				//turno del jugador en el índex i del array numJugadores
				for (int i = 0; i < numJugadores.length; i++) {
					System.out.println("______________________________________________________________");
					System.out.println("elección del jugador " + nombres[i]); //se muestra la elección y el jugador al que le toca
					System.out.println("introduce una letra para ver si se encuentra en la palabra = ");
					char letra = entradaTec.next().toLowerCase().charAt(0); //se selecciona un caracter en la posición 0, para que en caso de que se ponga una frase solo pille la posición 0
					int aciertos = 0; //se mantiene el numero de aciertos
					
					//zona de acierto de letra
					for (int j = 0; j < letras.length; j++) {
						if (letras[j].equals(Character.toString(letra))) { //tenemos que convertir el caracter a un string para poder compararlos usando la clase Arrays
							letrasPrint[j] = letras[j]; //se transforma la letra de la posición[i] en el array letras en letrasPrint en la posicion[i]
							System.out.println(Arrays.toString(letrasPrint)); //se muestra letrasprint en la pantalla para ver la letra acertada
							aciertos++; //se suma un acierto en caso de que se encuentre en la palabra
						}
						//zona del fallo en la letra
					}
					
					if (aciertos == 0) { //en caso de que no haya nuingún acierto
						System.out.println("no se he encontrado la letra dentro de la palabra :(");
						vidasPorJug[i]--; //se le reduce una vida al jugador que ha fallado
						System.out.println(Arrays.toString(letrasPrint)); //se printean en pantalla las letras acertadas hasta el momento
						System.out.println("El jugador " + nombres[i] + " tiene " + vidasPorJug[i] + " vidas"); //se muestra las vidas que le quedan a ese jugador
						System.out.println("___________________________________________________________________");
					}
					
					//en caso de que se encuentre la palabra secreta se termina el juego
					if (Arrays.equals(letras, letrasPrint)) { //en caso de que los valores dentro de los arrays sean iguales (se usa la clase Arrays para esto)
						System.out.println("_______________________________________________________");
						System.out.println("felicidades, has encontrado la palabra secreta!!");
						System.out.println("|| ...Exiting... ||");
						palabraEncontrada = true; //se sambia el boolean de palabraEncontrada a true
						break;// se sale del if
					}
				}
				//terminar el bucle si se encientra la palabra
				if (palabraEncontrada) {
					break; //se termina el bucle while en caso de que el boolean sea true
				}
				
				//en caso de que las vidas lleguen a 0
				for (int i = 0; i < vidasPorJug.length; i++) {
					if (vidasPorJug[i] == 0) {
						System.out.println("_______________________________________________________");
						System.out.println("Se ha llegado a las 0 vidas, el juego termina");
						System.out.println("|| ...EXITING... ||");
						index--;
						break;
					}
				}
				if (index == 0) {
					break;
				}
				
			}
			
		}
		
	}

}
