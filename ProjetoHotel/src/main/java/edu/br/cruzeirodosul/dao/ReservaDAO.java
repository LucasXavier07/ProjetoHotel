package edu.br.cruzeirodosul.dao;

import edu.br.cruzeirodosul.model.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    
    public void salvar(Reserva reserva) throws SQLException {
        String sql = "INSERT INTO reservas (cliente, quarto, data_entrada, data_saida, status) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, reserva.getCliente());
            stmt.setInt(2, reserva.getQuarto());
            stmt.setDate(3, java.sql.Date.valueOf(reserva.getDataEntrada()));
            stmt.setDate(4, java.sql.Date.valueOf(reserva.getDataSaida()));
            stmt.setString(5, reserva.getStatus());
            
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    reserva.setId(rs.getLong(1));
                }
            }
        }
    }
    
    public List<Reserva> listarTodos() throws SQLException {
        String sql = "SELECT * FROM reservas";
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
                
                reservas.add(reserva);
            }
        }
        
        return reservas;
    }
    
    public Reserva buscarPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM reservas WHERE id = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Reserva reserva = new Reserva();
                    reserva.setId(rs.getLong("id"));
                    reserva.setCliente(rs.getString("cliente"));
                    reserva.setQuarto(rs.getInt("quarto"));
                    reserva.setDataEntrada(rs.getDate("data_entrada").toLocalDate());
                    reserva.setDataSaida(rs.getDate("data_saida").toLocalDate());
                    reserva.setStatus(rs.getString("status"));
                    
                    return reserva;
                }
            }
        }
        
        return null;
    }
    
    public void atualizar(Reserva reserva) throws SQLException {
        String sql = "UPDATE reservas SET cliente = ?, quarto = ?, data_entrada = ?, data_saida = ?, status = ? WHERE id = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, reserva.getCliente());
            stmt.setInt(2, reserva.getQuarto());
            stmt.setDate(3, java.sql.Date.valueOf(reserva.getDataEntrada()));
            stmt.setDate(4, java.sql.Date.valueOf(reserva.getDataSaida()));
            stmt.setString(5, reserva.getStatus());
            stmt.setLong(6, reserva.getId());
            
            stmt.executeUpdate();
        }
    }
    
    public void excluir(Long id) throws SQLException {
        String sql = "DELETE FROM reservas WHERE id = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
} 