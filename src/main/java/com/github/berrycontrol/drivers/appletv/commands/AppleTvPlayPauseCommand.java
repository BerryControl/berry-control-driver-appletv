package com.github.berrycontrol.drivers.appletv.commands;

import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand;

public class AppleTvPlayPauseCommand extends AppleTvDeviceCommand {
    public AppleTvPlayPauseCommand() {
        super(Command.PLAY_PAUSE.ordinal(), "Play/Pause");
    }

    @Override
    public String getIconResourcePath() {
        return "images/play_pause.png";
    }

    @Override
    public void execute(String deviceId) {
        execute("play_pause", deviceId);
    }
}
