package io.github.victorbaraldii.controle.controle_horas.repository;

import io.github.victorbaraldii.controle.controle_horas.model.RegistroHora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistroHoraRepository extends JpaRepository<RegistroHora, Long> {

    @Query("""
            SELECT r FROM RegistroHora r
            WHERE MONTH(r.data) = :mes
            AND YEAR(r.data) = :ano
            """)
    List<RegistroHora> buscarPorMesAno(
            @Param("mes") int mes,
            @Param("ano") int ano
    );
}
