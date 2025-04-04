package dao;

import com.sun.jdi.connect.spi.Connection;

public interface IConexao {
    
    public Connection getConnection();
    
    public void closeConnection();
}
