package edu.pingpong.cotxox;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.pingpong.cotxox.domain.Carrera;
import edu.pingpong.cotxox.domain.Conductor;
import edu.pingpong.cotxox.domain.PoolConductores;

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
    public void setOrigenTest(){
        String origen = "Plaza España";
        carrera.setOrigen(origen);
        assertEquals(origen, carrera.getOrigen()); 
    }

    @Test
    public void setDestinoTest(){
        String destino = "Plaza España";
        carrera.setDestino(destino);
        assertEquals(destino, carrera.getDestino()); 
    }

    @Test
    public void setDistanciaTest(){
        double distancia = 9.0;
        double delta = 0.001;
        carrera.setDistancia(distancia);
        assertEquals(distancia, carrera.getDistancia(), delta); 
    }

    @Test
    public void getCosteEsperadoTest(){
        int tiempoEsperado = 15;
        double distancia = 9.0;
        double delta = 0.001;
        carrera.setDistancia(distancia);
        carrera.setTiempoEsperado(tiempoEsperado);
        assertEquals(distancia * 1.35 + tiempoEsperado * 0.35, carrera.getCosteEsperado(), delta);
    }

    @Test
    public void setTiempoEsperadoTest(){
        int tiempoEsperado = 15;
        carrera.setTiempoEsperado(tiempoEsperado);
        assertEquals(tiempoEsperado, carrera.getTiempoEsperado()); 
    }

    @Test
    public void setConductorTest(){
        Conductor conductor = new Conductor("Carlos");
        carrera.setConductor(conductor);
        assertEquals(conductor, carrera.getConductor()); 
    }

    @Test
    public void asignarConductorTest(){
        carrera.setConductor(null);
        String nombre = "Carlos";
        Conductor conductor = new Conductor(nombre);
        List<Conductor> poolConductores = new ArrayList<Conductor>();
        poolConductores.add(conductor);
        PoolConductores conductores = new PoolConductores(poolConductores);
        carrera.asignarConductor(conductores);
        assert (carrera.getConductor() != null); 
    }

    @Test
    public void realizarPagoTest(){
        double pago = 25.0;
        double delta = 0.001;
        carrera.realizarPago(pago);
        assertEquals(pago, carrera.getCosteTotal(), delta); 
    }

    @Test
    public void recibirPropinaTest(){
        int propina = 5;
        carrera.recibirPropina(propina);
        assertEquals(propina, carrera.getPropina()); 
    }

    @Test
    public void liberarConductorTest(){
        Conductor conductor = new Conductor("Carlos");
        carrera.setConductor(conductor);
        carrera.liberarConductor();
        assert (!carrera.getConductor().isOcupado());
    }
}
