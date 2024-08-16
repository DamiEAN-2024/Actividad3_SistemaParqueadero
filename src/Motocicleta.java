import java.time.LocalDateTime;

public class Motocicleta extends Vehiculo {

    private int cilindraje;

    // Constructor que inicializa todos los atributos
    public Motocicleta(String placa, String marca, String modelo, LocalDateTime horaEntrada, int cilindraje) {
        super(placa, marca, modelo, horaEntrada);  // Llamada al constructor de Vehiculo
        this.cilindraje = cilindraje;  // Inicializa el atributo específico de Motocicleta
    }

    // Getter y setter para cilindraje
    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
