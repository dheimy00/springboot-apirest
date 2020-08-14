package br.com.builders.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.builders.modelo.Cliente;
import br.com.builders.repositories.ClienteRepositories;
import br.com.builders.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	
	@Autowired
	private ClienteRepositories clienteRepositories;
	

	@Override
	public Cliente salvar(Cliente cliente) {
		
		return clienteRepositories.save(cliente);
		
	}

	@Override
	public List<Cliente> lista() {

		return clienteRepositories.findAll();
	}

	@Override
	public Cliente atualiza(final Long id,final Cliente cliente) {
		
		Cliente cl = clienteRepositories.findById(id).get();
		cl.setCpf(cliente.getCpf());
		cl.setNome(cl.getNome());
		cl.setDataNascimento(cliente.getDataNascimento());
		
		return clienteRepositories.save(cl);
	}

	@Override
	public void excluir(final Long id) {
		
		 clienteRepositories.deleteById(id);
		
	}

	@Override
	public Cliente getCliente(Long id) {
		
		return clienteRepositories.findById(id).get();
		
	}
	
	@Override
	public boolean existeByCpf(Cliente cliente) {
		
		return clienteRepositories.existsByCpf(cliente.getCpf());
	}
	
	@Override
	public List<Cliente> getClienteByCpfOrNomeContaining(String cpf, String nome) {
		
		return clienteRepositories.findByCpfOrNomeContaining(cpf, nome);
	}




}
