package com.example.demo.DTO;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CuentasDTO {

    private BigInteger cliente;
    private double monto;
    private short estado;

}
