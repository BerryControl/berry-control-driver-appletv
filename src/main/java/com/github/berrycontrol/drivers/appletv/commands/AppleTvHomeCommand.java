package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvHomeCommand extends AppleTvDeviceCommand {
    public AppleTvHomeCommand() {
        super(Command.HOME.ordinal(), "Home");
    }

    @Override
    public String getIconResourcePath() {
        return "images/home.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("home", deviceId);
    }
}
