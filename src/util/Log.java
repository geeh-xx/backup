package util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Log extends PrintWriter {

	public Log() throws Exception {
		super(new FileWriter(
				new File(
						System.getProperty("user.dir")+"//log.txt"
					)
				), 
			true
			);
	}
	
}
