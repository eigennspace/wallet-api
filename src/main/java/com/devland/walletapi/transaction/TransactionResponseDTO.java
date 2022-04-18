package com.devland.walletapi.customer;

import com.devland.walletapi.transaction.TransactionType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferResponseDTO {
    private Long walletId1;

    private Long walletId2;

    private TransactionType transactionType;

    private String transactionDescription;

    private double amount;

    public TransferResponseDTO convertToResponse(){
        return TransferResponseDTO.builder().walletId1(this.walletId1).walletId2(this.walletId2).transactionType(this.transactionType)
                .transactionDescription(this.transactionDescription).amount(this.amount).build();
    }
}
