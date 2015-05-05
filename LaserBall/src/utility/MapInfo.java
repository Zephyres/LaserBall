package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapInfo {
	private ArrayList<String> details;
	
	public MapInfo(String map) {
		details = new ArrayList<String>();
		
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(new File("src/text/" + map + "/info.txt"));
			
			while(s.hasNext())
				details.add(s.nextLine());
		} catch(FileNotFoundException e) {}
	}
	
	public String getMapName() {
		return details.get(0);
	}
	
	public float getSpawnX() {
		return Float.parseFloat(details.get(1).split(" ")[0]);
	}
	
	public float getSpawnY() {
		return Float.parseFloat(details.get(1).split(" ")[1]);
	}
	
	public ArrayList<float[]> getSpawnerDetails() {
		ArrayList<float[]> det = new ArrayList<float[]>();
		float[] a = new float[3];
		
		if(details.size() < 3)
			return det;
		
		int i = 0;
		for(String s : this.details.get(2).split(" ")) {
			a[i] = Float.parseFloat(s);
			i++;
			
			if(i % 3 == 0) {
				det.add(a);
				a = new float[3];
				i = 0;
			}
		}
		
		return det;
	}
}
