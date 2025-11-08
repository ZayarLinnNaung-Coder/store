package devz.assessment.store.service;

import devz.assessment.store.dto.MerchantStoreDTO;
import devz.assessment.store.dto.request.NearbySearchRequest;

import java.util.List;
import java.util.Optional;

public interface MerchantStoreService {

    List<MerchantStoreDTO> findNearbyStores(NearbySearchRequest request);
    List<MerchantStoreDTO> getAllStoresAsDTO();
    Optional<MerchantStoreDTO> getStoreById(Long id);
}