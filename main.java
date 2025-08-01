public class main {
    public static void main(String[] args) {
        Campo campo = new Campo();
        int ronda = 1;
        campo.iniciarJuego();

        while (ronda <= 4){
            System.out.println("Iniciando ronda " + ronda);
            Pokemon pokemonAtacante = campo.nuevaRondaJ1();
            Pokemon pokemonDefensor = campo.nuevaRondaJ2();
            campo.calcularAtaque(pokemonAtacante, pokemonDefensor);

            System.out.println("Ronda " + ronda + " completada.");
            ronda++;
        }

    }
}