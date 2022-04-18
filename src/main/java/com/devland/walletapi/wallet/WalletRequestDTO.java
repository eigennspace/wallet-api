package com.devland.walletapi.wallet;

import lombok.*;

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
