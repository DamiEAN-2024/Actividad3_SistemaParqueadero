import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class InterfazGraficaParqueadero extends JFrame {

    private Parqueadero parqueadero = new Parqueadero();
    private JTextField txtPlaca, txtMarca, txtModelo, txtTipo;

    public InterfazGraficaParqueadero() {
        // Configurar la ventana
        setTitle("Sistema de Parqueadero");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Etiquetas y campos de texto
        JLabel lblPlaca = new JLabel("Placa:");
        lblPlaca.setBounds(20, 20, 100, 25);
        add(lblPlaca);

        txtPlaca = new JTextField();
        txtPlaca.setBounds(120, 20, 200, 25);
        add(txtPlaca);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(20, 60, 100, 25);
        add(lblMarca);

        txtMarca = new JTextField();
        txtMarca.setBounds(120, 60, 200, 25);
        add(txtMarca);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(20, 100, 100, 25);
        add(lblModelo);

        txtModelo = new JTextField();
        txtModelo.setBounds(120, 100, 200, 25);
        add(txtModelo);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(20, 140, 100, 25);
        add(lblTipo);

        txtTipo = new JTextField();
        txtTipo.setBounds(120, 140, 200, 25);
        add(txtTipo);

        // Botones
        JButton btnRegistrarEntrada = new JButton("Registrar Entrada");
        btnRegistrarEntrada.setBounds(20, 180, 150, 25);
        add(btnRegistrarEntrada);

        JButton btnRegistrarSalida = new JButton("Registrar Salida");
        btnRegistrarSalida.setBounds(180, 180, 150, 25);
        add(btnRegistrarSalida);

        JButton btnConsultarEstado = new JButton("Consultar Estado");
        btnConsultarEstado.setBounds(20, 220, 150, 25);
        add(btnConsultarEstado);

        JButton btnGenerarReporte = new JButton("Generar Reporte");
        btnGenerarReporte.setBounds(180, 220, 150, 25);
        add(btnGenerarReporte);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(100, 260, 150, 25);
        add(btnSalir);

        // Acción del botón "Registrar Entrada"
        btnRegistrarEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();
                String marca = txtMarca.getText();
                String modelo = txtModelo.getText();
                String tipo = txtTipo.getText();

                Vehiculo vehiculo = new Automovil(placa, marca, modelo, LocalDateTime.now(), tipo);
                parqueadero.registrarEntrada(vehiculo);
                JOptionPane.showMessageDialog(null, "Vehículo registrado con éxito.");

                // Limpiar los campos
                limpiarCampos();
            }
        });

        // Acción del botón "Registrar Salida"
        btnRegistrarSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();
                try {
                    double costo = parqueadero.registrarSalida(placa);
                    JOptionPane.showMessageDialog(null, "Costo del parqueo: $" + costo);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                // Limpiar los campos
                limpiarCampos();
            }
        });

        // Acción del botón "Consultar Estado"
        btnConsultarEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder estado = new StringBuilder();
                for (Vehiculo vehiculo : parqueadero.getVehiculos()) {
                    estado.append("Placa: ").append(vehiculo.getPlaca())
                          .append(", Marca: ").append(vehiculo.getMarca())
                          .append(", Modelo: ").append(vehiculo.getModelo()).append("\n");
                }

                if (estado.length() == 0) {
                    estado.append("El parqueadero está vacío.");
                }

                JOptionPane.showMessageDialog(null, estado.toString());
            }
        });

        // Acción del botón "Generar Reporte"
        btnGenerarReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder reporte = new StringBuilder("Reporte de Vehículos del Día:\n");
                for (Vehiculo vehiculo : parqueadero.getVehiculosUsadosHoy()) {
                    reporte.append("Placa: ").append(vehiculo.getPlaca())
                           .append(", Marca: ").append(vehiculo.getMarca())
                           .append(", Modelo: ").append(vehiculo.getModelo()).append("\n");
                }
                if (reporte.length() == 0) {
                    reporte.append("No hay vehículos registrados hoy.");
                }

                JOptionPane.showMessageDialog(null, reporte.toString());
            }
        });

        // Acción del botón "Salir"
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // Método para limpiar los campos
    private void limpiarCampos() {
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtTipo.setText("");
    }

    public static void main(String[] args) {
        InterfazGraficaParqueadero frame = new InterfazGraficaParqueadero();
        frame.setVisible(true);
    }
}
