package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.jcraft.jsch.ChannelSftp;

public class Download {

	
	public Download() {
		
	}
		 
		/**
		 * Classe responsavel pelo download do arquivo 
		* @param args
		*/
		public void dowloadBackup(ChannelSftp channelSftp,String localDownload) {

			try{
				//channelSftp.cd(SFTPWORKINGDIR);
				byte[] buffer = new byte[1024];
				BufferedInputStream bis = new BufferedInputStream(channelSftp.get(Bacukp.DataDeHoje()+".sql", new ProgressMonitor()));
				channelSftp.rm(Bacukp.DataDeHoje()+".sql");
				File newFile = new File(localDownload+"/"+Bacukp.DataDeHoje()+".sql");
				OutputStream os = new FileOutputStream(newFile);
				BufferedOutputStream bos = new BufferedOutputStream(os);
				int readCount;
				long to ;
				String minutos;
				int total = 0;
				long inicial = new Date().getTime(); 
				System.out.println("Iniciando download do backup...");
				while( (readCount = bis.read(buffer)) > 0) {
					to = new Date().getTime() - inicial;
					to = ( to / 60000 ) % 60; 
					minutos = String.format("%02d",to);
					total = Integer.parseInt(minutos);
					bos.write(buffer, 0, readCount);
//					if (total == 0) {
//						System.out.println("Download em andamento...");
//					}
//					
//					if (total == 5) {
//						System.out.println("Download ainda em andamento...");
//					}
//					if (total == 15) {
//						System.out.println("Demorando ne?");
//					}
//					if (total == 20) {
//						System.out.println("Meio grande esse backup...");
//					}
//					if (total > 20) {
//						System.out.println("Vai tomar um caf�,pq pelo visto,vai demorar e muito");
//					}
				}
				System.out.println("Download do Backup Realizado com Sucesso");
				System.out.println("Tempo gasto foi de : "+total+" min");
				bis.close();
				bos.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
		 
		}
		 
		
		
		
}
