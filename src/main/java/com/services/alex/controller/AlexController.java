package com.services.alex.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/services-test")
public class AlexController {

    public List<String> listNames = new ArrayList<>();


    @GetMapping("/list-get")
    public List<String> listNames(){
        return listNames;
    }

    @GetMapping("/clear-list")
    public void clearListNames(){
        listNames.clear();
    }

    @PostMapping("/add-post-names")
    public ResponseEntity<?> addNames(@RequestParam("name") String names ){
        String[] arrayNames = names.split(";");
        listNames.addAll(Arrays.asList(arrayNames));
        Map<String,String> mapResponse = new HashMap<>();
        mapResponse.put("mensaje"," se añadio exitosamente el nombre ".concat(names));
        return ResponseEntity.ok(mapResponse);
    }



}
