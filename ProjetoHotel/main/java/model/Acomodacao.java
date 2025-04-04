package model;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@requiredArgsConstructor

public class Acomodacao {
    public int id;

    @NonNull
    public String endereco;

    @NonNull
    public double preco_base;
    
    @NonNull
    public String descricao_acomodacao;
    
    @NonNull
    public String adicionais;    
}
