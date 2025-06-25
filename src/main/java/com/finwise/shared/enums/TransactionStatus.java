package com.finwise.shared.enums;

public enum TransactionStatus {
    PENDING("En Attente"),
    COMPLETED("Terminé"),
    CANCELLED("Annulé"),
    FAILED("Échoué");
    
    private final String displayName;
    
    TransactionStatus(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() { return displayName; }
}
