package com.example.demo.DTO;

import java.math.BigInteger;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagosDTO {

    private int id;
    private BigInteger cliente;
    private double pago;
    private long plazo;
    private int iva;
    private int interes;
}
