package net.ausiasmarch.icat2022.repository;

import net.ausiasmarch.icat2022.entity.StayEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StayRepository extends JpaRepository<StayEntity, Long> {

    Page<StayEntity> findByNombreIgnoreCaseContainingOrCodigoIgnoreCaseContaining(String nombre, String codigo, Pageable oPageable);

    @Query(value = "select * from stay where (nombre like %?2% or raza like %?3% or edad like %?4% or relaciónConOtrosGatos like %?5%)",
            nativeQuery = true)
    Page<StayEntity> findByNombreOrRazaOrEdadOrRelaciónConOtrosGatos(long IdTipoproducto, String nombre, String codigo, Pageable oPageable);
}
