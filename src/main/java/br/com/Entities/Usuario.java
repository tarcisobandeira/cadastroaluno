package br.com.Entities;

public class Usuario {

	private String processar = "sim";
	private String nome;
	private String sobrenome;
	private String ra;
	private String cpf;
	private String iniciais;

	public String getProcessar() {
		return processar;
	}

	public void setProcessar(String processar) {
		this.processar = processar;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIniciais() {
		return iniciais;
	}

	public void setIniciais(String iniciais) {
		this.iniciais = iniciais;
	}

}
