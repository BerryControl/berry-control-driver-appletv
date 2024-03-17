package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvTurnOffCommand extends AppleTvDeviceCommand {
    public AppleTvTurnOffCommand() {
        super(Command.OFF.ordinal(), "Turn Off");
    }

    @Override
    public String getIconResourcePath() {
        return "images/turn_off.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("turn_off", deviceId);
    }
}
