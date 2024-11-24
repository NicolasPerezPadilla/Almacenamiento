package com.uninorte;

import java.util.ArrayList;

public class Registro {
    private ArrayList<Object> datos;
    private ArrayList<Class<?>> tipoDatos;

    public Registro() {
        datos = new ArrayList<>();
        tipoDatos = new ArrayList<>();
    }

    public void addDato(Object dato) {
        datos.add(dato);
        
        if (!fueLeido(dato.getClass())) {
            tipoDatos.add(dato.getClass());
        }
    }

    public ArrayList<Object> obtenerDatos() {
        return datos;
    }


    public ArrayList<Class<?>> obtenerTipoDatos() {
        return tipoDatos;
    }

    public boolean fueLeido(Class<?> class1) {
        return tipoDatos.contains(class1);
    }

    
    public int obtenerCantidadDatos() {
        return datos.size();
    }

    public void editarDatos(int index, Object... nuevosDatos) {

        for (int i = 0; i < datos.size(); i++) {
            datos.set(i, nuevosDatos[i]);
        }
    }

}
