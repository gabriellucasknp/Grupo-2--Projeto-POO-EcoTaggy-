package com.ecoTaggy.service;


import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@Service
public class RelatorioPDFService {


    public void gerarRelatorioESG(HttpServletResponse response, Map<String, Object> dados) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());


        document.open();


        // Estilo de Fontes
        Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Font fontSubtitulo = FontFactory.getFont(FontFactory.HELVETICA, 12);
        Font fontNegrito = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);


        // Cabeçalho
        Paragraph titulo = new Paragraph("Relatório de Impacto Ambiental - EcoTaggy", fontTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);


        document.add(new Paragraph("Gerado em: " + dados.get("dataGeracao"), fontSubtitulo));
        document.add(new Paragraph("Metodologia: " + dados.get("metodologia"), fontSubtitulo));
        document.add(new Paragraph(" ")); // Linha em branco
        document.add(new Paragraph("-----------------------------------------------------------------------"));
        document.add(new Paragraph(" "));


        // Conteúdo Principal
        document.add(new Paragraph("Resumo do Impacto Consolidado:", fontNegrito));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("CO2 Evitado: " + dados.get("co2Total") + " kg"));
        document.add(new Paragraph("Combustível Poupado: " + dados.get("combustivelTotal") + " Litros"));
        document.add(new Paragraph("Tickets de Papel Evitados: " + dados.get("papelTotal") + " kg"));
        document.add(new Paragraph("Total de Transações Analisadas: " + dados.get("transacoesAvaliadas")));
        
        document.add(new Paragraph(" "));
        document.add(new Paragraph("-----------------------------------------------------------------------"));
        document.add(new Paragraph("Este documento certifica a redução de pegada de carbono através da otimização de fluxo em praças de pedágio e estacionamentos parceiros.", fontSubtitulo));


        document.close();
    }
}


