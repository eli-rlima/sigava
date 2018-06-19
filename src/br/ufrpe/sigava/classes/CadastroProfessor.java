package br.ufrpe.sigava.classes;

import br.ufrpe.sigava.pessoa.Professor;
import br.ufrpe.sigava.repositorios.IRepositorioProfessor;

import java.time.LocalDate;


public class CadastroProfessor {
    private IRepositorioProfessor repositorioProfessor;

    public CadastroProfessor (IRepositorioProfessor instanciaRepositorio){
        this.repositorioProfessor = instanciaRepositorio;
    }

    public boolean cadastrar (Professor professor){
        boolean retorno = false;
        if (professor != null && !repositorioProfessor.existe(professor)){
            if (repositorioProfessor.adicionar(professor)){
                retorno = true;
            }
        }
        return retorno;
    }

    public boolean cadastrar (String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf) {
        Professor professor = null;
        boolean retorno = false;
        if (nome != null && email != null && senha != null && cpf != null){
            if(sexo == 'm' || sexo == 'f'){
                professor = repositorioProfessor.buscarCpf(cpf);
            }
            if (professor == null){
                 retorno = this.repositorioProfessor.adicionar(nome,email,sexo,dataNascimento,senha,cpf);
            }
        }
        return retorno;
    }

    public boolean descadastrar (Professor professor){
        boolean retorno = false;
        if (professor != null && repositorioProfessor.existe(professor)){
            retorno = repositorioProfessor.remover(professor);
        }
        return retorno;
    }

    public Professor procurar (String nome){
        Professor professor = null;
        if (nome != null){
            professor = this.repositorioProfessor.buscar(nome);
        }
        return professor;
    }

    public boolean existe(Professor professor){
        boolean retorno = false;
        if(professor != null){
            retorno = this.repositorioProfessor.existe(professor);
        }
        return retorno;
    }


}
