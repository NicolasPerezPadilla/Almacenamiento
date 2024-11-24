import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.uninorte.BaseDeDatos;

public class TestAlmacenamiento {
    
    @Test
    public void testUnRegistro() {
 
        // nos aseguramos de que la base de datos esté vacía
        BaseDeDatos baseDeDatos= new BaseDeDatos();
        //baseDeDatos.BorrarTodo();

        // almacenamos un registro con estructura Boolean, Integer y String
        // se espera que el índice sea 001001
        // lo que significa que es el primer registro de la primera tabla
        assertEquals("001001", baseDeDatos.AgregarRegistro(Boolean.valueOf(false), Integer.valueOf(0), "Hola "));

        assertEquals(1, baseDeDatos.ObtenerNumeroTablas());

        assertEquals(1, baseDeDatos.ObtenerNumRegistrosEnTabla(1)); 

        baseDeDatos.BorrarTodo();
    
        assertEquals(0, baseDeDatos.ObtenerNumeroTablas());

        assertEquals(-1, baseDeDatos.ObtenerNumRegistrosEnTabla(0)); 
    }

    @Test
    public void testMultiplesRegistrosMultiplesTablas() {
 
        // nos aseguramos de que la base de datos esté vacía
        BaseDeDatos baseDeDatos= new BaseDeDatos();
        baseDeDatos.BorrarTodo();

        // almacenamos un registro con estructura Boolean, Integer y String
        // se espera que el índice sea 001001
        // lo que significa que es el primer registro de la primera tabla
        assertEquals("001001", baseDeDatos.AgregarRegistro(Boolean.valueOf(false), Integer.valueOf(0), "Hola "));

        assertEquals("001002", baseDeDatos.AgregarRegistro(Boolean.valueOf(true), Integer.valueOf(1), " mundo"));        

        assertEquals("002001", baseDeDatos.AgregarRegistro(Boolean.valueOf(true), Double.valueOf(1.5)));

        assertEquals(2, baseDeDatos.ObtenerNumeroTablas());

        assertEquals(2, baseDeDatos.ObtenerNumRegistrosEnTabla(1)); 

        assertEquals(1, baseDeDatos.ObtenerNumRegistrosEnTabla(2));

        baseDeDatos.BorrarTodo();
  
    }

    @Test
    public void testImprimirTablas(){
        
        // nos aseguramos de que la base de datos esté vacía
        BaseDeDatos baseDeDatos= new BaseDeDatos();
        baseDeDatos.BorrarTodo();

        // almacenamos un registro con estructura Boolean, Integer y String
        // se espera que el índice sea 001001
        // lo que significa que es el primer registro de la primera tabla
        assertEquals("001001", baseDeDatos.AgregarRegistro(Integer.valueOf(0), "Hola "));

        assertEquals("001002", baseDeDatos.AgregarRegistro(Integer.valueOf(1), " mundo"));

        assertEquals("002001", baseDeDatos.AgregarRegistro(Double.valueOf(1.5)));
        
        assertEquals("ID: 001001 0 | Hola  --- ID: 001002 1 |  mundo --- ID: 002001 1.5 ", baseDeDatos.ImprimirTodo());
        
        baseDeDatos.BorrarTodo();
    }

    @Test
    public void testEditarRegistro() {
 
        // nos aseguramos de que la base de datos esté vacía
        BaseDeDatos baseDeDatos= new BaseDeDatos();
        baseDeDatos.BorrarTodo();

        // almacenamos un registro con estructura Boolean, Integer y String
        // se espera que el índice sea 001001
        // lo que significa que es el primer registro de la primera tabla
        assertEquals("001001", baseDeDatos.AgregarRegistro(Boolean.valueOf(false), Integer.valueOf(0), "Hola "));

        assertEquals("001002", baseDeDatos.AgregarRegistro(Boolean.valueOf(true), Integer.valueOf(1), " mundo"));        

        assertEquals("002001", baseDeDatos.AgregarRegistro(Boolean.valueOf(true), Double.valueOf(1.5)));

        assertEquals(2, baseDeDatos.ObtenerNumeroTablas());

        assertEquals(2, baseDeDatos.ObtenerNumRegistrosEnTabla(1)); 

        assertEquals(1, baseDeDatos.ObtenerNumRegistrosEnTabla(2));

        baseDeDatos.EditarReg("001001", Boolean.valueOf(true), Integer.valueOf(0), "Hola de nuevo ");

        baseDeDatos.EditarReg("001002", Boolean.valueOf(false), Integer.valueOf(1), "mundo");

        baseDeDatos.EditarReg("002001", Boolean.valueOf(false), Double.valueOf(1.5));

        assertEquals("ID: 001001 true | 0 | Hola de nuevo  --- ID: 001002 false | 1 | mundo --- ID: 002001 false | 1.5 ", baseDeDatos.ImprimirTodo());

        baseDeDatos.BorrarTodo();
  
    }

    @Test
    public void testMultiplesTablas() {
 
        // nos aseguramos de que la base de datos esté vacía
        BaseDeDatos baseDeDatos= new BaseDeDatos();
        baseDeDatos.BorrarTodo();

        // almacenamos un registro con estructura Boolean, Integer y String
        // se espera que el índice sea 001001
        // lo que significa que es el primer registro de la primera tabla
        assertEquals("001001", baseDeDatos.AgregarRegistro(Boolean.valueOf(false), Integer.valueOf(0), "Hola "));      

        assertEquals("002001", baseDeDatos.AgregarRegistro("someValue", Integer.valueOf(0), "Hola "));     

        assertEquals(2, baseDeDatos.ObtenerNumeroTablas());

        assertEquals(1, baseDeDatos.ObtenerNumRegistrosEnTabla(1)); 

        assertEquals(1, baseDeDatos.ObtenerNumRegistrosEnTabla(2));

        baseDeDatos.BorrarTodo();
  
    }
}
