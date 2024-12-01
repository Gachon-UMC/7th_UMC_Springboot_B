package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.service.RegionService.RegionService;
import umc.study.validation.annotation.ExistRegion;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/regions")
public class RegionController {

    private final RegionService regionService;

    // 특정 지역에 가게 추가 API
    @PostMapping("/{regionId}/stores")
    public ResponseEntity<StoreResponseDTO> addStoreToRegion(
            @PathVariable @ExistRegion Long regionId,
            @RequestBody @Valid StoreRequestDTO storeRequestDTO) {
        StoreResponseDTO response = regionService.addStoreToRegion(regionId, storeRequestDTO);
        return ResponseEntity.ok(response);
    }
}
