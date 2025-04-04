-- Criar o banco de dados se não existir
CREATE DATABASE IF NOT EXISTS locacoes;

-- Usar o banco de dados
USE locacoes;

-- Criar a tabela de reservas
CREATE TABLE IF NOT EXISTS reservas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente VARCHAR(100) NOT NULL,
    quarto INT NOT NULL,
    data_entrada DATE NOT NULL,
    data_saida DATE NOT NULL,
    status VARCHAR(20) NOT NULL
); 