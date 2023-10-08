package com.shreyash.demo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetails {
    @Column(name = "upi", unique = true)
    String upi;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "qr_code", unique = true)
    String qrCode;

    @OneToOne(mappedBy = "account")
    Restaurants restaurants;

    public AccountDetails(String upi, String qrCode) {
        this.upi = upi;
        this.qrCode = qrCode;
    }
}
