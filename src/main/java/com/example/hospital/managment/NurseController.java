package com.example.hospital.managment;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    NurseService nurseService=new NurseService();
    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse){
        String ans=nurseService.addNurse(nurse);
        return ans;


    }
    @GetMapping("/getByAge")
    public List<Nurse> getNurseGreaterThanAge(@RequestParam("age")Integer age){
        List<Nurse> nurseList=nurseService.getList(age);
        return nurseList;
    }
    @GetMapping("/getBYQualification")
    public List<Nurse> getNurseByQualification(@RequestParam("qualification")String qualification){

        List<Nurse> nurses=nurseService.getNurseWithQualification(qualification);
        return nurses;

    }

}
