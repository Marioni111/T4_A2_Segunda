/* 1)Crear arbol
 * 2)agregar
 * 3)eliminar
 * 4)mostrar o recorrer
 * 
 */

public class ArbolBinario {

	NodoArbol nodoRaiz;
	
	public ArbolBinario(){
		crearArbol();
	}
	
	public void crearArbol() {
		nodoRaiz = null;
	}
	
	public void agregarElemento(int dato) {
		
		NodoArbol nuevoNodo = new NodoArbol(dato);
		
		if(nodoRaiz == null) {
			nodoRaiz = nuevoNodo;
		}else {
			NodoArbol nodoAux = nodoRaiz;
			NodoArbol nodoAnterior;
			while(nodoAux != null) {
				nodoAnterior = nodoAux;
				if(dato > nodoAux.getDato()) {//derecha
					nodoAux = nodoAux.getNodoDer();
					if (nodoAux == null) {
						nodoAnterior.setNodoDer(nuevoNodo);
					}
				}else {//izquierda
					nodoAux = nodoAux.getNodoIzq();
					if (nodoAux == null) {
						nodoAnterior.setNodoIzq(nuevoNodo);
					}
				}
			}
		}
	}
	
	public void recorridoPreorden(NodoArbol nodoRaiz) {
		
		if(!(nodoRaiz == null)) {
			System.out.print(nodoRaiz.getDato() + "--->");
			recorridoPreorden(nodoRaiz.getNodoIzq());
			recorridoPreorden(nodoRaiz.getNodoDer());
		}	
	}
	
	
	public void recorridoInorden(NodoArbol nodoRaiz) {
		
		if(!(nodoRaiz == null)) {
			recorridoInorden(nodoRaiz.getNodoIzq());
			System.out.print(nodoRaiz.getDato() + "--->");
			recorridoInorden(nodoRaiz.getNodoDer());
		}
	}
	
	public void recorridoPostorden(NodoArbol nodoRaiz) {
		
		if(!(nodoRaiz == null)) {
			recorridoPostorden(nodoRaiz.getNodoIzq());
			recorridoPostorden(nodoRaiz.getNodoDer());
			System.out.print(nodoRaiz.getDato() + "--->");
			
		}
	}

	public void buscarDatoMayor() {
		
		NodoArbol mayor = nodoRaiz;
		NodoArbol nodoAux = nodoRaiz.getNodoDer();
		
			while(nodoAux != null) {
				if(mayor.getDato() < nodoAux.getDato()) {
					mayor = nodoAux;
					nodoAux = nodoAux.getNodoDer();
				}if(nodoAux == null) {
					break;
				}
			}
			System.out.println(mayor.getDato() + " Es el mayor");
	}
	
	public void buscarDatoMenor() {
		
		NodoArbol menor = nodoRaiz;
		NodoArbol nodoAux = nodoRaiz.getNodoIzq();
		
			while(nodoAux != null) {
				if(menor.getDato() > nodoAux.getDato()) {
					menor = nodoAux;
					nodoAux = nodoAux.getNodoIzq();
				}if(nodoAux == null) {
					break;
				}
			}
			System.out.println(menor.getDato() + " Es el menor");
	}
	
	//3) Eliminar
		public boolean eliminarElemento(int dato) {
			
			if(!(nodoRaiz==null)) {
				
				//buscar el dato
				NodoArbol anterior = nodoRaiz;
				NodoArbol aux = nodoRaiz;
				String ladoArbol ="";
				
				//return metodoBusquedaRecursivo(aux, dato);
				while(aux.getDato() != dato) {
					anterior = aux;
					if(dato<=aux.getDato()) { //izquierda
						aux = aux.getNodoIzq();
						ladoArbol = "IZQ";
					}else {//Derecha
						aux = aux.getNodoDer();
						ladoArbol = "DER";
					}
					
					if(aux==null) {
						System.out.println("buscado y no encontrdo");
						return false;
					}
				}//while
				
				System.out.println("encontrado y eliminado");

				
				
				//proceso de eliminacion  (se encontro el dato)
				
				//Escenario 1: El nodo a eliminar es HOJA
				if(aux.getNodoIzq()==null && aux.getNodoDer()==null) { //verficar si es hoja
					if(aux==nodoRaiz)
						nodoRaiz = null;
					else if(ladoArbol.equals("IZQ"))
						anterior.setNodoIzq(null);
					else
						anterior.setNodoDer(null);
				}else if(aux.getNodoIzq()==null) { //verificar si tiene un solo hijo a la IZQ
					if(aux==nodoRaiz)
						nodoRaiz = aux.getNodoIzq();
					else if(ladoArbol.equals("IZQ"))
						anterior.setNodoIzq(aux.getNodoIzq());
					else
						anterior.setNodoDer(aux.getNodoIzq());
				}else if(aux.getNodoDer()==null) { //verificar si tiene un solo hijo a la DER
					if(aux==nodoRaiz)
						nodoRaiz = aux.getNodoDer();
					else if(ladoArbol.equals("IZQ"))
						anterior.setNodoIzq(aux.getNodoDer());
					else
						anterior.setNodoDer(aux.getNodoDer());
				
				
				}else { // de lo contrario TIENE DOS HIJOS -----------------------------------
					
					//----------------------------------------------------------------
					NodoArbol reemplazo = reemplazar(aux);

					if(aux==nodoRaiz)
						nodoRaiz = reemplazo;
					else if(ladoArbol.equals("IZQ"))
						anterior.setNodoIzq(reemplazo);
					else
						anterior.setNodoDer(reemplazo);
					
					reemplazo.setNodoIzq(aux.getNodoIzq());
				}
				return true;
					//----------------------------------------------------------------
				

			}else {
				System.out.println("Arbol vacio");
				return false;
			}
		}
		
		
		public NodoArbol reemplazar(NodoArbol nodo){
			NodoArbol reemplazarPadre = nodo;
			NodoArbol reemplazo = nodo;
			NodoArbol auxiliar = nodo.getNodoDer();
			
			while(auxiliar != null){
				reemplazarPadre = reemplazo;
				reemplazo = auxiliar;
				auxiliar= auxiliar.getNodoIzq();
			}
			if(reemplazo!=nodo.getNodoDer()){
				reemplazarPadre.setNodoIzq(reemplazo.getNodoDer());
				reemplazo.setNodoDer(nodo.getNodoDer());
			}
			return reemplazo;		
		}//metodo reemplazar
	
}
