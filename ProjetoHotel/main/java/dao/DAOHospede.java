package dao;

import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Hospede;

public class DAOHospede implements ICRUD<Hospede>{
    
    public ArrayList<Hospede> hospedes;
    
    public DAOHospede(){
        this.hospedes = new ArrayList<Hospede>();
    }
    
    @Override
    public void create(Hospede h) {
        this.hospedes.add(h);
        System.out.println("Adicionou um jovem");
    }

    @Override
    public void delete(Hospede h) {
        
    }

    @Override
    public List<Hospede> getAll() {
        return this.hospedes;
    }

    @Override
    public Hospede queryHospede(Hospede h) {
        return null;
    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void closeConnection() {
        
    }    
}
