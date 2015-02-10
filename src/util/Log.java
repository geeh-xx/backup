package util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Log extends PrintWriter {

	public Log() throws Throwable {
		super(new FileWriter(
				new File(
						System.getProperty("user.dir")+"/log/log.txt"
					)
				), 
			true
			);
	}
	
}
