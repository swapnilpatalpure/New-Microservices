package com.swapcode.accounts.services;

import com.swapcode.accounts.dto.CustomerDto;

public interface AccountsService {

    /**
     * @param customerDto - CustomerDto object
     **/
    void createAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on given mobileNumber
     **/
    CustomerDto fetchAccount(String mobileNumber);

    /**
     * @param customerDto - Input accountNumber
     * @update Accounts Details based on given accountNumber
     **/
    boolean updateAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of account details is successful or not
     **/
    boolean deleteAccount(String mobileNumber);

}
