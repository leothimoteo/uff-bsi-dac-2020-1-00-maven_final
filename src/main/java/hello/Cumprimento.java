package hello;

public class Cumprimento {

	private static String cumprimento;

	public Cumprimento(String dia, String tarde, String noite, int horario) {
		this.setCumprimento(this.cumprimentar(dia, tarde, noite, horario));
	}

	public static String getCumprimento() {
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
	private String cumprimentar(String dia, String tarde, String noite, int horario) {
		String cumprimento;
		if (horario >= 12 && horario < 18) {
			cumprimento = tarde;
		} else if (horario >= 18 && horario < 24) {
			cumprimento = noite;
		} else {
			cumprimento = dia;
		}
		return cumprimento;
	}

}
