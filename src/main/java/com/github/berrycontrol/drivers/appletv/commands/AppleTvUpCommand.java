package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvUpCommand extends AppleTvDeviceCommand {
    public AppleTvUpCommand() {
        super(Command.UP.ordinal(), "Up");
    }

    @Override
    public String getIconResourcePath() {
        return "images/up.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("up", deviceId);
    }
}
