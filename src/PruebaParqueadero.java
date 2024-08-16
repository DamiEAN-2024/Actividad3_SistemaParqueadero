import java.time.LocalDateTime;

public class PruebaParqueadero {
    public static void main(String[] args) throws Exception {
        // Crear una instancia del parqueadero
        Parqueadero parqueadero = new Parqueadero();

        // Crear un automóvil y registrar su entrada
        Vehiculo automovil = new Automovil("ABC123", "Toyota", "Corolla", LocalDateTime.now(), "Gasolina");
        parqueadero.registrarEntrada(automovil);

        // Consultar el estado del parqueadero (debería mostrar el automóvil ingresado)
        System.out.println("Estado del parqueadero después de registrar la entrada:");
        parqueadero.consultarEstadoParqueadero();

        // Esperar algunos segundos para simular tiempo de estadía (puedes usar un tiempo más largo si lo prefieres)
        try {
            Thread.sleep(2000);  // 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Registrar la salida del automóvil y calcular el costo
        double costo = parqueadero.registrarSalida("ABC123");
        System.out.println("Costo del parqueo: $" + costo);

        // Consultar el estado del parqueadero (debería estar vacío después de la salida)
        System.out.println("Estado del parqueadero después de registrar la salida:");
        parqueadero.consultarEstadoParqueadero();
    }
}
