import java.time.LocalDateTime;
import java.util.Scanner;

public class InterfazParqueadero {

    public static void main(String[] args) throws Exception {
        Parqueadero parqueadero = new Parqueadero();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú del Parqueadero ---");
            System.out.println("1. Ingresar un vehículo");
            System.out.println("2. Registrar la salida de un vehículo");
            System.out.println("3. Consultar el estado del parqueadero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    ingresarVehiculo(parqueadero, scanner);
                    break;
                case 2:
                    registrarSalidaVehiculo(parqueadero, scanner);
                    break;
                case 3:
                    consultarEstadoParqueadero(parqueadero);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    // Método para ingresar un vehículo
    public static void ingresarVehiculo(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Automóvil");
        System.out.println("2. Motocicleta");
        System.out.println("3. Camión");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        Vehiculo vehiculo = null;
        switch (tipo) {
            case 1:
                System.out.print("Ingrese el tipo de combustible: ");
                String tipoCombustible = scanner.nextLine();
                vehiculo = new Automovil(placa, marca, modelo, LocalDateTime.now(), tipoCombustible);
                break;
            case 2:
                System.out.print("Ingrese el cilindraje de la motocicleta: ");
                int cilindraje = scanner.nextInt();
                vehiculo = new Motocicleta(placa, marca, modelo, LocalDateTime.now(), cilindraje);
                break;
            case 3:
                System.out.print("Ingrese la capacidad de carga en toneladas: ");
                double capacidadCarga = scanner.nextDouble();
                vehiculo = new Camion(placa, marca, modelo, LocalDateTime.now(), capacidadCarga);
                break;
            default:
                System.out.println("Tipo de vehículo inválido.");
                return;
        }

        parqueadero.registrarEntrada(vehiculo);
        System.out.println("Vehículo registrado exitosamente.");
    }

    // Método para registrar la salida de un vehículo
    public static void registrarSalidaVehiculo(Parqueadero parqueadero, Scanner scanner) throws Exception {
        System.out.print("Ingrese la placa del vehículo que va a salir: ");
        String placa = scanner.nextLine();
        double costo = parqueadero.registrarSalida(placa);
        if (costo > 0.0) {
            System.out.println("El costo del parqueo es: $" + costo);
        }
    }

 // Método para consultar el estado del parqueadero
    public static void consultarEstadoParqueadero(Parqueadero parqueadero) {
        if (parqueadero.getVehiculos().isEmpty()) {  
            System.out.println("El parqueadero está vacío.");
        } else {
            System.out.println("Vehículos presentes en el parqueadero:");
            for (Vehiculo vehiculo : parqueadero.getVehiculos()) {  
                System.out.println("Placa: " + vehiculo.getPlaca() + ", Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo());
            }
        }
    }
           
 }

