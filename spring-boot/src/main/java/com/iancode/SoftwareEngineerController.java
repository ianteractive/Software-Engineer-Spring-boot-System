package com.iancode;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers(){
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id){
        return softwareEngineerService.getEngineerById(id);
    }

    @PostMapping
    public void AddNewSoftwareEngineer(@Valid @RequestBody SoftwareEngineer softwareEngineer){
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @DeleteMapping("{id}")
    public void DeleteSoftwareEngineer(@PathVariable Integer id){
        softwareEngineerService.deleteSoftwareEngineerById(id);
    }

    @PutMapping("{id}")
    public void UpdateSoftwareEngineer(@PathVariable Integer id,
                                       @RequestBody SoftwareEngineer updateSoftwareEngineer){
        softwareEngineerService.updateSoftwareEngineer(id, updateSoftwareEngineer);
    }

    @GetMapping("/search")
    public SoftwareEngineer searchByName(@RequestParam String name){
        return softwareEngineerService.searchByName(name);
    }



}
