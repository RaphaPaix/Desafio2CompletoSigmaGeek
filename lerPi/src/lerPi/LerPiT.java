package lerPi;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LerPiT {
	private final static List<char[]>mList=new ArrayList<char[]>();
	public static void main(String[] args) throws Exception {
		
		//criando e carregando o arquivo

		//file de 100 bilhoes de digitos decimais obtido na pagina:
		//https://archive.org/details/pi_dec_1t
		File file = new File("C:\\Users\\Rapha\\Downloads\\pitri.txt");
		FileInputStream entrada = new FileInputStream( file );
		System.out.println("Tamanho do arquivo: "+file.length());
		
		//declarando variáveis
		byte[] buffer = new byte[50000];//para ex vamos de 50 em 50 - no programa utilizar 50000
	    char[] charme = new char[buffer.length];
		int[] vetorLinhaNova = new int[charme.length];
		int[] ultimosAnterior = new int[20];
		int[] resto = new int[40];
		int iteracao=0;
		int numeroIteracoes=4;
		int leitura=0;
		int contador=0;
		//parte logica 
		//dentro do while de leitura do arquivo, colocar varios ifs
		//de acordo com o numero da iteração, utilizaremos tal parte do arquivo
		int cont;
		while ( ( cont = entrada.read( buffer ) ) > -1 ) {
				iteracao++;
				for(int i=0;i<buffer.length;i++) {
			    	 charme[i]=(char)buffer[i];
			     }
				if(iteracao==1) {
					charme[1]='0';
				}
				for(int i=0;i<charme.length;i++) {
	            	switch (charme[i]) {
					case '0':
						vetorLinhaNova[i]=0;
						break;
					case '1':
						vetorLinhaNova[i]=1;
						break;
					case '2':
						vetorLinhaNova[i]=2;
						break;
					case '3':
						vetorLinhaNova[i]=3;
						break;
					case '4':
						vetorLinhaNova[i]=4;
						break;
					case '5':
						vetorLinhaNova[i]=5;
						break;
					case '6':
						vetorLinhaNova[i]=6;
						break;
					case '7':
						vetorLinhaNova[i]=7;
						break;
					case '8':
						vetorLinhaNova[i]=8;
						break;
					case '9':
						vetorLinhaNova[i]=9;
						break;
					default:
						break;
					}
	            }
				//conferindo se o vetor foi convertido corretamente para int
				/*
				System.out.println("");
				for(int i=0;i<50;i++) {
					System.out.printf("%d",vetorLinhaNova[i]);
				}
				*/
				if(iteracao>1) {
					//obter vetor resto
					for(int m=0;m<20;m++) {
	            		resto[m]=ultimosAnterior[m];
	            		resto[m+20]=vetorLinhaNova[m];
	            	}
					//conferir vetor resto
					/*
					System.out.println("\nResto: ");
					for(int m=0;m<40;m++) {
	            		System.out.printf("%d",resto[m]);
	            	}
	            	*/
					//conferir se tem palindromo no vetor resto
					for(int m=0;m<resto.length-20;m++) {
	            		if(resto[m]==resto[m+20]) {
	            			if(resto[m+1]==resto[m+19]) {
	            				if(resto[m+2]==resto[m+18]) {
	            					if(resto[m+3]==resto[m+17]) {
	            						if(resto[m+4]==resto[m+16]) {
	            							if(resto[m+5]==resto[m+15]) {
	            								if(resto[m+6]==resto[m+14]) {
	            									if(resto[m+7]==resto[m+13]) {
	            										if(resto[m+8]==resto[m+12]) {
	            											if(resto[m+9]==resto[m+11]) {
	            												System.out.println("\n-------------Palindromo encontrado-------------");
		            											contador++;
		            											int[] palindromo = new int[21];
		            											int k=m;
		            											for(int j=0;j<21;j++) {
		            												palindromo[j]=resto[k];
		            												System.out.printf("%d",palindromo[j]);
		            												k++;
		            											}
		            											leitura++;
		            											System.out.println("\nEstá na leitura: "+leitura);
	            						            		}else {
	            						            			continue;
	            						            		}
	            					            		}else {
	            					            			continue;
	            					            		}
	            				            		}else {
	            				            			continue;
	            				            		}
	            			            		}else {
	            			            			continue;
	            			            		}
	            		            		}else {
	            		            			continue;
	            		            		}
	            	            		}else {
	            	            			continue;
	            	            		}
	        	            		}else {
	        	            			continue;
	        	            		}
	    	            		}else {
	    	            			continue;
	    	            		}
		            		}else {
		            			continue;
		            		}
	            		}else {
	            			continue;
	            		}
	            	}
				}
				//conferir palindromo vetorLinhaNova
				for(int i=0;i<vetorLinhaNova.length-20;i++) {
	            	if(vetorLinhaNova[i]==vetorLinhaNova[i+20]) {
	            		if(vetorLinhaNova[i+1]==vetorLinhaNova[i+19]) {
	            			if(vetorLinhaNova[i+2]==vetorLinhaNova[i+18]) {
	            				if(vetorLinhaNova[i+3]==vetorLinhaNova[i+17]) {
	            					if(vetorLinhaNova[i+4]==vetorLinhaNova[i+16]) {
	            						if(vetorLinhaNova[i+5]==vetorLinhaNova[i+15]) {
	            							if(vetorLinhaNova[i+6]==vetorLinhaNova[i+14]) {
	            								if(vetorLinhaNova[i+7]==vetorLinhaNova[i+13]) {
	            									if(vetorLinhaNova[i+8]==vetorLinhaNova[i+12]) {
	            										if(vetorLinhaNova[i+9]==vetorLinhaNova[i+11]) {
	            											System.out.println("\n-------------Palindromo encontrado-------------");
	            											contador++;
	            											int[] palindromo = new int[21];
	            											int k=i;
	            											for(int j=0;j<21;j++) {
	            												palindromo[j]=vetorLinhaNova[k];
	            												System.out.printf("%d",palindromo[j]);
	            												k++;
	            											}
	            											leitura++;
	            											System.out.println("\nEstá na leitura: "+leitura);
	            						            	}else {
	            						            		continue;
	            						            	}
	            					            	}else {
	            					            		continue;
	            					            	}
	            				            	}else {
	            				            		continue;
	            				            	}
	            			            	}else {
	            			            		continue;
	            			            	}
	            		            	}else {
	            		            		continue;
	            		            	}
	            	            	}else {
	            	            		continue;
	            	            	}
	                        	}else {
	                        		continue;
	                        	}
	                    	}else {
	                    		continue;
	                    	}
	                	}else {
	                		continue;
	                	}
	            	}else {
	            		continue;
	            	}
	            }
	            //obtendo vetor anterior
	            for(int l=0;l<20;l++) {
	            	ultimosAnterior[l]=vetorLinhaNova[(vetorLinhaNova.length-20)+l];
	            }
				//conferir vetor anterior
	            /*
	            System.out.println("\n20 Anteriores");
				for(int l=0;l<20;l++) {
					System.out.printf("%d",ultimosAnterior[l]);
				}
				*/
				if(iteracao%5000==0) {
					leitura++;
					System.out.println("Leitura: "+leitura);
			        if(contador==0) {
			        	System.out.println("Nenhum palindromo de 21 numeros encontrado.");
			        }
				}
		}
		
		
		
	}
	private static boolean ehPrimo(int numero) {
		if(numero==0||numero==1) {
			return false;
		}
	    for (int j = 2; j < numero; j++) {
	        if (numero % j == 0)
	            return false;   
	    }
	    return true;
	}
}
