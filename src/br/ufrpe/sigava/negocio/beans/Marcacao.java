package br.ufrpe.sigava.classes;

import java.time.LocalDate;

public class Marcacao {
    private int codigoTarefa;
    private LocalDate dataTermino;

    public Marcacao(int codigoTarefa, LocalDate dataTermino) {
        this.codigoTarefa = codigoTarefa;
        this.dataTermino = dataTermino;
    }

    public int getCodigoTarefa() {
        return codigoTarefa;
    }

    public void setCodigoTarefa(int codigoTarefa) {
        this.codigoTarefa = codigoTarefa;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }
}
