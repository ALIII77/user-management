package aea.user_management.controller;

import aea.user_management.entity.Telephone;
import aea.user_management.exception.ResourceNotFoundException;
import aea.user_management.service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telephones")
public class TelephoneController {

    @Autowired
    private TelephoneService telephoneService;

    @PostMapping
    public ResponseEntity<Telephone> createTelephone(@RequestBody Telephone telephone) {
        Telephone savedTelephone = telephoneService.save(telephone);
        return new ResponseEntity<>(savedTelephone, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Telephone>> getAllTelephones() {
        List<Telephone> telephones = telephoneService.findAll();
        return new ResponseEntity<>(telephones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telephone> getTelephoneById(@PathVariable Long id) {
        Telephone telephone = telephoneService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Telephone not found with id: " + id));
        return new ResponseEntity<>(telephone, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Telephone> updateTelephone(@PathVariable Long id, @RequestBody Telephone telephoneDetails) {
        telephoneDetails.setId(id);
        Telephone updatedTelephone = telephoneService.update(telephoneDetails);
        return new ResponseEntity<>(updatedTelephone, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelephone(@PathVariable Long id) {
        telephoneService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
