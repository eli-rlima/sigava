package br.ufrpe.sigava.classes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Disciplina{

  private String nome;
  private Pessoa professor;
  private ArrayList<Pessoa> alunos = new ArrayList<Pessoa>();
  private LocalDate dataInicio;
  private LocalDate dataFim;
  private DayOfWeek diaAula;
  private int duracaoAula;
  private int cargaHoraria;
  private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();


  public Disciplina(String nome, LocalDate dataInicio, DayOfWeek diaAula, int duracaoAula,int cargaHoraria) {
    this.setNome(nome);
    this.setDataInicio(dataInicio);
    this.setDiaAula(diaAula);
    this.setDuracaoAula(duracaoAula);
    this.setCargaHoraria(cargaHoraria);
    this.setDataFim(this.gerarDataFim());
    }
  
  public Disciplina() {

  }

  public int getDuracaoAula() {
        return duracaoAula;
    }

  public void setDuracaoAula(int duracaoAula) {
        this.duracaoAula = duracaoAula;
    }

  public String getNome() {
    return nome;
  }

  public Pessoa getProfessor() {
  return professor;
 }
  
  public ArrayList getAlunos() {
    return alunos;
  }

  public LocalDate getDataInicio() {
    return dataInicio;
  }

  public DayOfWeek getDiaAula() {
    return diaAula;
  }

  public int getCargaHoraria() {
    return this.cargaHoraria;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setProfessor(Pessoa professor) {
    this.professor = professor;
  }

  public void setAlunos(ArrayList alunos) {
	this.alunos = alunos;
  }

  public void setDataInicio(LocalDate dataInicio) {
    this.dataInicio = dataInicio;
  }

  public void setDataFim(LocalDate dataFim) {
    this.dataFim = dataFim;
  }

  public LocalDate getDataFim() {
      return dataFim;
  }

  public void setDiaAula(DayOfWeek diaAula) {
    this.diaAula = diaAula;
  }

  public void setCargaHoraria(int cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }
		  
  public boolean adicionarAluno(Pessoa aluno) {
    boolean retorno = false;
    if (aluno != null) {
      this.alunos.add(aluno);
      retorno = true;
    }
    return retorno;
  }

  public boolean adicionarProfessor(Pessoa professor) {
    boolean retorno = false;
    if (professor != null) {
      this.professor = professor;
      retorno = true;
    }
    return retorno;
  }
  
  public boolean adicionarTarefa(Tarefa tarefa) {
    boolean retorno = false;
    if (tarefa != null) {
        this.tarefas.add(tarefa);
        retorno = true;
    }
    return retorno;
}
  
  public LocalDate gerarDataFim(){
      LocalDate dataFim = null;
      LocalDate dataInicioP = this.getDataInicio();
      DayOfWeek diaAula = this.getDiaAula();
      int cargaHoraria = this.getCargaHoraria();
      for (int i = cargaHoraria; i > 0;){
          if (dataInicioP.getDayOfWeek().equals(diaAula)){
              i -= this.getDuracaoAula();
              dataInicioP = dataInicioP.plusDays(1);
            }
          else {
              dataInicioP = dataInicioP.plusDays(1);
          }
        }
        dataInicioP = dataInicioP.plusDays(-1);
        dataFim = dataInicioP;
      return dataFim;
    }

  public int gerarCargaHorariaRestante(){
      int cargaHorariaRestante = 0;
      LocalDate dataInicioP = this.getDataInicio();
      LocalDate hoje = LocalDate.now();
      DayOfWeek diaAula = this.getDiaAula();
      int cargaHoraria = this.getCargaHoraria();

      if (dataInicioP.isBefore(hoje)){
          for (int i = cargaHoraria; dataInicioP.isBefore(hoje);){
               if (dataInicioP.getDayOfWeek().equals(diaAula)) {
                   i -= this.getDuracaoAula();
                   dataInicioP = dataInicioP.plusDays(1);
                   cargaHorariaRestante = i;
               }
               else{
                   dataInicioP = dataInicioP.plusDays(1);
               }
          }

          if (hoje.getDayOfWeek().equals(diaAula)){
              cargaHorariaRestante -= this.getDuracaoAula();
          }
        }
      else cargaHorariaRestante = cargaHoraria;

      return cargaHorariaRestante;
  }

  public String toString() {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      return "Nome da Disciplina: " + this.getNome() + "" + "\nProfessor:" + this.getProfessor().getNome()+ "\n"
          + "Inicio da disciplina: " + this.getDataInicio().format(formatter) + "\nData termino da disciplina: "
          + this.getDataFim().format(formatter) + "\nDia que ocorre a aula:" + this.getDiaAula()
          + "\nCarga Horaria: " + this.getCargaHoraria();
    }

  public boolean equals(Disciplina obj) {
        boolean retorno = false;
        if (obj.getAlunos() != null && obj.getDataFim() != null && obj.getDataInicio() != null
            && obj.getDiaAula() != null && obj.getNome() != null && obj.getProfessor() != null) {
          if (this.getAlunos() != null && this.getDataFim() != null && this.getDataInicio() != null
              && this.getDiaAula() != null && this.getNome() != null && this.getProfessor() != null) {

            if (this.getNome().equals(obj.getNome()) && this.getAlunos().equals(obj.getAlunos())
                && this.getCargaHoraria() == obj.getCargaHoraria() && this.getDataFim().equals(obj.getDataFim())
                && this.getDataInicio().equals(obj.getDataInicio())
                && this.getProfessor().equals(obj.getProfessor())
                && this.getDiaAula().equals(obj.getDiaAula())) {
              retorno = true;

            }

          }

        }

        return retorno;
      }

}