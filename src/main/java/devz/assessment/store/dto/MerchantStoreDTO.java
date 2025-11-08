package devz.assessment.store.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Merchant store response with distance information")
public class MerchantStoreDTO {

    @Schema(description = "Store ID", example = "1")
    private Long id;

    @Schema(description = "Store name", example = "Coffee Shop Central")
    private String storeName;

    @Schema(description = "Latitude coordinate", example = "16.8051")
    private Double latitude;

    @Schema(description = "Longitude coordinate", example = "96.1560")
    private Double longitude;

    @Schema(description = "Store address", example = "123 Main Street, Yangon")
    private String address;

    @Schema(description = "Phone number", example = "+95912345678")
    private String phoneNumber;

    @Schema(description = "Store category", example = "Food & Beverage")
    private String category;

    @Schema(description = "Distance from user location in kilometers (null if not applicable)", example = "2.5")
    private Double distanceKm;
}