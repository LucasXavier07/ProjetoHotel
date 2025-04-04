package edu.br.cruzeirodosul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.br.cruzeirodosul.model.Reserva;
import edu.br.cruzeirodosul.repository.ReservaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    
    @Autowired
    private ReservaRepository reservaRepository;
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping
    public String listarReservas(Model model) {
        model.addAttribute("reservas", reservaRepository.findAll());
        return "reservas/lista";
    }
    
    @GetMapping("/nova")
    public String novaReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservas/form";
    }
    
    @PostMapping("/salvar")
    public String salvarReserva(@Valid @ModelAttribute Reserva reserva,
                               BindingResult result,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "reservas/form";
        }
        
        try {
            reservaRepository.save(reserva);
            redirectAttributes.addFlashAttribute("mensagem", "Reserva salva com sucesso!");
            return "redirect:/reservas";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar a reserva: " + e.getMessage());
            return "redirect:/reservas/nova";
        }
    }
    
    @GetMapping("/editar/{id}")
    public String editarReserva(@PathVariable Long id, Model model) {
        Reserva reserva = reservaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        model.addAttribute("reserva", reserva);
        return "reservas/form";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluirReserva(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            reservaRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensagem", "Reserva excluída com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao excluir a reserva: " + e.getMessage());
        }
        return "redirect:/reservas";
    }
} 