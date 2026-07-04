package tn.validation.Scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledS {
    @Scheduled(fixedRate = 20000)
    public void scheduled() {
        System.out.println("scheduled");
    }

}
