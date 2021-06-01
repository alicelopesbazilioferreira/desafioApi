package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.repositories.EditoraRepository;


@Service
public class EditoraService {
	
	@Autowired
	public EditoraRepository editoraRepository;
	
	public Editora procurePorUmaEditora(Integer id){
		return editoraRepository.findById(id).get() ;
	}
	
	public List<Editora> listeTodosAsEditoras(){
		return editoraRepository.findAll();
	}
	
	public Long Count() {
		return editoraRepository.count();
	}
	
	public Editora save(Editora editora){
		Editora novaEditora= editoraRepository.save(editora);
		return  novaEditora;
	}
	
	public Editora update ( Editora editora) {
		return editoraRepository.save(editora);
	}

	
//	public Alunos update (Integer id, Alunos aluno) {
//      Alunos novoAluno = alunosRepository.findById (id).get();
//      //Alunos novoAluno = alunosRepository.getOne(); função depreciada, poxa queria usar ela
//      updateDados (novoAluno, aluno);
//      return alunosRepository.save(novoAluno);
//  }
//
//	private void updateDados(Alunos novoAluno, Alunos aluno) {
//      novoAluno.setNome(aluno.getNome());
//      novoAluno.setDataNascimento(aluno.getDataNascimento());
//      novoAluno.setCpf(aluno.getCpf());
//      novoAluno.setLogradouro(aluno.getLogradouro());
//      novoAluno.setBairro(aluno.getBairro());
//      novoAluno.setCidade(aluno.getCidade());
//      novoAluno.setComplemento(aluno.getComplemento());
//      novoAluno.setEmprestimo(aluno.getEmprestimo());
//  }

}
