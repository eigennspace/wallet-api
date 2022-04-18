package com.devland.walletapi.customer;

import com.devland.walletapi.wallet.WalletResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomerResponseDTO {
    private Long id;

    private String name;

    private String NIK;

    private LocalDateTime dateOfBirth;

    private LocalDateTime customerCreatedAt;

    private WalletResponseDTO walletResponseDTO;
}
