package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.classes.Cronograma;
import br.ufrpe.sigava.classes.Disciplina;
import br.ufrpe.sigava.classes.Marcacao;
import br.ufrpe.sigava.pessoa.Aluno;

import java.time.LocalDate;
import java.util.ArrayList;

public class RepositorioAluno implements IRepositorioAluno{
    private ArrayList<Aluno> repositorioAluno;
    private static RepositorioAluno instance;

    private RepositorioAluno(){
        this.repositorioAluno = new ArrayList<Aluno>();
    }

    public static RepositorioAluno getInstance(){
        if (instance == null){
            instance = new RepositorioAluno();
        }
        return instance;
    }

    @Override
    public boolean adicionar (Aluno aluno){
        return this.repositorioAluno.add(aluno);
    }

    @Override
    public boolean adicionar (String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf){
        Aluno aluno = new Aluno(nome,email,sexo,dataNascimento,senha,cpf);
        return adicionar(aluno);
    }

    @Override
    public boolean remover (Aluno aluno){
        return this.repositorioAluno.remove(aluno);
    }

    @Override
    public Aluno buscar (String cpf){
        Aluno aluno = null;
        for (int i = 0; i < this.repositorioAluno.size(); i++) {
            if (this.repositorioAluno.get(i).getCpf().equalsIgnoreCase(cpf)) {
                aluno = this.repositorioAluno.get(i);
            }
        }
        return aluno;
    }

    @Override
    public boolean existe (Aluno aluno) {
        return this.repositorioAluno.contains(aluno);
    }

    @Override
    public boolean adicionarMarcacao(String semestre, Aluno aluno, int codigoTarefa, LocalDate dataTermino){
        Cronograma cronograma = aluno.buscarCronograma(semestre);
        return cronograma.adicionar(codigoTarefa, dataTermino);
    }

    @Override
    public boolean existeCronograma (Aluno aluno, String nomeCronograma) {
        boolean retorno = false;
        if (aluno != null && nomeCronograma != null) {
            for (int i = 0; i < aluno.getCronogramas().size(); i++) {
                if (aluno.getCronogramas().get(i).getNome().equals(nomeCronograma)) {
                    retorno = true;
                }
            }
        }
        return retorno;
    }
}
