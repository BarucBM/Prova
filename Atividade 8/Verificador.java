import java.util.ArrayList;

public class Verificador {
    public Verificador() {}

    public boolean verificarFinalString(String frase1, String frase2){
        String[] frase1Separada = frase1.split("");
        String[] frase2Separada = frase2.split("");

        return frase1Separada[frase1Separada.length - 1].equalsIgnoreCase(frase2Separada[1]) && frase1Separada[frase1Separada.length - 2].equalsIgnoreCase(frase2Separada[0]);
    }

}
