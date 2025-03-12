package utility;

import java.util.HashMap;
import java.util.Map;

public class MobileEmulationConfig {
    public static Map<String, Object> getEmulationSettings(String deviceName) {
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", deviceName);
        return mobileEmulation;
    }
}
