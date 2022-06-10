package com.devland.walletapi;

import com.devland.walletapi.customer.Customer;
import com.devland.walletapi.customer.CustomerResponseDTO;
import com.devland.walletapi.wallet.Wallet;
import com.devland.walletapi.wallet.WalletResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class CustomerTest {
//    @Test
//            void convertToResponse_shouldReturnCustomerResponseDTO_whenInvoked(){
//        LocalDateTime dateTime = LocalDateTime.of(2022, 4, 18, 7, 7, 7);
//        LocalDateTime dob = LocalDateTime.of(1998, 12, 5, 7, 7, 7);
//
//        Customer customer = Customer.builder().id(1L).name("Harist").NIK("123456")
//                .dateOfBirth(dob)
//                .customerCreatedAt(dateTime)
//                .wallet(Wallet.builder().id(1L).walletBalance(0).transactions(null)
//                        .walletCreatedAt(dateTime).build())
//                .build();
//        CustomerResponseDTO expectedResult = CustomerResponseDTO.builder()
//                .name("Harist").NIK("123456")
//                .dateOfBirth(dob)
//                .customerCreatedAt(dateTime)
//                .walletResponseDTO(WalletResponseDTO.builder().walletBalance(0)
//                        .transactions(null).walletCreatedAt(dateTime).build()).build();
//
//        CustomerResponseDTO actualResult = customer.convertToResponse();
//
//        Assertions.assertEquals(expectedResult, actualResult);
//    }

}