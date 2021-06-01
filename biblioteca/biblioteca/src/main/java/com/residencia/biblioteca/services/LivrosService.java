package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Livros;
import com.residencia.biblioteca.repositories.LivrosRepository;

@Service
public class LivrosService {
	
	@Autowired
	public LivrosRepository livrosRepository;
	
	public Livros procurePorUmLivro(Integer id){
		return livrosRepository.findById(id).get() ;
	}
	
	public List<Livros> listeTodosOsLivros(){
		return livrosRepository.findAll();
	}
	
	public Long Count() {
		return livrosRepository.count();
	}
	
	public Livros save(Livros livros){
		Livros novosLivros= livrosRepository.save(livros);
		return  novosLivros;
	}
	
	public Livros update ( Livros livros) {
		return livrosRepository.save(livros);
	}


}
