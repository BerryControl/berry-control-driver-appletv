package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvLeftCommand extends AppleTvDeviceCommand {
    public AppleTvLeftCommand() {
        super(Command.LEFT.ordinal(), "Left");
    }

    @Override
    public String getIconResourcePath() {
        return "images/left.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("left", deviceId);
    }
}
