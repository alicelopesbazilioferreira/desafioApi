package com.residencia.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.residencia.biblioteca.entities.Alunos;
import com.residencia.biblioteca.services.AlunosService;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
	@Autowired
    private AlunosService alunosService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Alunos> findById(@PathVariable Integer id){
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Alunos>(alunosService.procurePorUmAluno(id), headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Alunos>> findAll() throws Exception{
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Alunos>>(alunosService.listeTodosOsAlunos(), headers, HttpStatus.OK);
	}
	
	
//	public void excluir(){
//	      List<Usuario> usuarios = repository.findAll();
//	      Usuario usuario = usuarios.get(0);
//	      repository.delete(usuario);
//	    }
	
//	@DeleteMapping(path ={"/{id}"})
//	public ResponseEntity <?> delete(@PathVariable long id) {
//	   return repository.findById(id)
//	           .map(record -> {
//	               repository.deleteById(id);
//	               return ResponseEntity.ok().build();
//	           }).orElse(ResponseEntity.notFound().build());
//	}
	
//	@GetMapping("/matricula")
//	public ResponseEntity<List<Alunos>> listByMatricula(@RequestParam(required = true) Integer matricula) {
//		HttpHeaders headers = new HttpHeaders();
//		return new ResponseEntity<>(alunosService.listByMatricula(matricula), headers, HttpStatus.OK);
//	}
	
	@GetMapping("/count")
	public Long count() {
		return alunosService.Count();
	}
	
	@PostMapping("/")
	public ResponseEntity<Alunos> save(@RequestBody Alunos alunos){
		//return alunoService.save(aluno);
		HttpHeaders headers = new HttpHeaders();
		
		if(null != alunosService.save(alunos))
			return new ResponseEntity<Alunos>(alunosService.save(alunos), headers, HttpStatus.OK);
		else
			return new ResponseEntity<Alunos>(alunosService.save(alunos), headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/") // pode ou não colocar o path na frente do "/"
    public Alunos update(@RequestBody Alunos alunos){
       return alunosService.update(alunos);
    }
	

}
