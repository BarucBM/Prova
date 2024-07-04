package Especies;

import Sistema.imprimir;

public class Especie implements imprimir {
    String planeta;
    int periculosidade;

    public Especie(String planeta, int periculosidade) {
        this.planeta = planeta;
        this.periculosidade = periculosidade;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public int getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(int periculosidade) {
        this.periculosidade = periculosidade;
    }

    public void imprimir(){}


    @Override
    public void print() {
        System.out.println( "Planeta: " + this.getPlaneta() + "\n" +
                "Periculosidade: " + this.periculosidade + "\n");
    }
}
