package online_banking.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * OTP (One-Time Password) management
 * When users want to login or reset passwords,
 * they can request an OTP instead of using
 * their regular password
 */
@Entity
@NoArgsConstructor
@Data
public class OtpInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String accountNumber;

    @Column
    private String otp;

    @Column
    private LocalDateTime generatedAt;

    public OtpInfo(String accountNumber, String otp, LocalDateTime generatedAt) {
        this.accountNumber = accountNumber;
        this.otp = otp;
        this.generatedAt = generatedAt;
    }

}
