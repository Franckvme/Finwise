package com.finwise.shared.enums;

public enum Currency {
    EUR("Euro", "€", "EUR"),
    USD("US Dollar", "$", "USD"),
    GBP("British Pound", "£", "GBP"),
    CAD("Canadian Dollar", "C$", "CAD"),
    CHF("Swiss Franc", "CHF", "CHF"),
    JPY("Japanese Yen", "¥", "JPY"),
    AUD("Australian Dollar", "A$", "AUD"),
    XAF("CFA Franc", "FCFA", "XAF"); // Pour le Cameroun
    
    private final String displayName;
    private final String symbol;
    private final String code;
    
    Currency(String displayName, String symbol, String code) {
        this.displayName = displayName;
        this.symbol = symbol;
        this.code = code;
    }
    
    public String getDisplayName() { return displayName; }
    public String getSymbol() { return symbol; }
    public String getCode() { return code; }
}
