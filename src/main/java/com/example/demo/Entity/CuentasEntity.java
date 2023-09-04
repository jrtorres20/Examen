package com.example.demo.Entity;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cuentasdebito")
@AllArgsConstructor
@NoArgsConstructor
public class CuentasEntity {

    @Id
    @Column(name = "cliente")
    private BigInteger cliente;

    @Column(name = "monto")
    private double monto;

    @Column(name = "estado")
    private short estado;
}
