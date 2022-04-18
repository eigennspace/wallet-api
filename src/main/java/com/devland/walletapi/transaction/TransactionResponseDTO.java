package com.devland.walletapi.transaction;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDTO {
    private Long walletId1;

    private Long walletId2;

    private String transactionDescription;

    private double amount;
}
