package mc322.lab06;

public class Sala {
	
	Componente [] meusComponentes;
	boolean salaConhecida;
	
	public Sala() {
		meusComponentes = null;
	}
	
	public boolean adicionaComponente(Componente c) {
		// m�todo verifica
		if(verifica(c)) {
			if(meusComponentes != null) {
				Componente [] novoVetor = new Componente[meusComponentes.length + 1];
				novoVetor[0] = c;
				for(int i = 0; i < meusComponentes.length; i++ ) {
					novoVetor[i+1] = meusComponentes[i];
				}
				meusComponentes = new Componente[novoVetor.length];
				meusComponentes = novoVetor;
			}else {
				meusComponentes = new Componente [1];
				meusComponentes[0] = c;
				meusComponentes[0].printa();
			}
			return true;
		}else {
			//N�o pode colocar nessa sala;
			return false;
		}
	}
	
	public boolean retiraComponente(Componente c) {
		boolean estado = false;
		for(int i = 0;i < meusComponentes.length;i++) {
			if(c == meusComponentes[i]) {
				estado = true;
			}
		}
		
		if(estado) {
			if(meusComponentes.length > 1) {
				Componente [] novoVetor = new Componente[meusComponentes.length - 1];
				int aux = 0;
				for(int i = 0; i < meusComponentes.length; i++ ) {
					if(meusComponentes[i] != c) {
						novoVetor[aux] = meusComponentes[i];
						aux++;
					}
				}
				meusComponentes = new Componente[novoVetor.length];
				meusComponentes = novoVetor;
			}else {
				meusComponentes = null;
			}
		}
		
		return estado;
	}
	
	private boolean verifica(Componente c) {
		//OURO, WUMPUS E BURACO n�o podem estar na mesma sala
		boolean estado = true;
		if(meusComponentes != null) {
			for(int i = 0; i < meusComponentes.length; i++) {
				if(meusComponentes[i].getTipo() == 'O' || meusComponentes[i].getTipo() == 'W' || meusComponentes[i].getTipo() == 'B') {
					if(c.getTipo() == 'O' || c.getTipo() == 'W' || c.getTipo() == 'B') {
						estado = false;
					}
				}
			}
		}
		return estado;
	}
	
}
