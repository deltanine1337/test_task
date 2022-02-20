package com.test.task.controllers;

import com.test.task.model.dto.DistrictDTO;
import com.test.task.services.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/district")
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictService districtService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Iterable<DistrictDTO> getDistricts() {
        return districtService.getDistricts();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public DistrictDTO addDistrict(@RequestBody DistrictDTO districtDto) {
        return districtService.addDistrict(districtDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteDistrict(@PathVariable("id") Long id) {
        districtService.deleteDistrict(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public DistrictDTO updateDistrict(@PathVariable("id") Long id, @RequestBody DistrictDTO districtDto) {
        return districtService.updateDistrict(id, districtDto);
    }
}
