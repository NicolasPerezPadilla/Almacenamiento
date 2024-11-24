package com.uninorte;

import java.util.ArrayList;

public class BaseDeDatos {
    private ArrayList<Tabla> tablas;

    public BaseDeDatos() {
        tablas = new ArrayList<>();
    }

    // Método público para agregar un registro con parámetros variables
    public String AgregarRegistro(Object... datos) {
        Registro registro = new Registro();

        for (Object object : datos) {
            registro.addDato(object);
        }

        return AgregarRegistroAux(registro);

    }

    public String AgregarRegistroAux(Registro registro) {


        if (seEncuentraTabla(registro)) {

            for (int i = 0; i < tablas.size(); i++) {

                Tabla tabla = tablas.get(i);
                ArrayList<Registro> registrosAux = tabla.obtenerRegistros();

                if (registro.obtenerTipoDatos().equals(registrosAux.get(0).obtenerTipoDatos())) {
                    tabla.addRegistro(registro);                   
                    return String.format("%03d%03d", i + 1, registrosAux.size());
                }
            }

        } else {           
            Tabla tabla = new Tabla(registro);
            tablas.add(tabla);            
            return String.format("%03d%03d", tablas.size(), 1);

        }
        return null; 
    }

    public boolean seEncuentraTabla(Registro registro) {

        for (Tabla tabla1 : tablas) {

            ArrayList<Registro> registrosAux2 = tabla1.obtenerRegistros();

            if (!registrosAux2.isEmpty() && registro.obtenerTipoDatos().equals(registrosAux2.get(0).obtenerTipoDatos())) {
                return true;
            }

        }
        return false;
    }

    public String ImprimirTodo() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < tablas.size(); i++) {

            Tabla tabla = tablas.get(i);
            ArrayList<Registro> registros = tabla.obtenerRegistros();

            for (int j = 0; j < registros.size(); j++) {

                Registro registro = registros.get(j);
                ArrayList<Object> datos = registro.obtenerDatos();   
                String id = String.format("%03d%03d", i + 1, j + 1);   
                result.append("ID: ").append(id).append(" ");

                for (int k = 0; k < datos.size(); k++) {
                    result.append(datos.get(k));

                    if (k < datos.size() - 1) {
                        result.append(" | "); 
                    }
                }

                result.append(" --- ");
            }
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 4); 
        }

        return result.toString();
    }

    public void BorrarTodo() {
        tablas.clear();
    }

    public void EditarReg(String recordId, Object... newValues) {
        int tablaIndex = Integer.parseInt(recordId.substring(0, 3)) - 1;  
        int registroIndex = Integer.parseInt(recordId.substring(3, 6)) - 1; 

        if (tablaIndex >= 0 && tablaIndex < tablas.size()) {

            Tabla tabla = tablas.get(tablaIndex);
            ArrayList<Registro> registros = tabla.obtenerRegistros();

            if (registroIndex >= 0 && registroIndex < registros.size()) {
                Registro registro = registros.get(registroIndex);
                registro.editarDatos(registroIndex, newValues);

            } else {
                 System.out.println("No se encontró el registro con el índice especificado.");

            }
        } else {
             System.out.println("No se encontró la tabla con el índice especificado.");
        }
    }

    public boolean BorrarReg(String recordId) {
        int tablaIndex = Integer.parseInt(recordId.substring(0, 3)) - 1;  
        int registroIndex = Integer.parseInt(recordId.substring(3, 6)) - 1;  

        if (tablaIndex >= 0 && tablaIndex < tablas.size()) {
            Tabla tabla = tablas.get(tablaIndex);
            ArrayList<Registro> registros = tabla.obtenerRegistros();

            if (registroIndex >= 0 && registroIndex < registros.size()) {
                registros.remove(registroIndex);
                return true;

            } 

            return false;
        }
        return false;
    }

    public Integer ObtenerNumRegistrosEnTabla(int i) {
        if (i <= 0 || i > tablas.size()) {
            return -1;
        }
        return tablas.get(i - 1).obtenerNumRegistros();
    }

    public Integer ObtenerNumeroTablas() {
        return tablas.size();
    }

}
