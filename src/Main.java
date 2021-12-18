import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static int tipoDiccionario;
	public static ListaOrdenada lista = new ListaOrdenada();

	public static void interactiva() {
		int operacion;

		do {
			System.out.print("\n---\nIngrese la operacion a realizar: \n" + "	1 para insert \n"
					+ "	2 para remove \n" + "	3 para find \n" + "	4 para findRange \n" + "	5 para height \n"
					+ "	6 para toString \n" + "	0 para salir\n " + ":");
			operacion = sc.nextInt();

			if (operacion == 0) {
				System.out.println(">Decidiste salir");
			} else if (operacion == 1) {
				if (tipoDiccionario == 1) {
					/* llenar mati */
				} else if (tipoDiccionario == 2) {
					System.out.print("Ingrese llave nueva: ");
					int key = sc.nextInt();
					System.out.print("\nIngrese valor nuevo: ");
					String item = sc.next();
					lista.insert(key, item);
				}
			} else if (operacion == 2) {
				if (tipoDiccionario == 1) {
					/* llenar mati */
				} else if (tipoDiccionario == 2) {
					System.out.print("Ingrese llave a remover: ");
					int key = sc.nextInt();
					lista.remove(key);
				}
			} else if (operacion == 3) {
				if (tipoDiccionario == 1) {
					/* llenar mati */
				} else if (tipoDiccionario == 2) {
					System.out.print("Ingrese llave a buscar: ");
					int key = sc.nextInt();
					String salida = lista.find(key);
					if (salida == "") {
						System.out.println("Llave no encontrada en lista");
					} else {
						System.out.println("Encontrada: " + salida);
					}
				}
			} else if (operacion == 4) {
				if (tipoDiccionario == 1) {
					/* llenar mati */
				} else if (tipoDiccionario == 2) {
					System.out.print("Ingrese rango minimo de busqueda (begin): ");
					int begin = sc.nextInt();
					System.out.print("Ingrese rango maximo de busqueda (begin): ");
					int end = sc.nextInt();
					String salida = lista.findRange(begin, end);
					if(salida=="") {
						System.out.println("Ningun elemento dentro del rango");
					}else {
						System.out.println("Elementos encontrados\n+"+salida);
					}
				}
			} else if (operacion == 5) {
				if (tipoDiccionario == 1) {
					/* llenar mati */
				} else if (tipoDiccionario == 2) {
					System.out.print("Ingrese llave a buscar altura asociada: ");
					int key = sc.nextInt();
					int salida=lista.height(key);
					if(salida==-1) {
						System.out.println("Llave no esta en lista, por tanto, no se puede calcular su altura asociada");
					}else {
						System.out.println("Altura asociada: "+salida);
					}
				}
			} else if (operacion == 6) {
				if (tipoDiccionario == 1) {
					/* llenar mati */
				} else if (tipoDiccionario == 2) {
					System.out.println("\n" + lista.toString());
				}
			} else {
				System.out.println(">ERROR: operacion no valida, intentalo nuevamente");
			}
		} while (operacion != 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("---\nIngrese el tipo de diccionario sobre el cual operará:\n" + "	1 sobre arborAVL\n "
				+ "	2 sobre lista Ordenada\n" + "	0 para salir\n" + ":");
		tipoDiccionario = sc.nextInt();

		System.out.print("\n---\nIngrese la version a realizar: \n" + "	1 para probar version interactiva \n"
				+ "	2 para probar version experimental \n" + "	0 para salir \n" + ":");
		int version = sc.nextInt();

		switch (version) {
		case 0:
			System.out.println(">Decisiste salir");
			break;
		case 1:
			interactiva();
			break;
		case 2:
			/* experimental */
			break;
		default:
			System.out.println(">ERROR: operacion no valida");
			break;
		}
	}

}
