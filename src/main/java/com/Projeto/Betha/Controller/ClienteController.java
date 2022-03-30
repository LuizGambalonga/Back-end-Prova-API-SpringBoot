package com.Projeto.Betha.Controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.Projeto.Betha.Model.ClienteModel;
import com.Projeto.Betha.Repository.ClienteRepository;;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	@ResponseStatus(HttpStatus.OK)
	public List<ClienteModel> listar() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteModel listarClientePorID(@PathVariable Long id) {
	return	clienteRepository
			.findById(id)
			.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteModel adicionar(@RequestBody ClienteModel clienteModel) {
		return clienteRepository.save(clienteModel);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteModel AtualizaCliente(@PathVariable Long id,@RequestBody ClienteModel clienteModel) {
		ClienteModel clienteAtual = clienteRepository.findById(id).get();
		BeanUtils.copyProperties(clienteModel, clienteAtual, "id");
		return clienteRepository.save(clienteAtual);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletaCliente(@PathVariable Long id) {
		clienteRepository
		.findById(id)
		.map(cliente -> {
			clienteRepository.delete(cliente);
			return Void.TYPE;
		})
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
}
