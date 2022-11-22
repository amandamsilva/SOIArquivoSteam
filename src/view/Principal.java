package view;

import javax.swing.JOptionPane;

import controller.ISteamController;
import controller.SteamController;

public class Principal {

	public static void main(String[] args) {
		
		String year = JOptionPane.showInputDialog("Digite o ano do jogo: ");
		String month = JOptionPane.showInputDialog("Digite o m�s: ");
		String avg = JOptionPane.showInputDialog("Digite a m�dia de jogadores: ");
		String dir = JOptionPane.showInputDialog("Digite um diret�rio: ");
		String nameArq = JOptionPane.showInputDialog("Digite um nome para o arquivo: ");
			
		ISteamController arqCont = new SteamController();
		String path = "C:\\TEMP";
		String name = "SteamCharts.csv";
		
		try {
			arqCont.readFile(name, path, year, month, avg);
			arqCont.writeFile(nameArq, dir, year, month);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
