package ru.kpfu.itis.leontjev.warranty_department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.leontjev.warranty_department.entity.Client;
import ru.kpfu.itis.leontjev.warranty_department.repository.ClientRepository;
import ru.kpfu.itis.leontjev.warranty_department.service.ClientService;

import java.util.List;

/**
 * Created by Alexander on 02/05/2016.
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    @Transactional
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Client delete(long id) {
        Client client = clientRepository.findOne(id);
        clientRepository.delete(client);
        return client;
    }

    @Override
    @Transactional
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public Client update(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    @Transactional
    public Client findById(long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public List<Client> findAllByOrderByNameAsc() {
        return clientRepository.findAllByOrderByNameAsc();
    }
}
