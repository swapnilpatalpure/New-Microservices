package com.swapcode.accounts.service;

import com.swapcode.accounts.dto.CustomerDto;
import com.swapcode.accounts.repository.AccountsRepository;
import com.swapcode.accounts.repository.CustomerRepository;
import com.swapcode.accounts.services.AccountsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class AccountsServiceTest {

    @Autowired
    private AccountsService accountsService;

    @MockBean
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomerRepository customerRepository;

//    @Test
//    public CustomerDto fetchAccount(String mobileNumber){
//        Mockito.when(accountsRepository.findAll()).thenReturn()
//    }

}
