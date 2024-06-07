package aea.user_management.service.implementation;


import aea.user_management.entity.Address;
import aea.user_management.repository.AddressRepository;
import aea.user_management.service.AddressService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {


    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address update(Address address) {
        if (address.getId() == null || !addressRepository.existsById(address.getId())) {
            throw new IllegalArgumentException("Address not found");
        }
        return addressRepository.save(address);
    }


}
