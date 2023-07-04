package Libreria;

import Libreria.Entidades.Autor;
import Libreria.Entidades.Editorial;
import Libreria.Persistencias.AutorDAO;
import Libreria.Persistencias.EditorialDAO;
import Utilidades.Menu.ServiciosMenu;
import com.mysql.jdbc.Messages;
import java.util.List;
import java.util.UUID;

/*
1) Crear base de datos Librería
2) Crear unidad de persistencia
3) Crear entidades previamente mencionadas (excepto Préstamo) 
4) Generar las tablas con JPA
5) Crear servicios previamente mencionados.
6) Crear los métodos para persistir entidades en la base de datos librería
7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
8) Búsqueda de un Autor por nombre.
9) Búsqueda de un libro por ISBN.
10) Búsqueda de un libro por Título. 
11) Búsqueda de un libro/s por nombre de Autor.
12) Búsqueda de un libro/s por nombre de Editorial.
13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación: 
• Validar campos obligatorios.
• No ingresar datos duplicados.
 */


/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ServiciosMenu sm = new ServiciosMenu();
        Editorial ed = new Editorial();
        Autor au = new Autor();
        
        EditorialDAO eDAO = new EditorialDAO();
        AutorDAO aDAO = new AutorDAO();
        
        System.out.println("Objeto autor");
        au.setNombre("Vargas Llosas");
        au.setAlta(true);
        au.setId(UUID.randomUUID().toString());
        System.out.println("Objeto antes de pasarlo a la base de datos");
        System.out.println(au);
        System.out.println("");
        System.out.println("pasando objeto a la base de datos");
        aDAO.guardar(au);
        System.out.println("");
        System.out.println("Obteniendo objedo de la base de datos");
        System.out.println("Lista");
        List<Autor> l = aDAO.ListaCompleta();
        for (Autor a : l) {
            System.out.println(a);
        }
        System.out.println("individual");
        System.out.println(aDAO.autorPorNombre(au.getNombre()));
        System.out.println("");
        System.out.println("objeto Editorial");
        
        ed.setNombre("Editorial Planeta");
        ed.setAlta(true);
        ed.setId(UUID.randomUUID().toString());
        System.out.println("Objeto antes de pasarlo a la base de datos");
        System.out.println(ed);
        System.out.println("");
        System.out.println("pasando objeto a la base de datos");
        eDAO.guardar(ed);
        System.out.println("");
        System.out.println("Obteniendo objedo de la base de datos");
        
        System.out.println(eDAO.EditorialPorNombre(ed.getNombre()));
        
        System.out.println("");
        System.out.println("Creando varias ediotriales:");
        for (int i = 0; i < 10; i++) {
            ed.setNombre("Editorial Planeta"+i);
        ed.setAlta(true);
        ed.setId(UUID.randomUUID().toString());
        eDAO.guardar(ed);
        }
        System.out.println("Lista de nombres:");
        List<String> ln = eDAO.listaDeNombres();
        System.out.println("");
        
        System.out.println("Eliminado informacion");
        String mc = sm.getStringMC(sm.multipleChoice(ln, "Pruba1"));
        
        eDAO.eliminar(eDAO.EditorialPorNombre(mc));
        ln = eDAO.listaDeNombres();
        for (String string : ln) {
            System.out.println(string);
        }
        for (String string : ln) {
             eDAO.eliminar(eDAO.EditorialPorNombre(string));
        }
        aDAO.eliminar(aDAO.autorPorNombre(au.getNombre()));
    }
    
}
