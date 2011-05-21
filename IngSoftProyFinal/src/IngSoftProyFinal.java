
import java.util.Scanner;

public class IngSoftProyFinal {

    public static Scanner in = new Scanner(System.in);
    public static String lineas="\n--------------------------------------\n";
    
    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        
        boolean continuar=true;
        Tablero tablero=new Tablero();
        String option="";
        String numeroCasillaUno;
        
        while (continuar)
        {
            System.out.println(lineas+"Bienvenido al Juego De Inge Del Software");
            System.out.println("Presione 1 para iniciar nuevo juego");
            System.out.println("Presione 2 para salir del juego");
            System.out.println("Presione 3 para continuar el juego"+lineas);
            option=in.next();
                
            switch (esNumero(option))
            {
                case 1:
                    tablero=new Tablero();
                    System.out.println(lineas+"R,B,A=Ocupado\nO=Vacio\n"+tablero.mostrarTablero()+lineas);  
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
                case 3:
                    iniciarJuego(tablero);
                    break;
                default:
                    break;
        }
    }
}

    private static void iniciarJuego(Tablero tablero) {
        
        boolean seguirJugando=true;
        String casillaDestino;
        String casillaOrigen;
        
        System.out.println(lineas+"R,B,A=Ocupado\nO=Vacio\n"+tablero.mostrarTablero()+lineas);  
        
        while (seguirJugando)
        {
            System.out.println("Presione 99 para volver al menu principal\n");
            System.out.print("Ingrese la casilla Origen: ");
            casillaOrigen = in.next();

            switch (esNumero(casillaOrigen))
            {
                    
                case 99:
                    System.out.println("Volviendo al menu principal...");
                    seguirJugando = false;
                    
                    break;
                    
                default:
                    System.out.print("\nIngrese la casilla destino: ");
                    casillaDestino = in.next();
                    System.out.println(lineas);
                    if(tablero.realizarJugada(esNumero(casillaOrigen)-1, esNumero(casillaDestino)-1))
                        System.out.println("\n"+tablero.mostrarTablero()+"\nComando:"+casillaOrigen+" a "+casillaDestino+lineas);
                    else
                        System.out.println("\n"+tablero.mostrarTablero()+"\nNo se pudo ejecutar el comando:"+casillaOrigen+" a "+casillaDestino+lineas);
                    if(tablero.cantidadCasillasVacias()==14)
                    {
                        System.out.println("GANASTE\n PRESIONE UNA TECLA PARA VOLVER AL MENU PRINCIPAL");
                        casillaOrigen=in.next();
                        seguirJugando=false;
                    }
                    else
                    {
                        if(!(tablero.existenMasJugadas()))
                        {
                            System.out.println("NO EXISTEN MAS JUGADAS\n PRESIONE UNA TECLA PARA VOLVER AL MENU PRINCIPAL");
                            casillaOrigen=in.next();
                            seguirJugando=false;
                        }
                    }
                    break;

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
