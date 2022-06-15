package com.example.mariage.Controller;

import com.example.mariage.Constants.EndPoints.ApiEndPoints;
import com.example.mariage.Model.Presence;
import com.example.mariage.Repository.GuestRepository;
import com.example.mariage.Model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ApiEndPoints.MAIN)
public class GuestController {

    @Autowired
    public GuestRepository guestRepository;

    @Autowired
    public PresenceController presenceController;

    @GetMapping(ApiEndPoints.Guest.MAIN)
    public Iterable<Guest> getGuest (){

        List<Guest> guestList = new ArrayList<>();
        guestRepository.findAll().forEach(guestList::add);
        return guestList
                .stream()
                .map(guest -> {
                    guest.setPresence(getGuestPresence(guest.getId()));
                    return guest;
                }).collect(Collectors.toList());
    }

    @PostMapping(ApiEndPoints.Guest.MAIN)
    public String postGuest(@RequestBody Guest guest) {
        guestRepository.save(guest);
        return HttpStatus.CREATED +" " + guest.id;
    }

    @GetMapping(ApiEndPoints.Guest.BY_ID)
    public Optional<Guest> getGuestById(@PathVariable String guestId){
        Optional<Guest> guest = guestRepository.findById(guestId);
        guest.get().setPresence(getGuestPresence(guestId));
        return guest;
    }

    @DeleteMapping(ApiEndPoints.Guest.BY_ID)
    public String deleteGuest(@PathVariable String guestId){
        guestRepository.deleteById(guestId);
        return HttpStatus.OK + " " + guestId;
    }

    private Presence getGuestPresence (String guestId){
        Presence presence = new Presence();
        if(presenceController.getPresenceByGuestId(guestId).isPresent()) {
            return presenceController.getPresenceByGuestId(guestId).get();
        } else {
            return null;
        }
    }
}
