package com.devland.walletapi.customer;

import com.devland.walletapi.transaction.TransactionRequestDTO;
import com.devland.walletapi.transaction.TransactionResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponseDTO>> getCustomers(){
        List<Customer> customers = this.customerService.getAll();

        List<CustomerResponseDTO> customerResponseDTOS = customers.stream()
                .map(customer -> customer.convertToResponse())
                .collect(Collectors.toList());

        return ResponseEntity.ok(customerResponseDTOS);
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        Customer newCustomer = customerRequestDTO.convertToEntity();

        Customer customer = this.customerService.createCustomer(newCustomer);
        CustomerResponseDTO customerResponseDTO = customer.convertToResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDTO);
    }

    @GetMapping("/customer/wallet/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable("id") Long id){
        Customer customer = customerService.getOne(id);

        CustomerResponseDTO customerResponseDTO = customer.convertToResponse();

        return ResponseEntity.ok(customerResponseDTO);
    }

    @PostMapping("/customer/{id}/transfer")
    public ResponseEntity<TransactionResponseDTO> transfer(@PathVariable("id") Long id, @RequestBody TransactionRequestDTO transactionRequestDTO){
       transactionRequestDTO.setWalletId1(id);
        this.customerService.transfer(transactionRequestDTO);

        TransactionResponseDTO transactionResponseDTO = TransactionResponseDTO.builder()
                .walletId1(transactionRequestDTO.getWalletId1())
                .walletId2(transactionRequestDTO.getWalletId2())
                .amount(transactionRequestDTO.getAmount())
                .transactionDescription(transactionRequestDTO.getTransactionDescription())
                .build();

       return ResponseEntity.ok(transactionResponseDTO);

    }

}
