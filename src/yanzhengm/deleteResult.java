package yanzhengm;

import java.io.File;

public class deleteResult {
	
	public static void delete() {
		File dir = new File("file");
		File[] files = dir.listFiles();
		for(File file1 : files ) {
			file1.delete();
		}
	}

}
