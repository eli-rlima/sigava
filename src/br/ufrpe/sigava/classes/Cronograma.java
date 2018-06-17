package br.ufrpe.sigava.classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cronograma {
    private ArrayList<Marcacao> marcacoes = new ArrayList<Marcacao>();
    private String semestre;

    public Cronograma(String semestre){ this.setSemestre(semestre);}

    public boolean adicionar(Marcacao marcacao){
        return marcacoes.add(marcacao);
    }

    public boolean remover(Marcacao marcacao){
        return marcacoes.remove(marcacao);
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Marcacao criarMarcacao(Tarefa tarefa, LocalDate dataTerminoTarefa){
        Marcacao marcacao = null;
        if (tarefa.getDataTermino().isEqual(dataTerminoTarefa) || tarefa.getDataTermino().isBefore(dataTerminoTarefa)){
            marcacao.setCodigoTarefa(tarefa.getCodigoTarefa());
            marcacao.setDataTermino(dataTerminoTarefa);
        }
        return marcacao;
    }
}