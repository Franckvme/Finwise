package com.finwise.modules.transaction.entities;

import com.finwise.shared.entities.BaseEntity;
import com.finwise.shared.enums.CategoryType;
import com.finwise.modules.user.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {
    
    @NotBlank
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(nullable = false)
    private String color = "#007bff";
    
    @Column(nullable = false)
    private String icon = "category";
    
    @Enumerated(EnumType.STRING)
    @Column(name = "category_type", nullable = false)
    private CategoryType categoryType;
    
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    
    @Column(name = "is_system", nullable = false)
    private Boolean isSystem = false;
    
    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;
    
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Category> children = new ArrayList<>();
    
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Transaction> transactions = new ArrayList<>();
    
    public boolean isParentCategory() {
        return !children.isEmpty();
    }
    
    public boolean isChildCategory() {
        return parent != null;
    }
}
