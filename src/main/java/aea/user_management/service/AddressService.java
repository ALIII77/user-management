package aea.user_management.service;


import aea.user_management.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AddressService {

    Address save(Address address);

    List<Address> findAll();

    Optional<Address> findById(Long id);

    void deleteById(Long id);

    Address update(Address address);


}
