package br.com.abreutech.sgc.config.validacao;

public class ErroDeFormularioDto {
	
	private String campo;
	private String message;
	
	public ErroDeFormularioDto(String campo, String message) {
		this.campo = campo;
		this.message = message;
	}

	public String getCampo() {
		return campo;
	}

	public String getMessage() {
		return message;
	}
	
	

}
