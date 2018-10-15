package com.camavilca.orlando.p04.repository;

import com.camavilca.orlando.p04.model.Mascotas;
import com.orm.SugarRecord;

import java.util.List;

public class RepositoryMascota {

    public static List<Mascotas> listar(){
        List<Mascotas> mascotas;
        mascotas = SugarRecord.listAll(Mascotas.class);
        return mascotas;
    }
    public static Mascotas read(Long id){
        Mascotas mascota = SugarRecord.findById(Mascotas.class,id);
        return mascota;
    }
    public static void create(String nombre,String raza, String edad){
        Mascotas mascota = new Mascotas(nombre,raza,edad);
        SugarRecord.save(mascota);
    }
    public static void update(Long id, String nombre,String raza, String edad){
        Mascotas mascota = SugarRecord.findById(Mascotas.class,id);
        mascota.setNombre(nombre);
        mascota.setRaza(raza);
        mascota.setEdad(edad);
        SugarRecord.save(mascota);
    }
    public static void delete(Long id){
        Mascotas mascotas = SugarRecord.findById(Mascotas.class,id);
        SugarRecord.delete(mascotas);
    }
}
