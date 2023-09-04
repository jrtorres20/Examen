package com.example.demo.Entity;

import java.math.BigInteger;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "prestamos")
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cliente")
    private BigInteger cliente;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "monto")
    private double monto;

    @Column(name = "estado")
    private short estado;
}
