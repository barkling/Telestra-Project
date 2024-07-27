package au.com.telstra.simcardactivator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class ActivateController {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String actuatorurl = "http://localhost:8080/actuator";

    @GetMapping("/actuate")
    public ResponseEntity<String> actuator(@RequestBody SimResource simCard) {
//        准备请求的负载
        String actuatorPayload = String.format("{\"iccid\":\"%s\"}", simCard.getIccid());
//        调用actuator微服务
        ActuatorResponse actuatorResponse = restTemplate.postForObject(actuatorurl, actuatorPayload, ActuatorResponse.class);
//        检查结果并输出
        if ( actuatorResponse != null && actuatorResponse.isSuccess()){
            return ResponseEntity.ok("SIM卡激活成功");
        }
        else {
            return ResponseEntity.ok("SIM卡激活失败");
        }
    }
}
