package com.ecoTaggy.controller;


import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.RelatorioPDFService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@Controller
public class ExportController {


    private final ImpactoService impactoService;
    private final RelatorioPDFService pdfService;


    public ExportController(ImpactoService impactoService, RelatorioPDFService pdfService) {
        this.impactoService = impactoService;
        this.pdfService = pdfService;
    }


    @GetMapping("/dashboard/relatorio/pdf")
    public void baixarRelatorio(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Relatorio_ESG_EcoTaggy.pdf";
        response.setHeader(headerKey, headerValue);


        // Pega os dados reais do banco
        Map<String, Object> dados = impactoService.gerarRelatorioESG();


        // Gera o PDF real
        pdfService.gerarRelatorioESG(response, dados);
    }
}


