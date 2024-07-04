package Sistema;

import Alienigenas.Alienigena;
import Especies.Especie;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Sistema {
    ArrayList<Especie> especiesRegistradas;
    ArrayList<Alienigena> alienigenasRegistrados;
    ArrayList<String> nomesPerigosos;
    Scanner scan;

    public Sistema() {
        especiesRegistradas = new ArrayList<>();
        alienigenasRegistrados = new ArrayList<>();
        nomesPerigosos = new ArrayList<>();
        this.scan = new Scanner(System.in);
    }

    public void ranking(){
        ArrayList<Alienigena> ranking = alienigenasRegistrados;
        Alienigena aux;
        for (int i=0; i < ranking.size(); ++i){
            for (int j=i; j < ranking.size(); ++j){
                if (ranking.get(i).getPericulosidade()>ranking.get(j).getPericulosidade()){
                    aux = ranking.get(i);
                    ranking.set(i,ranking.get(j));
                    ranking.set(j, aux);
                }
            }
        }
        int aux1 = 0;
        for (Alienigena alienigena:ranking){
            aux1++;
            System.out.println(aux1 + " " + alienigena.getNome() + " " + alienigena.getPericulosidade());
        }
    }


     protected Especie newEspecie(){
         System.out.println("Qual seu planeta de origem?");
         String planeta = scan.nextLine();
         if(planeta.equalsIgnoreCase("")){
             planeta = scan.nextLine();
         }

         System.out.println("Qual seu nivel de periculosidade?");
         int periculosidade = scan.nextInt();

         Especie especie = null;
         boolean especieExiste = false;
         for(Especie busca:especiesRegistradas) {
             if (busca.getPericulosidade() == periculosidade && busca.getPlaneta().equalsIgnoreCase(planeta)) {
                 especie = busca;
                 especieExiste = true;
                 break;
             }
         }
         if(!especieExiste){
             especie = new Especie(planeta, periculosidade);
         }
         especiesRegistradas.add(especie);
         return especie;
    }

    protected Alienigena newAlienigena(){
        System.out.println("\nQual seu ID?");
        int id = scan.nextInt();

        System.out.println("Qual seu nome?");
        String nome = scan.nextLine();
        if(nome.equalsIgnoreCase("")){
            nome = scan.nextLine();
        }

        Especie especie = this.newEspecie();


        Alienigena alien = new Alienigena(id, nome, especie, new Date());
        alienigenasRegistrados.add(alien);
        return alien;
    }

    protected void avaliacao(Alienigena alienigena){
        if (alienigena.getPericulosidade() >=50){
            alienigena.setQuarentena(50);
            System.out.println("Esse alienigena deve ficar 50 dias em quarentena;");

        }else{
            boolean foragido = false;
            for (String nome:nomesPerigosos){
                if(nome.equalsIgnoreCase(alienigena.getNome())){
                    alienigena.setQuarentena(100);
                    foragido =true;
                    System.out.println("Esse alienigena deve ficar 100 dias em quarentena;");
                    break;
                }
            }
            if(!foragido){
                System.out.println("Esse alienigena não é perigoso.");
            }
        }

    }

    public void start(){
        boolean aux = true;
        while (aux){
            System.out.println("\nO que deseja fazer?\n" +
                    "1 - Registrar um alienigena .\n" +
                    "2 - Registrar uma espécie. \n" +
                    "3 - Ranking\n" +
                    "4 - Relatório\n" +
                    "4 - Sair.\n");
            try{
                switch (scan.nextInt()){
                    case 1:
                        Alienigena x = this.newAlienigena();
                        this.avaliacao(x);
                        x.print();


                        break;

                    case 2:
                        Especie e = this.newEspecie();
                        e.print();
                        break;

                    case 3:
                        this.ranking();

                    case 4:
                        for(Alienigena alienigena:alienigenasRegistrados){
                            alienigena.print();
                        }
                        break;

                    case 5:
                        aux = false;


                }
            }catch (Exception e){
                System.out.println("Valor inválido!");
                break;
            }

        }

    }
}
