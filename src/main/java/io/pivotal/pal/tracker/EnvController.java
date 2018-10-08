package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memLim;
    private String cfInsInd;
    private String cfInsAddr;

    public EnvController(@Value("${PORT:8675}") String port,
                         @Value("${MEMORY_LIMIT:12G}") String memory_limit,
                         @Value("${CF_INSTANCE_INDEX:34}")String cf_instance_index,
                         @Value("${CF_INSTANCE_ADDR:123.sesame.street}")String cf_instance_addr) {
        this.port = port;
        this.memLim = memory_limit;
        this.cfInsInd = cf_instance_index;
        this.cfInsAddr = cf_instance_addr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map map = new HashMap<>();
        map.put("PORT", port);
        map.put("MEMORY_LIMIT", memLim);
        map.put("CF_INSTANCE_INDEX", cfInsInd);
        map.put("CF_INSTANCE_ADDR", cfInsAddr);
        return map;
    }
}
