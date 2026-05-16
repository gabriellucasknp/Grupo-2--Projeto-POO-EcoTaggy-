package com.ecoTaggy.controller;

import com.ecoTaggy.exception.DuplicateEmailException;
import com.ecoTaggy.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView handleDuplicateEmail(DuplicateEmailException ex) {
        return new ModelAndView("redirect:/cadastro?erro=email-em-uso");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFound(UserNotFoundException ex, HttpServletRequest request) {
        if (request.getRequestURI().startsWith("/transacao")) {
            return new ModelAndView("redirect:/login?erro=usuario-nao-encontrado");
        }
        return new ModelAndView("redirect:/landing?erro=usuario-nao-encontrado");
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handleResponseStatus(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                .body(Map.of("erro", ex.getReason() != null ? ex.getReason() : "Erro na requisição."));
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        logger.error("Erro interno capturado pelo GlobalExceptionHandler: ", ex);
        model.addAttribute("mensagemErro", "Desculpe, ocorreu um erro interno no servidor.");
        model.addAttribute("detalheErro", ex.getMessage());
        return "error";
    }
}
