
import java.util.Scanner;

public class IngSoftProyFinal {

    public static Scanner in = new Scanner(System.in);
    public static String lineas="--------------------------------------";
    
    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        
        boolean continuar=true;
        Tablero tablero=new Tablero();
        //int option=0;
        String option="";
        String numeroCasillaUno;
        
        while (continuar)
        {
            System.out.println(lineas+"\n Bienvenido al Juego De Inge Del Software");
            System.out.println("Presione 1 para iniciar nuevo juego");
            System.out.println("Presione 2 para salir del juego\n"+lineas);
            option=in.next();
                
            switch (esNumero(option))
            {
                case 1:
                    tablero=new Tablero();
                    System.out.println("Ocu=Ocupado\nVac=Vacio\n"+tablero.mostrarTablero());  
                    System.out.println("para iniciar el juego debe de ingresar una posicion del tablero para que sea un vacio (ejemplo:3)");
                    numeroCasillaUno = in.next();
                    if(tablero.agregarHuecoDeInicio(esNumero(numeroCasillaUno)-1))
                        iniciarJuego(tablero);
                    else
                        System.out.println("Ingreso una posicion invalida");
                    break;
                    
                case 2:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
                    
                default:
                    menuPrincipal();
                    break;
        }
    }
}

    private static void iniciarJuego(Tablero tablero) {
        
        boolean seguirJugando=true;
        String casillaDestino;
        String casillaOrigen;
        
        System.out.println(lineas+"\nOcu=Ocupado\nVac=Vacio\n"+tablero.mostrarTablero());  
        
        while (seguirJugando)
        {
            System.out.println("Presione 1 para volver al menu principal");
            System.out.println("Presione 2 para ingresar el movimiento\n"+lineas);
            String option = in.next();

            switch (esNumero(option))
            {
                    
                case 1:
                    System.out.println("Volviendo al menu principal...");
                    seguirJugando = false;
                    
                    break;
                    
                case 2:
                        System.out.print(lineas+"\nIngrese la casilla Origen: ");
                        casillaOrigen = in.next();
                        System.out.print("\nIngrese la casilla destino: ");
                        casillaDestino = in.next();
                        if(tablero.moverFicha(esNumero(casillaOrigen)-1, esNumero(casillaDestino)-1))
                            System.out.println("\nComando:"+casillaOrigen+" a "+casillaDestino+"\n"+tablero.mostrarTablero()+"\n"+lineas);
                    else
                        System.out.println("\nNo se pudo ejecutar el comando\n"+tablero.mostrarTablero()+"\n"+lineas);
                    
                    break;
                    
                default:
                    System.out.println("Opcion incorrecta...");
            }
        }
    }

    private static int esNumero(String cadenaComprobar) {
        int numero=-1;
        try
        {
            numero = Integer.parseInt(cadenaComprobar);
        }
        catch(NumberFormatException exeption)
        {
        }
        return numero;
    }
}
