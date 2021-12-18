
public class ListaOrdenada {
	NodoLista nodoInicial;
	int cantidadNodos;

	/* constructor */
	public ListaOrdenada() {
		nodoInicial = null;
		cantidadNodos = 0;
	}

	public void insert(int key, String item) {
		/* si la lista esta vacia */
		NodoLista nuevoNodo = new NodoLista(key, item);
		if (cantidadNodos == 0) {
			nodoInicial = nuevoNodo;
			cantidadNodos += 1;
			;
		} else { /* si contiene uno o más nodos */
			NodoLista nodoIterado = nodoInicial;
			/* se itera sobre todos los nodos */
			while (nodoIterado != null) {
				if (nodoIterado.key > key) {
					/*
					 * ANTES ----- Ant -> Iterado -> Sig
					 * 
					 * DESPUES ------ Ant -> nuevo -> iterado -> sig
					 */
					NodoLista nodoAnt = nodoIterado.nodoAnterior;
					if (nodoAnt != null) {
						nodoAnt.nodoSiguiente = nuevoNodo;
						nuevoNodo.nodoAnterior = nodoAnt;
						nuevoNodo.nodoSiguiente = nodoIterado;
						nodoIterado.nodoAnterior = nuevoNodo;
						cantidadNodos += 1;
						break;
					} else { /* si es menor que el primero */
						nodoInicial = nuevoNodo;
						nuevoNodo.nodoSiguiente = nodoIterado;
						nodoIterado.nodoAnterior = nuevoNodo;
						cantidadNodos += 1;
						break;
					}
				} else if (nodoIterado.key < key) {
					NodoLista nodoSig = nodoIterado.nodoSiguiente;
					if (nodoSig != null) {
						nodoIterado = nodoIterado.nodoSiguiente;
					} else {
						/*
						 * Ant -> Iterado
						 * 
						 * AHORA: Ant -> Iterado -> Ultimo
						 * 
						 */
						nodoIterado.nodoSiguiente = nuevoNodo;
						nuevoNodo.nodoAnterior = nodoIterado;
						cantidadNodos += 1;
					}
				} else {
					break;
				}
			}
		}
	}

	public void remove(int key) {

		NodoLista nodoIterado = nodoInicial;
		while (nodoIterado != null) {
			/* se borran */
			if (nodoIterado.key == key) {
				NodoLista nodoAnt = nodoIterado.nodoAnterior;
				NodoLista nodoSig = nodoIterado.nodoSiguiente;

				/* si es el unico nodo */
				if (nodoAnt == null && nodoSig == null) {
					/* null -> iterador (se elimina)-> null */
					nodoInicial = null;
				} else if (nodoAnt == null && nodoSig != null) {
					/* si es el primer nodo pero hay mas adelante de este */

					/* null-> iterador (se elimina) -> nodoSig */
					nodoSig.nodoAnterior = null;
					nodoInicial = nodoSig;
				} else if (nodoAnt != null && nodoSig != null) {
					/* si esta en medio de dos nodos */

					/* nodoAnt -> Iterador (se elimina)-> nodoSig */
					nodoAnt.nodoSiguiente = nodoSig;
					nodoSig.nodoAnterior = nodoAnt;
				} else if (nodoAnt != null && nodoSig == null) {
					/* si es el ultimo nodo pero hay antes detras de este */

					/* nodoAnt -> Iterador (se elimina) -> null */
					nodoAnt.nodoSiguiente = null;
				}
				cantidadNodos -= 1;
				break;
			} else { /* si no coinciden, avanza */
				nodoIterado = nodoIterado.nodoSiguiente;
			}
		}
	}

	public String find(int key) {
		NodoLista nodoIterado = nodoInicial;
		while (nodoIterado != null) {
			if (nodoIterado.key == key) {
				return nodoIterado.item;
			} else {
				nodoIterado = nodoIterado.nodoSiguiente;
			}
		}
		return "";
	}

	public String findRange(int begin, int end) {
		String informacion = "";
		NodoLista nodoIterado = nodoInicial;
		while (nodoIterado != null) {
			if (nodoIterado.key < begin) {
				/* se avanza */
				nodoIterado = nodoIterado.nodoSiguiente;
			} else if (nodoIterado.key >= begin) {
				if (nodoIterado.key <= end) {
					informacion += nodoIterado.toString() + "\n";
					nodoIterado = nodoIterado.nodoSiguiente;
				} else {
					/*
					 * sobrepasa el limite superior, no tiene sentido seguir iterando ya que como
					 * esta ordenada de menor a mayor, todos los elementos posteriores serán mayores
					 * y saldran de rango
					 */
					return informacion;
				}
			}
		}
		return informacion;
	}

	public int height(int key) {
		NodoLista nodoIterado = nodoInicial;
		int contador = 1;
		while (nodoIterado != null) {
			if (nodoIterado.key == key) {
				return cantidadNodos - contador;
			} else {
				nodoIterado = nodoIterado.nodoSiguiente;
				contador += 1;
			}
		}
		/*
		 * Como la lista no encontro ninguna llave coincidente, quiere decir que la
		 * altura asociada no representará ningun resultado, por tanto, para identificar
		 * este caso se retorna un -1
		 */
		return -1;
	}

	public String toString() {
		String informacion = "";
		NodoLista nodoIterado = nodoInicial;
		while (nodoIterado != null) {
			informacion += nodoIterado.toString() + "\n";
			nodoIterado = nodoIterado.nodoSiguiente;
		}
		return informacion;
	}
}
