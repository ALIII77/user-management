package aea.user_management.service.implementation;


import aea.user_management.entity.Telephone;
import aea.user_management.repository.TelephoneRepository;
import aea.user_management.service.TelephoneService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TelephoneServiceImpl implements TelephoneService {


    @Autowired
    private TelephoneRepository telephoneRepository;

    @Override
    public Telephone save(Telephone telephone) {
        return telephoneRepository.save(telephone);
    }

    @Override
    public List<Telephone> findAll() {
        return telephoneRepository.findAll();
    }

    @Override
    public Optional<Telephone> findById(Long id) {
        return telephoneRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        telephoneRepository.deleteById(id);
    }

    @Override
    public Telephone update(Telephone telephone) {
        if (telephone.getId() == null || !telephoneRepository.existsById(telephone.getId())) {
            throw new IllegalArgumentException("Telephone not found");
        }
        return telephoneRepository.save(telephone);
    }



}
