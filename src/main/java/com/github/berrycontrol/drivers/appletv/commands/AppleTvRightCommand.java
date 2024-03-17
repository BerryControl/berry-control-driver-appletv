package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvRightCommand extends AppleTvDeviceCommand {
    public AppleTvRightCommand() {
        super(Command.RIGHT.ordinal(), "Right");
    }

    @Override
    public String getIconResourcePath() {
        return "images/right.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("right", deviceId);
    }
}
