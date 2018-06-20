package br.ufrpe.sigava.classes;

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




}
