package com.example.demo.Repositories;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.PrestamoEntity;

@Repository
@EnableJpaRepositories
public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Integer> {

    List<PrestamoEntity> findByClienteInAndEstadoOrderByFecha(List<BigInteger> ctes, short estado);
}
