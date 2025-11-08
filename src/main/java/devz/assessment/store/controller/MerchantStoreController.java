package devz.assessment.store.controller;

import devz.assessment.store.dto.MerchantStoreDTO;
import devz.assessment.store.dto.request.NearbySearchRequest;
import devz.assessment.store.service.MerchantStoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/merchant-stores")
@RequiredArgsConstructor
@Tag(name = "Merchant Store API", description = "APIs for managing and searching merchant stores")
public class MerchantStoreController {

    private final MerchantStoreService service;

    @GetMapping("/nearby")
    @Operation(
            summary = "Find nearby stores (GET method)",
            description = "Search for nearby stores using query parameters with Haversine formula"
    )
    public ResponseEntity<List<MerchantStoreDTO>> findNearbyStores(
            @Parameter(description = "User's latitude", required = true, example = "16.8051")
            @RequestParam Double latitude,

            @Parameter(description = "User's longitude", required = true, example = "96.1560")
            @RequestParam Double longitude,

            @Parameter(description = "Search radius in km", example = "5.0")
            @RequestParam(defaultValue = "5.0") Double radiusKm,

            @Parameter(description = "Filter by category", example = "Food & Beverage")
            @RequestParam(required = false) String category
    ) {
        NearbySearchRequest request = new NearbySearchRequest(latitude, longitude, radiusKm, category);
        List<MerchantStoreDTO> stores = service.findNearbyStores(request);
        return ResponseEntity.ok(stores);
    }

    @GetMapping
    @Operation(
            summary = "Get all merchant stores",
            description = "Retrieve all merchant stores in the database (returns DTOs with lat/lon)"
    )
    public ResponseEntity<List<MerchantStoreDTO>> getAllStores() {
        return ResponseEntity.ok(service.getAllStoresAsDTO());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get store by ID",
            description = "Retrieve a specific merchant store by its ID"
    )
    public ResponseEntity<MerchantStoreDTO> getStoreById(
            @Parameter(description = "Store ID", required = true)
            @PathVariable Long id
    ) {
        return service.getStoreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}