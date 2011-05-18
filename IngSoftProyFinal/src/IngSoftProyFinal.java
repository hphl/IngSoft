
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
                    System.out.println(lineas+"\nR,B,A=Ocupado\nO=Vacio\n"+tablero.mostrarTablero()+"\n"+lineas);  
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
        
        System.out.println(lineas+"\nR,B,A=Ocupado\nO=Vacio\n"+tablero.mostrarTablero()+"\n"+lineas);  
        
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
                    if(tablero.moverFicha(esNumero(casillaOrigen)-1, esNumero(casillaDestino)-1))
                        System.out.println("\n"+tablero.mostrarTablero()+"\nComando:"+casillaOrigen+" a "+casillaDestino+"\n"+lineas);
                    else
                        System.out.println("\n"+tablero.mostrarTablero()+"\nNo se pudo ejecutar el comando:"+casillaOrigen+" a "+casillaDestino+"\n"+lineas);
                    if(tablero.cantidadCasillasVacias()==14)
                    {
                        System.out.println("GANASTE\n presione una tecla para volver al menu principal");
                        casillaOrigen=in.next();
                        seguirJugando=false;
                    }
                    else
                    {
                        if(tablero.perdio())
                        {
                            System.out.println("PERDISTE\n presione una tecla para volver al menu principal");
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
