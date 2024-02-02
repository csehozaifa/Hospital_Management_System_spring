package com.example.hospital.managment;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {
    NurseRepository nurseRepository=new NurseRepository();
    public String addNurse(Nurse nurse){
        //we should write some logic
        //validations
        if(nurse.getNurseId()<0){
            return "enter a valid userId";
        }
        if(nurse.getName().equals(null)){
            return "Name should not be a null";
        }
        //saving it to database
        String ans=nurseRepository.addNurse(nurse);
        return ans;

    }
    public List<Nurse> getList(int age){

        //calling all nurses from the database
        List<Nurse> nurses=nurseRepository.getAllNurses();
        //now i am writing the logic to extract required
        List<Nurse> finalList=new ArrayList<>();
        for(Nurse nurse:nurses){
            if(nurse.getAge()>age){
                finalList.add(nurse);
            }
        }
        return finalList;

    }

    public List<Nurse> getNurseWithQualification(String qualification){

        List<Nurse> nurseList=nurseRepository.getAllNurses();
        //logic to filter based on qualification
        List<Nurse> nurses=new ArrayList<>();
        for(Nurse nurse:nurseList){
            if(nurse.getQualification().equals(qualification)){
                nurses.add(nurse);
            }
        }
        return nurses;
    }

}
