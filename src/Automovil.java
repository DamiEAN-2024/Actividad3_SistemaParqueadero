import java.time.LocalDateTime;

public class Automovil extends Vehiculo {

    private String tipoCombustible;

    // Constructor que inicializa todos los atributos
    public Automovil(String placa, String marca, String modelo, LocalDateTime horaEntrada, String tipoCombustible) {
        super(placa, marca, modelo, horaEntrada);  // Llamada al constructor de Vehiculo
        this.tipoCombustible = tipoCombustible;
    }

    // Getter y setter para tipoCombustible
    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
}
