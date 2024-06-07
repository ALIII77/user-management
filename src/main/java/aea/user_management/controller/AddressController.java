package aea.user_management.controller;


import aea.user_management.entity.Address;
import aea.user_management.exception.ResourceNotFoundException;
import aea.user_management.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address savedAddress = addressService.save(address);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.findAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Address address = addressService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address addressDetails) {
        addressDetails.setId(id);
        Address updatedAddress = addressService.update(addressDetails);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}