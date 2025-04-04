# Sistema de Reservas de Hotel

Este é um sistema simples de reservas de hotel que permite:
- Listar todas as reservas
- Inserir novas reservas
- Calcular preços automaticamente baseado na temporada

## Requisitos
- Java JDK 8 ou superior
- MySQL Server (USB Web Server)
- Driver JDBC do MySQL

## Configuração

1. Instale o Java JDK
2. Instale o USB Web Server com MySQL
3. Baixe o driver JDBC do MySQL:
   - Acesse: https://dev.mysql.com/downloads/connector/j/
   - Baixe o arquivo ZIP do Connector/J Platform Independent
   - Extraia o arquivo ZIP
   - Copie o arquivo `mysql-connector-j-8.0.33.jar` (não o -javadoc.jar) para a pasta `lib` do projeto

## Estrutura do Projeto
```
src/
├── main/
│   ├── java/
│   │   ├── main/
│   │   │   └── ReservasMaven.java
│   │   ├── dao/
│   │   │   ├── Conexao.java
│   │   │   └── ReservaDAO.java
│   │   └── model/
│   │       └── Reserva.java
│   └── resources/
│       └── schema.sql
└── lib/
    └── mysql-connector-j-8.0.33.jar
```

## Compilação e Execução

1. Certifique-se de que o driver JDBC está na pasta `lib`
2. Compile o projeto:
   ```
   compile.bat
   ```
3. Execute o programa:
   ```
   run.bat
   ```

## Configuração do Banco de Dados

1. Inicie o USB Web Server
2. Acesse o phpMyAdmin (geralmente em http://localhost:8080/phpmyadmin)
3. Crie um novo banco de dados chamado `locacoes`
4. Execute o script SQL em `src/resources/schema.sql`

## Preços por Temporada
- Alta Temporada (R$ 250,00/dia): Dezembro, Janeiro, Fevereiro e Julho
- Baixa Temporada (R$ 150,00/dia): Demais meses

## Solução de Problemas

Se encontrar o erro "Não foi possível localizar nem carregar a classe principal", verifique:
1. Se o driver JDBC está na pasta `lib` (não apenas o arquivo -javadoc.jar)
2. Se a pasta `target` existe e tem permissão de escrita
3. Se o comando de compilação foi executado com sucesso 