package controller;

import java.util.concurrent.Semaphore;

import model.Tempos;
import view.Main;

import java.io.*;

public class ThreadF1 extends Thread {

	private int id;
	private int equipe;
	private Semaphore semaforoPista;
	private int tempoTotal;
	private Tempos tempo = new Tempos();

	public ThreadF1(int id, int equipe, Semaphore semaforoPista) {
		this.id = id;
		this.equipe = equipe;
		this.semaforoPista = semaforoPista;
	}

	public void run() {
		try {
			semaforoPista.acquire();
			voltas();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		} finally {
			semaforoPista.release();
		}
	}

	public void voltas() throws IOException {
		int tempo;
		for (int i = 0; i < 3; i++) {
			tempo = (int) ((Math.random() * 101) + 60);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// System.out.println("Corredor " + (id + 1) + " terminou a volta " + volta + "
			// em " + tempo + " segundos");
			tempoTotal += tempo;
		}
		//System.out.println(
				//"Tempo total do corredor " + (id + 1) + " da equipe " + equipe + " = " + tempoTotal[id] + " segundos");
		enviarTempos(tempoTotal);
	}

	public void enviarTempos(int tempoTotal) {
		tempo.setId(id);
		tempo.setTempoTotal(tempoTotal);
		tempo.setEquipe(equipe);
		Main.controller.setTempo(tempo);
	}
}
