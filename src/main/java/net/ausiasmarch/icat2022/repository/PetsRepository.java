package net.ausiasmarch.icat2022.repository;

import net.ausiasmarch.icat2022.entity.PetsEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PetsRepository extends JpaRepository<PetsEntity, Long> {

    Page<PetsEntity> findByNombreIgnoreCaseContainingOrRazaIgnoreCaseContaining(String nombre, String raza, Pageable oPageable);

    @Query(value = "select * from pets where (nombre like %?2% or raza like %?3% or edad like %?4% or relaciónConOtrosGatos like %?5%)",
            nativeQuery = true)
    Page<PetsEntity> findByNombreOrRazaOrEdadOrRelaciónConOtrosGatos(long IdTipoproducto, String nombre, String raza, Pageable oPageable);
}
