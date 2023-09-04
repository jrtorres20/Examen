package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CuentasDTO;
import com.example.demo.DTO.PagosDTO;
import com.example.demo.DTO.ResponseDTO;
import com.example.demo.Services.ClienteServices;

@RestController
@RequestMapping("cliente/obtener/")
public class ClienteController {

    @Autowired
    private ClienteServices cteServices;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @GetMapping("pagos")
    public ResponseDTO calcularPagos() {
        List<PagosDTO> resp = new ArrayList<PagosDTO>();

        try {
            resp = cteServices.aplicarInteres();
        } catch (Exception ex) {
            logger.error("Ocurrio un error, favor de contactar a soporte tecnico", ex);
        }

        return new ResponseDTO((short) 1, "OK", resp);
    }

    @ResponseBody
    @GetMapping("cuentas")
    public ResponseDTO obtenerCuentas() {
        List<CuentasDTO> resp = new ArrayList<CuentasDTO>();

        try {
            resp = cteServices.obtenerCuentas();
        } catch (Exception ex) {
            logger.error("Ocurrio un error, favor de contactar a soporte tecnico", ex);
        }

        return new ResponseDTO((short) 1, "OK", resp);
    }

}
