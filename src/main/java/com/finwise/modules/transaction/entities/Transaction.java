package com.finwise.modules.transaction.entities;

import com.finwise.shared.entities.BaseEntity;
import com.finwise.shared.enums.TransactionStatus;
import com.finwise.shared.enums.TransactionType;
import com.finwise.shared.valueobjects.Money;
import com.finwise.modules.account.entities.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Data
@EqualsAndHashCode(callSuper = true)
public class Transaction extends BaseEntity {
    
    @NotNull
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(name = "amount")),
        @AttributeOverride(name = "currency", column = @Column(name = "currency"))
    })
    private Money amount;
    
    @NotBlank
    @Size(min = 2, max = 200)
    @Column(nullable = false)
    private String description;
    
    @NotNull
    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status = TransactionStatus.COMPLETED;
    
    @Column
    private String reference;
    
    @Column(name = "merchant_name")
    private String merchantName;
    
    @Column
    private String location;
    
    @Column(columnDefinition = "TEXT")
    private String notes;
    
    @Column(name = "is_recurring", nullable = false)
    private Boolean isRecurring = false;
    
    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transfer_account_id")
    private Account transferAccount; // Pour les virements
    
    public boolean isIncome() {
        return TransactionType.INCOME.equals(this.transactionType);
    }
    
    public boolean isExpense() {
        return TransactionType.EXPENSE.equals(this.transactionType);
    }
    
    public boolean isTransfer() {
        return TransactionType.TRANSFER.equals(this.transactionType);
    }
    
    public boolean isPending() {
        return TransactionStatus.PENDING.equals(this.status);
    }
    
    public boolean isCompleted() {
        return TransactionStatus.COMPLETED.equals(this.status);
    }
}
