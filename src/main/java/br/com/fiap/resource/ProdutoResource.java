package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.to.ProdutoTO;

@Path("/produto") // Parte do endereço da URL para acessar o serviço
public class ProdutoResource {
	
	private ProdutoBO pbo = new ProdutoBO();
	

	@GET
	@Produces(MediaType.APPLICATION_JSON) // Tipo de retorno JSON
	public List<ProdutoTO> buscar(){
		return pbo.listar();
	}
	
	@GET
	@Path("/{id}") // Parte da URL para acessar a busca com um parâmetro (id)
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoTO buscar (@PathParam("id") int id) { // Annotacion que pega o id do path e passa como parâmetro
		return pbo.listar(id);
	}
	
	@POST // Método POST
	@Consumes(MediaType.APPLICATION_JSON) // Recebe JSON
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uriInfo) { // Recebe o produto e as informações da URI
		pbo.cadastrar(produto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(produto.getCodigo()));
		return Response.created(builder.build()).build(); // Retorna um response com status 201 e URL para acessar o recurso cadastrado
	}
	
	@PUT // Método PUT
	@Path("/{id}") // Recebe o id no path (URL)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(ProdutoTO produto, @PathParam("id") int id) { // Recebe o produto e o id
		produto.setCodigo(id);
		pbo.atualizar(produto);
		
		return Response.ok().build(); // Retorna um response com HTTP status 200
	}
	
	@DELETE // Método DELETE
	@Path("/{id}") // Recebe o id no path (URL)
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@PathParam("id") int id) { // Recebe o ID
		pbo.remover(id);
	}

}

/*
	@GET //Requisição GET
	@Produces(MediaType.TEXT_PLAIN) //Retorna um texto puro com resposta
	public String buscar() {
		return "Hello World";
	}
*/