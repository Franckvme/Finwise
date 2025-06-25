package com.finwise.shared.enums;

public enum AccountType {
    CHECKING("Compte Courant"),
    SAVINGS("Compte Épargne"),
    CREDIT_CARD("Carte de Crédit"),
    INVESTMENT("Investissement"),
    LOAN("Prêt"),
    CASH("Espèces");
    
    private final String displayName;
    
    AccountType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() { return displayName; }
}
