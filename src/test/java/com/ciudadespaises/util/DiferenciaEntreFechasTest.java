package com.ciudadespaises.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Period;

class DiferenciaEntreFechasTest {

    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas;

    @Test
    void calculateYearsOfIndependency() {
        diferenciaEntreFechas = new DiferenciaEntreFechas();
        String fechaIndependencia = "20/07/1810";

        Period resultado = diferenciaEntreFechas.calculateYearsOfIndependency(fechaIndependencia);

        Assertions.assertEquals(6,resultado.getMonths() );
        Assertions.assertEquals(19,resultado.getDays() );
        Assertions.assertEquals(212,resultado.getYears() );
    }
}