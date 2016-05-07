package ru.kpfu.itis.leontjev.warranty_department.service;

import ru.kpfu.itis.leontjev.warranty_department.entity.Client;

import java.util.List;

/**
 * Created by Alexander on 22/04/2016.
 */
public interface ClientService {
    Client create(Client client);
    Client delete(long id);
    List<Client> findAll();
    Client update(Client client);
    Client findById(long id);
}
