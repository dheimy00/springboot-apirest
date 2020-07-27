package br.com.builders.services;

import java.util.List;

import br.com.builders.modelo.Cliente;

public interface ClienteService {
	
	Cliente salvar(Cliente cliente);
	
	List<Cliente> lista();
	
	Cliente atualiza(Long id,Cliente cliente);
	
	void excluir(Long id);
	
	Cliente getCliente(Long id);
	
	boolean existeByCpf(Cliente cliente);
		
	List<Cliente> getClienteByCpfOrNomeContaining(String cpf,String nome);

}
