package ex01;


import java.util.ArrayList;
import java.util.Iterator;

public class Cine {
	private int nombreFiles;
	private int nombreSeients;
	private GestioButaques gestioButaques;
	
	public Cine() {
		demanarDadesInicials();	
		gestioButaques=new GestioButaques();
		
	}
	
	public void setNombreFiles(int nombreFiles) {
		this.nombreFiles = nombreFiles;
	}
	
	public int getNombreFiles() {
		return nombreFiles;
	}
	
	public void setNombreSeients(int nombreSeients) {
		this.nombreSeients = nombreSeients;
	}
	
	public int getNombreSeients() {
		return nombreSeients;
	}
	public void iniciar(Cine cine) {
		int opcio;
		
		
		do{
			opcio=menu();
			switch(opcio) {
			case 1:
				mostrarButaques(cine);
				break;
			case 2:
				mostrarButaquesPersona(cine);
				break;
			case 3:
				reservarButaca(cine);
				break;
			case 4:
				anularReserva( cine);
				break;
			case 5:
				anularReservaPersona(cine);
				break;
			case 0:
				System.out.println("Fi");
				break;
			default:
				System.out.println("Opció incorrecta");
				break;
				
				
			}
			
			
		}while(opcio!=0);
		
	}
	
	public int menu() {
		
		int opcio=-1;
		while(opcio<0||opcio>5){
			System.out.println(
					"1.- Mostrar totes les butaques reservades.\n"+
					"2.- Mostrar les butaques reservades per una persona.\n"+
					"3.- Reservar una butaca.\n"+
					"4.- Anul·lar la reserva d’una butaca.\n"+
					"5.- Anul·lar totes les reserves d’una persona.\n"+
					"0.- Sortir");
			opcio=Entrada.llegirInt("Selecciona una acció.....");
			if(opcio<0||opcio>5) {
				System.out.println("Selecciona una opció correcte");
			}
		}
		return opcio;
	}
	
	public void mostrarButaques(Cine cine){
		
		ArrayList<Butaca> butaques=new ArrayList<>();
		butaques =cine.gestioButaques.getButaques();
		Iterator<Butaca> butaquesIterator= butaques.iterator();
		while(butaquesIterator.hasNext()) {
			System.out.println(butaquesIterator.next().toString());
		}
		

	
	}
	public void anularReservaPersona(Cine cine){
		int i;
		String persona="";
		int personas=0;
		ArrayList<Butaca> butaques=new ArrayList<>();
		butaques =cine.gestioButaques.getButaques();
	
		try {
			persona=introduirPersona(cine);
		} catch (ExcepcioNomPersonaIncorrecte e) {
			System.out.println("Nom de persona incorrecte");
		}
		i=0;
		do {
		 
			if(persona.equals(butaques.get(i).getPersonaRes())) {
				System.out.println(butaques.get(i).toString());
				butaques.remove(i);
				i=0;
				System.out.println("Reserva esborrada");
				++personas;
			}
			else {
				++i;
			}
			
		}while(i<butaques.size());
		if (personas==0) {
			System.out.println("Expectador inexistent");
		}

	}
	
	public void reservarButaca(Cine cine) {
		
		
		try {
		Butaca butaca=new Butaca(introduirFila(cine),introduirSeient(cine),introduirPersona(cine));
		gestioButaques.afegirButaca(butaca);
		}catch (ExcepcioFilaIncorrecta e) {
			System.out.println("La fila no existeix");
		}catch (ExcepcioSeientIncorrecte e) {
			System.out.println("El seient no existeix");
		}catch (ExcepcioNomPersonaIncorrecte e) {
			System.out.println("Nom persona Incorrecte");
		}catch (ExcepcioButacaOcupada e) {
			System.out.println("La butaca està ocupada");
		}
		
			
	}
	
	public void anularReserva(Cine cine) {
		int fila=0;
		int seient=0;
			
		try {
		fila=introduirFila(cine);
		seient=introduirSeient(cine);
		cine.gestioButaques.eliminarButaca(fila, seient);
		}catch (ExcepcioFilaIncorrecta e) {
			System.out.println("La fila no existeix");
			
		}catch (ExcepcioSeientIncorrecte e) {
			System.out.println("El seient no existeix");
		}catch (ExcepcioButacaLLiure e) {
			System.out.println("La butaca està lliure");
		}
			
	}
	
	public void mostrarButaquesPersona(Cine cine) {
		
		String persona="";
		int i;
		int personas=0;
		ArrayList<Butaca> butaques=new ArrayList<>();
		butaques=cine.gestioButaques.getButaques();
		try {
			persona=introduirPersona(cine);
		} catch (Exception e) {
			System.out.println("Nom de persona incorrecte");
		}
		for(i=0;i<butaques.size();++i) {
			if(persona.equals(butaques.get(i).getPersonaRes())) {
				System.out.println(butaques.get(i).toString());
				++personas;
			}
		}
		if (personas==0) {
			System.out.println("Expectador inexistent");
		}
		
		
	}
	
	public void demanarDadesInicials() {
		setNombreFiles(Entrada.llegirInt("Quantes files te la sala?"));
		setNombreSeients(Entrada.llegirInt("Quantes butaques hi han per fila?"));
	}
	
	public int introduirFila(Cine cine) throws ExcepcioFilaIncorrecta{
		int fila;
		fila=Entrada.llegirInt("Introdueix fila:");
		if ((fila>=1)&&(fila<=cine.nombreFiles)) {
			return fila;
		}
		else {
			
			throw new ExcepcioFilaIncorrecta();
		}
	}
	
	public int introduirSeient(Cine cine) throws ExcepcioSeientIncorrecte{
		int seient;
		seient=Entrada.llegirInt("Introdueix seient:");
		if ((seient>=1)&&(seient<=cine.nombreSeients)) {
			return seient;
		}
		else {
			
			throw new ExcepcioSeientIncorrecte();
		}
	}
	
	public String introduirPersona(Cine cine ) throws ExcepcioNomPersonaIncorrecte{
		String persona;
		char lletra;
		int i;
		persona=Entrada.llegirString("Introdueix nom espectador:");
		for (i=0;i<persona.length();++i) {
			lletra=persona.charAt(i);
			if (!(lletra>='a'&&lletra<='z')||(lletra>='A'&&lletra<='Z')) {
				throw new ExcepcioNomPersonaIncorrecte();
			}
		}
		return persona;
		
	}

	
}
	

	

