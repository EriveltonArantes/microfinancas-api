package com.microfinancasapi.controller;

import com.microfinancasapi.model.Grupo;
import com.microfinancasapi.model.Cliente;
import com.microfinancasapi.model.Emprestimo;
import com.microfinancasapi.model.Parcela;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.microfinancasapi.repository.GrupoRepository grupoRepository;

    @Autowired
    private com.microfinancasapi.repository.ClienteRepository clienteRepository;

    @Autowired
    private com.microfinancasapi.repository.EmprestimoRepository emprestimoRepository;

    @Autowired
    private com.microfinancasapi.repository.ParcelaRepository parcelaRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalGrupo", grupoRepository.count());
        resumo.put("somaMaxMembrosGrupo", grupoRepository.findAll().stream().filter(e -> e.getMaxMembros() != null).mapToInt(e -> e.getMaxMembros()).sum());
        resumo.put("graficoGrupo", grupoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalCliente", clienteRepository.count());
        resumo.put("somaRendaCliente", clienteRepository.findAll().stream().filter(e -> e.getRenda() != null).mapToDouble(e -> e.getRenda()).sum());
        resumo.put("graficoCliente", clienteRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalEmprestimo", emprestimoRepository.count());
        resumo.put("somaValorSolicitadoEmprestimo", emprestimoRepository.findAll().stream().filter(e -> e.getValorSolicitado() != null).mapToDouble(e -> e.getValorSolicitado()).sum());
        resumo.put("graficoEmprestimo", emprestimoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalParcela", parcelaRepository.count());
        resumo.put("somaValorParcelaParcela", parcelaRepository.findAll().stream().filter(e -> e.getValorParcela() != null).mapToDouble(e -> e.getValorParcela()).sum());
        resumo.put("graficoParcela", parcelaRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
