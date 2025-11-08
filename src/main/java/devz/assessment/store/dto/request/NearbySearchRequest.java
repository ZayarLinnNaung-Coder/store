package devz.assessment.store.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request to find nearby merchant stores")
public class NearbySearchRequest {
    
    @NotNull(message = "Latitude is required")
    @Min(value = -90, message = "Latitude must be between -90 and 90")
    @Max(value = 90, message = "Latitude must be between -90 and 90")
    @Schema(description = "User's current latitude", example = "13.7563", required = true)
    private Double latitude;
    
    @NotNull(message = "Longitude is required")
    @Min(value = -180, message = "Longitude must be between -180 and 180")
    @Max(value = 180, message = "Longitude must be between -180 and 180")
    @Schema(description = "User's current longitude", example = "100.5018", required = true)
    private Double longitude;
    
    @Schema(description = "Search radius in kilometers (default: 5km)", example = "5.0")
    private Double radiusKm = 5.0;
    
    @Schema(description = "Filter by store category (optional)", example = "Food & Beverage")
    private String category;
}