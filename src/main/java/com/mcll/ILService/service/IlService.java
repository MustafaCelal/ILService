package com.mcll.ILService.service;

import com.mcll.ILService.exception.IlAlreadyExistException;
import com.mcll.ILService.exception.IlNotFoundException;
import com.mcll.ILService.model.Il;
import com.mcll.ILService.repository.IlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IlService {
    private final IlRepository ilRepository;
    public List<Il> getIller(String name) {
        if (name==null)
            return ilRepository.findAll();
        else return ilRepository.findByName(name).get();
    }


    public Il createIl(Il newIl) {
        if (ilRepository.findByName(newIl.getName()).get()==null)
            return ilRepository.save(newIl);
        else throw new IlAlreadyExistException("il already exist!");
    }

    public void deleteIl(String id) {
        ilRepository.deleteById(id);
    }

    public Il getIlById(String id) {
        return ilRepository.findById(id)
                .orElseThrow(()->new IlNotFoundException("il not found!"));

        /*Optional<Il> il = ilRepository.findById(ilId);
        if (il.isEmpty()){
            throw new RuntimeException("Il not found");
        }
        return il.get();*/
    }

    public Il updateIl(String id, Il updatedIl) {
        Il oldIl = getIlById(id);
        oldIl.setName(updatedIl.getName());
        return ilRepository.save(oldIl);
    }
}
