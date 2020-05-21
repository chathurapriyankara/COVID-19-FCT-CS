package lk.ac.kln.fct.covid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataReader {
	private static final String JSON_ARRAY = "records";
	private static final String COUNTRY = "countriesAndTerritories";
	
	
	/**
	 * This method reads the contents form a JSON file and prints the required data.
	 * 
	 * @param filePath the path to JSON file.
	 */
	public void readData(String filePath) {
		try {
			String fileContent = Files.readString(Paths.get(filePath));
			JSONObject obj  = new JSONObject(fileContent);
			JSONArray arr = obj.getJSONArray(JSON_ARRAY);
			
			for(int i = 0; i < arr.length(); i ++) {
				System.out.println(arr.getJSONObject(i).getString(COUNTRY));
				//TODO Improve this to print required data.
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
