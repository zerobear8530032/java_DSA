package Patterns;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Copypatterns {
	public static void main(String args[]) throws IOException {
		String path ="file.txt";
		File f = new File(path);
		if(!f.exists()) {
			try {
				f.createNewFile();				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		String readpath ="src/Patterns/Pattern";
		FileWriter writer = new FileWriter(f,true);
		int counter=0;
		for(int i =1;i<=35;i++) {
			File file = new File(readpath+i+".java");
			if(file.exists()) {
				counter++;
			}
		
			try {				
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				if(line.contains("//")) {
					writer.append(line+"\n");
				}
			}
			}catch(Exception e  ) {
				System.out.println(e);
			}
		}
		writer.close();
		System.out.println(counter);
	}	
}

