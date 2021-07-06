package hello;

public class Cumprimento {

	private String dia;
	private String tarde;
	private String noite;

	private int horario;

	private String cumprimento;

	public Cumprimento() {
	}

	public Cumprimento(int horario) {
		this.horario = horario;
	}

	public Cumprimento(String dia, String tarde, String noite) {
		this.dia = dia;
		this.tarde = tarde;
		this.noite = noite;
		this.cumprimento = this.cumprimentar(dia, tarde, noite, horario);
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getTarde() {
		return tarde;
	}

	public void setTarde(String tarde) {
		this.tarde = tarde;
	}

	public String getNoite() {
		return noite;
	}

	public void setNoite(String noite) {
		this.noite = noite;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public String getCumprimento() {
		return cumprimento;
	}

	public void setCumprimento(String cumprimento) {
		this.cumprimento = cumprimento;
	}

	/**
	 * Retorna um cumprimento de acordo com horário o correspodente
	 * 
	 * @return cumprimento
	 */
	private String cumprimentar(String dia, String tarde, String noite, int hourOfDay) {
		String cumprimento;
		if (hourOfDay >= 12 && hourOfDay < 18) {
			cumprimento = tarde;
		} else if (hourOfDay >= 18 && hourOfDay < 24) {
			cumprimento = noite;
		} else {
			cumprimento = dia;
		}
		return cumprimento;
	}

}
