package com.codegym.controller;

import com.codegym.model.entity.SmartPhone;
import com.codegym.model.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class PhoneRestController {
    @Autowired
    private ISmartPhoneService smartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone){
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("smartphones", smartPhoneService.findAll());
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditPage(@PathVariable Long id){
        SmartPhone smartPhone = this.smartPhoneService.findById(id).get();
        return new ModelAndView("/edit","smartPhone",smartPhone);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editSmartPhone(@PathVariable Long id,@RequestBody SmartPhone smartPhone){
        Optional<SmartPhone> smartPhoneOptional = smartPhoneService.findById(id);
        if (!smartPhoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SmartPhone currentSmartphone = smartPhoneOptional.get();

        smartPhone.setId(currentSmartphone.getId());
        smartPhone.setModel(currentSmartphone.getModel());
        smartPhone.setProducer(currentSmartphone.getProducer());
        smartPhone.setPrice(currentSmartphone.getPrice());

        smartPhoneService.save(smartPhone);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
