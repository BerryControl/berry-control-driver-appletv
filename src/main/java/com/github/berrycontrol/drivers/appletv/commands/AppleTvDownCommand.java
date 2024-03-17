package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvDownCommand extends AppleTvDeviceCommand {
    public AppleTvDownCommand() {
        super(Command.DOWN.ordinal(), "Down");
    }

    @Override
    public String getIconResourcePath() {
        return "images/down.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("down", deviceId);
    }
}
