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

import com.residencia.biblioteca.entities.Livros;
import com.residencia.biblioteca.services.LivrosService;


@RestController
@RequestMapping("/livros")
public class LivrosController {
	
	@Autowired
    private LivrosService livrosService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Livros> procurePorUmLivro(@PathVariable Integer id){
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Livros>(livrosService.procurePorUmLivro(id), headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Livros>> findAll() throws Exception{
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Livros>>(livrosService.listeTodosOsLivros(), headers, HttpStatus.OK);
	}
	
//	@GetMapping("/matricula")
//	public ResponseEntity<List<Alunos>> listByMatricula(@RequestParam(required = true) Integer matricula) {
//		HttpHeaders headers = new HttpHeaders();
//		return new ResponseEntity<>(alunosService.listByMatricula(matricula), headers, HttpStatus.OK);
//	}
	
	@GetMapping("/count")
	public Long count() {
		return livrosService.Count();
	}
	
	@PostMapping("/")
	public ResponseEntity<Livros> save(@RequestBody Livros livros){
		//return alunoService.save(aluno);
		HttpHeaders headers = new HttpHeaders();
		
		if(null != livrosService.save(livros))
			return new ResponseEntity<Livros>(livrosService.save(livros), headers, HttpStatus.OK);
		else
			return new ResponseEntity<Livros>(livrosService.save(livros), headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/")
    public Livros update(@RequestBody Livros livros){
       return livrosService.update(livros);
	}

}
