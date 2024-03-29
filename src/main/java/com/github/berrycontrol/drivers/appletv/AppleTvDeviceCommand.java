package com.github.berrycontrol.drivers.appletv;

import com.github.berrycontrol.driver.api.BerryHubDeviceCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;

public abstract class AppleTvDeviceCommand extends BerryHubDeviceCommand {
    public enum Command {
        BACK,
        DOWN,
        HOME,
        LEFT,
        PLAY_PAUSE,
        RIGHT,
        SELECT,
        ON,
        OFF,
        UP,
        VOLUME_DOWN,
        VOLUME_UP
    }

    protected final RestTemplate restTemplate = new RestTemplate();

    private byte[] icon = null;

    public AppleTvDeviceCommand(int id, String title) {
        super(id, title);
    }

    public byte[] getIcon() {
        return readIcon(getIconResourcePath());
    }

    public abstract String getIconResourcePath();

    public abstract void execute(String deviceId);

    protected void execute(String command, String deviceId) {
        try {
            String url = String.format("http://localhost:9090/control/%s/%s", command, deviceId);

            ResponseEntity<Void> response = restTemplate.postForEntity(url, null, Void.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected byte[] readIcon(String resourcePath) {
        if (icon != null) {
            return icon;
        }

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            int length = is.available();
            byte[] data = new byte[length];

            is.read(data, 0, length);

            icon = data;
            return icon;
        } catch (Exception x) {
            return null;
        }
    }
}
