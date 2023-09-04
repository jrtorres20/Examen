package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.CuentasEntity;

@Repository
@EnableJpaRepositories
public interface CuentaRepository extends JpaRepository<CuentasEntity, Integer> {

    List<CuentasEntity> findByEstado(short estado);
}
