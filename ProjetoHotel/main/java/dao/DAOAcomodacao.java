package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.*;
import java.util.List;

public class DAOAcomodacao extends Conexao{
    
    public DAOAcomodacao(){
        this.conn = getConnection();
    }

    @Override
    public void closeConnection() {
        try{
            this.getConnection().close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
    
    public void create(Acomodacao a){
        try{
            String sql = "INSERT INTO acomodacoes(endereco,preco_base,descricao_acomodacao,adicionais) VALUES(?,?,?,?)";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,a.getEndereco());
            stmt.setDouble(2,a.getPreco_base());
            stmt.setString(3,a.getDescricao_acomodacao());
            stmt.setString(4,a.getAdicionais());
            stmt.execute();
            System.out.println("Acomodação Cadastrada com Sucesso");
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
    
    public List<Acomodacao> queryAll(){
	try{
           List<Acomodacao> acomodacoes = new ArrayList<Acomodacao>(); 
	   String sql = "SELECT id,endereco,preco_base,descricao_acomodacao,adicionais FROM acomodacoes";
           PreparedStatement stmt = this.conn.prepareStatement(sql);
	   ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()){
               Acomodacao a = new Acomodacao();
	       a.setId(rs.getInt("id"));
	       a.setPreco_base(rs.getDouble("preco_base"));	 
               a.setEndereco(rs.getString("endereco"));
               a.setDescricao_acomodacao(rs.getString("descricao_acomodacao"));
               a.setAdicionais(rs.getString("adicionais"));
               acomodacoes.add(a);
           }
	   return acomodacoes;
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
    }

    public void exbieAcomodacoes(){
        List<Acomodacao> acomodacoes = queryAll();
        for(Acomodacao a : acomodacoes){
            System.out.println("ID: "+a.getId());
            System.out.println("Endereço: "+a.getEndereco());
            System.out.println("Preço Base: "+a.getPreco_base());
            System.out.println("Descrição: "+a.getDescricao_acomodacao());
            System.out.println("Adicionais: "+a.getAdicionais());
            System.out.println("-------------------------------------------------");
        }
    }
}