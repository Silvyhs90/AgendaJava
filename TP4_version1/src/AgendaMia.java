import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class AgendaMia 
{

	public static void main(String[] args) 
	{
		Agenda a1= new Agenda();
		 int opcion = 0;
	 while(opcion!=12)
		 {
		 opcion=Integer.parseInt(JOptionPane.showInputDialog("Menu Principal Agenda \nIngrese Opcion \n 1- Mostrar todos los contactos \n 2- Agregar contacto \n 3- Eliminar contacto \n 4- Editar contacto \n 5- Busqueda por dni \n 6- Busqueda por nombre \n 7- Busqueda por apellido \n 8- Ordenar por nombre \n 9- Ordenar por apellido \n 10- Crear archivo \n 11- Mostrar archivo \n  12- Salir"));
		 	switch(opcion)
		 	{
		 	default: 
		 		System.out.println("Indique solo numero del 1 al 11");
		 		break;
        	case 1:
        		a1.mostrarAgenda();
        		break;
        	case 2:
        		String agre;
        		do {
        			a1.agregarContacto();
        	agre=JOptionPane.showInputDialog(null,"Quiere agregar otro contacto?");	
				}while (agre.equalsIgnoreCase("si"));
				break;
        	case 3:
        		String borrar;
				do {
					a1.borrarContacto();
        	borrar=JOptionPane.showInputDialog(null,"Quiere eliminar otro contacto?");
				 }while (borrar.equalsIgnoreCase("si"));
        		break;
        	case 4:
        		String modif;
        		do
        		{
        		a1.modificarContacto();	
        	modif=JOptionPane.showInputDialog(null,"Quiere editar otro contacto?");
				}while (modif.equalsIgnoreCase("si"));
        		break;
        	case 5:
        		String d;
        		do
        		{
        		a1.buscarDni("B34093848");	
        	d=JOptionPane.showInputDialog(null,"Quiere buscar otro dni en esta agenda?");
				}while (d.equalsIgnoreCase("si"));
        		break;
        	case 6:
        		String nom;
        		do
        		{
        			a1.buscarNombre("juan");	
        	nom=JOptionPane.showInputDialog(null,"Quiere buscar otro nombre en esta agenda?");		
				}while (nom.equalsIgnoreCase("si"));
        		break;
        	case 7:
        		String ape;
        		do
        		{
        			a1.buscarApellido("perez");	
        	ape=JOptionPane.showInputDialog(null,"Quiere buscar otro apellido en esta agenda?");		
				}while (ape.equalsIgnoreCase("si"));
        		break;
        	case 8:
        		a1.ordenarNombre();
        		a1.mostrarAgenda();
        		break;
        	case 9:
        		a1.ordenarApellido();
        		a1.mostrarAgenda();
        		break;
        	case 10:
        		a1.imprimirContactos();
        		break;
        	case 11:
        		a1.LeoArchivo();
        		break;
        	case 12:
        		System.out.println("Adios");
        		break;
        		
        	}
		 	
		 	}
	}
	

}


class Agenda 
{
	private Contacto []age= new Contacto [100];		// Esto es una clase que tiene como atributo un objeto de otra clase.
	
	
	public Agenda()   //constructor
	{
		
		inventaContacto();  //metodo que ya tiene contactos agregados en la agenda
		
		// LEER ARCHIVO
		RandomAccessFile archivo = null;
		byte datos[] = null;			//creo una referencia p/ el array pero no lo creo aun.
		//new byte[tam]; //array de bytes 

		// apertura y cierre de archivos, sea para leer o escribir tienen que estar dentro del TRY.
		try
		{
			archivo = new RandomAccessFile("Agenda.txt" , "rw");
		}
		catch(IOException e)
		{
			
		}
		
		if(archivo!=null)
		{
			String linea= new String();
		try
		{
			int tam=(int)archivo.length();   
			datos= new byte[tam]; //array de bytes, dentro de los corchetes esta el tama�o del archivo.length() 
			archivo.read(datos); //devuelve la cantidad de bytes que pudo leer
			// le paso como datos para que lea el archivo entero
		}
		catch(Exception e)
		{
			System.out.println("Error al leer" +e);
		}
		try
		{
			archivo.close();  // siempre cerrar el archivo!
		}
		catch (IOException e)
		{
			System.out.println("Error al cerrar");
		}
		
		if(datos!=null) //datos es array de bytes y esta asociado con cada byte que representa
		{
			String archivoString= new String (datos);
		}
		}
		
		
	}
	
	public void LeoArchivo()
		{
			RandomAccessFile archivo = null;
			byte datos[] = null;			//creo una referencia p/ el array pero no lo creo aun.
			//new byte[tam]; //array de bytes 

			// apertura y cierre de archivos, sea para leer o escribir tienen que estar dentro del TRY.
			try
			{
				archivo = new RandomAccessFile("Agenda.txt","rw");
			}
			catch(IOException e)
			{
				
			}
			
			if(archivo!=null)
			{
				String linea= new String();
			try
			{
				int tam=(int)archivo.length();   
				datos= new byte[tam]; //array de bytes, dentro de los corchetes esta el tama�o del archivo.length() 
				archivo.read(datos);
				linea=new String(datos);//convierto a string
				System.out.println(linea);
				
			}
			catch(Exception e)
			{
				System.out.println("Error al leer" +e);
			}
			try
			{
				archivo.close();  // siempre cerrar el archivo!
			}
			catch (IOException e)
			{
				System.out.println("Error al cerrar");
			}
			}
			
		
		
		
	}
		
	
	 
	public void inventaContacto()
	{
		age[0]=new Contacto("juan", "lopez","40969555", "45886969", "tio" , 65 );
		age[1]=new Contacto("silvina", "saucedo","39284456", "45886969", "yo misma" , 29 );
		age[12]=new Contacto("juan", "gutierrez","345532434", "1556576777", "primo" , 39 );
		age[8]=new Contacto("mariana", "fernandez","8202949", "34445656", "cu�ada" , 32 );
		age[25]=new Contacto("fabian", "housay","12939444", "45766666", "amigo" , 33 );
		age[32]=new Contacto("roberto", "fernandez","32848555", "8686868", "conocido" , 76 );
		age[18]=new Contacto("clara", "alvear","2050444", "41565654545", "abuela materna" , 99 );
		age[19]=new Contacto("juan", "lopez","40969555", "45886969", "primo" , 65 );
		age[30]=new Contacto("silvina", "saucedo","39284456", "45886969", "trabajo" , 29 );
		age[21]=new Contacto("juan", "gutierrez","345532434", "1556576777", "amigo" , 39 );
		age[99]=new Contacto("mariana", "fernandez","8202949", "34445656", "amigo" , 32 );
		age[76]=new Contacto("fabian", "housay","12939444", "45766666", "amigo" , 33 );
		age[66]=new Contacto("manuel", "fernandez","32848555", "8686868", "abuelo" , 76 );
		age[80]=new Contacto("margarita", "alvear","2050444", "41565654545", "abuela paterna" , 99 );
		
		
		
		System.out.println(" ");
	}
		
	public boolean agregarContacto()
	{
		String nombre, apellido, dni, telefono, relacion;
		int edad;
		int i=0;
		
		for( i=0; (i< age.length) && (age[i]!=null)  ; i++) //busco un lugar vacio 
		{
			
		}
		// sali porque esta lleno o porque encontre lugar
		
		if (i < age.length)
		{//no esta lleno el array, osea hay lugar
			nombre=JOptionPane.showInputDialog(null,"Ingrese nombre");
			apellido=JOptionPane.showInputDialog(null,"Ingrese apellido");
			dni=JOptionPane.showInputDialog(null,"Ingrese DNI");
			telefono=JOptionPane.showInputDialog(null,"Ingrese telefono");
			relacion=JOptionPane.showInputDialog(null,"Ingrese relacion /Eje: Pareja, familiar, conocido, etc ");
			edad=Integer.parseInt(JOptionPane.showInputDialog(null," Ingrese edad"));
			
			age[i]=new Contacto(nombre, apellido, dni, telefono, relacion , edad );	
			System.out.println("El contacto ["+i+"] se ha agregado con exito");
			mostrarAgenda();
			return(true);
				
		}
		else 
		{
			System.out.println("La agenda esta llena");
			return(false);
		}
			
	}
	
	public boolean borrarContacto()
{
	//Al contacto lo tengo que volver null;
	boolean borrar=false;
	int pos=Integer.parseInt(JOptionPane.showInputDialog("ingrese posicion a borrar")); // posicion de memoria donde esta mi contacto
	
	
	for( int i=0; i< age.length; i++)
	{
		if (age[i]== age[pos])  // si la posicion de I es igual a la de POS, se borra el contacto porque es nulo, entonces es true
		{
			age[i]=null;
				borrar=true;
				
		}
	}
	System.out.println("El contacto ["+pos+"] se ha eliminado con exito");
	mostrarAgenda();
		if(borrar)
		{	
			return(false);
		}
		else 
		{
			return(true); // se borra el contacto
		}
		
}

	public boolean modificarContacto()
{
	String nombre, apellido;
	int edad, pos , i;
	pos=Integer.parseInt(JOptionPane.showInputDialog("ingrese posicion a modificar"));
	nombre=JOptionPane.showInputDialog(null, "ingrese nuevo nombre");
	apellido=JOptionPane.showInputDialog(null, "Ingrese nuevo apellido");
	edad=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese nueva edad"));
	boolean modificar = false;       
	
	for( i=0 ; i < age.length ; i++)        // busco en las posiciones de la agenda, y si la posicion i es igual a pos, hago la modificacion.
	{
		if(age[i]==age[pos])
		{
			age[pos].setNombre(nombre);          //llamo a la clase .nombre que sea igual al atributo nombre que declare en este metodo
			age[pos].setApellido(apellido);
			age[pos].setEdad(edad);
			
			System.out.println("El contacto ["+i+"] se ha editado con exito");
			mostrarAgenda();
			return (modificar);
		}
		
		if(age[i]!=age[pos])
		{
		System.out.println("El contacto que quiso modificar NO existe, intente con otra posicion");
		
		}
		
		
	}	
		if(modificar)
		{
			return(false);
		}
		else
		{
				
			return(true);	
		}
 }


	public void mostrarAgenda()
	{
		System.out.println(" ");
		for(int i=0 ; i<age.length ; i++)
		{
			if(age[i]!=null) //si no esta vacio lo muestro
			{
				System.out.println("["+i+"]");
				age[i].mostrarDatos();	
			}
			
		}
		System.out.println("  ");
	}
	
	public void imprimirContactos()
	{
		String textoLinea = " ";
		
		try 
		{
		
		FileOutputStream flujo_a_miArchivo = new FileOutputStream("Agenda.txt");  //no existe aun, no lo creamos
					
		for(int i=0 ; i<age.length ; i++)
		{
			if(age[i]!=null) //si no esta vacio lo muestro
			{
				textoLinea= textoLinea.concat(Integer.toString(i));		//pasar de INT a STRING
				
				textoLinea= textoLinea.concat(" " + age[i].getNombre());
				textoLinea= textoLinea.concat(" " + age[i].getApellido());
				textoLinea= textoLinea.concat(" " + age[i].getDni());
				textoLinea= textoLinea.concat(" " + age[i].getTelefono());
				textoLinea= textoLinea.concat(" " + age[i].getEdad());
				textoLinea= textoLinea.concat(" " + age[i].getRelacion());
				textoLinea=textoLinea.concat("\r\n");

				//System.out.println("["+i+"]");
				//age[i].mostrarDatos();	
			}
			
		}
		
		flujo_a_miArchivo.write(textoLinea.getBytes());//escribo linea en archivo				
		flujo_a_miArchivo.close();  // lo cierro!
		
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	

	public void buscarNombre(String nombre)
{
		System.out.println("Busqueda por NOMBRE: ");
		int nom=0;
		
		nombre= JOptionPane.showInputDialog("ingrese el nombre a buscar");
		
		for(int i=0; i< age.length ; i++)
		{
		if((age[i]!=null) && (age[i].getNombre().equalsIgnoreCase(nombre))) //posiciones llenas Y que tengan el nombre que se buscan
		{
			age[i].mostrarDatos();
			nom++;
		}
		}
		if(nom!=0)
		{
			System.out.print("SE ENCONTRARON : "+nom+"  "+nombre);
			
		}
		else 
		{
			System.out.print("NO se encontro ningun resultado con el nombre "+nombre);
		}
		System.out.println("  ");
}

	public void buscarApellido(String apellido)
	{
		System.out.println(" ");
		System.out.println("Busqueda por APELLIDO: ");
		int ape=0;
		
		apellido= JOptionPane.showInputDialog(null, "Ingrese el apellido a buscar");
		
		for(int i=0; i< age.length ; i++)
	{
		if((age[i]!=null) && (age[i].getApellido().equalsIgnoreCase(apellido))) //posiciones llenas Y que tengan el nombre que se buscan
		{
			System.out.print("se encontro ["+i+"]");
			age[i].mostrarDatos();
			ape++;
		}
	}
		if(ape!=0)
		{
			System.out.print("SE ENCONTRARON : "+ape+"  "+apellido);
			
		}
		else 
		{
			System.out.print(" NO se encontro ningun resultado con el apellido "+apellido);
		}
		System.out.println("  ");
	}

	public void buscarDni(String dni)
	{
		System.out.println(" ");
		System.out.println("Busqueda por DNI: ");
		int d=0;
		
		dni= JOptionPane.showInputDialog(null, "Ingrese el dni a buscar");
		
		for(int i=0; i< age.length ; i++)
	{
		if((age[i]!=null) && (age[i].getDni().equalsIgnoreCase(dni))) //posiciones llenas Y que tengan el nombre que se buscan
		{
			System.out.print("se encontro ["+i+"]");
			age[i].mostrarDatos();
			d++;
		}
	}
		if(d!=0)
		{
			System.out.print("SE ENCONTRARON : "+d+" dni "+dni);
			
		}
		else 
		{
			System.out.print(" NO se encontro ningun resultado con el dni "+dni);
		}
		System.out.println("  ");
	
	}
	
	public void ordenarNombre() {

        int i,j, intercambio=0;

        for (i = 0; (i < age.length); i++) {
            for (j = 0; (j < age.length); j++) 
            {
                if ((age[i] != null) && (age[j] != null) && (age[i].getNombre().compareToIgnoreCase(age[j].getNombre()) < 0)) 
                {
                    Contacto  axiJ;
                    Contacto  axiI; 
                    axiI = age[i];
                    axiJ = age[j];

                    age[j]=axiI;
                    age[i]=axiJ;
                  
                    intercambio++;
                
                }
            }
        }
        if(intercambio==0) {
            intercambio=0;
           
            System.out.println("La agenda ha sido ordenada exitosamente");
            return;
        }
	}
	
	public void ordenarApellido() {

        int i,j, intercambio=0;

        for (i = 0; (i < age.length); i++) {
            for (j = 0; (j < age.length); j++) 
            {
                if ((age[i] != null) && (age[j] != null) && (age[i].getApellido().compareToIgnoreCase(age[j].getApellido()) < 0)) 
                {
                    Contacto  axiJ;
                    Contacto  axiI; 
                    axiI = age[i];
                    axiJ = age[j];

                    age[j]=axiI;
                    age[i]=axiJ;
                  
                    intercambio++;
                
                }
            }
        }
        if(intercambio==0) {
            intercambio=0;
           
            System.out.println("La agenda ha sido ordenada exitosamente");
            return;
        }
}
}		


class Contacto
{
	private String nombre, apellido, dni, telefono, relacion;
	private int edad;
	
	public Contacto (String nombre, String apellido, String dni, String telefono, String relacion, int edad)
	{
		this.setNombre(nombre);			// tienen un setter porque le doy un valor a un atributo privado
		this.setApellido(apellido);
		this.setDni(dni);
		this.setTelefono(telefono);
		this.setRelacion(relacion);
		this.setEdad(edad);
	}  // constructor explicito
	


	public void mostrarDatos()
	{
		System.out.println(" Nombre: "+getNombre() + " Apellido: "+getApellido()+" Dni: "+getDni()+" Telefono: "+telefono+" Relacion: "+relacion+" Edad: "+getEdad());
	}
				// tienen un getter porque devuelve el valor que tiene el numero privado para mostrarlo con SYSTEM.OUT


	public String getDni() {
		return (dni);
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getApellido() {
		return (apellido);
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getNombre() {
		return (nombre);
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getEdad() {  // GETTER capta el valor, en un metodo publico que almacena un atributo int que es private
		return (edad);
	}

	
	public void setEdad(int edad) {			// SETTER establece un valor private con un void, porque no devuelve nada
		this.edad = edad;
	}
	
	
	public String getTelefono() {		
		return (telefono);
	}

	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setRelacion(String relacion)
	{
		this.relacion= relacion;
	}
	
	public String getRelacion() {		
		return (relacion);
	}
	
	
	
	

}
