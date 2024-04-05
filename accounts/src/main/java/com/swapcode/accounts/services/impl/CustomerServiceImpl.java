package com.swapcode.accounts.services.impl;

import com.swapcode.accounts.dto.AccountsDto;
import com.swapcode.accounts.dto.CardsDto;
import com.swapcode.accounts.dto.CustomerDetailsDto;
import com.swapcode.accounts.dto.LoansDto;
import com.swapcode.accounts.entity.Accounts;
import com.swapcode.accounts.entity.Customer;
import com.swapcode.accounts.exception.ResourceNotFoundException;
import com.swapcode.accounts.mapper.AccountsMapper;
import com.swapcode.accounts.mapper.CustomerMapper;
import com.swapcode.accounts.repository.AccountsRepository;
import com.swapcode.accounts.repository.CustomerRepository;
import com.swapcode.accounts.services.CustomerService;
import com.swapcode.accounts.services.client.CardsFeignClient;
import com.swapcode.accounts.services.client.LoansFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardsFeignClient cardsFeignClient;

    @Autowired
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {

        Customer customer=customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(()->new ResourceNotFoundException("Customer","mobileNumber",mobileNumber));

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(()->new ResourceNotFoundException("Accpunt","customerId",customer.getCustomerId().toString()));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        if(null!=loansDtoResponseEntity){
            customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        }

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        if(null != cardsDtoResponseEntity) {
            customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
        }

        return customerDetailsDto;
    }
}
