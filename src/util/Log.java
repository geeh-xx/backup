package util;

import java.io.*;

public class Log extends PrintWriter {

	public Log() throws Exception {
		super(new FileWriter(
				new File(
						System.getProperty("user.dir")+"//log_"+Util.DataDeHoje()+".txt"
					)
				), 
			true
			);
	}
}
