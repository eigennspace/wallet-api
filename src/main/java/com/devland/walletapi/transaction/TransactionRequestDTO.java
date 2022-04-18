package com.devland.walletapi.transaction;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequestDTO {
    private Long walletId1;

    private Long walletId2;

    private String transactionDescription;

    private double amount;
}
