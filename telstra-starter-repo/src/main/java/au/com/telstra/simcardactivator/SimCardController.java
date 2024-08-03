package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SimCardController {

    @Autowired
    private SimCardService simCardService;

    @PostMapping("/activate")
    public SimCard activateCard(@RequestParam String customerEmail, @RequestParam String iccid) {
        return simCardService.createSimCard(customerEmail, iccid);
    }

    @GetMapping("/query")
    public SimCard getSimCards(@RequestParam long id) {
        return simCardService.getSimCard(id);
    }

}
