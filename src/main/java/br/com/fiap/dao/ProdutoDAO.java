package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.ProdutoTO;

public class ProdutoDAO {
	
	public static List<ProdutoTO> listaProdutos;
	
	public ProdutoDAO() {
		
		if (listaProdutos == null) {
			
			listaProdutos = new ArrayList<ProdutoTO>();
	
			ProdutoTO pto = new ProdutoTO();
			pto.setCodigo(1);
			pto.setTitulo("Chinelo");
			pto.setPreco(32.90);
			pto.setQuantidade(120);
			listaProdutos.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(2);
			pto.setTitulo("Mouse");
			pto.setQuantidade(100);
			pto.setPreco(99.98);
			listaProdutos.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(3);
			pto.setTitulo("Teclado");
			pto.setQuantidade(67);
			pto.setPreco(110.45);
			listaProdutos.add(pto);

			pto = new ProdutoTO();
			pto.setCodigo(4);
			pto.setTitulo("Alcool Gel");
			pto.setQuantidade(1000);
			pto.setPreco(23.77);
			listaProdutos.add(pto);

			pto = new ProdutoTO();
			pto.setCodigo(5);
			pto.setTitulo("Pilhas AA");
			pto.setQuantidade(2000);
			pto.setPreco(2.98);
			listaProdutos.add(pto);
			
		}
	}
	
	public List<ProdutoTO> select(){
		return listaProdutos;
	}
	
	public ProdutoTO select(int id){
		for (int i = 0; i < listaProdutos.size(); i++) {
			if (listaProdutos.get(i).getCodigo() == id) {
				return listaProdutos.get(i);
			}
		}
		return null;
	}
	
	public boolean insert(ProdutoTO pto) {
		pto.setCodigo(listaProdutos.size() + 1);
		return listaProdutos.add(pto);
	}
	
	public void update (ProdutoTO pto) {
		ProdutoTO p = select(pto.getCodigo());
		p.setPreco(pto.getPreco());
		p.setQuantidade(pto.getQuantidade());
		p.setTitulo(pto.getTitulo());
	}
	
	public void delete (int id) {
		listaProdutos.remove(select(id));
	}
	
}








