package com.finwise.modules.user.entities;

import com.finwise.shared.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user_preferences")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPreferences extends BaseEntity {
    
    @Column(name = "notifications_enabled", nullable = false)
    private Boolean notificationsEnabled = true;
    
    @Column(name = "email_notifications", nullable = false)
    private Boolean emailNotifications = true;
    
    @Column(name = "push_notifications", nullable = false)
    private Boolean pushNotifications = true;
    
    @Column(name = "budget_alerts", nullable = false)
    private Boolean budgetAlerts = true;
    
    @Column(name = "goal_reminders", nullable = false)
    private Boolean goalReminders = true;
    
    @Column(nullable = false)
    private String theme = "LIGHT";
    
    @Column(name = "dashboard_layout", columnDefinition = "TEXT")
    private String dashboardLayout;
    
    // Relations
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
