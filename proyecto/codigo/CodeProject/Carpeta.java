
/**
 * clase para manejar las carpetas
 * 
 * Eduard Damiam y Esteban Osorio
 */
public class Carpeta
{
    protected String nombre;
    protected String carpetaPadre;
    
    Carpeta(String nombre, String carpetaPadre){
      this.nombre= nombre;
      this.carpetaPadre= carpetaPadre;
    }
    
    Carpeta(String nombre){
      this.nombre= nombre;
      this.carpetaPadre= "";
    }
}
