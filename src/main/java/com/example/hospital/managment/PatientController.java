package com.example.hospital.managment;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
HashMap<Integer, Patient> patientDb = new HashMap<>();
@PostMapping("/add")
public String addPatient1(@RequestBody Patient patient){
    return "added successfully";
}
@PostMapping("/addPatientViaParameters")


   public String addPatient(@RequestParam("patientId") Integer patientId,
                            @RequestParam("name") String name,
                            @RequestParam("age") Integer age,
                            @RequestParam("diseases") String diseases
                            ){
   Patient patient=new Patient(patientId,name,diseases,age);
   patientDb.put(patientId,patient);
           return "Patient added successfully";
}
@PostMapping("/addPatientViaRequestBody")
    public String addPatient(@RequestBody Patient patient){
    int key=patient.getPatientId();
    patientDb.put(key,patient);
    return "patient added via Request Body";
}
@GetMapping("/getInfoViaPathVariable/{patientId}")
public Patient getInfoPatient(@PathVariable("patientId")Integer patientId){
    Patient patient=patientDb.get(patientId);
    return patient;
}
@GetMapping("/getPatients/{age}/{diseases}")
public List<Patient> getPatients(@PathVariable("age")Integer age,@PathVariable("diseases")String diseases){
    List<Patient> patients=new ArrayList<>();
    for(Patient p:patientDb.values()){
        if(p.getAge()>age && p.getDiseases().equals(diseases)){
            patients.add(p);

        }
    }
    return patients;
}

@GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientId")Integer patientId){
    Patient patient=patientDb.get(patientId);
    return patient;
}
@GetMapping("/getAllPatients")
    public List<Patient> getAllPatients(){
    List<Patient> patients=new ArrayList<>();
    for(Patient p:patientDb.values()){
        patients.add(p);
    }
    return patients;
}
@GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name")String name){
    for(Patient p:patientDb.values()){
        if(p.getName().equals(name)){
            return p;
        }
    }
    return null;
}
@GetMapping("getPatientsListGreaterThanAge")
    public List<Patient> getPatientsListGreaterThanAge(@RequestParam("age")Integer age){
    List<Patient> patients=new ArrayList<>();
    for(Patient p:patientDb.values()){
        if(p.getAge()>age){
             patients.add(p);
        }
    }
    return patients;
}
@PutMapping("/updateDisease")
public String updateDisease(@RequestParam("patientId")Integer patientId,@RequestParam("dieases")String diseases){
    if(patientDb.containsKey(patientId)) {
        Patient patient = patientDb.get(patientId);
        patient.setDiseases(diseases);
        patientDb.put(patientId, patient);
        return "update successfully";
    }
    else {
        return "patient does not exist";
    }
}
@PutMapping("/updatePatientDetails")
    public String updatePatientDetails(@RequestBody Patient patient){
    int key= patient.getPatientId();
    if(patientDb.containsKey(key)){
        patientDb.put(key,patient);
        return "update patient successfully";
    }
    else {
        return "data was not existing";
    }


}
@DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam("patientId")Integer patientId){
    patientDb.remove(patientId);
    return "Patient deleted successfully";
}
}