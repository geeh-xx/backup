package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.swing.JProgressBar;
import javax.swing.JTextPane;

import com.jcraft.jsch.ChannelSftp;

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
	 */
	public void dowloadBackup(ChannelSftp channelSftp, String localDownload) {

		try {
			// channelSftp.cd(SFTPWORKINGDIR);
			byte[] buffer = new byte[1024];
			BufferedInputStream bis = new BufferedInputStream(channelSftp.get(
					Bacukp.DataDeHoje() + ".sql", new ProgressMonitor(progressBar)));
			channelSftp.rm(Bacukp.DataDeHoje() + ".sql");
			File newFile = new File(localDownload + "/" + Bacukp.DataDeHoje()
					+ ".sql");
			OutputStream os = new FileOutputStream(newFile);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			int readCount;
			long to;
			String minutos;
			int total = 0;
			long inicial = new Date().getTime();
			Mensagem mensagem = new Mensagem(textPane);
			mensagem.setMensagem("Iniciando download do backup...");
			mensagem.exibeMensagem();
			//System.out.println("Iniciando download do backup...");
			while ((readCount = bis.read(buffer)) > 0) {
				to = new Date().getTime() - inicial;
				to = (to / 60000) % 60;
				minutos = String.format("%02d", to);
				total = Integer.parseInt(minutos);
				bos.write(buffer, 0, readCount);
				// if (total == 0) {
				// System.out.println("Download em andamento...");
				// }
				//
				// if (total == 5) {
				// System.out.println("Download ainda em andamento...");
				// }
				// if (total == 15) {
				// System.out.println("Demorando ne?");
				// }
				// if (total == 20) {
				// System.out.println("Meio grande esse backup...");
				// }
				// if (total > 20) {
				// System.out.println("Vai tomar um café,pq pelo visto,vai demorar e muito");
				// }
			}
			
			mensagem.setMensagem("Download do Backup Realizado com Sucesso \n"
									+" Tempo gasto foi de : " + total + " min");
			mensagem.exibeMensagem();
			//System.out.println("Download do Backup Realizado com Sucesso");
			//System.out.println("Tempo gasto foi de : " + total + " min");
			bis.close();
			bos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
