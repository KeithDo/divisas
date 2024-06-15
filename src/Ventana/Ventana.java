package Ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import static javax.swing.JOptionPane.showInputDialog;

public class Ventana extends JFrame {
    private JPanel panelI, panelD;
    private JLabel appLogo, lblTitulo, keithdo;
    private JButton btnDivisa, btnTemperatura;

    public Ventana(String titulo) {

        this.setTitle(titulo);
        this.setIconImage(new ImageIcon(getClass().getResource("imgs/logo.png")).getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1000,800));
        this.setLocation(0,0);
        this.setResizable(false);
        this.setLayout(null);
        this.paneles();
        this.appLogo();
        this.panelD();
        this.agregarBotones();
        this.setLocationRelativeTo(null);
    }

    private void paneles() {
        this.panelI = new JPanel();
        this.panelI.setSize(new Dimension(500, 800));
        this.panelI.setBackground(new Color(21,36,61));
        this.panelI.setLocation(0,0);
        this.panelI.setLayout(null);
        this.getContentPane().add(this.panelI);

        this.panelD = new JPanel();
        this.panelD.setSize(new Dimension(500, 800));
        this.panelD.setBackground(new Color(198,198,198));
        this.panelD.setLocation(500,0);
        this.panelD.setLayout(null);
        this.getContentPane().add(this.panelD);
    }

    private void appLogo() {
        this.appLogo = new JLabel();
        this.appLogo.setSize(new Dimension(438,202));
        this.appLogo.setOpaque(false);
        this.appLogo.setLocation(31,299);
        this.appLogo.setIcon(new ImageIcon("src/Ventana/imgs/alura.png"));
        this.panelI.add(this.appLogo);
    }

    private void panelD() {
        this.lblTitulo = new JLabel();
        this.lblTitulo.setLocation(24,50);
        this.lblTitulo.setOpaque(false);
        this.lblTitulo.setSize(new Dimension(451,67));
        this.lblTitulo.setIcon(new ImageIcon("src/Ventana/imgs/lblTitulo.png"));
        this.panelD.add(this.lblTitulo);

        this.keithdo = new JLabel();
        this.keithdo.setSize(new Dimension(178,27));
        this.keithdo.setLocation(161,700);
        this.keithdo.setIcon(new ImageIcon("src/Ventana/imgs/keithdo.png"));
        this.panelD.add(this.keithdo);
    }

    private void agregarBotones() {
        Dimension dimension = new Dimension(336,100);
        this.btnDivisa = new JButton();
        this.btnDivisa.setLocation(82,200);
        this.btnDivisa.setSize(dimension);
        this.btnDivisa.setOpaque(true);
        this.btnDivisa.setBackground(null);
        this.btnDivisa.setBorder(null);
        this.btnDivisa.setIcon(new ImageIcon("src/Ventana/imgs/btnDivisa.png"));
        this.panelD.add(this.btnDivisa);
        this.btnDivisa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] opciones = {
                        "De pesos Colombianos a Dólar",
                        "De pesos Colombianos a Euros",
                        "De pesos Colombianos a Libras Esterlinas",
                        "De pesos Colombianos a Yen Japonés",
                        "De pesos Colombianos a Won sul-coreano",
                        "De Dólar a pesos colombianos",
                        "De Euros a pesos colombiano",
                        "De Libras Esterlinas a pesos colombianos",
                        "De Yen Japonés a pesos colombianos",
                        "De Won sul-coreano a pesos colombianos"
                };

                ImageIcon icono = new ImageIcon("src/Ventana/imgs/logo.png");
                var opcion = JOptionPane.showInputDialog(
                        null,
                        "Mensaje de bienvenida",
                        "Conversor de divisa",
                        JOptionPane.INFORMATION_MESSAGE,
                        icono,
                        opciones,
                        opciones[0]
                );
                //JOptionPane.showMessageDialog(null, new Notacion().conectar());
                int cantidad = Integer.parseInt(showInputDialog(null,"Ingrese la cantidad de dinero que deseas convertir"));
                var notacion = new Notacion().retorno().getConversion_rates();
                if (opcion == "De pesos Colombianos a Dólar") {
                    JOptionPane.showMessageDialog(null,"El valor de " + cantidad + " es de " + (cantidad * Double.parseDouble(notacion.get("USD").toString())));
                    System.out.println(notacion.get("COL").toString());
                } else if (opcion == "De pesos Colombianos a Euros") {
                    JOptionPane.showMessageDialog(null,"El valor de " + cantidad + " es de " + (cantidad * Double.parseDouble(notacion.get("EUR").toString())));
                } else if (opcion == "De pesos Colombianos a Libras Esterlinas") {
                    JOptionPane.showMessageDialog(null,"El valor de " + cantidad + " es de " + (cantidad * Double.parseDouble(notacion.get("GBP").toString())));
                } else if (opcion == "De pesos Colombianos a Yen Japonés") {
                    JOptionPane.showMessageDialog(null,"El valor de " + cantidad + " es de " + (cantidad * Double.parseDouble(notacion.get("JPY").toString())));
                } else if (opcion == "De pesos Colombianos a Won sul-coreano") {
                    JOptionPane.showMessageDialog(null,"El valor de " + cantidad + " es de " + (cantidad * Double.parseDouble(notacion.get("KRW").toString())));
                } else if (opcion == "De Dólar a pesos colombianos") {
                    JOptionPane.showMessageDialog(null,"El valor de " + cantidad + " es de " + (Double.parseDouble(notacion.get("USD").toString()) / cantidad));
                } else if (opcion == "De Euros a pesos colombiano") {
                    JOptionPane.showMessageDialog(null,"El valor de " + cantidad + " es de " + (Double.parseDouble(notacion.get("EUR").toString()) / cantidad));
                } else if (opcion == "De Libras Esterlinas a pesos colombianos") {
                    JOptionPane.showMessageDialog(null,"El valor de " + cantidad + " es de " + (Double.parseDouble(notacion.get("GBP").toString()) / cantidad));
                } else if (opcion == "De Yen Japonés a pesos colombianos") {
                    JOptionPane.showMessageDialog(null,"El valor de " + cantidad + " es de " + (Double.parseDouble(notacion.get("JPY").toString()) / cantidad));
                } else if (opcion == "De Won sul-coreano a pesos colombianos") {
                    JOptionPane.showMessageDialog(null,"El valor de " + cantidad + " es de " + (Double.parseDouble(notacion.get("KRW").toString()) / cantidad));
                }
            }
        });

        this.btnTemperatura = new JButton();
        this.btnTemperatura.setLocation(82,360);
        this.btnTemperatura.setSize(dimension);
        this.btnTemperatura.setOpaque(true);
        this.btnTemperatura.setBackground(null);
        this.btnTemperatura.setBorder(null);
        this.btnTemperatura.setIcon(new ImageIcon("src/Ventana/imgs/btnTemperatura.png"));
        this.panelD.add(this.btnTemperatura);
        this.btnTemperatura.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int cantidad = Integer.parseInt((JOptionPane.showInputDialog(null, "Ingrese la cantidad de grados a convertir")));
                String[] opciones = {
                        "De grados Celsius a grados Fahrenheit",
                        "De grados Celsius a grados Kelvin",
                        "De grados Celsius a grados Rankine",
                        "De grados Fahrenheit a grados Celsius",
                        "De grados Fahrenheit a grados Kelvin",
                        "De grados Fahrenheit a grados Rankine",
                        "De grados Kelvin a grados Celsius",
                        "De grados Kelvin a grados Fahrenheit",
                        "De grados Rankine a grados Celsius"
                };

                ImageIcon icono = new ImageIcon("src/Ventana/imgs/logo.png");
                var opcion = showInputDialog(
                        null,
                        "Escoja el tipo de grado a convertir",
                        "Conversión de grados de temperatura",
                        JOptionPane.QUESTION_MESSAGE,
                        icono,
                        opciones,
                        opciones[0]
                );

                if (opcion == "De grados Celsius a grados Fahrenheit") {
                    JOptionPane.showMessageDialog(null, "Conversión de " + cantidad + " grados Celsius a grados Fahrenheit es igual a " + ((cantidad * 1.8) + 32));
                } else if (opcion == "De grados Celsius a grados Kelvin") {
                    JOptionPane.showMessageDialog(null, "Conversión de " + cantidad + " grados Celsius a grados Kelvin es igual a " + (cantidad + 273.15));
                } else if (opcion == "De grados Celsius a grados Rankine") {
                    JOptionPane.showMessageDialog(null, "Conversión de " + cantidad + " grados Celsius a grados Rankine es igual a " + ((cantidad + 273.15) * 1.8));
                } else if (opcion == "De grados Fahrenheit a grados Celsius") {
                    JOptionPane.showMessageDialog(null, "Conversión de " + cantidad + " grados Celsius a grados Rankine es igual a " + ((cantidad - 32) / 1.8));
                } else if (opcion == "De grados Fahrenheit a grados Kelvin") {
                    JOptionPane.showMessageDialog(null, "Conversión de " + cantidad + " grados Celsius a grados Rankine es igual a " + ((cantidad + 459.67) / 1.8));
                } else if (opcion == "De grados Fahrenheit a grados Rankine") {
                    JOptionPane.showMessageDialog(null, "Conversión de " + cantidad + " grados Celsius a grados Rankine es igual a " + ((cantidad + 459.67) / 1.8));
                } else if (opcion == "De grados Kelvin a grados Celsius") {
                    JOptionPane.showMessageDialog(null, "Conversión de " + cantidad + " grados Celsius a grados Rankine es igual a " + (cantidad - 273.15));
                } else if (opcion == "De grados Kelvin a grados Fahrenheit") {
                    JOptionPane.showMessageDialog(null, "Conversión de " + cantidad + " grados Celsius a grados Rankine es igual a " + ((9 * cantidad) - 459.67));
                } else if (opcion == "De grados Rankine a grados Celsius") {
                    JOptionPane.showMessageDialog(null, "Conversión de " + cantidad + " grados Celsius a grados Rankine es igual a " + ((cantidad / 1.8) - 273.15));
                }
            }
        });
    }
}
