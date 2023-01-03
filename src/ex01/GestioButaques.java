package ex01;

import java.util.ArrayList;

public class GestioButaques {
	ArrayList<Butaca> butaques;
	
	public GestioButaques() {
		butaques= new ArrayList<Butaca>();
		
	}
	public ArrayList<Butaca> getButaques(){
		return butaques;
	}
	
	public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada {
		
		if(cercarButaca(butaca.getNumFila(),butaca.getNumSeient())>=0){
			throw new ExcepcioButacaOcupada();
		}
		else {
			butaques.add(butaca);
				
		}
		
		
	}

	public int cercarButaca(int fila, int seient) {
		Butaca butaca=new Butaca(fila, seient,"");
		int index=0;
		boolean trobat=false;
		while(!trobat&&index<butaques.size()) {
			trobat=butaques.get(index).equals(butaca);
			index++;
		}
		if(trobat==true) return index-1;
		else  return -1;
		

	}
	public void eliminarButaca(int fila, int seient)throws ExcepcioButacaLLiure {
		
		int index;
		index=cercarButaca(fila, seient);
		if(index!=-1) {
			butaques.remove(index);
			System.out.println("Reserva esborrada");
		}
		else {
			throw new ExcepcioButacaLLiure();
		}
		
	}

	
}
