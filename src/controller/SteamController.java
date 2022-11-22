package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class SteamController implements ISteamController{

	@Override
	public void readFile(String name, String path, String year, String month, String avg) throws IOException {
		
		File arq = new File (path, name);
		if (arq.exists() && arq.isFile()) {
			
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String line = buffer.readLine();
			
			while (line != null) {
				if (line.contains(year)) {
					if (line.contains(month)) {
						String [] vetGame = line.split(",");
						double rAvg = Double.parseDouble(vetGame[3]);
						double wAvg = Double.parseDouble(avg);
						
						if (rAvg >= wAvg) {
							System.out.println(vetGame[0] + "\t |" + "\t" + vetGame[3]);
						}
					}
				}
				line = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}else {
			throw new IOException("Arquivo Inválido");
		}
		
	}



	@Override
	public void writeFile(String nameArq, String dir, String year, String month) throws IOException {
		File file = new File ("C:\\TEMP\\SteamCharts.csv");
		Scanner sc = null;
		
		File arq = new File(dir, nameArq);
		File path = new File(dir);
		
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.contains(year)) {
					if(line.contains(month)) {
						String [] vetGame = line.split(",");
						
						if (path.exists() && path.isDirectory()) {
							boolean existe = false;
							if (arq.exists() && arq.isFile()) {
								existe = true;
							}
							
							String conteudo = vetGame[0]+ ";" + vetGame[3] +";\n";
							FileWriter openArq = new FileWriter(arq, existe);
							PrintWriter writeArq = new PrintWriter(openArq);
							writeArq.write(conteudo);
							writeArq.flush();
							writeArq.close();
							openArq.close();
							
						}else {
							throw new IOException("Diretório Inválido");
						}
					}
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}	
	}

}