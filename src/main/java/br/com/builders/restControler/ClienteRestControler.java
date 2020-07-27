package br.com.builders.restControler;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.builders.modelo.Cliente;
import br.com.builders.services.ClienteService;
import br.com.builders.util.ClienteNotFoundException;

@RestController
@RequestMapping(path = "/api")
public class ClienteRestControler {

	@Autowired
	private ClienteService clienteService;
	
	
	public static final Logger logger = LoggerFactory.getLogger(ClienteRestControler.class);

	/*----------------Salvar cliente---------------*/
	@PostMapping(path = "/clientes")
	public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente cliente) {

		logger.info("Salvar cliente : {} ", cliente);
		if (clienteService.existeByCpf(cliente)) {
			logger.info("Não foi possível salvar. Cliente com  nome {} já existe ", cliente.getCpf());
					throw new  ClienteNotFoundException("Não foi possível salvar. Cliente com  nome " + cliente.getNome() + " já existe ");
		}
		Cliente salvar = clienteService.salvar(cliente);
		return new ResponseEntity<>(salvar, HttpStatus.CREATED);
	}

	/*----------------Lista de clientes---------------*/
	@GetMapping(path = "/clientes")
	public ResponseEntity<List<Cliente>> lista() {
		List<Cliente> lista = clienteService.lista();
		if (lista.isEmpty()) {
			return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	/*----------------Atualizar um cliente---------------*/
	@PutMapping(path = "/clientes/{id}")
	public ResponseEntity<Cliente> atualiza(@PathVariable("id") final Long id, final Cliente cliente) {

		logger.info("Buscando cliente com id {}", id);
		List<Cliente> lista = clienteService.lista();
		if ( (id >= lista.size()) ||(id < 0 )) {
			logger.error("Não foi possível atualizar. Cliente com o ID {} ​​não encontrado.", id);
			throw new  ClienteNotFoundException("Não foi possível atualizar. Cliente com id " + id + " não encontrado");
		}
		Cliente atualiza = clienteService.atualiza(id, cliente);
		return new ResponseEntity<>(atualiza, HttpStatus.OK);
	}

	/*----------------Get um cliente---------------*/
	@GetMapping(path = "/clientes/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable("id") final Long id) {

		logger.info("Buscando cliente com id {}", id);
		List<Cliente> lista = clienteService.lista();
		if ( (id >= lista.size()) ||(id < 0 )) {
			logger.error("Cliente com o ID {} ​​não encontrado.", id);
			throw new  ClienteNotFoundException("Cliente com id " + id + " não encontrado");
		}
		Cliente get = clienteService.getCliente(id);
		return new ResponseEntity<>(get, HttpStatus.OK);
	}

	/*----------------Excluir um cliente---------------*/
	@DeleteMapping(path = "/clientes/{id}")
	public ResponseEntity<String> excluir(@PathVariable("id") final Long id) {

		logger.info("Buscando cliente com id {}", id);
		List<Cliente> lista = clienteService.lista();
		if ( (id >= lista.size()) ||(id < 0 )) {
			logger.error("Não foi possível excluir. Cliente com o ID {} ​​não encontrado.", id);
			throw new  ClienteNotFoundException("Não foi possível excluir. Cliente com id " + id + " não encontrado");
		}
		clienteService.excluir(id);
		return new ResponseEntity<>("Sucesso", HttpStatus.NO_CONTENT);
	}

	/*----------------Buscar cliente cpf e nome ---------------*/
	@GetMapping(path = "/clientes/buscar/{buscar}")
	public ResponseEntity<List<Cliente>> getClienteByNome(@PathVariable("buscar") final String cpf,
			@PathVariable("buscar") final String nome) {
		
		List<Cliente> lista = clienteService.getClienteByCpfOrNomeContaining(cpf, nome);
		
		if(lista == null) {
			throw new  ClienteNotFoundException("teste");
		}
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

}
