package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
		//Primeira forma de abrir arquivos em Java, verbosa e incorreta
		
		//instanciando o caminho do arquivo
		//usando FileReader e BufferedReader para as streamings de leitura
		String path = "c:\\dev\\in.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		//inicio do tratamento da abertura do arquivo
		//essa operaçao pode trazer erros de entrada/saida
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			//enquanto houver linhas para serem lidas
			while (line != null) {
				//mostra na tela a linha lida
				System.out.println(line);
				//continua a leitura do arquivo
				line = br.readLine();
			}
			
			// caso tenha dado errado a tentativa de abertura do arquivo
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {//bloco finally para garantir a execuçao desse trecho do codigo
			try {//bloco try porque pode dar errado o fechamento do arquivo
				if (br != null) {//testando se o FileReader ainda esta aberto
					br.close();//fechando
				}
				if (fr != null) {//testando se o BufferedReader ainda esta aberto
					fr.close();//fechando
				}
			} catch (IOException e) {//caso tenha encontrado erro ao fechar a streaming 
				e.printStackTrace();//de arquivo
			}
		}
		

	}

}
