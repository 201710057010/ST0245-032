import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Eduard Damiam y Esteban Osorio
 */
public class Main {
    public static final int space = 32;
    public static final int nothing = 160;
    public static TablaHash tabla = new TablaHash();

    public static void main(String [] args){
        leer();
        try{ 
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            System.out.println ("¿que carpeta desea buscar?");
            while(true){
                String buscado = read.readLine();
                long currentTime = System.currentTimeMillis();
                buscar(buscado);
                System.out.println(System.currentTimeMillis()-currentTime);
            }
        }
        catch (Exception e){
            System.out.println("a ocurrido un error :(");
        }
    }

    public static void leer(){
        try {
            BufferedReader input = new BufferedReader(new FileReader("treeEtc.txt")); //lee el archivo
            String key = ""; // var para manejar key
            String key2= ""; // var para manejar key
            String read; // var para manejar la lectura
            while ((read = input.readLine()) != null){
                if (!read.equals("") && !Character.isDigit(read.charAt(0))){
                    if (read.charAt(0) == '/' ){
                        Carpeta x = new Carpeta (read.substring(1));
                        key = tabla.funcionHash(x);
                        tabla.add(x);
                    }
                    else if (Character.isLetter(read.charAt(0))){
                        Carpeta x= new Carpeta (read.substring(0,read.length()-1));
                        key = tabla.funcionHash(x);
                        tabla.add(x);
                    }
                    else if (read.charAt(0) == '├' || read.charAt(0)=='└'){
                        for (int i =0; i<read.length();i++){
                            if (read.charAt(i)== '['){
                                while(read.charAt(i)!= ']'){
                                    i++;
                                }
                            }
                            if (Character.isLetter(read.charAt(i))||Character.isDigit(read.charAt(i))){
                                Carpeta x = new Carpeta (read.substring (i), key);
                                key2 = tabla.funcionHash(x);
                                tabla.add(x);
                                break;
                            }
                        }
                    }
                    else {
                        key2 = leeraux(read,key2,input,3,key);
                    }
                }else {
                    break;
                }
            }
        }   
        catch (Exception e){ 
            System.out.println("no se encontro el archivo");
        }
    }

    public static String leeraux(String read,String key,BufferedReader input,int x,String original)throws Exception{
        String key2 = "";
        String z = "";
        for (int i=0; i<read.length(); i++){
            if(read.charAt(i)=='['){
                while(read.charAt(i)!=']'){
                    i++;
                }
            }
            if (Character.isLetter(read.charAt(i))||Character.isDigit(read.charAt(i))){
                Carpeta y = new Carpeta (read.substring(i),key);
                key2=tabla.funcionHash(y);
                tabla.add(y);
                break;
            }
        }

        while ((read=input.readLine())!= null){
            if (read.equals("")){
                return "";
            }
            if (read.charAt(0) == '│'){ 
                if (read.length()-1 >= x){
                    if ((int)read.charAt(x)==space ||(int)read.charAt(x)==nothing) {
                        if ((int)read.charAt(x+3)==space||(int)read.charAt(x+3)==nothing || (int)read.charAt(x+3)=='│'){
                            read = leeraux(read,key2,input,x+3,original);
                            if (Character.isDigit(read.charAt(0))){
                               return read;    
                            }
                            for (int i =0; i < x; i++){
                                if (read.charAt(i)=='├' || read.charAt(i)=='└'){
                                  return read;    
                                }
                            }
                            for (int i= x; i<read.length();i++){
                                if (read.charAt(i)=='['){
                                    while (read.charAt(i)!=']'){
                                        i++;
                                    }
                                }
                                if (Character.isLetter(read.charAt(i))||Character.isDigit(read.charAt(i))){
                                    Carpeta y = new Carpeta (read.substring(i),key);
                                    key2 = tabla.funcionHash(y);
                                    tabla.add(y);
                                    break;
                                }  
                            }
                        }
                        else {
                            for (int i =x ; i< read.length();i++){
                                if (read.charAt(i)=='['){
                                    while (read.charAt(i)!=']'){
                                        i++;
                                    }
                                }
                                if (Character.isLetter(read.charAt(i))||Character.isDigit(read.charAt(i))){
                                    Carpeta y = new Carpeta (read.substring(i),key);
                                    key2 = tabla.funcionHash(y);
                                    tabla.add(y);
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        return read;
                    }
                }
            }
            else {
                for (int i =0 ; i< read.length();i++){
                    if (read.charAt(i)=='['){
                        while (read.charAt(i)!=']'){
                            i++;
                        }
                    }
                    if (Character.isLetter(read.charAt(i))||Character.isDigit(read.charAt(i))){
                        Carpeta y = new Carpeta (read.substring(i),original);
                        z = tabla.funcionHash(y);
                        tabla.add(y);
                        break;
                    }
                }
                return z;
            }
        }
        return z;
    }

    private static void buscar (String carpeta) throws Exception{
        tabla.search(carpeta);
    }
}
