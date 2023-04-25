import java.util.Scanner;

public class Menu {
    data e = new data();
    public void menu() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. ¿Cuánto fue el total de ventas de New York?\n" +
                "2. ¿Cuántos autos clásicos vendió New York?\n" +
                "3. ¿Cuánto fue el total de ventas de Autos Clásicos en New York?\n" +
                "4. ¿Cuántas Motocicletas vendió New York?\n" +
                "5. ¿Cuánto fue el total de ventas de Motocicletas en New York?\n" +
                "6. ¿Cuál fue el cliente de New York qué más autos compró?\n" +
                "7. ¿Cuál fue el cliente de todo el archivo qué más compró?\n" +
                "8. ¿Cuál fue el cliente de todo el archivo qué menos compró?\n" +
                "9. Salir del programa \n");
        int descicion = sc.nextInt();
        switch (descicion){
            case 2:
                TotalVentas();
                Thread.sleep(3000);
                menu();
                break;
            case 3:
                TotalClasicos();
                Thread.sleep(3000);
                menu();
                break;
            case 4:
                TotalMotos();
                Thread.sleep(3000);
                menu();
                break;
            case 5:
                TotalVentasMotos();
                Thread.sleep(3000);
                menu();
                break;
            case 6:
                MaxCompradorCarros();
                Thread.sleep(3000);
                menu();
                break;
            case 7:
                MaxComprador();
                Thread.sleep(3000);
                menu();
                break;
            case 8:
                MinComprador();
                Thread.sleep(3000);
                menu();
                break;
            case 9:
                System.out.println("Saliendo del programa");
                break;
            default:
                System.out.println("Opcion no valida, ingrese un nuevo numero");
                menu();
        }
    }
    public void TotalVentas(){
        System.out.println("El total de ventas en NYC es: "+ "$" + e.TotalVentas());
    }

    public void TotalClasicos(){
        System.out.println("El total de autos clasicos vendidos en NYC es: " + e.TotalClasicos());
    }

    public void TotalVentasClasicos(){
        System.out.println("El total de ventas de autos clasicos en NYC es: " + "$" + e.TotalVentasClasicos());
    }

    public void TotalMotos(){
        System.out.println("El total de motos vendidas en NYC es: " + e.TotalMotos());
    }

    public void TotalVentasMotos(){
        System.out.println("El total de motos vendidas en NYC es: " + "$" + e.TotalVentasMotos());
    }

    public void MaxCompradorCarros(){
        System.out.println("El cliente que más compró carros en NYC fue: " + e.MaxCompradorCarros());
    }

    public void MaxComprador(){
        System.out.println("El cliente que más compró fue: " + e.MaxComprador());
    }

    public void MinComprador(){
        System.out.println("El cliente que menos compró fue: " + e.MinComprador());
    }
}

