package com.ecoTaggy.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Captura qualquer exceção não tratada na aplicação.
     * Evita a exibição da Whitelabel Error Page e loga o problema real.
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        // Registra o erro no console de forma clara
        logger.error("Erro interno capturado pelo GlobalExceptionHandler: ", ex);
        
        // Opcional: Envia a mensagem de erro para o front-end
        model.addAttribute("mensagemErro", "Desculpe, ocorreu um erro interno no servidor.");
        model.addAttribute("detalheErro", ex.getMessage());
        
        return "error"; // Redireciona para um template de erro amigável (error.html)
    }
}