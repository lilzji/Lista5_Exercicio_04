package view;

import java.util.concurrent.Semaphore;
import controller.TemposController;
import controller.ThreadF1;


public class Main {

	private static int corredores = 14;
	public static TemposController controller = new TemposController(corredores);

	public static void main(String[] args) {

		int permissaoEquipes = 1;
		Semaphore mutex = new Semaphore(permissaoEquipes);
		int permissaoPista = 5;
		Semaphore semaforoPista = new Semaphore(permissaoPista);
		for (int id = 0; id < 2; id++) {
			try {
				mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				mutex.release();
			}
			int equipe = 0;
			for (int i = 0; i < 7; i++) {
				if (id == 0) {
					equipe++;
					Thread threadF1 = new ThreadF1((i + 1), equipe, semaforoPista);
					threadF1.start();
				} else {
					equipe++;
					Thread threadF1 = new ThreadF1((i + 7), equipe, semaforoPista);
					threadF1.start();
				}
			}
		}
		controller.start();
	}
}
