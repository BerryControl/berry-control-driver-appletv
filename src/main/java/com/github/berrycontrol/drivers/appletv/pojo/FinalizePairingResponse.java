package com.github.berrycontrol.drivers.appletv.pojo;

import java.io.Serializable;

public record FinalizePairingResponse(Boolean deviceHasPaired) implements Serializable {
}
