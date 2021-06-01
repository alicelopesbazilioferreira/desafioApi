package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Alunos;
import com.residencia.biblioteca.repositories.AlunosRepository;

@Service
public class AlunosService {
	
	@Autowired
	public AlunosRepository alunosRepository;
	
	public Alunos procurePorUmAluno(Integer id){
		return alunosRepository.findById(id).get() ;
	}
	
	public List<Alunos> listeTodosOsAlunos(){
		return alunosRepository.findAll();
	}
	
	public Long Count() {
		return alunosRepository.count();
	}
	
	public Alunos save(Alunos aluno){
		Alunos novoAluno = alunosRepository.save(aluno);
		return  novoAluno;
	}
	
	public boolean delete(Integer id){
		  if(id != null) {
			  alunosRepository.deleteById(id);
			  return true;
		  }
		  else {
			  return false;
		  }
	    }
	
//	public Alunos update (Integer id, Alunos aluno) {
//        Alunos novoAluno = alunosRepository.findById (id).get();
//        //Alunos novoAluno = alunosRepository.getOne(); função depreciada, poxa queria usar ela
//        updateDados (novoAluno, aluno);
//        return alunosRepository.save(novoAluno);
//    }
//
//	private void updateDados(Alunos novoAluno, Alunos aluno) {
//        novoAluno.setNome(aluno.getNome());
//        novoAluno.setDataNascimento(aluno.getDataNascimento());
//        novoAluno.setCpf(aluno.getCpf());
//        novoAluno.setLogradouro(aluno.getLogradouro());
//        novoAluno.setBairro(aluno.getBairro());
//        novoAluno.setCidade(aluno.getCidade());
//        novoAluno.setComplemento(aluno.getComplemento());
//        novoAluno.setEmprestimo(aluno.getEmprestimo());
//    }
	
	public Alunos update ( Alunos alunos) {
		return alunosRepository.save(alunos);
	}

}
