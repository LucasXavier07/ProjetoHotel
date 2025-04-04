package model;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Hospede {
    private String nome;    
    private String endereco;
    private String documento;
    private Contato contato;

    public void exibeDados(){
        System.out.println("Nome do Hóspede: "+this.nome);
        System.out.println("Endereço do Hóspede: "+this.endereco);
        System.out.println("Documento do Hóspede: "+this.documento);
        //System.out.println("Telefone do Hóspede: "+this.contato.telefone);
        //System.out.println("Email do Hóspede: "+this.contato.email);
    } 			
}
