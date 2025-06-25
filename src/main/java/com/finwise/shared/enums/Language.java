package com.finwise.shared.enums;

public enum Language {
    FR("Français"),
    EN("English"),
    ES("Español");
    
    private final String displayName;
    
    Language(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() { return displayName; }
}
