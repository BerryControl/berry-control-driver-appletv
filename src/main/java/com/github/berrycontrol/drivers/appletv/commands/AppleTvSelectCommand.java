package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvSelectCommand extends AppleTvDeviceCommand {
    public AppleTvSelectCommand() {
        super(Command.SELECT.ordinal(), "Select");
    }

    @Override
    public String getIconResourcePath() {
        return "images/select.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("select", deviceId);
    }
}
