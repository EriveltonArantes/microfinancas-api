package com.microfinancasapi.controller;

import com.microfinancasapi.dto.GrupoRequestDTO;
import com.microfinancasapi.dto.GrupoResponseDTO;
import com.microfinancasapi.service.GrupoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Grupo", description = "Gerenciamento de grupos")
@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    @Autowired
    private GrupoService service;

    @Operation(summary = "Listar todos os Grupo")
    @GetMapping
    public List<GrupoResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<GrupoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Grupo por ID")
    @GetMapping("/{id}")
    public GrupoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Grupo")
    @PostMapping
    public ResponseEntity<GrupoResponseDTO> criar(@Valid @RequestBody GrupoRequestDTO grupo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(grupo));
    }

    @Operation(summary = "Atualizar Grupo")
    @PutMapping("/{id}")
    public GrupoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody GrupoRequestDTO grupo) {
        return service.atualizar(id, grupo);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Grupo")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
