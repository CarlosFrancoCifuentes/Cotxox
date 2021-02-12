package edu.pingpong.cotxox.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PoolConductores {

    private List<Conductor> conductor = new ArrayList<Conductor>();

    public PoolConductores(List<Conductor> conductores){
        this.conductor = conductores;
    }

    public List<Conductor> getPoolConductores(){
        return this.conductor;
    }

    public Conductor asignarConductor(){
        Conductor conductor = new Conductor();
		Random aleatorio = new Random();
		boolean asignado = false;
		while (!asignado) {
			int index = aleatorio.nextInt(getPoolConductores().size());
			conductor = getPoolConductores().get(index);
			if (!conductor.isOcupado()) {
				conductor.setOcupado(true);
				asignado = true;
			}
		}
		return conductor;
    }
}
