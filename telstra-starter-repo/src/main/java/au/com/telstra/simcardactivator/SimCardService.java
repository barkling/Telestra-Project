package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class SimCardService {
    @Autowired
    private SimCardRepo simCardRepo;
    private final RestTemplate restTemplate = new RestTemplate();

    public SimCard createSimCard(String customerEmail, String iccid) {
        // request to SimCardActuator
        String postUrl = "http://localhost:8444/actuate";
        Boolean isActive = restTemplate.postForObject(postUrl, iccid, Boolean.class);

        // save to simcardRepo
        SimCard simCard = new SimCard(customerEmail, iccid, isActive);
        return simCardRepo.save(simCard);
    }

    public SimCard getSimCard(long simCardID) {
        return simCardRepo.findSimCardById(simCardID);
    }
}
