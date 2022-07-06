package uz.pdp.springadvanced.springadvancedcascadetypes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springadvanced.springadvancedcascadetypes.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
