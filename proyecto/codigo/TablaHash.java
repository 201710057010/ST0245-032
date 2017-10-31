import java.util.*;
/**
 * 
 * Eduard Damiam Londoño y Esteban Osorio.
 * clase para la tabla hash
 */
public class TablaHash 
{
    HashMap <String,Carpeta> coleccionCarpetas;

    public TablaHash (){
        coleccionCarpetas=  new HashMap<String,Carpeta>();
    }

    public  void add(Carpeta carpeta){
        String key = funcionHash(carpeta);
        coleccionCarpetas.put(key,carpeta);
    }

    public String funcionHash(Carpeta carpeta){
        String hash = carpeta.nombre.hashCode() + ""; // se saca la key 
        if (coleccionCarpetas.containsKey(hash)) {
            for (int i = 1; i > -1; i++){ // si ya hay un elemento con esa key 
                if (!coleccionCarpetas.containsKey(hash + i )){// se hace una key igual a ella contanada i 
                    return hash + i;
                }
            }
        }
        return hash;
    }

    public void search (String nombre) throws Exception {
        String hash = nombre.hashCode() + "";
        String x = hash;
        if (!coleccionCarpetas.containsKey(hash)){
            System.out.println("la carpeta no existe");
        }else{
            int i =1;
            searchAux(hash);
            if (coleccionCarpetas.containsKey(x + i)){
                while (true){
                    hash = x + i;
                    searchAux (hash);
                    i++;
                    if (!coleccionCarpetas.containsKey(x + i)){
                        break;
                    }
                }
            }
        }
    }

    private  void searchAux(String hash){
        Carpeta carpeta = coleccionCarpetas.get(hash);
        String ruta = carpeta.nombre; 
        if (!carpeta.carpetaPadre.equals("")){
            while (true){
                carpeta = coleccionCarpetas.get(carpeta.carpetaPadre);
                ruta = carpeta.nombre + "/" + ruta; 
                if (carpeta.carpetaPadre.equals("")){
                    break;
                }
            }
        }
        System.out.println ("la ruta es : " + ruta); 
    }
}
