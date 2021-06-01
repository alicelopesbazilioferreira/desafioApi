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

import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.services.EditoraService;

@RestController
@RequestMapping("/editora")
public class EditoraController {
	
	@Autowired
    private EditoraService editoraService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Editora> findById(@PathVariable Integer id){
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Editora>(editoraService.procurePorUmaEditora(id), headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Editora>> findAll() throws Exception{
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Editora>>(editoraService.listeTodosAsEditoras(), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return editoraService.Count();
	}
	
	@PostMapping("/")
	public ResponseEntity<Editora> save(@RequestBody Editora editora){
		//return alunoService.save(aluno);
		HttpHeaders headers = new HttpHeaders();
		
		if(null != editoraService.save(editora))
			return new ResponseEntity<>(editoraService.save(editora), headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(editoraService.save(editora), headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/")
    public Editora update(@RequestBody Editora editora){
       return editoraService.update(editora);
	}

}
