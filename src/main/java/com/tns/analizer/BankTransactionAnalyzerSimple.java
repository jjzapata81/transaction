package com.tns.analizer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankTransactionAnalyzerSimple {

    private static final String FILE = "src/test/resources/transactions.csv";
    private long montoTotal = 0;
    private long montoTotalEnero = 0;
    private String categorias[];
    private List<Transaccion> lstTra = new ArrayList<>();
    private Transaccion oTra;

    public void execute() {
        try{
            FileReader fr = new FileReader(FILE);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            boolean entro = false;

            while(linea != null){
                String fecha = linea.split(",")[0];
                long monto = Long.parseLong(linea.split(",")[1]);
                String categoria = linea.split(",")[2];
                oTra = new Transaccion(fecha, monto, categoria);
                lstTra.add(oTra);
                linea = br.readLine();
                entro = true;
            }
            if(entro) {
                //MONTO TOTAL DEL ARCHIVO
                montoTotal = MontoTotal(lstTra);
                System.out.println("1. Monto Total: " + montoTotal);

                //MONTO NEGATIVO O POSITIVO
                String valor = (montoTotal > 0) ? "Positivo" : "Negativo";
                System.out.println("2. El monto es: " + valor);

                //TOTAL MONTO ENERO
                montoTotalEnero = MontoTotalMes(lstTra);
                System.out.println("3. Monto total enero: " + montoTotalEnero);

                //CATEGORIA MAYOR MONTO
                categorias = ValorMayorGasto(lstTra);
                System.out.println("4. Categoria: " + categorias[0] + " || Monto: " + categorias[1]);
            }else{
                System.out.println("Archivo vacío");
            }



            /*
            //CATEGORIA QUE MAYOR GASTO GENERA
            long gastos[] = new long[6];
            List<String> categorias = new ArrayList<>();
            categorias.add("Gastos de representacion");
            categorias.add("Alimentacion");
            categorias.add("Entretenimiento");
            categorias.add("Ventas netas");
            categorias.add("Cobro cuenta");
            categorias.add("Renta");

            for (Transaccion t : lstTra) {
                switch (t.getCategoria()){
                    case "Gastos de representacion":
                        gastos[0] = gastos[0] + t.getMonto();
                        break;
                    case "Alimentacion":
                        gastos[1] = gastos[1] + t.getMonto();
                        break;
                    case "Entretenimiento":
                        gastos[2] = gastos[2] + t.getMonto();
                        break;
                    case "Ventas netas":
                        gastos[3] = gastos[3] + t.getMonto();
                        break;
                    case "Cobro cuenta":
                        gastos[4] = gastos[4] + t.getMonto();
                        break;
                    case "Renta":
                        gastos[5] = gastos[5] + t.getMonto();
                        break;

                }
            }
            long menor = gastos[0];
            int j = 0;

            for (int i =  0 ; i<gastos.length ; i++){
                if(menor > gastos[i]){
                    menor = gastos[i];
                    j = i;
                }
            }
            System.out.println("4. Categoria: " + categorias.get(j) + " || Monto: " + menor);




            /*String valor = "";
            long montoTotalEnero = 0;
            long montoTotal = 0;
            List<String> categorias = new ArrayList();

            boolean existe = false;
            List<String> archivo = new ArrayList<>();



            while(linea != null){
                long suma = 0;
                archivo.add(linea);
                montoTotal += Long.parseLong(linea.split(",")[1]);
                if(linea.split(",")[0].substring(3,5).equals("01")){
                    montoTotalEnero += Long.parseLong(linea.split(",")[1]);
                }
                for (String c: categorias) {
                    if(c.equals(linea.split(",")[2])){
                        existe = true;
                    }
                }
                if(!existe){
                    categorias.add(linea.split(",")[2]);


                }
                existe = false;


                */
/*
                for (int i = 0; i<categorias.size();i++){
                    if( linea.split(",")[2].equals(categorias.get(i) )){
                        suma = suma + Long.parseLong(linea.split(",")[1]);
                        //suma = suma + gastos.get(i);

                    }
                }
                suma = 0;
                linea = br.readLine();

            }
             br.close();

            long gastos[] = new long[categorias.size()];

            for (int j = 0; j<archivo.size();j++) {
                linea = archivo.get(j);
                long suma = Long.parseLong(linea.split(",")[1]);
                for (int i = 0; i < categorias.size(); i++) {
                    if (linea.split(",")[2].equals(categorias.get(i))) {
                        gastos[i] =

                    }
                }





            }

*/


            System.out.println("Estamos listos para empezar!!");
        }catch (Exception e){
            System.out.println("Error...");
            System.out.println(e.getMessage());
        }

    }

    public static long MontoTotal(List<Transaccion> t){
        long total = 0;
        for (Transaccion tr : t){
            total += tr.getMonto();
        }
        return total;
    }

    public static  long MontoTotalMes(List<Transaccion> t){
        long total = 0;
        for (Transaccion tr : t){
            if(tr.getFecha().substring(3,5).equals("01")){
                total += tr.getMonto();
            }
        }
        return total;
    }

    private static String CategoriaMayorGasto(int j){

        long gastos[] = new long[6];
        List<String> categorias = new ArrayList<>();
        categorias.add("Gastos de representacion");
        categorias.add("Alimentacion");
        categorias.add("Entretenimiento");
        categorias.add("Ventas netas");
        categorias.add("Cobro cuenta");
        categorias.add("Renta");
        return categorias.get(j);
    }

    public static String[] ValorMayorGasto(List<Transaccion> t){
        long gastos[] = new long[6];

        for (Transaccion tr : t) {
            switch (tr.getCategoria()){
                case "Gastos de representacion":
                    gastos[0] = gastos[0] + tr.getMonto();
                    break;
                case "Alimentacion":
                    gastos[1] = gastos[1] + tr.getMonto();
                    break;
                case "Entretenimiento":
                    gastos[2] = gastos[2] + tr.getMonto();
                    break;
                case "Ventas netas":
                    gastos[3] = gastos[3] + tr.getMonto();
                    break;
                case "Cobro cuenta":
                    gastos[4] = gastos[4] + tr.getMonto();
                    break;
                case "Renta":
                    gastos[5] = gastos[5] + tr.getMonto();
                    break;

            }
        }

        long mayor = gastos[0];
        int j = 0;

        for (int i =  0 ; i<gastos.length ; i++){
            if(mayor > gastos[i]){
                mayor = gastos[i];
                j = i;
            }
        }
        String categoria[] = new String[2];
        categoria[0] = CategoriaMayorGasto(j);
        categoria[1] = String.valueOf(mayor);

        return categoria;
    }

}




