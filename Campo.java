import java.util.Scanner;

public class Campo {
    Scanner teclado = new Scanner(System.in);

    Jugador jugador1 = new Jugador("Jugador 1");
    Jugador jugador2 = new Jugador("Jugador 2");

    Pokemon pokemon1 = new Pokemon("Charmander", "Fuego", 15, 5, new Habilidad("Cola de fuego", 25, 80));
    Pokemon pokemon2 = new Pokemon("Squirtle", "Agua", 17, 6, new Habilidad("Chorro de agua", 20, 90));
    Pokemon pokemon3 = new Pokemon("Bulbasaur", "Planta", 19, 7, new Habilidad("Látigo cepa", 30, 70));
    Pokemon pokemon4 = new Pokemon("Dedene", "Electrico", 16, 4, new Habilidad("Impactrueno", 20, 85));
    Pokemon pokemon5 = new Pokemon("Pikachu", "Eléctrico", 15, 5, new Habilidad("Bola Electrica", 25, 80)); 
    Pokemon pokemon6 = new Pokemon("Odish", "Planta", 10, 8, new Habilidad("Ataque rápido", 15, 90));
    Pokemon pokemon7 = new Pokemon("Piplup", "Agua", 15, 10, new Habilidad("Hidrobomba", 100, 50));
    Pokemon pokemon8 = new Pokemon("Torchic", "Fuego", 14, 9, new Habilidad("Lanzallamas", 22, 75));

    public void iniciarJuego() {
        System.out.println("Jugador 1, elige tus Pokémon iniciales:");
        System.out.println("1. " + pokemon1.getDatos());
        System.out.println("2. " + pokemon2.getDatos());
        System.out.println("3. " + pokemon3.getDatos());
        System.out.println("4. " + pokemon4.getDatos());
        System.out.println("5. " + pokemon5.getDatos());
        System.out.println("6. " + pokemon6.getDatos());
        System.out.println("7. " + pokemon7.getDatos());
        System.out.println("8. " + pokemon8.getDatos());
        System.out.println("Selecciona 4 Pokémon uno por uno (1-8):");
        int opcion1 = teclado.nextInt();
        int opcion2 = teclado.nextInt();
        int opcion3 = teclado.nextInt();
        int opcion4 = teclado.nextInt();
    }

    public Pokemon nuevaRondaJ1() {
        System.out.println("Jugador 1, elige un Pokémon para atacar:");
        System.out.println("1. " + jugador1.pokemon1.getDatos());
        System.out.println("2. " + jugador1.pokemon2.getDatos());
        System.out.println("3. " + jugador1.pokemon3.getDatos());
        System.out.println("4. " + jugador1.pokemon4.getDatos());
        int opcion = teclado.nextInt();
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
        System.out.println("Jugador 2, elige un Pokémon para atacar:");
        System.out.println("1. " + jugador2.pokemon1.getDatos());
        System.out.println("2. " + jugador2.pokemon2.getDatos());
        System.out.println("3. " + jugador2.pokemon3.getDatos());
        System.out.println("4. " + jugador2.pokemon4.getDatos());
        int opcion = teclado.nextInt();
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

    public int calcularAtaque(Pokemon pokemonAtacante, Pokemon pokemonDefensor) {
        int efectotipo = 0;
        if (pokemonAtacante.getTipo() == "Fuego" && pokemonDefensor.getTipo() == "Planta") {
            efectotipo = 20;
        } else if (pokemonAtacante.getTipo() == "Agua" && pokemonDefensor.getTipo() == "Fuego") {
            efectotipo = 20;
        } else if (pokemonAtacante.getTipo() == "Planta" && pokemonDefensor.getTipo() == "Agua") {
            efectotipo = 20;
        } else if (pokemonAtacante.getTipo() == "Electrico" && pokemonDefensor.getTipo() == "Agua") {
            efectotipo = 20; 
        } else if (pokemonAtacante.getTipo() == "Agua" && pokemonDefensor.getTipo() == "Electrico") {
            efectotipo = -10; 
        } else if (pokemonAtacante.getTipo() == "Planta" && pokemonDefensor.getTipo() == "Fuego") {
            efectotipo = -10; 
        }else if (pokemonAtacante.getTipo() == "Fuego" && pokemonDefensor.getTipo() == "Agua") {
            efectotipo = -10; 
        } else if (pokemonAtacante.getTipo() == "Agua" && pokemonDefensor.getTipo() == "Planta") {
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
}