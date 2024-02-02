package com.example.hospital.managment;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepository {
    //this is a class that will contain database(Hashmap,mysql)
    HashMap<Integer,Nurse> nurseDb=new HashMap<>();
    public String addNurse(Nurse nurse){
        int key=nurse.getNurseId();
        nurseDb.put(key,nurse);
        return "Nurse Added Successfully";

    }
    public List<Nurse> getAllNurses(){
        return nurseDb.values().stream().toList();
    }
}
