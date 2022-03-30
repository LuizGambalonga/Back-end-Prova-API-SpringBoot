package com.Projeto.Betha.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.Betha.Model.UsuarioModel;
import com.Projeto.Betha.Repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*" )
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioModel> listar() {
		return usuarioRepository.findAll();
	}
	
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioModel adicionar(@RequestBody UsuarioModel usuarioModel) {
		return usuarioRepository.save(usuarioModel);
	}
	
	@PutMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioModel AtualizaCliente(@RequestBody UsuarioModel usuarioModel) {
		return usuarioRepository.save(usuarioModel);
	}
	
	@DeleteMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public void deletaCliente(@RequestBody UsuarioModel usuarioModel) {
		usuarioRepository.delete(usuarioModel);
	}
}
