package com.finwise.modules.account.entities;

import com.finwise.shared.entities.BaseEntity;
import com.finwise.shared.enums.AccountType;
import com.finwise.shared.enums.Currency;
import com.finwise.shared.valueobjects.Money;
import com.finwise.modules.user.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
@Data
@EqualsAndHashCode(callSuper = true)
public class Account extends BaseEntity {
    
    @NotBlank
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String name;
    
    @Column(name = "account_number")
    private String accountNumber;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(name = "balance_amount")),
        @AttributeOverride(name = "currency", column = @Column(name = "balance_currency"))
    })
    private Money balance = new Money();
    
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    
    @Column(name = "bank_name")
    private String bankName;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "last_sync_at")
    private LocalDateTime lastSyncAt;
    
    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<com.finwise.modules.transaction.entities.Transaction> transactions = new ArrayList<>();
    
    public void updateBalance(Money amount) {
        if (this.balance == null) {
            this.balance = new Money(amount.getAmount(), amount.getCurrency());
        } else {
            this.balance = this.balance.add(amount);
        }
    }
    
    public void debitAccount(Money amount) {
        if (this.balance == null) {
            this.balance = new Money(amount.getAmount().negate(), amount.getCurrency());
        } else {
            this.balance = this.balance.subtract(amount);
        }
    }
    
    public boolean hasSufficientBalance(Money amount) {
        return this.balance != null && this.balance.getAmount().compareTo(amount.getAmount()) >= 0;
    }
}
