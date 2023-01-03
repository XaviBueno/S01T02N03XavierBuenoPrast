package ex01;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Entrada {
	
	public static byte llegirByte(String missatge) {
		boolean valid=false;
		byte output=0;
		Scanner input= new Scanner(System.in);
		System.out.println(missatge);
		while(valid==false) {
			try {
				valid=true;
				output=input.nextByte();
			}catch(InputMismatchException e){
				input.nextLine();
				System.out.println("Error de format");
				valid=false;
				
			}
		}
		return output;
	}
	
	public static int llegirInt(String missatge) {
		boolean valid=false;
		int output=0;
		Scanner input= new Scanner(System.in);
		System.out.println(missatge);
		while(valid==false) {
			try {
				valid=true;
				output=input.nextInt();
			}catch(InputMismatchException e){
				input.nextLine();
				System.out.println("Error de format");
				valid=false;
				
			}
		}
		return output;
	}
	
	public static float llegirFloat(String missatge) {
		boolean valid=false;
		float output=0;
		Scanner input= new Scanner(System.in);
		System.out.println(missatge);
		while(valid==false) {
			try {
				valid=true;
				output=input.nextFloat();
			}catch(InputMismatchException e){
				input.nextLine();
				System.out.println("Error de format");
				valid=false;
				
			}
		}
		return output;
	}
	
	public static double llegirDouble(String missatge) {
		boolean valid=false;
		double output=0;
		Scanner input= new Scanner(System.in);
		System.out.println(missatge);
		while(valid==false) {
			try {
				valid=true;
				output=input.nextDouble();
			}catch(InputMismatchException e){
				input.nextLine();
				System.out.println("Error de format");
				valid=false;
				
			}
		}
		return output;
	}
	
	public static char llegirChar(String missatge)  {
		boolean valid=false;
		String teclat;
		char output=0;
		Scanner input= new Scanner(System.in);
		System.out.println(missatge);
		while(valid==false) {
			
			try {
				valid=true;
				comprovaChar(teclat=input.next());
				output=teclat.charAt(0);
			}catch(Exception e){
				input.nextLine();
				System.out.println("Error de format");
				valid=false;
				
			}
		}
		return output;
	}
	
	public static String llegirString(String missatge) {
		
		boolean valid=false;
		String output="";
		Scanner input= new Scanner(System.in);
		System.out.println(missatge);
		while(valid==false) {
			try {
				valid=true;
				output=input.next();
			}catch(Exception e){
				input.nextLine();
				System.out.println("Error de format");
				valid=false;
				
			}
		}
		return output;
		
	}
	
	public static boolean llegirSiNo(String missatge) {
		boolean valid=false;
		boolean output=false;
		Scanner input= new Scanner(System.in);
		System.out.println(missatge);
		while(valid==false) {
			try {
				valid=true;
				output=comprovaSiNo(input.next());
				
			}catch(Exception e){
				input.nextLine();
				System.out.println("Error de format");
				valid=false;
				
			}
		}
		return output;
		
	}
	
	static void comprovaChar(String entrada) throws ExceptionFormat{
		if( entrada.length()>1) {
			
				throw new ExceptionFormat(("Error de Format"));
				}
		}
	static boolean comprovaSiNo(String entrada) throws ExceptionFormat{
		 boolean output=false;
		 String siNo=entrada.toLowerCase();
		 if (siNo.equals("s")) {
			 output=true;
		 }
		 else if  (siNo.equals("n"))  {
			 output=false;
		 }
		 else {
			 throw new ExceptionFormat(("Error de Format")); 
		 }
		 return output;
	}
		
}
