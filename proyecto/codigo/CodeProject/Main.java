import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Eduard Damiam y Esteban Osorio
 */
public class Main {
    public static final int space = 32;
    public static final int nothing = 160;
    public static TablaHash tabla = new TablaHash();

    public static void main(String [] args){
        leer();
        System.out.println("gg");
    }

    public static void leer(){
        try {
            BufferedReader input = new BufferedReader(new FileReader("ejemplito.txt")); //lee el archivo
            String key = ""; // var para manejar key
            String key2= ""; // var para manejar key
            String read; // var para mejar la lectura
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
                            if (Character.isLetter(read.charAt(i))){
                                Carpeta x = new Carpeta (read.substring (i), key);
                                key2 = tabla.funcionHash(x);
                                tabla.add(x);
                                break;
                            }
                        }
                    }
                    else {
                        leeraux(read,key2,input,3,key);
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

    public static void leeraux(String read,String key,BufferedReader input,int x,String original)throws Exception{
        String key2 = "";
        for (int i=0; i<read.length(); i++){
            if(read.charAt(i)=='['){
                while(read.charAt(i)!=']'){
                    i++;
                }
            }
            if (Character.isLetter(read.charAt(i))){
                Carpeta y = new Carpeta (read.substring(i),key);
                key2=tabla.funcionHash(y);
                tabla.add(y);
                break;
            }
        }

        while ((read=input.readLine())!= null){
            if (read.equals("")){
                return;
            }
            if (read.charAt(0) == '│'){ 
                if ((int)read.charAt(x)==space ||(int)read.charAt(x)==nothing) {
                    if ((int)read.charAt(x+3)==32){
                        leeraux(read,key2,input,x+3,original);
                    }
                    else {
                        for (int i =x ; i< read.length();i++){
                            if (read.charAt(i)=='['){
                                while (read.charAt(i)!=']'){
                                    i++;
                                }
                            }
                            if (Character.isLetter(read.charAt(i))){
                                Carpeta y = new Carpeta (read.substring(i),key);
                                key2 = tabla.funcionHash(y);
                                tabla.add(y);
                                break;
                            }
                        }
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
                    if (Character.isLetter(read.charAt(i))){
                        Carpeta y = new Carpeta (read.substring(i),original);
                        tabla.add(y);
                        break;
                    }
                }
                return;
            }
        }
    }
}
