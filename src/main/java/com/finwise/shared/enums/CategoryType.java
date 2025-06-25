package com.finwise.shared.enums;

public enum CategoryType {
    INCOME("Revenu"),
    EXPENSE("Dépense"),
    TRANSFER("Virement");
    
    private final String displayName;
    
    CategoryType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() { return displayName; }
}
