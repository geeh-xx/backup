package controller;

import javax.swing.JProgressBar;

import com.jcraft.jsch.SftpProgressMonitor;

public class ProgressMonitor implements SftpProgressMonitor {

	private double count;
	private double max;
	private String src;
	private int percent;
	private int lastDisplayedPercent;

	private Monitor monitor;
	private final JProgressBar progressBar;

	ProgressMonitor(JProgressBar progressBar) {
		this.progressBar = progressBar;
		count = 0;
		max = 0;
		percent = 0;
		lastDisplayedPercent = 0;
	}

	public void init(int op, String src, String dest, long max) {
		this.max = max;
		this.src = src;
		count = 0;
		percent = 0;
		lastDisplayedPercent = 0;
		status();
	}

	public boolean count(long count) {
		this.count += count;
		percent = (int) ((this.count / max) * 100.0);
		status();
		return true;
	}

	public void end() {
		percent = (int) ((count / max) * 100.0);
		status();
	}

	private void status() {
		if (lastDisplayedPercent <= percent - 10) {
			System.out.println(src + ": " + percent + "% " + ((long) count)
					+ "/" + ((long) max));
			if (monitor == null)
				monitor = new Monitor();
			else {
				monitor.atualiza();
			}
			lastDisplayedPercent = percent;
		}
	}

	class Monitor {
		public void atualiza() {
			if (percent < 100) {
				if (progressBar != null) {
					progressBar.setVisible(true);
					progressBar.setBounds(22, 456, 153, 23);
					progressBar.setValue(percent);
					progressBar.setStringPainted(true);
				}
			}
		}
	}

}
