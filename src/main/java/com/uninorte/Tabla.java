package com.uninorte;

import java.util.ArrayList;

public class Tabla {
    private ArrayList<Registro> registros;

    
    public Tabla(Registro registro) {
        registros = new ArrayList<>();
        registros.add(registro);
    }

    public void addRegistro(Registro registro) {
        if (registros.isEmpty()) {
            registros.add(registro);

        } else {           
            ArrayList<Class<?>> tiposExistentes = registros.get(0).obtenerTipoDatos();
            ArrayList<Class<?>> tiposNuevos = registro.obtenerTipoDatos();

            if (tiposExistentes.equals(tiposNuevos)) {
                registros.add(registro);
                
            } else {
                throw new IllegalArgumentException("Los tipos de datos del nuevo registro no coinciden con los tipos existentes.");
            }
        }
    }

    public ArrayList<Registro> obtenerRegistros() {
        return registros;
    }

    public Integer obtenerNumRegistros(){
        return registros.size();
    }

}
