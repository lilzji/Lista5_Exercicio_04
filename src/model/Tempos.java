package model;

public class Tempos {
	private int id;
	private int tempoTotal;
	private int equipe;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setTempoTotal(int tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	public int getTempoTotal() {
		return this.tempoTotal;
	}

	public String toString() {
		return tempoTotal + " " + id;
	}

	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}
	
	public int getEquipe() {
		return this.equipe;
	}
}
