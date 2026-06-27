package com.microfinancasapi.repository;

import com.microfinancasapi.model.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
}
