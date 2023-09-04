package com.example.demo.Services;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CuentasDTO;
import com.example.demo.DTO.PagosDTO;
import com.example.demo.Entity.CuentasEntity;
import com.example.demo.Entity.PrestamoEntity;
import com.example.demo.Mapper.ClienteMapper;
import com.example.demo.Repositories.CuentaRepository;
import com.example.demo.Repositories.PrestamoRepository;

@Service
public class ClienteServices {

    @Autowired
    private CuentaRepository repoCuentas;

    @Autowired
    private PrestamoRepository repoPrestamos;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<PagosDTO> aplicarInteres() throws ParseException {
        short status = 0;// Activas cuentas
        short stats = 0;// Activas prestamos
        List<PagosDTO> listPagos = new ArrayList<PagosDTO>();

        // Parametros de entrada
        String fecha = "2021-02-15";
        SimpleDateFormat clasFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date diasPrestamo = clasFecha.parse(fecha);
        double porcInteres = 7.50;
        double tasaIva = 16.00;
        short diasComercial = 360;

        try {
            List<CuentasEntity> entListCuentas = repoCuentas.findByEstado(status);
            List<BigInteger> ctes = ClienteMapper.clientes(entListCuentas);
            List<PrestamoEntity> entListPrestamos = repoPrestamos.findByClienteInAndEstadoOrderByFecha(ctes, stats);

            entListPrestamos.stream().forEach(cta -> {
                PagosDTO pagoCte = new PagosDTO();

                // Calcular el plazo
                long dias = calculaPlazo(cta.getFecha());

                // Calcular el interes
                int interes = calcularInteres(diasComercial, porcInteres, cta.getMonto());

                // Calcular el iva
                int iva = (int) (interes * tasaIva);

                // calcular el pago
                double pago = cta.getMonto() + interes + iva;

                pagoCte.setCliente(cta.getCliente());
                pagoCte.setId(cta.getId());
                pagoCte.setPago(pago);
                pagoCte.setIva(iva);
                pagoCte.setPlazo(dias);
                pagoCte.setInteres(interes);
                listPagos.add(pagoCte);

            });

        } catch (Exception ex) {
            logger.error("ocurrio un error en aplicarInteres", ex);
        }

        return listPagos;

    }

    public long calculaPlazo(Date FecPrestamo) {
        long dif = 0;
        String prestamo = FecPrestamo.toString();

        try {
            SimpleDateFormat clasFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date diasPrestamo = clasFecha.parse(prestamo);
            Date diaActual = new Date();

            long difDias = diaActual.getTime() - diasPrestamo.getTime();

            TimeUnit time = TimeUnit.DAYS;
            dif = time.convert(difDias, TimeUnit.MILLISECONDS);

        } catch (Exception ex) {
            logger.error("ocurrio un error en aplicarInteres", ex);
        }

        return dif;
    }

    public int calcularInteres(long dias, double porcInteres, double monto) {
        int interes = 0;
        int firtsCalculo = 0;

        try {
            firtsCalculo = (int) (monto * dias * porcInteres);
            interes = (int) (firtsCalculo / dias);

        } catch (Exception ex) {
            logger.error("ocurrio un error en aplicarInteres", ex);
        }

        return interes;
    }

    public List<CuentasDTO> obtenerCuentas() {
        short status = 0;
        List<CuentasDTO> ctas = new ArrayList<CuentasDTO>();
        try {
            List<CuentasEntity> entListCuentas = repoCuentas.findByEstado(status);
            ctas = ClienteMapper.mapCuentas(entListCuentas);

        } catch (Exception ex) {
            logger.error("ocurrio un error en aplicarInteres", ex);
        }

        return ctas;
    }

}
