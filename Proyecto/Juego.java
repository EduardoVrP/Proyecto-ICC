import java.util.Scanner;

/**
 * Clase juego que permite jugar una variante del ajedrez
 * llamada extincion
 * 
 * @author Eduardo Vargas Perez
 * @version 1.0
 **/
public class Juego{
    /**
     * Metodo main. Permite el juego
     *
     * @param args Los argumentos
     **/
    public static void main(String[] args){
	//Objetos/ variables y constantes que usare
	Scanner usuario = new Scanner (System.in);
	String nombre1;
	String nombre2;
	int menu = -1;

	//Si te pasan dos nombres pues se hace el juego
	//  entre dos jugadores
	if(args.length == 2){
	    //Guardar los nombres
	    nombre1 = args[0];
	    nombre2 = args[1];
	    
	    //Dar una bienvenida y preguntar que nivel quieren jugar
	    while(menu == -1){
		System.out.println("¿Que tal " + nombre1 + " y " + nombre2 + "?¿Que nivel quieren jugar? (Ingesen solo el numero del nivel deseado)");
		System.out.println("\n Nivel 1: Maximo 20 turnos \n Nivel 2: Maximo 40 turnos \n Nivel 3: Maximo 100 turnos \n Nivel 4: Salir del juego");
		try{
		    menu = usuario.nextInt();
		    System.out.println(nombre1 + " mueve a las blancas(mayusculas) y " + nombre2 + " mueve a las negras (minusculas)");
		    //switch para jugar la cantidad de turnos elegidos o salir
		    switch (menu){
		    case 1:
			jugar(20,nombre1,nombre2);
			break;
		    case 2:
			jugar(40,nombre1,nombre2);
			break;
		    case 3:
			jugar(100,nombre1,nombre2);
			break;
		    case 4:
			System.out.println("Saliendo...");
			break;
		    default:
			System.out.println("¿Acaso vieron esa opcion?");
			menu = -1;
			break;
		    }//Fin de switch
		}catch(Exception e){
		    System.out.println("Oigan estoy pidiendo un numero entero\n");
		    menu = -1;
		    usuario.next();
		}finally{
		    //En cualquier caso imprime una linea en blanco cuando acabe todo para que no se vea feo
		    System.out.println(" ");
		}//Fin try/catch
	    }//Fin de while para menu
	}else if(args.length == 1){
	    nombre1 = args[0];
	     //Dar una bienvenida y preguntar que nivel quieren jugar
	    while(menu == -1){
		System.out.println("¿Que tal " + nombre1 + "?¿Que nivel quieres jugar? (Ingesa solo el numero del nivel deseado)");
		System.out.println("\n Nivel 1: Maximo 20 turnos \n Nivel 2: Maximo 40 turnos \n Nivel 3: Maximo 100 turnos \n Nivel 4: Salir del juego");
		try{
		    menu = usuario.nextInt();
		    //switch para jugar la cantidad de turnos elegidos o salir
		    switch (menu){
		    case 1:
			jugarCompu(20,nombre1);
			break;
		    case 2:
			jugarCompu(40,nombre1);
			break;
		    case 3:
			jugarCompu(100,nombre1);
			break;
		    case 4:
			System.out.println("Saliendo...");
			break;
		    default:
			System.out.println("¿Acaso viste esa opcion?");
			menu = -1;
			break;
		    }//Fin de switch
		}catch(Exception e){
		    System.out.println("Oye estoy pidiendo un numero entero\n");
		    menu = -1;
		    usuario.next();
		}finally{
		    //En cualquier caso imprime una linea en blanco cuando acabe todo para que no se vea feo
		    System.out.println(" ");
		}//Fin try/catch
	    }//Fin de while menu
	}else{
	    System.out.println("Hola, este programa es para jugar una variante de ajedrez llamada extincion, si quieres jugar de dos jugadores ingresa los nombres " +
			       "al ejecutar el programa (java Juego nombre1 nombre2), si quieres jugar con la computadora ingresa (java Juego nombre1). " +
			       "\nEn cualquier caso puedes jugar una partida rapida de 20 turnos aqui o salir\n");
	    while(menu == -1){
		System.out.println("¿Que quieres hacer?(ingresa el numero de la opcion)");
		System.out.println(" Opcion 1: Jugar de dos jugadores \n Opcion 2: Jugar solo \n Opcion 3: Salir");
		try{
		    menu = usuario.nextInt();
		    //switch para jugar la cantidad de turnos elegidos o salir
		    switch (menu){
		    case 1:
			jugar(20,"Jugador 1", "Jugador 2");
			break;
		    case 2:
			jugarCompu(40,"Jugador 2");
			break;
		    case 3:
			System.out.println("Saliendo...");
			break;
		    default:
			System.out.println("¿Acaso viste esa opcion?");
			menu = -1;
			break;
		    }//Fin de switch
		}catch(Exception e){
		    System.out.println("Oye estoy pidiendo un numero entero\n");
		    menu = -1;
		    usuario.next();
		}finally{
		    //En cualquier caso imprime una linea en blanco cuando acabe todo para que no se vea feo
		    System.out.println(" ");
		}//Fin try/catch
	    }//Fin while menu 
	}//Fin de if/else argumentos
    }//Fin del Main


    /**
     * Metodo static para crear un tablero de Piezas
     *
     * @return tablero El tablero para jugar
     **/
    public static Pieza[][] crearTablero(){
	//Declaro la matriz de piezas de 6x6
	Pieza[][] tablero = new Pieza[6][6];
	//Ciclos for para llenar el tablero
	for(int i = 0; i < tablero.length; i++){
	    //Primero lleno las piezas blancas
	    if(i == 0){
		//Lleno las filas de atras en las blancas
		tablero[i][0] = new Torre(true,0,i);
		tablero[i][1] = new Caballo(true,1,i);
		tablero[i][2] = new Dama(true,2,i);
		tablero[i][3] = new Rey(true,3,i);
		tablero[i][4] = new Caballo(true,4,i);
		tablero[i][5] = new Torre(true,5,i);		    
	    }else if(i == 1){
		//Lleno los peones de las blancas
		for(int j = 0; j < tablero[i].length; j++){
		    tablero[i][j] = new Peon(true,j,i);
			}//Fin for j peones blancos
	    }else if(i == 5){//Ahora lleno lo de atras en las negras
		tablero[i][0] = new Torre(false,0,i);
		tablero[i][1] = new Caballo(false,1,i);
		tablero[i][2] = new Dama(false,2,i);
		tablero[i][3] = new Rey(false,3,i);
		tablero[i][4] = new Caballo(false,4,i);
		tablero[i][5] = new Torre(false,5,i);
	    }else if(i == 4 ){
		//Lleno los peones negros
		for(int j = 0; j < tablero[i].length; j++){
		    tablero[i][j] = new Peon(false,j,i);
			}//Fin for j peones negros
	    }else{//Lena el resto de casillas con piezas vacias
		for(int j = 0; j < tablero[i].length; j++){
		    tablero[i][j] = new Vacia(true, j,i);
		}//Fin for j Vacias
	    }//Fin de if/else
	}//Fin for i
	//Regreso el tablero
	return tablero;
    }//Fin de crearTablero


    /**
     * Metodo static Juegar. Tiene practicamente 
     *   el algoritmo del juego para dos jugadores
     * 
     * @param turnos La cantidad de turnos a jugar
     * @param nombre1 El nombre del primer jugador
     * @param nombre2 El nombre del segundo jugador
     **/
    public static void jugar(int turnos, String nombre1, String nombre2){
	//Objetos, variables y constantes a usar

	//Objeto de la clase Scanner
	Scanner usuario = new Scanner (System.in);
	//Tablero
	Pieza[][] tablero = crearTablero();
	//Para llevar control de los turnos hasta el momento
	int n = 1;
	//Para llevar control del menu
	int menu = -1;
	//Para las coordenadas X
	int[] linea = new int[6];
	//Para el juego
	int x;
	int y;
	int nuevaX;
	int nuevaY;
	boolean movimiento;
	boolean vacia;
	boolean color;

	//Voy a llenar el arreglo de lineas
	for(int i = 0; i < linea.length; i++){
	    linea[i] = i;
	}

	//Empecemos con el juego
	do{
	    //Abrimos el menu
	    while(menu == -1){
		//Estas son para ver si ya perdio alguien
		boolean pierdeBlancas = false;
		boolean pierdeNegras = false;
		//Esto es para imprimir el tablero
		int coordenadaY = 0;
		for(int i = 0; i < tablero.length; i++){
		    //For para los piezas
		    for(int j = 0; j < tablero[i].length; j++){
		    System.out.print(tablero[i][j] + "   ");
		    }//Fin de for j
		    System.out.println(" " + coordenadaY);
		    coordenadaY += 1;
		}//Fin de for i (imprimir el tablero)
		//Imprimir las coordenadas x del tablero
		System.out.println(" ");
		for(int i = 0; i < linea.length; i++){
		    System.out.print(linea[i] + "   ");
		}
		System.out.println(" ");//Aqui ya se acabo de imprimir el tablero
		
		//Ahora dependiendo si el turno es par o impar mueven las blancas o negras
		System.out.println("Este es el turno " + n);
		
		//En turno impar mueven las blancas
		//En turno par mueven las negras
		if(n % 2 != 0){
		    System.out.println("Le toca mover a " + nombre1.toUpperCase() + " (Blancas, mayusculas)");
		}else{
		    System.out.println("Le toca mover a " + nombre2.toUpperCase() + " (Negras, minusculas)");
		}
		
		System.out.println("\n¿Que quieres hacer? (ingresa el numero)");
		System.out.println("1.Mover");
		System.out.println("2.Comer");
		System.out.println("3.Salir");
		
		try{
		    //Le pedimos al usuario que ingrese lo que quiere hacer
		    menu = usuario.nextInt();
		    
		    //Abrimos caso dependiendo lo que quiera hacer el usuario
		    switch(menu){
		    case 1: //Caso donde el usuario quiere mover
			
			//Pedir las coordenadas de la pieza a mover
			System.out.println("Ingresa las coordenadas de la pieza que quieres mover...");
			//Pedir x (Aunque en realidad para mi es la coordenada Y)
			System.out.println("Coordenada x:  ");
			x = usuario.nextInt();
			//Pedir y (Aunque en realidad para mi es la coordenada X)
			System.out.println("Coordenada y:  ");
			y = usuario.nextInt();
			
			//Pedir las coordenadas a donde mover
			System.out.println("Ingresa las coordenadas a donde quieres mover esa pieza");
			//Pedir x 
			System.out.println("Coordenada x:  ");
			nuevaX = usuario.nextInt();
			//Pedir y
			System.out.println("Coordenada y:  ");
			nuevaY = usuario.nextInt();

			//Comprobemos que son coordenadas validas
			if( x <= 5 && y <= 5 && nuevaX <= 5 &&
			    nuevaY <= 5 && x >= 0 && y >= 0 &&
			    nuevaX >= 0 && nuevaY >= 0){
			    
			    //Boolean para saber si la pieza a donde mover es vacia
			    vacia = tablero[nuevaY][nuevaX].getVacia();
			    //Boolean para saber el color de la pieza
			    color = tablero[y][x].getColor();
			    
			    //Para mi como que estan volteadas las cosas
			    //Si es turno impar mueven las blancas
			    if(n % 2 != 0 && color){
				//Validemos el movimiento
				movimiento = validarMovimiento(tablero, tablero[y][x],x,y,nuevaX,nuevaY);
				//Si es valido haz el intercambio
				if(movimiento && vacia){
				    Pieza temp = tablero[nuevaY][nuevaX];
				    tablero[y][x].mover(nuevaX,nuevaY);
				    tablero[nuevaY][nuevaX] = tablero[y][x];
				    tablero[y][x] = temp;
				}else{
				    System.out.println("No puedes hacer ese movimiento, lastima");
				}//Fin de el movimiento en las blancas
				//Si es turno par mueven las negras
			    }else if(n % 2 == 0 && !(color)){
				//Validemos el movimiento
				movimiento = validarMovimiento(tablero, tablero[y][x],x,y,nuevaX,nuevaY);
				//Si es valido haz el intercambio
				if(movimiento && vacia){
				    Pieza temp = tablero[nuevaY][nuevaX];
				    tablero[y][x].mover(nuevaX,nuevaY);
				    tablero[nuevaY][nuevaX] = tablero[y][x];
				    tablero[y][x] = temp;
				}else{
				    System.out.println("No puedes hacer ese movimiento, lastima");
				}//Fin del movimiento de las negras
			    }else{
				System.out.println("No puedes mover una pieza que no sea tuya, lastima");
			    }
			}else{
			    System.out.println("Las coordenadas no son validas, lastima");
			}
			menu = -1;
			break;
		    case 2://Caso donde el usuario quiere comer

			//Pedir las coordenadas de la pieza a mover
			System.out.println("Ingresa las coordenadas de la pieza que quieres mover...");
			//Pedir x (Aunque en realidad para mi es la coordenada Y)
			System.out.println("Coordenada x:  ");
			x = usuario.nextInt();
			//Pedir y (Aunque en realidad para mi es la coordenada X)
			System.out.println("Coordenada y:  ");
			y = usuario.nextInt();
			
			//Pedir las coordenadas a donde mover
			System.out.println("Ingresa las coordenadas a donde quieres mover esa pieza");
			//Pedir x 
			System.out.println("Coordenada x:  ");
			nuevaX = usuario.nextInt();
			//Pedir y
			System.out.println("Coordenada y:  ");
			nuevaY = usuario.nextInt();

			if( x <= 5 && y <= 5 && nuevaX <= 5 &&
			    nuevaY <= 5 && x >= 0 && y >= 0 &&
			    nuevaX >= 0 && nuevaY >= 0){
			    
			    //Boolean para saber si la pieza a donde mover es vacia
			    vacia = tablero[nuevaY][nuevaX].getVacia();
			    //Boolean para saber el color de la pieza
			    color = tablero[y][x].getColor();
			    
			    //Para mi como que estan volteadas las cosas
			    //Si es turno impar mueven las blancas
			    if(n % 2 != 0 && color){
				//Validemos el movimiento
				movimiento = validarMovimiento(tablero, tablero[y][x],x,y,nuevaX,nuevaY);
				//Si es valido y lo que hay en donde se quiere comer no es vacio proseguimos
				if(movimiento && !(vacia)){
				    Pieza temp = tablero[nuevaY][nuevaX];
				    tablero[y][x].comer(nuevaX,nuevaY);
				    tablero[nuevaY][nuevaX] = tablero[y][x];
				    tablero[y][x] = new Vacia(true, x,y);
				}else{
				    System.out.println("No puedes hacer ese movimiento, lastima");
				}//Fin de el movimiento en las blancas
				//Si es turno par mueven las negras
			    }else if(n % 2 == 0 && !(color)){
				//Validemos el movimiento
				movimiento = validarMovimiento(tablero, tablero[y][x],x,y,nuevaX,nuevaY);
				//Si es valido haz el intercambio
				if(movimiento && !(vacia)){
				    Pieza temp = tablero[nuevaY][nuevaX];
				    tablero[y][x].comer(nuevaX,nuevaY);
				    tablero[nuevaY][nuevaX] = tablero[y][x];
				    tablero[y][x] = new Vacia(true, x,y);
				}else{
				    System.out.println("No puedes hacer ese movimiento, lastima");
				}//Fin del movimiento de las negras
			    }else{
				System.out.println("No puedes mover una pieza que no sea tuya, lastima");
			    }
			}else{
			    System.out.println("Las coordenadas no son validas, lastima");
			}
			menu = -1;
			break;
		    case 3://Caso donde el usuario decide salirse
			System.out.println("Adio'...");
			n = turnos + 1; //Esto es para romper el ciclo
			break;
		    default: //Caso donde ponga otra tontera el usuario
			System.out.println("Ah mira como que hoy amanecimos bien chistosos, ¿Apoco viste esa opcion aqui arriba?, ya perdiste tu turno\n");
			menu = -1;
			break;
		    }
		}catch(MovimientoInvalido e){
		    System.out.println("Error: " + e.getMessage() + "\n");
		    menu = -1;
		}catch(Exception e){
		    System.out.println("Oye te estoy pidiendo un numero entero\n");
		    menu = -1;
		    usuario.next();
		}finally{
		    //En cualquier caso imprime una linea en blanco cuando acabe todo para que no se vea feo
		    System.out.println(" ");
		}//Fin try/catch
		n++;
		if(n > turnos){
		    menu = 3;
		    System.out.println("Gana " + nombre1 + " porque yo lo digo");
		}

		//Veamos si hay perdedor
		pierdeBlancas = hayPerdedor(tablero, true);
		pierdeNegras = hayPerdedor(tablero, false);

		if(pierdeBlancas){
		    System.out.println("Pierde " + nombre1 + ". El GANADOR es " + nombre2);
		    menu = 3;
		    n = turnos + 1;
		}else if (pierdeNegras){
		    System.out.println("Pierde " + nombre2 + ". El GANADOR es " + nombre1);
		    menu = 3;
		    n = turnos + 1;
		}
	    }//Fin de while para menu
	}while(n <= turnos);
	System.out.println("Se acabo el juego");
    }//Fin de jugar

    /**
     * Metodo static para validar un movimiento (torre o dama)
     * 
     * @param tablero El tablero
     * @param pieza La pieza a mover
     * @param x La coordenada x de la pieza
     * @param y La coordenada y de la pieza
     * @param nuevaX La coordenada donde mover
     * @param nuevaY La coordenada donde mover
     * @return Un valor boolean, true si es valido 
     *         false en otro caso
     **/
    public static boolean validarMovimiento(Pieza[][] tablero, Pieza pieza, int x, int y, int nuevaX, int nuevaY){
	boolean movimientoV;
	boolean sonVacias = true;
	
 	//Si es torre hay que verificar que toda la linea este vacia
	if(tablero[y][x] instanceof Torre){
	    
	    //Primero comprobemos que esta libre el camino para moverse
	    if(x == nuevaX){//caso donde se mueve en el eje Y
		if(y > nuevaY){//caso si se mueve hacia arriba
		    for(int i = y - 1; i > nuevaY; i--){
			//Si encuentras una pieza que no es vacia de por medio no se puede mover
			if(!(tablero[i][x].getVacia())){
			    sonVacias = false;
			    break;
			}//Fin de if
		    }//Fin del for
		}else if(y < nuevaY){//Caso donde avanza hacia abajo
		    for(int i = y + 1; i < nuevaY; i++){
			if(!(tablero[i][x].getVacia())){
			    sonVacias = false;
			    break;
			}//Si encuentras una pieza que no es vacia de por medio no se puede mover
		    }//Fin del for
		}//Fin de if/else (arriba o abajo)
	    }else if(y == nuevaY){//Caso donde nos movemos en el eje X
		if(x > nuevaX){//caso si se mueve hacia la izquierda
		    for(int i = x - 1; i > nuevaX; i--){
			if(!(tablero[y][i].getVacia())){
			    sonVacias = false;
			    break;
			}//Si encuentras una pieza que no es vacia de por medio no se puede mover
		    }//Fin del for
		}else if(x < nuevaX){//Caso donde avanza hacia la derecha
		    for(int i = x + 1; i < nuevaX; i++){
			if(!(tablero[y][i].getVacia())){
			    sonVacias = false;
			    break;
			}//Si encuentras una pieza que no es vacia de por medio no se puede mover
		    }//Fin del for
		}//Fin de if/else (izquierda derecha)
	    }//Fin de if para revisar el camino
	    
	    //Si se cumple lo de el movimiento se puede mover
	    if(sonVacias){
	        movimientoV = true; 
	    }else{
		movimientoV = false;
	    }//Fin del movimiento de la torre

	}else if(tablero[y][x] instanceof Dama){//Para la dama la linea recta igual
	    //Primero comprobemos que esta libre el camino para moverse
	    if(x == nuevaX){//caso donde se mueve en el eje Y
		if(y > nuevaY){//caso si se mueve hacia arriba
		    for(int i = y - 1; i > nuevaY; i--){
			if(!(tablero[i][x].getVacia())){
			    sonVacias = false;
			    break;
			}//Si encuentras una pieza que no es vacia de por medio no se puede mover
		    }//Fin del for
		}else if(y < nuevaY){//Caso donde avanza hacia abajo
		    for(int i = y + 1; i < nuevaY; i++){
			if(!(tablero[i][x].getVacia())){
			    sonVacias = false;
			    break;
			}//Si encuentras una pieza que no es vacia de por medio no se puede mover
		    }//Fin del for
		}//Fin de if/else (arriba o abajo)
	    }else if(y == nuevaY){//Caso donde nos movemos en el eje X
		if(x > nuevaX){//caso si se mueve hacia la izquierda
		    for(int i = x - 1; i > nuevaX; i--){
			if(!(tablero[y][i].getVacia())){
			    sonVacias = false;
			    break;
			}//Si encuentras una pieza que no es vacia de por medio no se puede mover
		    }//Fin del for
		}else if(x < nuevaX){//Caso donde avanza hacia la derecha
		    for(int i = x + 1; i < nuevaX; i++){
			if(!(tablero[y][i].getVacia())){
			    sonVacias = false;
			    break;
			}//Si encuentras una pieza que no es vacia de por medio no se puede mover
		    }//Fin del for
		}//Fin de if/else (izquierda derecha)
		
		//MOVIMIENTOS EN DIAGONAL
	    }else if(nuevaY < y){//Diagonal hacia arriba
		//Arriba derecha
		if(x < nuevaX){
		    for(int i = y-1; i > nuevaY; i--){
			x++;
			if(!(tablero[i][x].getVacia())){
			    sonVacias = false;
			    break;
			}//Si encuentras una pieza que no es vacia de por medio no se puede mover
		    }//Fin de for
		    //Arriba izquierda 
		}else if(x > nuevaX){
		    for(int i = y - 1; i > nuevaY; i--){
			x--;
			if(!(tablero[i][x].getVacia())){
			    sonVacias = false;
			    break;
			}//Si encuentras una pieza que no es vacia de por medio no se puede mover
		    }//Fin de for
		}//Fin if/else izquierda y derecha
	    }else if(nuevaY > y){//Diagonal hacia abajo
		//Abajo derecha
		if(x < nuevaX){
		    for(int i = y + 1; i < nuevaY; i++){
			x++;
			if(!(tablero[i][x].getVacia())){
			    sonVacias = false;
			    break;
			}//Si encuentras una pieza que no es vacia de por medio no se puede mover
		    }//Fin de for
		    //Abajo izquierda 
		}else if(x > nuevaX){
		    for(int i = y + 1; i < nuevaY; i++){
			x--;
			if(!(tablero[i][x].getVacia())){
			    sonVacias = false;
			    break;
			}//Si encuentras una pieza que no es vacia de por medio no se puede mover
		    }//Fin de for
		}//Fin if/else izquierda y derecha
		
	    }//Fin if/else movimientos
	    //Si se cumple lo de el movimiento se puede mover
	    if(sonVacias){
		movimientoV = true; 
	    }else{
		movimientoV = false; 
	    }
	}else{
	    movimientoV = true;
	}//Fin if/else instanceof
	return movimientoV;
    }//Fin de validar movimiento

    /**
     * Metodo static que corrobora si ya hay perdedor
     *
     * @param tablero El tablero a revisar
     * @param el color de las piezas a revisar
     * @return True si ya no hay piezas de un tipo y color, false en otro caso
     **/
    public static boolean hayPerdedor(Pieza[][] tablero, boolean color){
	//Objetos, variables y constantes a usar
	//Iniciemos en false el de perdedor
	boolean perdedor = false;
	//Una variable para contar que haya piezas de cada tipo
	int peon = 0;
	int torre = 0;
	int caballo = 0;
	int dama = 0;
	int rey = 0;
	
	//Solo hay que checar que haya al menos una pieza del color dado
	for(int i = 0; i < tablero.length; i++){
	    for(int j = 0; j < tablero[i].length; j++){
		//Vamos a revisar si todavia hay peones de un mismo color
		if(tablero[i][j] instanceof Peon &&
		   ((color && tablero[i][j].getColor()) ||
		    (!(color) && !(tablero[i][j].getColor())))){
		    peon++;
		    //Ahora veamos si hay torres
		}else if(tablero[i][j] instanceof Torre &&
			 ((color && tablero[i][j].getColor()) ||
			  (!(color) && !(tablero[i][j].getColor())))){
		    torre++;
		    //Veamos si hay caballos
		}else if(tablero[i][j] instanceof Caballo &&
			 ((color && tablero[i][j].getColor()) ||
			  (!(color) && !(tablero[i][j].getColor())))){
		    caballo++;
		    //Veamos si hay Reina
		}else if(tablero[i][j] instanceof Dama &&
			 ((color && tablero[i][j].getColor()) ||
			  (!(color) && !(tablero[i][j].getColor())))){
		    dama++;
		    //Veamos si hay rey
		}else if(tablero[i][j] instanceof Rey &&
			 ((color && tablero[i][j].getColor()) ||
			  (!(color) && !(tablero[i][j].getColor())))){
		    rey++;
		}//Fin if/else 
	    }//Fin for j
	}//Fin for i

	//Si alguna de las variables es 0 entonces el de ese color ya perdio
	if(peon == 0 || torre == 0 || caballo == 0
	   || dama == 0 || rey == 0){
	    perdedor = true;
	}//Fin de if

	return perdedor;
    }//Fin de hay perdedor

    /**
     * Metodo static para jugar solo con la compu
     *
     * @param turnos La cantidad de turnos a jugar
     * @param nombre El nombre del jugador
     **/
    public static void jugarCompu(int turnos, String nombre){
	//Objetos, variables y constantes a usar

	//Objeto de la clase Scanner
	Scanner usuario = new Scanner (System.in);
	//Tablero
	Pieza[][] tablero = crearTablero();
	//Para llevar control de los turnos hasta el momento
	int n = 1;
	//Para llevar control del menu
	int menu = -1;
	//Para las coordenadas X
	int[] linea = new int[6];
	//Para el juego
	int x;
	int y;
	int nuevaX;
	int nuevaY;
	boolean movimiento;
	boolean vacia;
	boolean color;

	//Voy a llenar el arreglo de lineas
	for(int i = 0; i < linea.length; i++){
	    linea[i] = i;
	}

	//Empecemos con el juego
	do{
	    //Abrimos el menu
	    while(menu == -1){
		//Estas son para ver si ya perdio alguien
		boolean pierdeBlancas = false;
		boolean pierdeNegras = false;
		//Esto es para imprimir el tablero
		int coordenadaY = 0;
		for(int i = 0; i < tablero.length; i++){
		    //For para los piezas
		    for(int j = 0; j < tablero[i].length; j++){
		    System.out.print(tablero[i][j] + "   ");
		    }//Fin de for j
		    System.out.println(" " + coordenadaY);
		    coordenadaY += 1;
		}//Fin de for i (imprimir el tablero)
		//Imprimir las coordenadas x del tablero
		System.out.println(" ");
		for(int i = 0; i < linea.length; i++){
		    System.out.print(linea[i] + "   ");
		}
		System.out.println(" ");//Aqui ya se acabo de imprimir el tablero
		
		//Ahora dependiendo si el turno es par o impar mueven las blancas o negras
		System.out.println("Este es el turno " + n);

		 System.out.println("\n\n¿Que quieres hacer? (ingresa el numero)");
		 System.out.println("1.Mover");
		 System.out.println("2.Comer");
		 System.out.println("3.Salir");
		 
		 //Pedirle el numero al usuario
		 try{
		     menu = usuario.nextInt();
		     //Abrimos casos dependiendo lo que escogio el usuario
		     
		     switch(menu){
		     case 1: //Caso donde el usuario quiere mover
			 //Pedir las coordenadas de la pieza a mover
			 System.out.println("Ingresa las coordenadas de la pieza que quieres mover...");
			 //Pedir x (Aunque en realidad para mi es la coordenada Y)
			 System.out.println("Coordenada x:  ");
			 x = usuario.nextInt();
			 //Pedir y (Aunque en realidad para mi es la coordenada X)
			 System.out.println("Coordenada y:  ");
			 y = usuario.nextInt();
			 
			 //Pedir las coordenadas a donde mover
			 System.out.println("Ingresa las coordenadas a donde quieres mover esa pieza");
			 //Pedir x 
			 System.out.println("Coordenada x:  ");
			 nuevaX = usuario.nextInt();
			 //Pedir y
			 System.out.println("Coordenada y:  ");
			 nuevaY = usuario.nextInt();
			 //Para mi como que estan volteadas las cosas
			 vacia = tablero[nuevaY][nuevaX].getVacia();
			 movimiento = validarMovimiento(tablero, tablero[y][x],x,y,nuevaX,nuevaY);
			 if(movimiento && vacia){
			     Pieza temp = tablero[nuevaY][nuevaX];
			     tablero[y][x].mover(nuevaX,nuevaY);
			     tablero[nuevaY][nuevaX] = tablero[y][x];
			     tablero[y][x] = temp; 
			 }else{
			     System.out.println("No puedes hacer eso");
			 }
			 
			 menu = -1;
			 break;
		     case 2: //Caso donde el usuario quiere comer
			 //Pedir las coordenadas de la pieza a mover
			 System.out.println("Ingresa las coordenadas de la pieza que quieres mover...");
			 //Pedir x (Aunque en realidad para mi es la coordenada Y)
			 System.out.println("Coordenada x:  ");
			 x = usuario.nextInt();
			 //Pedir y (Aunque en realidad para mi es la coordenada X)
			 System.out.println("Coordenada y:  ");
			 y = usuario.nextInt();
			 
			 //Pedir las coordenadas a donde mover
			 System.out.println("Ingresa las coordenadas a donde quieres mover esa pieza");
			 //Pedir x 
			 System.out.println("Coordenada x:  ");
			 nuevaX = usuario.nextInt();
			 //Pedir y
			 System.out.println("Coordenada y:  ");
			 nuevaY = usuario.nextInt();
			 //Para mi como que estan volteadas las cosas
			 vacia = tablero[nuevaY][nuevaX].getVacia();
			 movimiento = validarMovimiento(tablero, tablero[y][x],x,y,nuevaX,nuevaY);
			 if(movimiento && !(vacia)){
			     tablero[y][x].comer(nuevaX,nuevaY);
			     tablero[nuevaY][nuevaX] = tablero[y][x];
			     tablero[y][x] =  new Vacia(true, y,x); 
			 }else{
			     System.out.println("No puedes hacer eso");
			 }
			 menu = -1;
			 break;
		     case 3: //Caso donde el usuario decide salirse
			 System.out.println("Adio'...");
			 break;
		     default: //Caso donde ponga otra tontera el usuario
			 System.out.println("Ah mira como que hoy amanecimos bien chistosos, ¿Apoco viste esa opcion aqui arriba?");
			 menu = -1;
			 break;
		     }//Fin de switch menu
		 }catch(MovimientoInvalido e){
		     System.out.println("Error: " + e.getMessage());
		     menu = -1;
		 }catch(Exception e){
		     System.out.println("Baboso, te pedi un numero. Intentalo otra vez por menso\n");
		     menu = -1;
		     usuario.next();
		 }finally{
		     //En cualquier caso imprime una linea en blanco cuando acabe todo para que no se vea feo
		     System.out.println(" ");
		 }//Fin try/catch para pedir nuemeros del usuario
		 n++;
		 if(n > turnos){
		     System.out.println("Se acabo");
		     menu = 3;
		 }
	    }//Fin while menu
	}while (n <= turnos);
    }//Fin jugar compu
    
}//Fin de la clase juego
