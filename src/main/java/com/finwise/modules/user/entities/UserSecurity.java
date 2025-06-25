package com.finwise.modules.user.entities;

import com.finwise.shared.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_security")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserSecurity extends BaseEntity {
    
    @NotBlank
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    
    @NotBlank
    @Column(nullable = false)
    private String salt;
    
    @Column(name = "is_two_factor_enabled", nullable = false)
    private Boolean isTwoFactorEnabled = false;
    
    @Column(name = "two_factor_secret")
    private String twoFactorSecret;
    
    @Column(name = "last_password_change")
    private LocalDateTime lastPasswordChange;
    
    @Column(name = "failed_login_attempts", nullable = false)
    private Integer failedLoginAttempts = 0;
    
    @Column(name = "is_locked", nullable = false)
    private Boolean isLocked = false;
    
    @Column(name = "lock_expiration_time")
    private LocalDateTime lockExpirationTime;
    
    // Relations
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    public void incrementFailedAttempts() {
        this.failedLoginAttempts++;
        if (this.failedLoginAttempts >= 5) {
            this.isLocked = true;
            this.lockExpirationTime = LocalDateTime.now().plusMinutes(30);
        }
    }
    
    public void resetFailedAttempts() {
        this.failedLoginAttempts = 0;
        this.isLocked = false;
        this.lockExpirationTime = null;
    }
    
    public boolean isAccountLocked() {
        return isLocked && (lockExpirationTime == null || LocalDateTime.now().isBefore(lockExpirationTime));
    }
}
