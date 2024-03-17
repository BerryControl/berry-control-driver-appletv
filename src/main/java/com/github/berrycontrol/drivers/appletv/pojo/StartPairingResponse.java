package com.github.berrycontrol.drivers.appletv.pojo;

import java.io.Serializable;

public record StartPairingResponse(String pairingRequest, Boolean deviceProvidesPin) implements Serializable {
}
