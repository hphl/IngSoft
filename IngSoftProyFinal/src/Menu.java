
import java.util.Scanner;

public class Menu {

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
        
        while (continuar){
            System.out.println(lineas+"Bienvenido al Juego De Inge Del Software");
            System.out.println("Presione 1 para iniciar nuevo juego");
            System.out.println("Presione 2 para salir del juego");
            //System.out.println("Presione 3 para continuar el juego"+lineas);
            option=in.next();
                
            switch (esNumero(option)){
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
                /*case 3:
                    iniciarJuego(tablero);
                    break;*/
                default:
                    break;
        }
    }
}

    private static void iniciarJuego(Tablero tablero) {
        
        boolean seguirJugando=true;
        String casillaDestino;
        String casillaOrigen;
        
        System.out.println(lineas+"R,B,A=Rojo,Blanco,Azulo\nO=Vacio\n"+tablero.mostrarTablero()+lineas);  
        
        while (seguirJugando){
            System.out.println("Presione 99 para volver al menu principal");
            System.out.println("Presione 98 para que lo resuelva la maquina");
            System.out.print("Ingrese la casilla Origen: ");
            casillaOrigen = in.next();

            switch (esNumero(casillaOrigen)) {
                case 99:
                    System.out.println("Volviendo al menu principal...");
                    seguirJugando = false;

                    break;

                case 98:
                    System.out.println("Resolviendo, Espere porfavor ...");
                    System.out.println(tablero.mostrarTablero()+tablero.resolverJuego(new Tablero()));
                    System.out.println("PRESIONE UNA TECLA PARA VOLVER AL MENU PRINCIPAL");
                    casillaOrigen = in.next();
                    seguirJugando = false;
                    break;

                default:
                    System.out.print("Ingrese la casilla destino: ");
                    casillaDestino = in.next();
                    if (tablero.realizarJugada(esNumero(casillaOrigen) - 1, esNumero(casillaDestino) - 1)) {
                        System.out.println("\nComando:" + casillaOrigen + " a " + casillaDestino + "\n\n" + tablero.mostrarTablero() + lineas);
                    } else {
                        System.out.println("\nNo se pudo ejecutar el comando:" + casillaOrigen + " a " + casillaDestino + "\n\n" + tablero.mostrarTablero() + lineas);
                    }
                    if (tablero.terminoJuego()) {
                        if (tablero.ganarJuego()) {
                            System.out.println("GANASTE\n PRESIONE UNA TECLA PARA VOLVER AL MENU PRINCIPAL");
                        } else {
                            System.out.println("NO EXISTEN MAS JUGADAS\n PRESIONE UNA TECLA PARA VOLVER AL MENU PRINCIPAL");
                        }
                        casillaOrigen = in.next();
                        seguirJugando = false;
                    }

                    break;
            }
        }
    }

    private static int esNumero(String cadenaComprobar) {
        int numero=-1;
        try{
            numero = Integer.parseInt(cadenaComprobar);
        }
        catch(NumberFormatException exeption){
        }
        return numero;
    }
}
