import java.time.LocalDateTime;

public class Camion extends Vehiculo {

    private double capacidadCarga;

    // Constructor que inicializa todos los atributos
    public Camion(String placa, String marca, String modelo, LocalDateTime horaEntrada, double capacidadCarga) {
        super(placa, marca, modelo, horaEntrada);  // Llamada al constructor de Vehiculo
        this.capacidadCarga = capacidadCarga;  // Inicializa el atributo específico de Camion
    }

    // Getter y setter para capacidadCarga
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}
