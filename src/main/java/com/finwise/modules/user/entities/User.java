package com.finwise.modules.user.entities;

import com.finwise.shared.entities.BaseEntity;
import com.finwise.shared.enums.Currency;
import com.finwise.shared.enums.Language;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    
    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;
    
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "profile_picture")
    private String profilePicture;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "preferred_currency", nullable = false)
    private Currency preferredCurrency = Currency.EUR;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language = Language.FR;
    
    @Column(nullable = false)
    private String timezone = "Europe/Paris";
    
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    
    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;
    
    // Relations
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserSecurity userSecurity;
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserPreferences userPreferences;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<com.finwise.modules.account.entities.Account> accounts = new ArrayList<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<com.finwise.modules.transaction.entities.Category> categories = new ArrayList<>();
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public void updateLastLogin() {
        this.lastLoginAt = LocalDateTime.now();
    }
}
