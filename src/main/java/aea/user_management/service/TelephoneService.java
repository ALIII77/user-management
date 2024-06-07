package aea.user_management.service;


import aea.user_management.entity.Telephone;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TelephoneService {

    Telephone save(Telephone telephone);
    List<Telephone> findAll();
    Optional<Telephone> findById(Long id);
    void deleteById(Long id);
    Telephone update(Telephone telephone);


}
