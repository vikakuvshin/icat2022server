package net.ausiasmarch.icat2022.repository;

import net.ausiasmarch.icat2022.entity.HostEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HostRepository extends JpaRepository<HostEntity, Long> {

    @Query(value = "select * from host where (nombre like %?2% or dni like %?3% or apellido1 like %?4% or apellido2 like %?5%)", nativeQuery = true)
    Page<HostEntity> findByNombreIgnoreCaseContainingOrDniIgnoreCaseContainingOrApellido1IgnoreCaseContainingOrApellido2IgnoreCaseContaining(
        Long filtertype, String nombre, String dni, String apellido1, String apellido2, Pageable oPageable);

    Page<HostEntity> findByNombreIgnoreCaseContainingOrDniIgnoreCaseContainingOrApellido1IgnoreCaseContainingOrApellido2IgnoreCaseContaining(
	String nombre, String dni, String apellido1, String apellido2, Pageable oPageable);
}
