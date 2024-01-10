package lesson15;

import java.io.File;
import java.util.Arrays;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File	f = new File("c:/");
		
	
		
		System.err.println("Exists: "+f.exists());
		System.err.println("Is directory? "+f.isDirectory());
		System.err.println("Content "+Arrays.toString(f.list()));
		
		File	folder = new File(f, "testfolder/innerfolder");
		System.err.println("Exists: "+folder.exists());
		System.err.println("Is directory? "+folder.isDirectory());
		System.err.println("Is file? "+folder.isFile());
		
		System.err.println("Creates: "+folder.mkdirs());
		System.err.println("Delete: "+folder.getParentFile().delete());
	}

}
