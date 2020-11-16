package studybuddy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class FileReader {
	
	private Scanner fileScanner;
	
	public int lines = 0;
	
	public FileReader(){
		JFileChooser chooser = new JFileChooser();
        
        try {   
            if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION){
                throw new Error("Input file not selected");
            }
            File questionFile = chooser.getSelectedFile();
            fileScanner = new Scanner(questionFile);
            
            FileInputStream fis = new FileInputStream(questionFile);
            Scanner scanner = new Scanner(fis);
            while(scanner.hasNextLine()){
            scanner.nextLine();
            lines++;
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Data file not found.");
        } catch (Exception e) {
            System.err.println("A mysterious error occurred.");
            e.printStackTrace(System.err);
        }
	}
	
	
	public boolean fileHasNextLine(){
		return this.fileScanner.hasNextLine();
	}
	
	public String getNextLineOfFile(){
		return this.fileScanner.nextLine();
	}
	
	public void finalize(){
		try{
			this.fileScanner.close();
		}catch(Exception ex){
			 System.err.println("A mysterious error occurred on closing Scanner.");
	         ex.printStackTrace(System.err);
		}
	}
}
