package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Anotação para identificar que a clasee pode ser transformada em Json;
public class ProdutoTO {
	
	private int codigo, quantidade;
	private String titulo;
	private double preco;
	
	public ProdutoTO() {
		
	}
	
	public ProdutoTO(int codigo, int quantidade, String titilo, double preco) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.titulo = titilo;
		this.preco = preco;
	}
	
	public ProdutoTO( int quantidade, String titilo, double preco) {
		super();
		this.quantidade = quantidade;
		this.titulo = titilo;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titilo) {
		this.titulo = titilo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

}
