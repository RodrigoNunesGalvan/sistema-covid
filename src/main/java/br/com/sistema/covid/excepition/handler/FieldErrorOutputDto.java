package br.com.sistema.covid.excepition.handler;

public class FieldErrorOutputDto {
	
	private String field;
	private String menssage;
	
	
	public FieldErrorOutputDto() {
	}

	public FieldErrorOutputDto(String field, String menssage) {
		this.field = field;
		this.menssage = menssage;
	}

	public String getField() {
		return field;
	}

	public String getMenssage() {
		return menssage;
	}
	
}
