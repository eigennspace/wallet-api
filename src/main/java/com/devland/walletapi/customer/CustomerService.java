package com.devland.walletapi.customer;

import com.devland.walletapi.transaction.Transaction;
import com.devland.walletapi.transaction.TransactionRepository;
import com.devland.walletapi.transaction.TransactionType;
import com.devland.walletapi.transaction.TransactionRequestDTO;
import com.devland.walletapi.wallet.InsufficientWalletBalanceException;
import com.devland.walletapi.wallet.Wallet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    public List<Customer> getAll(){
        return this.customerRepository.findAll();
    }

    public List<Transaction> ngambilTransaksi(double amount, Long id){
        return this.transactionRepository.ngambilTransaksi(amount, id);
    }

    public Customer createCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    public Customer getOne(Long id){
        Optional<Customer> optionalCustomer = this.customerRepository.findById(id);
        if (optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException();
        }
        return  optionalCustomer.get();
    }

    public void transfer(TransactionRequestDTO transactionRequestDTO){
        Customer customer1 = this.customerRepository.findCustomerByWalletId(transactionRequestDTO.getWalletId1());
        Customer customer2 = this.customerRepository.findCustomerByWalletId(transactionRequestDTO.getWalletId2());

        Transaction transaction1 = new Transaction();
        Transaction transaction2 = new Transaction();

        if (customer1 == null){
            throw new CustomerNotFoundException();
        }

        if (customer2 == null){
            throw new CustomerNotFoundException();
        }

        if (customer1.getWallet().getWalletBalance() < transactionRequestDTO.getAmount()){
            throw new InsufficientWalletBalanceException();
        }

        /***
         * Reduce Wallet Balance for customer 1 after transfer
         */
        customer1.getWallet()
                .setWalletBalance(customer1.getWallet().getWalletBalance() - transactionRequestDTO.getAmount());

        /***
         * Set Transaction History for customer 1 after doing transfer
         */
        transaction1.setTransactionType(TransactionType.OUT);
        transaction1.setTransactionDescription(transactionRequestDTO.getTransactionDescription());
        transaction1.setAmount(transactionRequestDTO.getAmount());
        transaction1.setWallet(Wallet.builder().id(transactionRequestDTO.getWalletId1()).build());

        this.transactionRepository.save(transaction1);
        this.customerRepository.save(customer1);

        /***
         * Add Wallet Balance for customer 2 after got a transfer
         */
        customer2.getWallet()
                .setWalletBalance(customer2.getWallet().getWalletBalance() + transactionRequestDTO.getAmount());

        /***
         * Set Transaction History for customer 2 after got a transfer
         */
        transaction2.setTransactionType(TransactionType.IN);
        transaction2.setTransactionDescription(transactionRequestDTO.getTransactionDescription());
        transaction2.setAmount(transactionRequestDTO.getAmount());
        transaction2.setWallet(Wallet.builder().id(transactionRequestDTO.getWalletId2()).build());

        this.transactionRepository.save(transaction2);
        this.customerRepository.save(customer2);
    }
}