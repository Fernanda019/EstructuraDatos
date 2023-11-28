public class ListaSimple
{
	Node top;

	//Métodos para los casos de inserción de nodos
	public boolean insertaPrimerNodo(String dato)
	{
		if (top == null) 
		{ //La lista no está vacía
			top = new Node();
			top.name = dato;
			top.next = null;

			return true;
		}
		else 
		{
			return false;
		}
	}

	public void insertaAntesPrimerNodo(String nombre)
	{
		Node temp; 
		temp = new Node ();
		temp.name = nombre;
		temp.next = this.top;
		this.top = temp;
		temp = null;
	}

	public void insertaAlFinal(String nombre)
	{
		Node temp = new Node ();
		temp.name = nombre;
		temp.next = null;
		//Node temp2;
		Node temp2 = this.top;

		while (temp2.next != null)
			temp2 = temp2.next;

		temp2.next = temp;
		temp = null;
		temp2 = null;
	}

	public boolean insertaEntreNodos(String nombre, String buscado)
	{
		Node temp = new Node();
		temp.name = nombre;
		Node temp2 = this.top;

		//boolean NodoNoEncontrado = true;

		while ( (temp2 != null) 
				&& temp2.name.equals(buscado) == false ) 
		{	
		         temp2 = temp2.next;
		}

		if (temp2 != null)
		{  //Nodo buscado se encontró
			temp.next = temp2.next;
			temp2.next = temp;
			temp = null;
			temp2 = null;
			return true;
		}
		else return false;
	} 

	//Buscar nodo
	public Node BuscarNodo (String buscado)
    {
        Node temp = top;

        while (temp != null && !temp.name.equalsIgnoreCase(buscado))
        {
            temp = temp.next;
        }

        return temp;
    }

    //Agregar uno despues de él
    public void BuscarYAgregarNodo(String buscado, String dato)
    {
        //Otorga en valor booleano a "valorEncontrado" para saber si es null
       Node valorEncontrado = BuscarNodo(buscado);

       if (top == valorEncontrado)
       {
           Node temp = new Nodo();
           temp.name = dato;
           temp.next = valorEncontrado.next;
           valorEncontrado.next = temp;
       }

    }

    //Intercambiar nodo por otro buscado
    public void IntercambiarNodo(String buscado, String nuevo)
    {
        Node valorEncontrado = BuscarNodo(buscado);

        if (valorEncontrado != null)
        {
            Node temp2 = top;

            while (temp2 != null && !temp2.name.equalsIgnoreCase(buscado))
            {
                temp2 = temp2.next;
            }

            temp2.name = nuevo;
            temp2 = null;
        }
    }

	public void imprimir()
	{
		for (Node temp = this.top; temp != null; temp = temp.next){
			System.out.print("[ " + temp.name + " ] -> ");
		}

		System.out.print("[X]\n"); 
	}

	public String toString()
	{
		String cadAux = "";
		for (Node temp = this.top; temp != null; temp = temp.next)
		{
			cadAux += "[ " + temp.name + " ] -> ";
		}

		cadAux += "[X]\n"; 

		return cadAux;
	}
    
	//Métodos de borrado
	public void borrarPrimerNodo()
	{
		this.top = this.top.next;
	}

	//Borrar cualquier nodo que no sea el primero
	public boolean borrarCualquierNodo(String buscado)
	{
		Node temp = this.top;

		while ( (temp != null) 
				&& temp.name.equals(buscado) == false ) 
		{	
		         temp = temp.next;
		}

		if (temp != null)
		{  //Nodo buscado se encontró
			temp.next = temp.next.next;
			temp = null;
			
			return true;
		}
		else return false;
	}

}