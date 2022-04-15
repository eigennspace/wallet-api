package com.devland.walletapi.wallet;

import com.devland.walletapi.transaction.Transaction;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletRequestDTO {
    private Long id;

    private double walletBalance;

    public Wallet convertToEntity(){
        return Wallet.builder().id(this.id)
                .walletBalance(this.walletBalance).build();
    }
}
