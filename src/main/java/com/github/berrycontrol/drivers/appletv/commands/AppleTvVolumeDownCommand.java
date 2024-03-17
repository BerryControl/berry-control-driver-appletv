package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvVolumeDownCommand extends AppleTvDeviceCommand {
    public AppleTvVolumeDownCommand() {
        super(Command.VOLUME_DOWN.ordinal(), "Volume Down");
    }

    @Override
    public String getIconResourcePath() {
        return "images/volume_down.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("volume_down", deviceId);
    }
}
