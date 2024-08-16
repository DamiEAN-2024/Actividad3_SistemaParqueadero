import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {

    private List<Vehiculo> vehiculos;
    private List<Vehiculo> vehiculosUsadosHoy;  // Lista para almacenar los vehículos que han salido hoy

    private static final double TARIFA_AUTOMOVIL = 5000.0;
    private static final double TARIFA_MOTOCICLETA = 3000.0;
    private static final double TARIFA_CAMION = 10000.0;

    public Parqueadero() {
        this.vehiculos = new ArrayList<>();
        this.vehiculosUsadosHoy = new ArrayList<>();  // Inicializar la lista aquí
    }

    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo con placa " + vehiculo.getPlaca() + " registrado.");
    }

    public double registrarSalida(String placa) throws Exception {
        Vehiculo vehiculo = buscarVehiculoPorPlaca(placa);
        if (vehiculo == null) {
            throw new Exception("Vehículo no encontrado en el parqueadero.");
        }

        // Simulamos una salida 2 horas después de la entrada (puedes cambiar esto a LocalDateTime.now() si lo prefieres)
        LocalDateTime horaSalida = vehiculo.getHoraEntrada().plusHours(2);

        double costo = calcularCosto(vehiculo, horaSalida);
        vehiculos.remove(vehiculo);
        vehiculosUsadosHoy.add(vehiculo);  // Agregar el vehículo a la lista de los que usaron el parqueadero hoy
        return costo;
    }

    private double calcularCosto(Vehiculo vehiculo, LocalDateTime horaSalida) {
        // Calcula la duración en horas
        Duration duracion = Duration.between(vehiculo.getHoraEntrada(), horaSalida);
        long horasEstadia = (long) Math.ceil(duracion.toMinutes() / 60.0);  // Redondea las fracciones de hora

        if (vehiculo instanceof Automovil) {
            return horasEstadia * TARIFA_AUTOMOVIL;
        } else if (vehiculo instanceof Motocicleta) {
            return horasEstadia * TARIFA_MOTOCICLETA;
        } else if (vehiculo instanceof Camion) {
            return horasEstadia * TARIFA_CAMION;
        }

        return 0.0;
    }

    private Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    public void consultarEstadoParqueadero() {
        if (vehiculos.isEmpty()) {
            System.out.println("El parqueadero está vacío.");
        } else {
            System.out.println("Vehículos presentes en el parqueadero:");
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println("Placa: " + vehiculo.getPlaca() + ", Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo());
            }
        }
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    // Método corregido para obtener los vehículos que han usado el parqueadero en el día
    public List<Vehiculo> getVehiculosUsadosHoy() {
        return vehiculosUsadosHoy;
    }
}
