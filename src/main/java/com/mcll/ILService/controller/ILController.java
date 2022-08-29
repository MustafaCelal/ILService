package com.mcll.ILService.controller;

import com.mcll.ILService.exception.IlAlreadyExistException;
import com.mcll.ILService.exception.IlNotFoundException;
import com.mcll.ILService.model.Il;
import com.mcll.ILService.service.IlService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/iller")
@AllArgsConstructor
public class ILController {

   private final IlService ilService;

    @GetMapping
    public ResponseEntity<List<Il>> getIlller(@RequestParam(required = false) String name){
        return new ResponseEntity<>(ilService.getIller(name), OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable(name = "id") String id){
        return new ResponseEntity<>(getIlById(id), OK);
    }


    @PostMapping
    public ResponseEntity<Il> createIl(@RequestBody Il newIl){
        return new ResponseEntity<>(ilService.createIl(newIl),CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Il> updateIl(@PathVariable(name = "id") String id,@RequestBody Il updatedIl){
        return new ResponseEntity<>(ilService.updateIl(id,updatedIl),OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteIl(@PathVariable(name = "id") String id){
        ilService.deleteIl(id);

        return new ResponseEntity(OK);
    }

    private Il getIlById(String id){
        return ilService.getIlById(id);
    }

    @ExceptionHandler(IlNotFoundException.class)
    public ResponseEntity<String> handleIlNotFoundException(IlNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),NOT_FOUND);
    }

    @ExceptionHandler(IlAlreadyExistException.class)
    public ResponseEntity<String> handleIlAlreadyExistException(IlAlreadyExistException exception){
        return new ResponseEntity<>(exception.getMessage(),NOT_FOUND);
    }

}

