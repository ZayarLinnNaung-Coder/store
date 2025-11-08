package devz.assessment.store.service.impl;

import devz.assessment.store.entity.MerchantStore;
import devz.assessment.store.repo.MerchantStoreRepo;
import devz.assessment.store.service.MerchantStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import devz.assessment.store.dto.MerchantStoreDTO;
import devz.assessment.store.dto.request.NearbySearchRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class MerchantStoreServiceImpl implements MerchantStoreService {
    
    private final MerchantStoreRepo repository;

    public List<MerchantStoreDTO> findNearbyStores(NearbySearchRequest request) {
        log.info("Searching stores near lat: {}, lon: {}, radius: {}km",
                request.getLatitude(), request.getLongitude(), request.getRadiusKm());

        Double radiusMeters = request.getRadiusKm() * 1000;

        List<Object[]> results = repository.findStoresNearby(
                request.getLatitude(),
                request.getLongitude(),
                radiusMeters,
                request.getCategory()
        );

        return mapResultsToDTO(results);
    }

    public List<MerchantStoreDTO> getAllStoresAsDTO() {
        log.info("Fetching all stores");
        List<MerchantStore> stores = repository.findAll();
        return stores.stream()
                .map(this::convertToDTO)
                .toList();
    }

    public Optional<MerchantStoreDTO> getStoreById(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO);
    }

    // Helper method: Convert Entity to DTO
    private MerchantStoreDTO convertToDTO(MerchantStore store) {
        return MerchantStoreDTO.builder()
                .id(store.getId())
                .storeName(store.getStoreName())
                .latitude(store.getLatitude())
                .longitude(store.getLongitude())
                .address(store.getAddress())
                .phoneNumber(store.getPhoneNumber())
                .category(store.getCategory())
                .distanceKm(null) // No distance for getAllStores
                .build();
    }

    private List<MerchantStoreDTO> mapResultsToDTO(List<Object[]> results) {
        return results.stream()
                .map(row -> MerchantStoreDTO.builder()
                        .id(((Number) row[0]).longValue())
                        .storeName((String) row[1])
                        .latitude((Double) row[2])
                        .longitude((Double) row[3])
                        .address((String) row[4])
                        .phoneNumber((String) row[5])
                        .category((String) row[6])
                        .distanceKm(Math.round(((Number) row[8]).doubleValue() / 10.0) / 100.0)
                        .build())
                .toList();
    }

}