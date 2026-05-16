package com.ecoTaggy.controller;

import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.UsuarioService;
import com.ecoTaggy.service.ImpactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ecoTaggy.repository.PapelEconomizadoRepository;
import com.ecoTaggy.entity.ImpactoAmbiental;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DashboardController {
    
    @Autowired
    private PapelEconomizadoRepository papelEconomizadoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ImpactoService impactoService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        Long id = (Long) session.getAttribute("usuarioLogadoId");
        if (id == null) {
            id = 1L;
        }

        Usuario usuario = usuarioService.buscarPorIdOptional(id)
                .orElseGet(Usuario::new);

        model.addAttribute("usuario", usuario);
        model.addAttribute("impacto", usuario.getImpacto() != null ? usuario.getImpacto() : new ImpactoAmbiental());

        int totalFolhas = papelEconomizadoRepository.findAll().stream()
                .mapToInt(reg -> reg.getQuantidadeFolhas() != null ? reg.getQuantidadeFolhas() : 0)
                .sum();

        model.addAttribute("totalFolhas", totalFolhas);

        Map<String, Object> relatorio = impactoService.gerarRelatorioESG();
        model.addAttribute("relatorio", relatorio != null ? relatorio : new HashMap<>());

        return "dashboard";
    }

}
