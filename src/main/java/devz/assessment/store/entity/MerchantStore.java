package devz.assessment.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "merchant_stores",
    indexes = {
        @Index(name = "idx_merchant_active", columnList = "is_active"),
        @Index(name = "idx_merchant_category", columnList = "category"),
        @Index(name = "idx_merchant_active_category", columnList = "is_active, category"),
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantStore {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "store_name", nullable = false, length = 200)
    private String storeName;

    @Column(name = "location", columnDefinition = "geometry(Point,4326)")
    private Point location;
    
    @Column(length = 500)
    private String address;
    
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
    
    @Column(length = 100)
    private String category;
    
    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private Boolean isActive = true;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    // Helper methods for lat/lon
    @Transient
    public Double getLatitude() {
        return location != null ? location.getY() : null;
    }
    
    @Transient
    public Double getLongitude() {
        return location != null ? location.getX() : null;
    }
}