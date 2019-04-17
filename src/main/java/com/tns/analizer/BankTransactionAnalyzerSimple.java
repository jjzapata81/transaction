package com.tns.analizer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import  java.util.Date;

public class BankTransactionAnalyzerSimple {


    private BufferedReader bf;

    public BankTransactionAnalyzerSimple() throws FileNotFoundException {
    }


    public void execute() {
        try{
            System.out.println("El valor total es:"+(this.monto_total()));
            System.out.println(this.valorNegativoPositivo(this.monto_total()));
            System.out.println("El monto total del mes de enero es: "+this.monto_mes("01"));
            System.out.println("La categoria que genera mas gastos es: "+this.categoriaConMasGasto());
            System.out.println("La categoria que genera mayor ingreso es: "+this.categoriaConMayorIngreso());
        }catch (Exception e){
            System.out.println("Error...");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public double monto_total() throws IOException {
        //strlinea y str transaccion toman el valor de la linea y el valor del dato respectivamente
        BufferedReader bf= this.bufferRead();
        String strLinea;
        double dblMontoTotal=0;
        //nos separa los datos en diferentes arreglos cuanod estos estan delimitados por ","
        while((strLinea  = bf.readLine())!=null){
        String[] strTransaction = strLinea.split(",");
        double dblValorMonto= Double.parseDouble(strTransaction[1]);
        dblMontoTotal=dblMontoTotal+dblValorMonto;
        }
        return dblMontoTotal;
    }
    public String valorNegativoPositivo(double dblValor) {

        if (dblValor < 0)
            return "El monto es negativo";
        else if (dblValor == 0)
            return "El monto es igual a 0";
        else
            return "El valor es positivo";

    }

    public double monto_mes(String mes) throws IOException, ParseException {
        String strLinea;
        double dblMontoTotal=0;
        BufferedReader bf= this.bufferRead();

        while((strLinea  = bf.readLine())!=null){

            String[] strTransaction = strLinea.split(",");
            String[] strMeses=strTransaction[0].split("-");

            if(strMeses[1].equals(mes)){
                double dblValorMonto= Double.parseDouble(strTransaction[1]);
                dblMontoTotal=dblMontoTotal+dblValorMonto;
            }

        }
        return dblMontoTotal;
    }
    public String categoriaConMasGasto() throws IOException, ParseException {
        String strLinea;
        double dblMontoTotal=0;
        int pos=0;
        BufferedReader bf= this.bufferRead();
        List<String> categoria = new ArrayList<String>();

        while((strLinea  = bf.readLine())!=null){

            String[] strTransaction = strLinea.split(",");

            if(categoria.contains(strTransaction[2])){
                pos = categoria.indexOf(strTransaction[2]);

                for(int x=0;x<categoria.size();x++) {
                    if(categoria.get(pos)==categoria.get(x)){
                        double operacion = Double.parseDouble(categoria.get(pos+1))+Double.parseDouble(strTransaction[1]);
                        categoria.set(pos+1,String.valueOf(operacion));
                    }
                }

            }
            else{

                categoria.add(strTransaction[2]);
                categoria.add(strTransaction[1]);

            }


        }
        double menor=0;
        String strMenor="";
        for (int x=1;x< categoria.size();x=x+2){

            if (Double.parseDouble(categoria.get(x))<menor){
                menor=Double.parseDouble(categoria.get(x));
                strMenor=categoria.get(x-1);
            }
        }
        return strMenor;
    }
    public String categoriaConMayorIngreso() throws IOException, ParseException {
        String strLinea;
        double dblMontoTotal=0;
        int pos=0;
        BufferedReader bf= this.bufferRead();
        List<String> categoria = new ArrayList<String>();

        while((strLinea  = bf.readLine())!=null){

            String[] strTransaction = strLinea.split(",");

            if(categoria.contains(strTransaction[2])){
                pos = categoria.indexOf(strTransaction[2]);

                for(int x=0;x<categoria.size();x++) {
                    if(categoria.get(pos)==categoria.get(x)){
                        double operacion = Double.parseDouble(categoria.get(pos+1))+Double.parseDouble(strTransaction[1]);
                        categoria.set(pos+1,String.valueOf(operacion));
                    }
                }

            }
            else{

                categoria.add(strTransaction[2]);
                categoria.add(strTransaction[1]);

            }


        }
        double mayor=0;
        String strMayor="";
        for (int x=1;x< categoria.size();x=x+2){

            if (Double.parseDouble(categoria.get(x))>mayor){
                mayor=Double.parseDouble(categoria.get(x));
                strMayor=categoria.get(x-1);
            }
        }
        return strMayor;
    }


public  BufferedReader bufferRead() throws FileNotFoundException {
      String FILE = "src/test/resources/transactions.csv";
    FileReader fr = new FileReader(FILE);
    bf = new BufferedReader(fr);
    return  new BufferedReader(fr);
    }


}




