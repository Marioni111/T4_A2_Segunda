import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArbolBinario ab = new ArbolBinario();
		Scanner entrada = new Scanner(System.in);
		
		ab.agregarElemento(7);
		ab.agregarElemento(14);
		ab.agregarElemento(3);
		ab.agregarElemento(40);
		ab.agregarElemento(1);
		ab.agregarElemento(9);
		ab.agregarElemento(37);
		ab.agregarElemento(3);
		ab.agregarElemento(2);
		
		int op = 0;
		int cont = 0;
		int elemento = 0;
		
		do{
			System.out.println("1)Mostrar lista preorden \n2)Mostrar lista inorden\n3)Mostrar lista postorden\n4)Agregar elemento \n5)Buscar numero mayor \n6)Buscar numero menor \n7)Eliminar elemento\n8)Salir\n-----------------------------");
			op = entrada.nextInt();
			switch(op) {
				case 1 :
					ab.recorridoPreorden(ab.nodoRaiz);
					System.out.println();
					break;
				case 2 :
					ab.recorridoInorden(ab.nodoRaiz);
					System.out.println();
					break;
				case 3 :
					ab.recorridoPostorden(ab.nodoRaiz);
					System.out.println();
					break;
				case 4 :
					System.out.println("Ingresa el elemento que deseas agregar:");
					elemento = entrada.nextInt();
					ab.agregarElemento(elemento);
					break;
				case 5 :
					ab.buscarDatoMayor();
					break;
				case 6 :
					ab.buscarDatoMenor();
					break;
				case 7 :
					System.out.println("Ingresa el elemento que deseas eliminar:");
					elemento = entrada.nextInt();
					ab.eliminarElemento(elemento);
					break;
				case 8 :
					cont ++;
					break;
			}
		}while(cont<1);
		System.out.println("Nos vemos");
	}
}
