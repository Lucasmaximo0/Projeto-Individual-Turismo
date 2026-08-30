package com.turismo.projetoindividual;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Destino")

public class TurismoController {

    private List<Destino> destinos = new ArrayList<>();
    private  Integer contador = 0;

    @PostMapping
    public  Destino cadastrar(@RequestBody Destino destino){
        destino.setId(++contador);
        destinos.add(destino);

        return destino;

    }

    @GetMapping
    public List<Destino> listar(){
        return  destinos;
    }



}
