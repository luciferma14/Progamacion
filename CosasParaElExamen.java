import java.util.Scanner;

public class CosasParaElExamen {
    public static void main(String[] args) {

        int hora;

        System.out.println("Que hora es: ");
        hora = sc.nextInt();

        if (hora >= 8 && hora < 12) {
            System.out.println("Buenos dias!");

        }else if (hora >= 13 && hora <= 21) {
            System.out.println("Buenas tardes!");

        }else if (hora >= 22 && hora <= 24) {
            System.out.println("Buenas noches!");
            
        }

        int mes;

        System.out.print("Intruducca el mes del año: ");
        mes = sc.nextInt();

        switch (mes){
            case 1: 
                System.out.println("Enero");
                break;
            case 2: 
                System.out.println("Febrero");
                break;
            case 3: 
                System.out.println("Marzo");
                break; // y continua
        }

        int num;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Pinta un número: ");

            num = sc.nextInt();
            
            System.out.println("Has pintado un: " + num);

        } while (num != 0);
            System.out.println("Ha terminado el programa.");
        
        // pinta una lista del 0 hasta el 50
        for (int i = 0; i <= 50; i++){

                System.out.println(i);
    
            }
        
        // pinta los num múltiplos de 5 entre el 0 y el 100 (incluidos)    
        for (int i = 0 ; i <= 100; i++){
            if (i % 5 == 0)
            
            System.out.println(i);
        }
        //programa que pida una base y un exponente (enteros positivos) y que calcule la potencia
        int base;
        int exponente;
        int resultado = 1;

        System.out.println("Escribe la base: ");
        base = sc.nextInt();

        System.out.println("Escribe un exponente: ");
        exponente = sc.nextInt();

        for (int i = 1; i <= exponente; i++) {
            resultado *= base;
        }

        System.out.println("La base " + base + " elvadada a " + exponente + " da como reslutado = " + resultado);
    
        //cuántos dígitos tiene un número entero(+/-)hasta 6 díg
        int numero;
		String resultado = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Numero: ");
		numero = sc.nextInt();
		
		if (numero<0) numero = -numero;
		
		if      (numero < 10) resultado = "1";
		else if (numero < 100) resultado = "2";
		else if (numero < 1000) resultado = "3";
		else if (numero < 10000) resultado = "4";
		else if (numero < 100000) resultado = "5";
		else if (numero < 1000000) resultado = "6";
		else resultado = "Error";
		
		
		System.out.println("Resultado: " + resultado);
    
        //número introducido por teclado es o no primo.
        int numero;
		int cont;
		boolean primo;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Numero : ");
		numero = sc.nextInt();
		
		numero = Math.abs(numero);
		
		cont = numero - 1;
		
		if (numero == 0 || numero == 1) primo = false;
		else                            primo = true;
		
		while(primo && cont > 1) {

			if (numero%cont == 0) primo = false;
			cont--;			
		}		
		System.out.println(primo?"Primo":"No Primo");

        //lea un num positivo por teclado y que escriba en la salida, línea a línea,
        //los pares de enteros i, j, 1≤ i ≤ n, i ≤ j ≤ n y el valor que toma la expresión i + j + i * j
        int n;
        System.out.print("Numero : ");
		n = sc.nextInt();		

		for (int i = 1; i<=n ; i++) {
			for (int j = i; j<=n; j++) {
				System.out.printf("Par (%d,%d): %d+%d+%d*%d vale %d \n", i, j, i, j, i, j, i+j+i*j);
            }
        }    

        //“Piedra, papel o tijeras”
        int yo;
		int pc;
		
		String resultado = "";
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("\nJugada: ");
			yo = sc.nextInt();
		} while(yo>3||yo<1);


		pc = (int) (Math.random()*3+1);
		
		if (yo == pc)  resultado = "Empate";
		else if (   (yo == 1 &&  pc == 3) ||
				(yo == 2 &&  pc == 1) ||
				(yo == 3 &&  pc == 2)   ) resultado = "Gana jugador";
		else 					           resultado = "Gana PC";

		System.out.println("PC: " + pc + " Yo: " + yo + ". " + resultado);

        //lea 15 números por teclado y que los almacene en un array. Rota
        //los elementos de ese array
        int[] num = new int[15];
		int aux;
		
		Scanner sc = new Scanner(System.in);
		
		//Rellenar Array
		for(int i = 0; i<num.length ; i++) {
			System.out.print("Dame el "+i+": ");
			num[i] =  sc.nextInt();
		}
		
		//Rotar
		aux = num[num.length-1];
		for(int i = num.length-1; i>0 ; i--) {
			num[i] = num[i-1];
		}
		num[0] = aux;
		
		//Pintar resultado
		for(int i = 0; i<num.length ; i++) {
			System.out.println(num[i]);
		}

        //tres en raya
        char[][] tab = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		int row;
		int col;
		int cont = 0;
		boolean sigue = true;
		Scanner sc = new Scanner (System.in);

		do {

			//Pido Fila y Columna
			do {
				System.out.print("Row: ");
				row=sc.nextInt();
				System.out.print("Col: ");
				col=sc.nextInt();
			} while (tab[row][col]!=' ');
			tab[row][col] = 'X';

			if (	(tab[0][0]=='X'&&tab[1][1]=='X'&&tab[2][2]=='X') ||
				(tab[0][2]=='X'&&tab[1][1]=='X'&&tab[2][0]=='X') ||
				(tab[row][0]=='X'&&tab[row][1]=='X'&&tab[row][2]=='X') ||
				(tab[0][col]=='X'&&tab[1][col]=='X'&&tab[2][col]=='X') ) {
					
				sigue = false;

				System.out.println("Yo gano");
			}
			
			cont++;
			
			if (cont == 9) {
				System.out.println("Nadie gana");
				sigue=false;
			}

			//Lanza PC
			if (sigue) {
				do{
					row=(int)(Math.random()*3);
					col=(int)(Math.random()*3);
				} while (tab[row][col]!=' ');
				tab[row][col] = 'O';
				System.out.println("PC lanza: "+row+","+col);
				
				if (	(tab[0][0]=='O'&&tab[1][1]=='O'&&tab[2][2]=='O') ||
					(tab[0][2]=='O'&&tab[1][1]=='O'&&tab[2][0]=='O') ||
					(tab[row][0]=='O'&&tab[row][1]=='O'&&tab[row][2]=='O') ||
					(tab[0][col]=='O'&&tab[1][col]=='O'&&tab[2][col]=='O') ) {
						
					sigue = false;

					System.out.println("PC gana");
				}				
			
			}
			
			for(int i = 0;i<3;i++) {
				for(int j = 0;j<3;j++) {
					System.out.print(tab[i][j]);
				}
				System.out.println();
			}
				
			cont++;
			
		} while(sigue);

        //Crear y rellenar por teclado una tabla de tamaño 4x4 y decir si es simétrica o no
        int[][] mat = new int[4][4];
		boolean simetrica;
		Scanner sc  =new Scanner (System.in);
		
		//Rellena
		for(int i = 0; i<4; i++) {
			for (int j = 0; j<4; j++) {
				System.out.print("("+i+","+j+"): ");
				mat[i][j] = sc.nextInt();
			}
		}
		
		//Pinta la matriz y calcula
		simetrica = true;		
		for(int i = 0; i<4; i++) {
			for (int j = 0; j<4; j++) {
				System.out.print(mat[i][j]);
				if(mat[i][j] != mat[j][i]) simetrica = false;
			}
			System.out.println();
		}
		
		System.out.println(simetrica?"Simetrica":"No simetrica");

        //Crear una matriz “marco” de tamaño 8x6: todos sus elementos deben ser 0 salvo los de
        //los bordes que deben ser 1.
        int[][] mat = new int[8][6];
		
		//Creo
		for(int i = 0; i < 8 ; i++) {
			for(int j = 0; j < 6 ; j++) {
				if(i==0||j==0||i==7||j==5) 	mat[i][j] = 1;
				else				   		mat[i][j] = 0;
			}
		}
	
		//Pinto
		for(int i = 0; i < 8 ; i++) {
			for(int j = 0; j < 6 ; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}

        //Escribe un programa que lea un número n e imprima una pirámide
        Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("Numero: ");
		num = sc.nextInt();
		System.out.println();
		
		for (int i = 1; i<= num; i++) {
			//Pinto espacios
			for(int k=1;k<=num-i;k++) 	System.out.print(" ");
			//Cuento hacia delante
			for (int j=1;j<=i;j++) 		System.out.print(j);
			//Cuento hacia tras
			for (int j=i-1;j>=1;j--) 		System.out.print(j);
			//Salto de linea
			System.out.println();

			//Usa la cadena de tu nombre completo y aplica los métodos de la clase String (wrapped)
			//necesarios para separar tu nombre de tus apellidos almacenándolos en variables distintas
			String nombre = "Lucia Ferrandis Martinez";

			int primerespacio = nombre.indexOf(' ');
			int segundoespacio = nombre.indexOf(' ',primerespacio+1);
	
	
	
			System.out.println(nombre.substring(0,primerespacio));
			System.out.println(nombre.substring(primerespacio+1,segundoespacio)); 
			System.out.println(nombre.substring(segundoespacio+1)); 

			//Dadas las palabras del ejercicio anterior, utiliza la clase envoltorio para obtener la longitud de
			//cada palabra.
			String nombre = "Lucia";
        	String apellido1 = "Ferrandis";
        	String apellido2 = "Martinez";
			
        	System.out.println(nombre.length());
        	System.out.println(apellido1.length());
        	System.out.println(apellido2.length());

			// calcule las raíces de una ecuación de segundo grado. Para ax2+bx+c=0 

			float a;
        	float b;
        	float c;
        	double sqrtdisc;

        	Scanner sc = new Scanner(System.in);

        	System.out.print("Dime a: ");
        	a = sc.nextFloat();
        	System.out.print("Dime b: ");
        	b = sc.nextFloat();
        	System.out.print("Dime c: ");
        	c = sc.nextFloat();

        	sqrtdisc = Math.sqrt((b*b-4*a*c));

        	System.out.printf("X1 : %3.2f\n", (-b+sqrtdisc)/2/a);
        	System.out.printf("X2 : %3.2f\n", (-b-sqrtdisc)/2/a);

        	sc.close();
    }   	
}