public class Main {
    public static void main(String[] args) {
        Verificador test = new Verificador();

        System.out.println(test.verificarFinalString("programação", "ão"));
        System.out.println(test.verificarFinalString("olá", "mundo"));
        System.out.println(test.verificarFinalString("", "abc"));
        System.out.println(test.verificarFinalString("hellO", "lo"));
    }
}