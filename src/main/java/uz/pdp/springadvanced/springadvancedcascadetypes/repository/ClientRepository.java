package uz.pdp.springadvanced.springadvancedcascadetypes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.springadvanced.springadvancedcascadetypes.entity.Client;

@RepositoryRestResource(path = "client")
public interface ClientRepository extends JpaRepository<Client, Long> {

}
