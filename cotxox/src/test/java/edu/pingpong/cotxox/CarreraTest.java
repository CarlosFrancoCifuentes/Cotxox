package edu.pingpong.cotxox;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.pingpong.cotxox.domain.Carrera;

public class CarreraTest {

    Carrera carrera;
    
    @Before
    public void constructorTest(){
        String[] tarjetasVisa = { "4929637175949220", 
								  "4024007198786385", 
								  "4417129513323481", 
								  "4532121888937144",
								  "4916119711304546" };
        
        for (String tarjetaVisa : tarjetasVisa){
            carrera = new Carrera(tarjetaVisa);
            assertEquals(tarjetaVisa, carrera.getTarjetaCredito());
        }
    }

    @Test
    public void setOrigen(){
        String origen = "Plaza España";
        carrera.setOrigen(origen);
        assertEquals(origen, carrera.getOrigen()); 
    }
}
