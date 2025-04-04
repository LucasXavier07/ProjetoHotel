package main;

import java.util.ArrayList;
import java.util.List;

import dao.*;
import model.*;

public class ReservasMaven {

    public static void main(String[] args) {
       /*
       // Usando o Construtor vazio
        Hospede h = new Hospede();
        
        // Usando o Construtor All Argumentos
        Hospede h1 = new Hospede("Ichigo","Av Salgado Filho","123456789-00",new Contato("ichigoshinigami@soulsociety.com","6447-1838"));
        
        DAOHospede hospedes = new DAOHospede();
        // IHospede hospedes = new DAOHospede();

        DAOAcomodacao acomodacoes = new DAOAcomodacao();

        
        hospedes.create(h);
        hospedes.create(h1); 
        dao.create(a);
        System.out.println("Deu certo!");
        */

        DAOAcomodacao dao = new DAOAcomodacao();
        List<Acomodacao> acomodacoes = new ArrayList<Acomodacao>();
        acomodacoes = dao.queryAll();
    }
}
