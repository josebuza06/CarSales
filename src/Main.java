import java.io.*;

public class Main {
    public static void main(String[] args) {
        String ruta="C:\\Users\\Jose Buzani\\Downloads\\car_sales.csv";//ruta del archivo que lee
        String newRuta= "C:\\Users\\Jose Buzani\\Downloads\\tabla_suma.csv";//ruta del nuevo archivo que creamos
        try {

            BufferedReader br= new BufferedReader(new FileReader(ruta));
            BufferedWriter writer= new BufferedWriter(new FileWriter(newRuta));

            String line;

            boolean primerLinea= true;//boolean para saber si es el encabezado

            double res=0;

            while ((line= br.readLine()) != null){//ciclo para que lea lineas hasta que se acaben
                if (primerLinea){
                    primerLinea=false;//cambia el valor de primerLinea si da como true que es la primera linea para que pueda empezar a leer
                    continue;
                }
                String[] separador= line.split(",");
                double sales= Double.parseDouble(separador[4].replace("$","").trim());//variable que va guardando las ventas y elimina los $

                res+=sales;//suma los valores al contador

            }//end while

            writer.write("Resultado:"+","+"$"+ res);//escritura del resultado en el archivo csv

            br.close();//cerrar buffered reader
            writer.close();//cerrar buffered writer

            System.out.println("Hecho");
        }catch (IOException e){
            System.out.println("Error al escribir en el archivo"+ e.getMessage());
        }
    }
}