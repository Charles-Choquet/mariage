package com.example.mariage.Repository;

import com.example.mariage.Model.Presence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenceRepository  extends CrudRepository<Presence, String> {
}
