package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Conexao implements IConexao{
    private Connection conn;    

    @Override
    public Connection getConnection() {
        try{
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/locacoes", "root", "usbw");
            System.out.println("Conexão realizada com sucesso!");
            return this.conn;
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }

    }
    
}
