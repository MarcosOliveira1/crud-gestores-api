package com.desafio.crud.gestores.resourse;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.crud.gestores.model.Gestor;
import com.desafio.crud.gestores.repository.GestorRepository;

@RestController
@RequestMapping("/gestor")
@CrossOrigin(origins = "*")
public class GestorResource {

	@Autowired
	private GestorRepository gestorRepository;
	
	/*
	 *Criar gestor 
	 */
	@PostMapping
	public ResponseEntity<Gestor> CriarGestor(@RequestBody Gestor gestor, HttpServletResponse response){
		Gestor g = gestorRepository.save(gestor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
		buildAndExpand(gestor.getId()).toUri();
		
		return ResponseEntity.created(uri).body(g);
	}
	
	/*
	 * listar Gestor
	 */
	@GetMapping
	public List<Gestor> ListarGestor(){
		return gestorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Gestor> buscarPessoaId(@PathVariable int id){
			return gestorRepository.findById(id);
	}
	
	/*
	 * Editar Gestor
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Gestor> EditarGestor(@PathVariable int id,@RequestBody Gestor gestor){
		Gestor gestorSalvo = gestorRepository.findById(id).orElse(null);
		BeanUtils.copyProperties(gestor, gestorSalvo,"id");
		gestorRepository.save(gestorSalvo);
		return ResponseEntity.ok(gestorSalvo);
	}
	/*
	 * Excluir gestor
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable int id) {
		gestorRepository.deleteById(id);
	}
	
}
