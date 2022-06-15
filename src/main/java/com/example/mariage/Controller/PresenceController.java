package com.example.mariage.Controller;

import com.example.mariage.Constants.EndPoints.ApiEndPoints;
import com.example.mariage.Model.Presence;
import com.example.mariage.Repository.PresenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping(ApiEndPoints.MAIN)
public class PresenceController {

    @Autowired
    public PresenceRepository presenceRepository;

    @GetMapping(ApiEndPoints.Presence.MAIN)
    public Iterable<Presence> getPresence() {
        return presenceRepository.findAll();
    }

    @PostMapping(ApiEndPoints.Presence.MAIN)
    public String postPresence(@RequestBody Presence presence, @RequestParam String guestId) {
        presence.setGuestId(guestId);
        presence.setId(guestId);
        presenceRepository.save(presence);
        return HttpStatus.CREATED +" " + presence.id;
    }

    @GetMapping(ApiEndPoints.Presence.BY_ID)
    public Optional<Presence> getPresenceById(@PathVariable String id){
        return presenceRepository.findById(id);
    }

    @DeleteMapping(ApiEndPoints.Presence.BY_ID)
    public String deletePresence(@PathVariable String presenceId) {
        presenceRepository.deleteById(presenceId);
        return HttpStatus.OK + " " + presenceId;
    }

    @GetMapping(ApiEndPoints.Presence.BY_GUEST_ID)
    public Optional<Presence> getPresenceByGuestId(@PathVariable String guestId){
        return presenceRepository.findById(guestId);
    }
}
