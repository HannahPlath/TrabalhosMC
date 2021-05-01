package mc322.lab05;

public class Peao {
	private int i,j;
	private char cor;
	
	public char getCor() {
		return cor;
	}
	
	public Peao(int i, int j, char cor) {
		this.i = i;
		this.j = j;
		this.cor = cor;
	}
	
	//vetor: preto: 1, branco:-1, vazio: 0 [caminho, i, j]
	
	public boolean [] validaMovimento(char[] caminho) {
		
		// saida = [true = movimento valido, true = ataque/false = avan�o]
		boolean [] saida = {true, true};
		int tamanho = caminho.length;
		int i_target = Character.getNumericValue(caminho[tamanho -2]);
		int j_target = Character.getNumericValue(caminho[tamanho -1]);
		
		// entrada inv�lida
		if(tamanho <= 2) {
			saida[0] = false;
			saida[1] = false;
			return saida;
		}
		
		//target n�o pode estar ocupado por uma pe�a
		if(caminho[tamanho - 3] != '-') {
			saida[0] = false;
		}
		
		if(saida[0] == true) {
			
			//apenas avan�ando
			if(tamanho == 3) {
				if(cor == 'p') {
					//System.out.println("entrou em p");
					if(i - i_target > 0) {
						//System.out.println("if > 0");
						i = i_target;
						j = j_target;
						saida[1] = false;
					}
					else {
						//System.out.println("else if > 0");
						saida[0] = false;
					}
				}
				else if(cor == 'b') {
					//System.out.println("entrou em b");
					if(i - i_target < 0) {
						//System.out.println("if < 0");
						i = i_target;
						j = j_target;
						saida[1] = false;
					}
					else {
						//System.out.println("else if < 0");
						saida[0] = false;
					}
				}
			}
			//ataque
			else if(tamanho == 4) {
				//System.out.println("tam 4");
				if(caminho[0] != '-') {
					if(caminho[0] != cor) {
						i = i_target;
						j = j_target;
						saida[1] = true;
					}
					else {
						saida[0] = false; 
					}
				}
				else {
					saida[0] = false;
				}
			}
			else {
				saida[0] = false;
			}
		}
		
	return saida;
	}
}
