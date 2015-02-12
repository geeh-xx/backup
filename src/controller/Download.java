package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import javax.swing.JProgressBar;
import javax.swing.JTextPane;

import util.Log;
import util.Util;

import com.jcraft.jsch.ChannelSftp;
import componente.Mensagem;
import componente.ProgressMonitor;

public class Download {

	private JProgressBar progressBar;
	private JTextPane textPane;
	public Download() {

	}

	public Download(JProgressBar progressBar,JTextPane textPane) {
		this.progressBar = progressBar;
		this.textPane =  textPane;

	}

	/**
	 * Classe responsavel pelo download do arquivo
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public void dowloadBackup(ChannelSftp channelSftp, String localDownload) {

		try {
			// channelSftp.cd(SFTPWORKINGDIR);
			byte[] buffer = new byte[1024];
			BufferedInputStream bis = new BufferedInputStream(channelSftp.get(
					Util.DataDeHoje() + ".sql", new ProgressMonitor(progressBar,textPane)));
			channelSftp.rm(Util.DataDeHoje() + ".sql");
			File newFile = new File(localDownload + "/" + Util.DataDeHoje()
					+ ".sql");
			OutputStream os = new FileOutputStream(newFile);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			int readCount;
			long to;
			String minutos;
			int total = 0;
			long inicial = new Date().getTime();
			Mensagem mensagem = new Mensagem(textPane);
			mensagem.exibeMensagem("Iniciando download do backup...");
			while ((readCount = bis.read(buffer)) > 0) {
				to = new Date().getTime() - inicial;
				to = (to / 60000) % 60;
				minutos = String.format("%02d", to);
				total = Integer.parseInt(minutos);
				bos.write(buffer, 0, readCount);
//				int contador = 0;
//				 if (total == 0) {
//				 System.out.println("Download em andamento...");
//				 }
//				
//				 if (total == 5) {
//				 System.out.println("Download ainda em andamento...");
//				 }
//				 if (total == 15) {
//				 System.out.println("Demorando ne?");
//				 }
//				 if (total == 20) {
//				 System.out.println("Meio grande esse backup...");
//				 }
//				 if (total > 20) {
//				 System.out.println("Vai tomar um café,pq pelo visto,vai demorar e muito");
//				 }
			}
			
			if (Util.verifica) {
				mensagem.exibeMensagem("Download do Backup Realizado com Sucesso \n"
						+" Tempo gasto foi de : " + total + " min");
			}else{
				mensagem.exibeMensagem("Erro ao fazer download do Backup");
			}
			
			bis.close();
			bos.close();
		} catch (Exception ex) {
			
				try {
					StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw);
					ex.printStackTrace(pw);
					pw.close();
					sw.close();
					Mensagem mensagem = new Mensagem(textPane);
					mensagem.exibeMensagem(sw.getBuffer().toString());
					ex.printStackTrace(new Log());
				} catch (Throwable e) {
					Util.alerta("Erro ao gerar arquivo de log", Util.ERRO);
					e.printStackTrace();
				}
				
				
			Util.alerta("Erro ao Realizar Download do Backup\n"
					+"Local de Download invalido", Util.ERRO);
			ex.printStackTrace();
		}

	}

}
