package com.microfinancasapi.controller;

import com.microfinancasapi.dto.EmprestimoRequestDTO;
import com.microfinancasapi.dto.EmprestimoResponseDTO;
import com.microfinancasapi.service.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Emprestimo", description = "Gerenciamento de emprestimos")
@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @Operation(summary = "Listar todos os Emprestimo")
    @GetMapping
    public List<EmprestimoResponseDTO> listar(@RequestParam(required = false) Long clienteId, @RequestParam(required = false) Long grupoId) {
        List<EmprestimoResponseDTO> resultado = service.listar();
        if (clienteId != null) {
            resultado = resultado.stream().filter(item -> clienteId.equals(item.getClienteId())).collect(java.util.stream.Collectors.toList());
        }
        if (grupoId != null) {
            resultado = resultado.stream().filter(item -> grupoId.equals(item.getGrupoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Emprestimo por ID")
    @GetMapping("/{id}")
    public EmprestimoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Emprestimo")
    @PostMapping
    public ResponseEntity<EmprestimoResponseDTO> criar(@Valid @RequestBody EmprestimoRequestDTO emprestimo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(emprestimo));
    }

    @Operation(summary = "Atualizar Emprestimo")
    @PutMapping("/{id}")
    public EmprestimoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody EmprestimoRequestDTO emprestimo) {
        return service.atualizar(id, emprestimo);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Emprestimo")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
