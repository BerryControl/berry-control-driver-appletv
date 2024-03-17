package com.github.berrycontrol.drivers.appletv.pojo;

import java.io.Serializable;

public record FinalizePairingRequest(String pin, Boolean deviceProvidesPin) implements Serializable {
}
