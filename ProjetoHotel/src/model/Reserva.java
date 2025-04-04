package model;

import java.time.LocalDate;
import java.time.Month;

public class Reserva {
    private Long id;
    private String cliente;
    private Integer quarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String status;
    private Double preco;
    
    // Preços base por temporada
    private static final double PRECO_BAIXA_TEMPORADA = 150.0;
    private static final double PRECO_ALTA_TEMPORADA = 250.0;
    
    public Reserva() {}
    
    public Reserva(Long id, String cliente, Integer quarto, LocalDate dataEntrada, LocalDate dataSaida, String status) {
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.status = status;
        this.preco = calcularPreco();
    }
    
    private double calcularPreco() {
        double precoTotal = 0.0;
        LocalDate dataAtual = dataEntrada;
        
        while (!dataAtual.isAfter(dataSaida)) {
            if (isAltaTemporada(dataAtual)) {
                precoTotal += PRECO_ALTA_TEMPORADA;
            } else {
                precoTotal += PRECO_BAIXA_TEMPORADA;
            }
            dataAtual = dataAtual.plusDays(1);
        }
        
        return precoTotal;
    }
    
    private boolean isAltaTemporada(LocalDate data) {
        Month mes = data.getMonth();
        // Alta temporada: Dezembro, Janeiro, Fevereiro, Julho
        return mes == Month.DECEMBER || 
               mes == Month.JANUARY || 
               mes == Month.FEBRUARY || 
               mes == Month.JULY;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public Integer getQuarto() {
        return quarto;
    }
    
    public void setQuarto(Integer quarto) {
        this.quarto = quarto;
    }
    
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
        this.preco = calcularPreco();
    }
    
    public LocalDate getDataSaida() {
        return dataSaida;
    }
    
    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
        this.preco = calcularPreco();
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Double getPreco() {
        return preco;
    }
    
    public void setPreco(Double preco) {
        this.preco = preco;
    }
} 