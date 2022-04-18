package com.devland.walletapi.customer;

import com.devland.walletapi.wallet.WalletRequestDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequestDTO {

    private Long id;

    private String name;

    private String NIK;

    private LocalDateTime dateOfBirth;

    private WalletRequestDTO walletRequestDTO;

    public Customer convertToEntity(){
        return Customer.builder().id(this.id)
                .name(this.name)
                .NIK(this.NIK)
                .dateOfBirth(this.dateOfBirth)
                .wallet(this.walletRequestDTO.convertToEntity()).build();
    }
}
