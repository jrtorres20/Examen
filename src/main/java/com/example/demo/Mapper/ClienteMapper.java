package com.example.demo.Mapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.example.demo.DTO.CuentasDTO;
import com.example.demo.Entity.CuentasEntity;

public class ClienteMapper {

    public static final ModelMapper MAPPER = new ModelMapper();

    public static List<BigInteger> clientes(List<CuentasEntity> entListCuentas) {
        List<BigInteger> ctes = new ArrayList<BigInteger>();

        entListCuentas.stream().forEach(x -> {
            BigInteger cte = x.getCliente();
            ctes.add(cte);
        });

        return ctes;
    }

    public static List<CuentasDTO> mapCuentas(List<CuentasEntity> cte) {
        List<CuentasDTO> ctess = new ArrayList<CuentasDTO>();

        cte.stream().forEach(x -> {
            CuentasDTO n = new CuentasDTO();
            n = mapp(x);
            ctess.add(n);

        });
        return ctess;
    }

    public static CuentasDTO mapp(CuentasEntity x) {
        return MAPPER.map(x, CuentasDTO.class);

    }
}
