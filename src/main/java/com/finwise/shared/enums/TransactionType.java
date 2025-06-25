package com.finwise.shared.enums;

public enum TransactionType {
    INCOME("Revenu"),
    EXPENSE("Dépense"),
    TRANSFER("Virement");
    
    private final String displayName;
    
    TransactionType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() { return displayName; }
}
