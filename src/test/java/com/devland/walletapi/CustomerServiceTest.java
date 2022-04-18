package com.devland.walletapi;

import com.devland.walletapi.customer.Customer;
import com.devland.walletapi.customer.CustomerRepository;
import com.devland.walletapi.customer.CustomerService;
import com.devland.walletapi.transaction.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;
    private TransactionRepository transactionRepository;

    @Test
    void getAll_shouldCreateTransferOfCustomer_whenInvoked(){
        LocalDateTime dateTime = LocalDateTime.of(2022, 04,17,07,07,07);

    }
}
