package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvTurnOnCommand extends AppleTvDeviceCommand {

    public AppleTvTurnOnCommand() {
        super(Command.ON.ordinal(), "Turn On");
    }

    @Override
    public String getIconResourcePath() {
        return "images/turn_on.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("turn_on", deviceId);
    }
}
