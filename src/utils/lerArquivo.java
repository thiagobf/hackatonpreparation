/**
 * 
 */

package utils;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
		
/**
 * @author Thiago Bueno Fernandes
 * @date: 27/02/2016
 * @version: 1.0
 * @category: Leitor de Arquivos
 *  
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class lerArquivo {

	public static void main(String[] args) {

		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("C:\\Thiago\\teste.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}