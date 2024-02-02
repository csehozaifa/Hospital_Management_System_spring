package com.example.hospital.managment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    HashMap<Integer,Doctor> doctorDb=new HashMap<>();
    @PostMapping("/add")
    public String AddDoctor(@RequestBody Doctor doctor){
        int doctorId=doctor.getDoctorId();
        doctorDb.put(doctorId,doctor);
        return "Doctor added successfully";

    }
}
