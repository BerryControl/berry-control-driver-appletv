package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvVolumeUpCommand extends AppleTvDeviceCommand {
    public AppleTvVolumeUpCommand() {
        super(Command.VOLUME_UP.ordinal(), "Volume Up");
    }

    @Override
    public String getIconResourcePath() {
        return "images/volume_up.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("volume_up", deviceId);
    }
}
