package com.dicapisar.coreManagerAPI.repository;

import com.dicapisar.coreManagerAPI.models.Brand;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("select b from Brand b where b.id =:brandId and b.isActive = true")
    Brand getBrandByIdAAndIsActive(@Param("brandId") Long brandId);

    @Query("select b from Brand b where b.name =:brandName")
    Brand getBrandByName(@Param("brandName") String brandName);

    @Query("select b from Brand b where b.isActive = :typeStatus")
    List<Brand> getBrandListByTypeStatus(@Param("typeStatus") Boolean typeStatus);

    @Query("select b from Brand b")
    List<Brand> getBrandList();

    @Query("select b from Brand b where b.id =:brandId")
    Brand getBrandById(@Param("brandId") Long brandId);

}
