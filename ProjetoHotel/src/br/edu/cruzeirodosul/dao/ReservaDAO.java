package br.edu.cruzeirodosul.dao;

import br.edu.cruzeirodosul.model.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    
    public void salvar(Reserva reserva) throws Exception {
        String sql = "INSERT INTO reservas (cliente, quarto, data_entrada, data_saida, status, preco) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, reserva.getCliente());
            stmt.setInt(2, reserva.getQuarto());
            stmt.setDate(3, java.sql.Date.valueOf(reserva.getDataEntrada()));
            stmt.setDate(4, java.sql.Date.valueOf(reserva.getDataSaida()));
            stmt.setString(5, reserva.getStatus());
            stmt.setDouble(6, reserva.getPreco());
            
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    reserva.setId(rs.getLong(1));
                }
            }
        }
    }
    
    public List<Reserva> listarTodos() throws Exception {
        String sql = "SELECT * FROM reservas ORDER BY data_entrada";
        List<Reserva> reservas = new ArrayList<>();
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getLong("id"));
                reserva.setCliente(rs.getString("cliente"));
                reserva.setQuarto(rs.getInt("quarto"));
                reserva.setDataEntrada(rs.getDate("data_entrada").toLocalDate());
                reserva.setDataSaida(rs.getDate("data_saida").toLocalDate());
                reserva.setStatus(rs.getString("status"));
                reserva.setPreco(rs.getDouble("preco"));
                
                reservas.add(reserva);
            }
        }
        
        return reservas;
    }
} 