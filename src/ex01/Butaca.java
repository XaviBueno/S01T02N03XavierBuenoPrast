package ex01;

public class Butaca {
	//Atributs
	private int numFila;
	private int numSeient;
	private String personaRes;
	
	//Constructor
	public Butaca() {
		
	}
	public  Butaca(int numFila,int numSeient,String personaRes) {
		this.numFila=numFila;
		this.numSeient=numSeient;
		this.personaRes=personaRes;
		
	}
	//Getters & Setters
	public int getNumFila() {
		return numFila;
	}
	
	public int getNumSeient() {
		return numSeient;
	}
	
	public String getPersonaRes(){
		return personaRes;
	}
	
	public void setNumFila(int numFila) {
		this.numFila=numFila;
	}
	
	public void setNumSeient(int numSeient) {
		this.numSeient=numSeient;
	}
	
	public void setPersonaRes(String personaRes) {
		this.personaRes=personaRes;
	}
	
	
	//Mètodes
	@Override
	public String toString() {
		
		return  "Fila: "+numFila+ ",Seient: "+numSeient+ " ,Persona: "+personaRes;
	}
	
	@Override
	public boolean equals(Object butaca ) {
		Butaca but=(Butaca)butaca;
		
		
		return (this.numFila==but.numFila)&&(this.numSeient==but.numSeient);
	}
		
	
	
	
}
