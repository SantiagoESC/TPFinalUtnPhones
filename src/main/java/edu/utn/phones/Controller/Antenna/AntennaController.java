package edu.utn.phones.Controller.Antenna;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.CallController;
import edu.utn.phones.Domain.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/antenna/call")
public class AntennaController {

    private final  CallController callController;

    @Autowired
    public AntennaController(CallController callController) {
        this.callController = callController;
    }

    @PostMapping("/")

    public ResponseEntity add(@RequestBody Call newCall) {
        Call ut = this.callController.add(newCall);

        return ResponseEntity.created(Configuration.getLocation(ut)).build();


    }
}
