package edu.br.cruzeirodosul.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome do cliente é obrigatório")
    private String cliente;
    
    @NotNull(message = "O número do quarto é obrigatório")
    @Positive(message = "O número do quarto deve ser positivo")
    private Integer quarto;
    
    @NotNull(message = "A data de entrada é obrigatória")
    private LocalDate dataEntrada;
    
    @NotNull(message = "A data de saída é obrigatória")
    private LocalDate dataSaida;
    
    @NotBlank(message = "O status é obrigatório")
    private String status;
}
