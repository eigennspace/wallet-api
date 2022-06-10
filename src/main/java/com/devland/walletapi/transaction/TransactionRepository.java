package com.devland.walletapi.transaction;

import com.devland.walletapi.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // JPQL
    @Query("SELECT t FROM Transaction t WHERE t.amount = ?1 and t.id = ?2")
    public List<Transaction> ngambilTransaksi(double amount, Long id);

    // = ? -> query binding //
    //    @Query(value = "SELECT * FROM transaction WHERE amount = ?1 and id = ?2"
    //            , nativeQuery = true)
    //    public List<Transaction> ngambilTransaksi(double amount, BigInteger id);

}