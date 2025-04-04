import dao.ReservaDAO;
import model.Reserva;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ReservaDAO reservaDAO = new ReservaDAO();
            
            while (true) {
                System.out.println("\n=== Sistema de Reservas ===");
                System.out.println("1. Listar todas as reservas");
                System.out.println("2. Inserir nova reserva");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                
                switch (opcao) {
                    case 1:
                        listarReservas(reservaDAO);
                        break;
                    case 2:
                        inserirReserva(reservaDAO, scanner);
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void listarReservas(ReservaDAO reservaDAO) throws Exception {
        List<Reserva> reservas = reservaDAO.listarTodos();
        System.out.println("\n=== Lista de Reservas ===");
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            for (Reserva r : reservas) {
                System.out.println("ID: " + r.getId());
                System.out.println("Cliente: " + r.getCliente());
                System.out.println("Quarto: " + r.getQuarto());
                System.out.println("Data Entrada: " + formatarData(r.getDataEntrada()));
                System.out.println("Data Saída: " + formatarData(r.getDataSaida()));
                System.out.println("Status: " + r.getStatus());
                System.out.println("Preço Total: R$ " + String.format("%.2f", r.getPreco()));
                System.out.println("-------------------");
            }
        }
    }
    
    private static String formatarData(LocalDate data) {
        return data.format(DATE_FORMATTER);
    }
    
    private static LocalDate lerData(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String dataStr = scanner.nextLine().trim();
                return LocalDate.parse(dataStr, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Use o formato DD/MM/AAAA (ex: 15/04/2024)");
            }
        }
    }
    
    private static void inserirReserva(ReservaDAO reservaDAO, Scanner scanner) throws Exception {
        System.out.println("\n=== Nova Reserva ===");
        
        Reserva reserva = new Reserva();
        
        System.out.print("Nome do Cliente: ");
        reserva.setCliente(scanner.nextLine());
        
        System.out.print("Número do Quarto: ");
        reserva.setQuarto(scanner.nextInt());
        scanner.nextLine(); // Consumir a quebra de linha
        
        reserva.setDataEntrada(lerData(scanner, "Data de Entrada (DD/MM/AAAA): "));
        reserva.setDataSaida(lerData(scanner, "Data de Saída (DD/MM/AAAA): "));
        
        System.out.print("Status: ");
        reserva.setStatus(scanner.nextLine());
        
        reservaDAO.salvar(reserva);
        System.out.println("Reserva salva com sucesso!");
        System.out.println("Preço Total: R$ " + String.format("%.2f", reserva.getPreco()));
    }
} 