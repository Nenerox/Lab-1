public class main {
    public static void main(String[] args) {
        Campo campo = new Campo();
        int ronda = 1;
        int J1 = 0;
        int J2 = 0;
        campo.iniciarJuego();

        while (ronda <= 4){
            System.out.println("Iniciando ronda " + ronda +"\n");
            Pokemon pokemonj1 = campo.nuevaRondaJ1();
            boolean especialj1 = campo.ataqueEspecial();
            
            Pokemon pokemonj2 = campo.nuevaRondaJ2();
            boolean especialj2 = campo.ataqueEspecial();

            if (especialj1 && especialj2) {
                if (campo.calcularAtaqueESP(pokemonj1, pokemonj2) > campo.calcularAtaqueESP(pokemonj2, pokemonj1)) {System.out.println("Gana el jugador 1 \n"); J1++;}
                else if (campo.calcularAtaqueESP(pokemonj1, pokemonj2) < campo.calcularAtaqueESP(pokemonj2, pokemonj1)) {System.out.println("Gana el jugador 2 \n"); J2++;}
                else System.out.println("EMPATE \n");   
            } else if (especialj1) {
                if (campo.calcularAtaqueESP(pokemonj1, pokemonj2) > campo.calcularAtaqueN(pokemonj2, pokemonj1)) {System.out.println("Gana el jugador 1 \n"); J1++;}
                else if (campo.calcularAtaqueESP(pokemonj1, pokemonj2) < campo.calcularAtaqueN(pokemonj2, pokemonj1)) {System.out.println("Gana el jugador 2 \n"); J2++;}
                else System.out.println("EMPATE \n"); 
            } else if (especialj2) {
                if (campo.calcularAtaqueN(pokemonj1, pokemonj2) > campo.calcularAtaqueESP(pokemonj2, pokemonj1)) {System.out.println("Gana el jugador 1 \n"); J1++;}
                else if (campo.calcularAtaqueN(pokemonj1, pokemonj2) < campo.calcularAtaqueESP(pokemonj2, pokemonj1)) {System.out.println("Gana el jugador 2 \n"); J2++;}
                else System.out.println("EMPATE \n"); 
            } else {
                if (campo.calcularAtaqueN(pokemonj1, pokemonj2) > campo.calcularAtaqueN(pokemonj2, pokemonj1)) {System.out.println("Gana el jugador 1 \n"); J1++;}
                else if (campo.calcularAtaqueN(pokemonj1, pokemonj2) < campo.calcularAtaqueN(pokemonj2, pokemonj1)) {System.out.println("Gana el jugador 2 \n"); J2++;}
                else System.out.println("EMPATE \n");
            }

            System.out.println("Ronda " + ronda + " completada. \n");
            ronda++;
        }
        System.out.println("El juego a terminado \n Jugador 1 gano: " + J1 + " rondas. \n Jugador 2 gano: " + J2 + " rondas." );

    }
}