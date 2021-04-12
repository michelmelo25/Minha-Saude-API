package com.api.minhasaudeapi.controller;

import com.api.minhasaudeapi.model.Cliente;
import com.api.minhasaudeapi.repository.ClienteRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente Add(@RequestBody Cliente cliente){
        try {
            return  clienteRepository.save(cliente);
        }catch(HibernateException e){
            return null;
        }
        }

    @GetMapping
    public List<Cliente> List(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{cpf}")
    public Cliente FindByCPF(@PathVariable String cpf){
        return clienteRepository.findByCpf(cpf);
    }

    @GetMapping("/nome={nome}")
    public List<Cliente> FindByNome(@PathVariable String nome){
        return clienteRepository.findByNome(nome);
    }

    @DeleteMapping("/{id}")
    public void RemoveById(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }

    @GetMapping("/data={data}")
    public List<Cliente> FindByDatePlus(@PathVariable String data){
        return clienteRepository.findByNascimentoIsAfter(data);
    }

    @DeleteMapping("/delete/{cpf}")
    public void RemoveByCpf(@PathVariable String cpf){
        Cliente cliente = clienteRepository.findByCpf(cpf);
        clienteRepository.deleteById(cliente.getId());
    }
//    @RequestHeader("cpf")
}
