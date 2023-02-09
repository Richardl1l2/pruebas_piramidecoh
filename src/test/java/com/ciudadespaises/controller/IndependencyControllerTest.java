package com.ciudadespaises.controller;

import com.ciudadespaises.models.Country;
import com.ciudadespaises.repositories.CountryRepository;
import com.ciudadespaises.util.DiferenciaEntreFechas;
import com.ciudadespaises.models.CountryResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import java.util.Optional;

class IndependencyControllerTest {

    @Autowired
    CountryResponse countryResponse;
    @Autowired
    Optional<Country> country;

    CountryRepository countryRepositoryMock = Mockito.mock(CountryRepository.class);

    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas = new DiferenciaEntreFechas();

    @Autowired
    IndependencyController independencyController = new IndependencyController(countryRepositoryMock,diferenciaEntreFechas);

    @BeforeEach
    void setUp() {
        Country mockCountry = new Country();
        mockCountry.setIsoCode("COL");
        mockCountry.setCountryIdependenceDate("20/07/1810");
        mockCountry.setCountryId((long) 1);
        mockCountry.setCountryName("Colombia");
        mockCountry.setCountryCapital("Bogota");

        Mockito.when(countryRepositoryMock.findCountryByIsoCode("COL")).thenReturn(mockCountry);
    }

    @Test
    void getCountryDetailsWithValidCountryCode() {
        ResponseEntity<CountryResponse> respuestaServicio;
        respuestaServicio = independencyController.getCountryDetails("COL");
        Assertions.assertEquals("Colombia",respuestaServicio.getBody().getCountryName());
    }

    @Test
    void getCountryDetailsWithInvalidCountryCode() {
        ResponseEntity<CountryResponse> respuestaServicio;
        respuestaServicio = independencyController.getCountryDetails("IT");
        Assertions.assertNull(respuestaServicio.getBody().getCountryName());
    }


}