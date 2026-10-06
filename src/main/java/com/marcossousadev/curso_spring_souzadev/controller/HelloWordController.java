package com.marcossousadev.curso_spring_souzadev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hello")
public class HelloWordController {
    // posso definir uma response status atráves de uma anotação

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(value = "/{id}")
    public String hello_world(@PathVariable Integer id){
        return "Hello World" + id;
    }

    @GetMapping("/buscar")
    // se não passamos required para o @RequestParam, por padrão ele aplica, true, obrigatório
    // para um novo Query Param adicionamos um &
    // exemplo: localhost:8080/users?fiter=Marcos&orderBy=desc
    // se por padrão esse parametro é obrigatório e eu não envio
    // vou receber um erro de BadRequest, que é um erro do cliente
    public ResponseEntity<String> hello(
            @RequestParam(value = "filter", required = true) String name,
            @RequestParam(value = "orderBy", required = true) String orderBy
    ) {
        return ResponseEntity.ok("Hello World!: " + name + " " + orderBy);
    }

    @GetMapping("/get")
    public ResponseEntity<String> helloW() {
        return new ResponseEntity<>("oi", HttpStatus.OK);
    }

    @GetMapping("/build")
    public ResponseEntity<Void> helloWorld(){
        return ResponseEntity.ok().build();
    }

    // padrões de retorno utilizado
    // GET
    // se eu quero retornar um dado
    @PatchMapping
    public ResponseEntity<String> getData(){
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    // PUT
    // se eu não quero retornar nada, apenas o status
    @PutMapping
    public ResponseEntity<Void> returnNada(){
        return ResponseEntity.ok().build();
    }

    // DELETE
    // é muito comum usar um status no-content
    @DeleteMapping
    public ResponseEntity<Void> deleteData() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // quando trabalhamos com criação e modificação, enviamos dados pelo body
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/criando-hello")
    public String create(@RequestBody String name) {
        return name;
    }
}
