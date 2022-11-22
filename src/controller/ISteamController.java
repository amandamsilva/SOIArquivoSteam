package controller;

import java.io.IOException;

public interface ISteamController {
	public void readFile(String name, String path, String year, 
			String month, String avg) throws IOException;
	public void writeFile(String nameArq, String dir, String year, 
			String month) throws IOException;
}
