
public class NodoLista {
	int key;
	String item;
	NodoLista nodoSiguiente;
	NodoLista nodoAnterior;
	
	NodoLista(int key, String item){
		this.key=key;
		this.item=item;
		nodoSiguiente=null;
		nodoAnterior=null;
	}

	@Override
	public String toString() {
		return "[key=" + key + ", item=" + item + "]";
	}
	
	
}
