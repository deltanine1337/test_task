package com.test.task.repos;

import com.test.task.model.House;
import com.test.task.model.keys.HouseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HouseRepo extends JpaRepository<House, Long> {
    @Query(value = "select * from house where district_id in (select district_id from district where " +
            "lower(district_name) like %:district%)", nativeQuery = true)
    Iterable<House> findByDistrict(@Param("district") String district);
    @Query(value = "select * from house where lower(street) like %:street%", nativeQuery = true)
    Iterable<House> findAllByStreet(@Param("street") String street);
    void deleteByHouseId(HouseId houseId);
    House findByHouseId(HouseId houseId);
}
