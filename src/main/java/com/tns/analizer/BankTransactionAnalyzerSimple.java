package com.tns.analizer;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.text.SimpleDateFormat;


public class BankTransactionAnalyzerSimple {

    Path FILE = Paths.get("src/test/resources", "transactions.csv");

    public void execute() {

        try {

            System.out.println("Estamos listos para empezar!!");
            List<String> lines = Files.readAllLines(FILE);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            int i;
            int rode = 0;
            int rode_month = 0;
            int max = 0;

            Date fecha;
            String start = "31-12-2017";
            String end = "31-01-2018";
            String linea;
            String category="";
            Map<String, Integer> categoria = new HashMap<>();
            for (i = 0; i < lines.size(); i++) {
                linea = lines.get(i);
                String[] partss = linea.split(",");
                rode += Integer.parseInt(partss[1]);

                fecha = dateFormat.parse(partss[0]);

                if (fecha.after(dateFormat.parse(start)) && fecha.before(dateFormat.parse(end))) {
                    rode_month += Integer.parseInt(partss[1]);
                }

                if (categoria.get(partss[2]) == null) {
                    categoria.put(partss[2], Integer.parseInt(partss[1]));

                } else {
                    categoria.put(partss[2], categoria.get(partss[2]) + Integer.parseInt(partss[1]));

                    max = categoria.get(partss[2]);
                    category = partss[2];
                }
            }

            System.out.println(" 1 ) el monto total es de " + rode);

            if (rode < 0) {
                System.out.println(" 2 ) el monto es negativo");
            } else if (rode >= 0) {
                System.out.println("2 )el monto es positivo");
            }
            System.out.println(" 3 ) el monto total del mes de enero es " + rode_month);
            System.out.println("4 )La categoria " + category + " es de " + max);

        } catch (Exception e) {
            System.out.println("Error...");
            System.out.println(e.getMessage());
        }

    }

}




