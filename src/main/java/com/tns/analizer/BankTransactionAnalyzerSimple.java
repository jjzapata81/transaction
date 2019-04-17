package com.tns.analizer;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class BankTransactionAnalyzerSimple {

    private static final String FILE = "src/test/resources/transactions.csv";

    public void execute() {
        try{
            //System.out.println("Estamos listos para empezar!!");            ;
            Pago pago = new Pago();
            BufferedReader br = new BufferedReader(new FileReader(FILE));
            List<Pago> listaPago = new ArrayList();
            int total = 0, totalEnero = 0;
            String tipoNumero, fPago, linea = br.readLine();

            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            while (linea != null) {

                String[] arreglo = linea.split(",");
                Date fechaPago = simpleDateFormat.parse(arreglo[0]);

                pago.setFecha_pago(fechaPago);
                pago.setMonto(Integer.valueOf(arreglo[1]));
                pago.setDescripcion(arreglo[2]);

                listaPago.add(pago);
                pago= new Pago();
                linea = br.readLine();
            }

            Iterator<Pago> itp = listaPago.iterator();
            while (itp.hasNext()) {
                Pago p = itp.next();
                 total += p.getMonto();
                 fPago = simpleDateFormat.format(p.getFecha_pago());
                 System.out.println(fPago);
                 String[] cadenaFecha = fPago.split("-");

                 if (cadenaFecha[1].equals("01")) {
                     totalEnero += p.getMonto();
                 }
            }
            if (total > 0) {
                tipoNumero = "Positivo";
            } else {
                tipoNumero = "Negativo";
            }

            System.out.println("El total es: "+total+" y es "+tipoNumero+"\n");
            System.out.println("El monto total de Enero es: "+totalEnero);

            //System.out.println(pago.calcularTotal());

        }catch (Exception e){
            System.out.println("Error...");
            System.out.println(e.getMessage());
        }

    }
}




