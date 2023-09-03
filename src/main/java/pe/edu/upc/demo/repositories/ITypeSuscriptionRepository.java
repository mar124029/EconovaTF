package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.TypeSuscription;

@Repository
public interface ITypeSuscriptionRepository extends JpaRepository<TypeSuscription, Integer> {

	@Query(value = "Select ty.name_suscription, count(e.id_type_suscription) from company e inner join type_suscription ty on e.id_type_suscription = ty.id_type_suscription group by ty.name_suscription", nativeQuery = true)
	public List<String[]> CantidadSuscripcionesXEmpresa();
}
