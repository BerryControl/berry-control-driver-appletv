package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvBackCommand extends AppleTvDeviceCommand {
    public AppleTvBackCommand() {
        super(Command.BACK.ordinal(), "Back");
    }

    @Override
    public String getIconResourcePath() {
        return "images/back.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("back", deviceId);
    }
}
