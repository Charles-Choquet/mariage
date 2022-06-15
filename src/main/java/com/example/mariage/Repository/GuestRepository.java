package com.example.mariage.Repository;

import com.example.mariage.Model.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, String>{

}
