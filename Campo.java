import java.util.Scanner;

public class Campo {
    Scanner teclado = new Scanner(System.in);

    Jugador jugador1 = new Jugador("Jugador 1");
    Jugador jugador2 = new Jugador("Jugador 2");

    Pokemon pokemon1 = new Pokemon("Charmander", "Fuego", 15, 5, new Habilidad("Cola de fuego", 25, 80));
    Pokemon pokemon2 = new Pokemon("Squirtle", "Agua", 17, 6, new Habilidad("Chorro de agua", 20, 90));
    Pokemon pokemon3 = new Pokemon("Bulbasaur", "Planta", 19, 7, new Habilidad("Látigo cepa", 30, 70));
    Pokemon pokemon4 = new Pokemon("Dedene", "Electrico", 16, 4, new Habilidad("Impactrueno", 100, 40));
    Pokemon pokemon5 = new Pokemon("Pikachu", "Eléctrico", 15, 5, new Habilidad("Bola Electrica", 25, 80)); 
    Pokemon pokemon6 = new Pokemon("Odish", "Planta", 10, 8, new Habilidad("Ataque rápido", 15, 90));
    Pokemon pokemon7 = new Pokemon("Piplup", "Agua", 15, 10, new Habilidad("Hidrobomba", 100, 40));
    Pokemon pokemon8 = new Pokemon("Torchic", "Fuego", 14, 9, new Habilidad("Lanzallamas", 22, 75));

    public void iniciarJuego() {
        jugador1.eleccionInicial(pokemon1, pokemon2, pokemon3, pokemon4);
        jugador2.eleccionInicial(pokemon5, pokemon6, pokemon7, pokemon8);
    }

    public boolean ataqueEspecial(){
        System.out.println("Desea utilizar la habilidad especial si/no");
        String opciones = teclado.nextLine();
        return opciones.equals("si");
    }


    public Pokemon nuevaRondaJ1() {
        System.out.println("Jugador 1, elige un Pokémon para atacar: \n");
        System.out.println("1. " + jugador1.pokemon1.getDatos());
        System.out.println("2. " + jugador1.pokemon2.getDatos());
        System.out.println("3. " + jugador1.pokemon3.getDatos());
        System.out.println("4. " + jugador1.pokemon4.getDatos());
        int opcion = teclado.nextInt();
        teclado.nextLine();
        switch (opcion){
            case 1:
                return jugador1.pokemon1;
            case 2:
                return jugador1.pokemon2;
            case 3:
                return jugador1.pokemon3;
            case 4:
                return jugador1.pokemon4;
            default:
                System.out.println("Opción inválida. Elige un Pokémon válido.");
                return nuevaRondaJ1();
        }
    }

    public Pokemon nuevaRondaJ2() {
        System.out.println("Jugador 2, elige un Pokémon para atacar: \n");
        System.out.println("1. " + jugador2.pokemon1.getDatos());
        System.out.println("2. " + jugador2.pokemon2.getDatos());
        System.out.println("3. " + jugador2.pokemon3.getDatos());
        System.out.println("4. " + jugador2.pokemon4.getDatos());
        int opcion = teclado.nextInt();
        teclado.nextLine();
        switch (opcion){
            case 1:
                return jugador2.pokemon1;
            case 2:
                return jugador2.pokemon2;
            case 3:
                return jugador2.pokemon3;
            case 4:
                return jugador2.pokemon4;
            default:
                System.out.println("Opción inválida. Elige un Pokémon válido.");
                return nuevaRondaJ2();
        }
    }

    public int calcularAtaqueN(Pokemon pokemonAtacante, Pokemon pokemonDefensor) {
        int efectotipo = 0;
        if ((pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Planta")) || (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Fuego")) || (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Agua")) || (pokemonAtacante.getTipo().equals("Electrico") && pokemonDefensor.getTipo().equals("Agua"))  ) {
            efectotipo = 20;
        } else if (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Electrico") || (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Fuego")) || (pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Agua")) || (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Planta"))) {
            efectotipo = -10; 
        }
        
        int ataque = pokemonAtacante.getAtaque();
        int defensa = pokemonDefensor.getDefensa();
        int daño = ataque - defensa + efectotipo;
        if (daño < 0) {
            daño = 0;
        }
        return daño;
    }

    public int calcularAtaqueESP(Pokemon pokemonAtacante, Pokemon pokemonDefensor) {
        int efectotipo = 0;
        if ((pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Planta")) || (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Fuego")) || (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Agua")) || (pokemonAtacante.getTipo().equals("Electrico") && pokemonDefensor.getTipo().equals("Agua"))  ) {
            efectotipo = 20;
        } else if (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Electrico") || (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Fuego")) || (pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Agua")) || (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Planta"))) {
            efectotipo = -10; 
        }
        
        int ataque = 0;
        if (pokemonAtacante.getHabilidad().usarHabilidad()) ataque = pokemonAtacante.getHabilidad().getAtaque();
        int defensa = pokemonDefensor.getDefensa();

        int daño = ataque - defensa + efectotipo;
        if (daño < 0) {
            daño = 0;
        }
        return daño;
    }
}
