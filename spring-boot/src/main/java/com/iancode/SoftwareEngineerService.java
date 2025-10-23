package com.iancode;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + "not found."));
    }

    public void deleteSoftwareEngineerById(Integer id) {
        boolean exist = softwareEngineerRepository.existsById(id);
        if(!exist){
            throw new SoftwareEngineerNotFoundException("Engineer with ID "+ id +" not found.");
        }
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineer(Integer id, SoftwareEngineer updateSoftwareEngineer) {
        SoftwareEngineer update = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new SoftwareEngineerNotFoundException("Engineer with ID "+ id +" not found."));

        update.setName(updateSoftwareEngineer.getName());   
        update.setTechStack(updateSoftwareEngineer.getTechStack());

        softwareEngineerRepository.save(update);
    }

    public SoftwareEngineer searchByName(String name) {
        return softwareEngineerRepository.findByName(name)
                .orElseThrow(() -> new SoftwareEngineerNotFoundException("Engineer with name " + name + " not found"));
    }
}
