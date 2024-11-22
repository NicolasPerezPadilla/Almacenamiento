package com.uninorte;

import java.io.*;
import java.util.ArrayList;

public class BaseDeDatos {


    // Método público para agregar un registro con parámetros variables
    public static String AgregarRegistro(Object... datos) {
        return "ID";
    }


    public static String ImprimirTodo() {
        StringBuilder result = new StringBuilder();
    
        return "SomeText";
    }

    public static void BorrarTodo() {
     
    }

    public static boolean EditarReg(String recordId, Object... newValues) {
       
        return false;
    }

    public static boolean BorrarReg(String recordId) {
       
        return false;
    }


    public static int ObtenerNumRegistrosEnTabla(int i) {

        return -1;
    }

    public static Integer ObtenerNumeroTablas() {
        return -1;
    }

}
