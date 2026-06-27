package com.microfinancasapi.controller;

import com.microfinancasapi.dto.ParcelaRequestDTO;
import com.microfinancasapi.dto.ParcelaResponseDTO;
import com.microfinancasapi.service.ParcelaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Parcela", description = "Gerenciamento de parcelas")
@RestController
@RequestMapping("/api/parcelas")
public class ParcelaController {

    @Autowired
    private ParcelaService service;

    @Operation(summary = "Listar todos os Parcela")
    @GetMapping
    public List<ParcelaResponseDTO> listar(@RequestParam(required = false) Long emprestimoId) {
        List<ParcelaResponseDTO> resultado = service.listar();
        if (emprestimoId != null) {
            resultado = resultado.stream().filter(item -> emprestimoId.equals(item.getEmprestimoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Parcela por ID")
    @GetMapping("/{id}")
    public ParcelaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Parcela")
    @PostMapping
    public ResponseEntity<ParcelaResponseDTO> criar(@Valid @RequestBody ParcelaRequestDTO parcela) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(parcela));
    }

    @Operation(summary = "Atualizar Parcela")
    @PutMapping("/{id}")
    public ParcelaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ParcelaRequestDTO parcela) {
        return service.atualizar(id, parcela);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Parcela")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
