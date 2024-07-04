package Alienigenas;
import Especies.*;
import Sistema.imprimir;

import java.util.*;

public class Alienigena implements imprimir {
    protected int id;
    protected String nome;
    protected Especie especie;
    protected Date dataEHora;
    protected int periculosidade;
    protected int quarentena;

    public Alienigena(int id, String nome, Especie especie,  Date dataEHora) {
        this.id = id;
        this.nome = nome;
        this.dataEHora = dataEHora;
        this.especie = especie;
        this.periculosidade = this.especie.getPericulosidade();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Date getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(Date dataEHora) {
        this.dataEHora = dataEHora;
    }

    public int getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(int periculosidade) {
        this.periculosidade = periculosidade;
    }

    public int getQuarentena() {
        return quarentena;
    }

    public void setQuarentena(int quarentena) {
        this.quarentena = quarentena;
    }

    @Override
    public void print() {
        System.out.println("\nID: " + this.id + "\n" +
                "Nome: " + this.nome + "\n" +
                "Data e hora de chegada: " + this.dataEHora + "\n");
        this.getEspecie().print();

        System.out.println("Quarentena: " + this.getQuarentena() + " dias");
    }
}
