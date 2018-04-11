package br.com.udemy.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.udemy.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String>{
    Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);
}