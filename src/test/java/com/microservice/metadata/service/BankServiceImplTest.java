package com.microservice.metadata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.microservice.metadata.dao.BankServiceRepository;
import com.microservice.metadata.entity.BankService;
import com.microservice.metadata.service.impl.BankServiceServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BankServiceImplTest {

    @Mock
    private BankServiceRepository bankServiceRepository;

    @InjectMocks
    private BankServiceServiceImpl bankServiceServiceImpl;

    private BankService bankService;

    @BeforeEach
    void setUp() {
        bankService = new BankService();
        bankService.setId(1L);
        bankService.setName("Test Service");
    }

    @Test
    void testGetAllBankServices() {
        when(bankServiceRepository.findAll()).thenReturn(Arrays.asList(bankService));

        List<BankService> bankServices = bankServiceServiceImpl.getAllBankServices();

        assertEquals(1, bankServices.size());
        assertEquals("Test Service", bankServices.get(0).getName());
        verify(bankServiceRepository).findAll();
    }

    @Test
    void testGetBankServiceById_Success() {
        when(bankServiceRepository.findById(1L)).thenReturn(Optional.of(bankService));

        BankService retrievedService = bankServiceServiceImpl.getBankServiceById(1L);

        assertEquals(bankService, retrievedService);
        verify(bankServiceRepository).findById(1L);
    }

    @Test
    void testGetBankServiceById_NotFound() {
        when(bankServiceRepository.findById(1L)).thenReturn(Optional.empty());

        BankService retrievedService = bankServiceServiceImpl.getBankServiceById(1L);

        assertNull(retrievedService);
        verify(bankServiceRepository).findById(1L);
    }

    @Test
    void testCreateBankService() {
        when(bankServiceRepository.save(bankService)).thenReturn(bankService);

        BankService createdService = bankServiceServiceImpl.createBankService(bankService);

        assertEquals(bankService, createdService);
        verify(bankServiceRepository).save(bankService);
    }
}
