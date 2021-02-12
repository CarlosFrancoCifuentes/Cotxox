package edu.pingpong.cotxox.domain;

import java.util.ArrayList;
import java.util.List;

public class Conductor {
    
    private String nombre = null;
    private String modelo = null;
    private String matricula = null;
    private double valoracionMedia = 0d;
    private boolean ocupado = false;
    private List<Byte> valoraciones = new ArrayList<Byte>();

    public Conductor(){        
    };

    public Conductor(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getValoracionMedia() {
        return this.valoracionMedia;
    }

    public int getNumeroValoraciones(){
        return this.valoraciones.size();
    }

    public void setValoraciones(Byte valoracion) {
        this.valoraciones.add(valoracion);
        this.calcularValoracionMedia();
    }

    private double calcularValoracionMedia(){
        int sumaValoraciones = 0;
        for (Byte valoracion : this.valoraciones){
            sumaValoraciones += valoracion;
        }
        this.valoracionMedia = (double) sumaValoraciones / getNumeroValoraciones();
        return this.valoracionMedia;
    }
    
    public void setOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }

    public boolean isOcupado(){
        return this.ocupado;
    }
}
