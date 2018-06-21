package br.ufrpe.sigava.classes;

import br.ufrpe.sigava.pessoa.Aluno;
import br.ufrpe.sigava.pessoa.Professor;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServidorSigava {
    private CadastroProfessor professores;
    private CadastroAlunos alunos;
    private CadastroTarefas tarefas;
    private CadastroDisciplinas disciplinas;

    private static ServidorSigava instance;

    private ServidorSigava(){
        this.professores = new CadastroProfessor();
        this.alunos = new CadastroAlunos();
        this.tarefas = new CadastroTarefas();
        this.disciplinas = new CadastroDisciplinas();
    }

    public static ServidorSigava getIstance(){
        if (instance == null){
            instance = new ServidorSigava();
        }
        return instance;
    }

    public void cadastrarAluno(Aluno aluno){ //TODO excepcion
        this.alunos.cadastrar(aluno);
    }

    public Aluno buscarAluno(String cpf){
        return this.alunos.procurar(cpf);
    }

    public void cadastrarAluno(String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf){
        this.alunos.cadastrar(nome, email, sexo, dataNascimento, senha, cpf);
    }

    public void adicionarMarcacao(String nomeDisciplina, String nomeCronogram, Aluno aluno, int codigoTarefa, LocalDate dataTermino){
        this.alunos.adicionarMarcacao(nomeDisciplina, nomeCronogram, aluno, codigoTarefa, dataTermino);
    }

    public void descadastrarAluno(Aluno aluno){
        this.alunos.descadastrar(aluno);
    }

    public boolean existeAluno(Aluno aluno){
        return this.alunos.existe(aluno);
    }

    public void cadastrarDisciplina(Disciplina disciplina){
        this.disciplinas.cadastrar(disciplina);
    }

    public void cadastrarDisciplina(String nome, LocalDate dataInicio, DayOfWeek diaAula, int duracaoAula, int cargaHoraria){
        this.disciplinas.cadastrar(nome, dataInicio, diaAula, duracaoAula, cargaHoraria);
    }

    public void descadastrarDisciplina(Disciplina disciplina){
        this.disciplinas.descadastrar(disciplina);
    }

    public Disciplina buscarDisciplina(String nome){
        return this.disciplinas.procurar(nome);
    }

    public boolean existeDisciplina(Disciplina disciplina){
        return this.disciplinas.existe(disciplina);
    }

    public void cadastrarProfessorDisciplina(String nomeDisciplina, Professor professor){
        this.disciplinas.cadastrarProfessor(nomeDisciplina, professor);
    }

    public void cadastrarAlunoDisciplina(String nomeDisciplina, Aluno aluno){
        this.disciplinas.cadastrarAluno(nomeDisciplina, aluno);
    }

    public void cadastrarTarefaDisciplina(String nomeDisciplina, Tarefa tarefa){
        this.disciplinas.cadastrarTarefa(nomeDisciplina, tarefa);
    }

    public void cadastrarProfessor(Professor professor){
        this.professores.cadastrar(professor);
    }

    public void cadastrarProfessor(String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf){
        this.professores.cadastrar(nome, email, sexo, dataNascimento, senha, cpf);
    }

    public void descadastrarProfessor(Professor professor){
        this.professores.descadastrar(professor);
    }

    public Professor buscarProfessor(String cpf){
        return this.professores.procurar(cpf);
    }

    public boolean existeProfessor(Professor professor){
        return this.professores.existe(professor);
    }

    public void cadastrarTarefa(Tarefa tarefa){
        this.tarefas.cadastrar(tarefa);
    }

    public void cadastrarTarefa(String descricao, LocalDate dataInicio, LocalDate dataTermino, int codigoTarefa){
        this.tarefas.cadastrar(descricao, dataInicio, dataTermino, codigoTarefa);
    }

    public void descadastrarTarefa(Tarefa tarefa){
        this.tarefas.descadastrar(tarefa);
    }

    public Tarefa buscarTarefa(int codigo){
        return this.tarefas.procurar(codigo);
    }

    public boolean existeTarefa(Tarefa tarefa){
        return this.tarefas.existe(tarefa);
    }
}
