package com.nikka.powerapp.controllers;

import com.nikka.powerapp.dao.model.Complain;
import com.nikka.powerapp.service.ComplainBookService;
import com.nikka.powerapp.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class ComplainBookController {

    private ComplainBookService complainBookService;
    private SmsService smsService;

    Logger logger = LoggerFactory.getLogger(ComplainBookController.class);

    public ComplainBookController(ComplainBookService complainBookService,
                                  SmsService smsService) {
        this.complainBookService = complainBookService;
        this.smsService = smsService;
    }

    @GetMapping("/complains")
    public List<Complain> getAllComplains() {
        List<Complain> complains = complainBookService.getAllComplains();
        return complains;
    }

    @PostMapping(value = "/complain", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Complain addComplain(@RequestBody Complain complain) {
        Complain newComplain = complainBookService.addComplain(complain);
        if (complain.getId() == null) {
            smsService.sendSMS(complain);
        }
        return newComplain;
    }

}
