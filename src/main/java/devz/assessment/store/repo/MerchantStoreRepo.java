package devz.assessment.store.repo;

import devz.assessment.store.entity.MerchantStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantStoreRepo extends JpaRepository<MerchantStore, Long> {

    @Query(value = """
        SELECT 
            m.id,
            m.store_name,
            ST_Y(m.location) as latitude,
            ST_X(m.location) as longitude,
            m.address,
            m.phone_number,
            m.category,
            m.is_active,
            ST_Distance(
                m.location::geography,
                ST_SetSRID(ST_MakePoint(:longitude, :latitude), 4326)::geography
            ) as distance_meters
        FROM merchant_stores m
        WHERE m.is_active = true
        AND ST_DWithin(
            m.location::geography,
            ST_SetSRID(ST_MakePoint(:longitude, :latitude), 4326)::geography,
            :radiusMeters
        )
        AND (:category IS NULL OR m.category = :category)
        ORDER BY distance_meters
        """, nativeQuery = true)
    List<Object[]> findStoresNearby(
            @Param("latitude") Double latitude,
            @Param("longitude") Double longitude,
            @Param("radiusMeters") Double radiusMeters,
            @Param("category") String category
    );

}