/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caso.de.estudio.pkg1;

import javax.swing.JOptionPane;

/**
 *
 * @author josem
 */
public class Ejercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 5 facturas
        Factura[] facturas = new Factura[5];

        // Solicitar los datos de cada factura mediante cuadros de diálogo
        for (int i = 0; i < 5; i++) {
            String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            String cedulaCliente = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
            String codigoFactura = JOptionPane.showInputDialog("Ingrese el código de la factura:");
            double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto de la factura:"));
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de la factura (1-12):"));
            int contieneElectricos = Integer.parseInt(JOptionPane.showInputDialog("¿Contiene eléctricos? (1 para sí, 0 para no):"));
            int contieneAutomotrices = Integer.parseInt(JOptionPane.showInputDialog("¿Contiene automotrices? (1 para sí, 0 para no):"));
            int contieneConstruccion = Integer.parseInt(JOptionPane.showInputDialog("¿Contiene construcción? (1 para sí, 0 para no):"));

            facturas[i] = new Factura(nombreCliente, cedulaCliente, codigoFactura, monto, mes, contieneElectricos, contieneAutomotrices, contieneConstruccion);
        }

        // Variable para acumular el monto total
        double totalMonto = 0;
        double totalComision = 0;
        int totalPuntos = 0;

        // Bucle de las facturas y calcular los totales
        for (Factura factura : facturas) {
            // Acumular el monto total
            totalMonto += factura.monto;

            // comisión y los puntos de cada factura
            double comision = 0;
            int puntos = 0;

            // categorías de productos
            if (factura.contieneElectricos == 1 && factura.contieneAutomotrices == 1 && factura.contieneConstruccion == 1) {
                comision += factura.monto * 0.10;
                puntos += 3;
            }

            if (factura.contieneElectricos == 1) {
                comision += factura.monto * 0.04;
                puntos += 1;
            }

            if (factura.contieneAutomotrices == 1) {
                comision += factura.monto * 0.04;
                puntos += 1;
            }

            if (factura.contieneConstruccion == 1) {
                comision += factura.monto * 0.08;
                puntos += 2;
            }

            // la factura es mayor a 50000
            if (factura.monto > 50000) {
                comision += factura.monto * 0.05;
                puntos += 1;
            }

            // comisión y los puntos totales
            totalComision += comision;
            totalPuntos += puntos;
        }

        //  supera los 300000
        if (totalMonto > 300000) {
            totalComision += 20000;
        }

        // resultados 
        JOptionPane.showMessageDialog(null, "Total Monto: " + totalMonto);
        JOptionPane.showMessageDialog(null, "Total Comision: " + totalComision);
        JOptionPane.showMessageDialog(null, "Total Puntos: " + totalPuntos);

        // Información adicional del vendedor
        String vendedorNombre = "Juanito Chacon";
        String vendedorCodigo = "A14422";
        String mes = "junio";
        double totalFacturas = 185000;
        double totalComisiones = 11500;
        int puntosObtenidos = totalPuntos;
        String logroBonoExtra = (totalMonto > 300000) ? "sí" : "no";
        String tieneVehiculo = "sí";
        String sucursal = "Heredia";

        // información del vendedor 
        String mensaje = String.format(
            "El Agente Vendedor \"%s\" código: %s en el mes de %s.\n\n" +
            "Vendió un total de %.2f en facturas\n" +
            "Obtuvo un total en comisiones de %.2f\n" +
            "El agente vendedor %s logro el objetivo de llegar al BONO EXTRA.\n" +
            "Puntos obtenidos por el vendedor: %d\n" +
            "El Agente Vendedor %s cuenta con vehículo propio\n" +
            "Sucursal: %s",
            vendedorNombre, vendedorCodigo, mes, totalFacturas, totalComisiones,
            logroBonoExtra, puntosObtenidos, tieneVehiculo, sucursal
        );

        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Atributos
    static class Factura {
        String nombreCliente;
        String cedulaCliente;
        String codigoFactura;
        double monto;
        int mes;
        int contieneElectricos;
        int contieneAutomotrices;
        int contieneConstruccion;

        // clase Factura
        public Factura(String nombreCliente, String cedulaCliente, String codigoFactura, double monto, int mes,
                       int contieneElectricos, int contieneAutomotrices, int contieneConstruccion) {
            this.nombreCliente = nombreCliente;
            this.cedulaCliente = cedulaCliente;
            this.codigoFactura = codigoFactura;
            this.monto = monto;
            this.mes = mes;
            this.contieneElectricos = contieneElectricos;
            this.contieneAutomotrices = contieneAutomotrices;
            this.contieneConstruccion = contieneConstruccion;
        }
    }
}

    
