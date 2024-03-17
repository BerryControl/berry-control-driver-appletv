package com.github.berrycontrol.drivers.appletv.pojo;

import java.io.Serializable;

public record StartPairingRequest(String remoteName) implements Serializable {
}
