package br.ufrpe.sigava.classes;

import java.time.LocalDate; 
import java.time.Period; 
import java.time.format.DateTimeFormatter; 
 
public class Tarefa { 
    private String descricao; 
    private LocalDate dataInicio; 
    private LocalDate dataTermino; 
    private int codigoTarefa; 
 
    public Tarefa(String descricao, LocalDate dataInicio, LocalDate dataTermino, int codigoTarefa) { 
        this.setDescricao(descricao);
        this.setDataInicio(dataInicio);
        this.setDataTermino(dataTermino);
        this.setCodigoTarefa(codigoTarefa);
    }
    
    public Tarefa(){
    	
    }
 
    public String getDescricao() { 
        return descricao; 
    } 
 
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    } 
 
    public LocalDate getDataInicio() { 
        return dataInicio; 
    } 
 
    public void setDataInicio(LocalDate dataInicio) { 
        this.dataInicio = dataInicio; 
    } 
 
    public LocalDate getDataTermino() { 
        return dataTermino; 
    } 
 
    public void setDataTermino(LocalDate dataTermino) { 
        this.dataTermino = dataTermino; 
    } 
 
    public int getCodigoTarefa() { 
        return codigoTarefa; 
    } 
 
    public void setCodigoTarefa(int codigoTarefa) { 
        this.codigoTarefa = codigoTarefa; 
    } 
 
    public int getDuracao(){ 
        Period period = Period.between(this.getDataInicio(), this.getDataTermino()); 
        return period.getDays(); 
    } 
    
    public String toString() { 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        return "Codigo da tarefa: " + this.getCodigoTarefa() +
                "\nDescricao da tarefa: " + this.getDescricao() +
                "\nData Inicio = " + this.getDataInicio().format(formatter) +
                "\nData Termino = " + this.getDataTermino().format(formatter) +
                this.getDuracao() + " dias para a data da entrega."; 
    } 
 
    public boolean equals(Tarefa anotherTarefa){ 
        boolean equals = false; 
        if(this.getCodigoTarefa() == anotherTarefa.getCodigoTarefa()){ 
            equals = true; 
        } 
        return equals; 
    } 
} 