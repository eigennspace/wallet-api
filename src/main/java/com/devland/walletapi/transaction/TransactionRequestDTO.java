package com.devland.walletapi.customer;

import com.devland.walletapi.transaction.TransactionType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferRequestDTO {
    private Long walletId1;

    private Long walletId2;

    private TransactionType transactionType;

    private String transactionDescription;

    private double amount;

}
