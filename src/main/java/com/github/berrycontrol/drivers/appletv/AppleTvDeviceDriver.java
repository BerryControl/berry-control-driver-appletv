package com.github.berrycontrol.drivers.appletv;

import com.github.berrycontrol.driver.api.BerryHubDeviceDriver;
import com.github.berrycontrol.drivers.appletv.AppleTvDeviceCommand.Command;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvBackCommand;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvDownCommand;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvHomeCommand;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvLeftCommand;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvPlayPauseCommand;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvRightCommand;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvSelectCommand;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvTurnOffCommand;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvTurnOnCommand;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvUpCommand;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvVolumeDownCommand;
import com.github.berrycontrol.drivers.appletv.commands.AppleTvVolumeUpCommand;

import java.util.List;

public class AppleTvDeviceDriver  implements BerryHubDeviceDriver<AppleTvDeviceCommand> {
    private static final List<AppleTvDeviceCommand> COMMANDS = List.of(
        new AppleTvTurnOnCommand(),
        new AppleTvTurnOffCommand(),
        new AppleTvBackCommand(),
        new AppleTvDownCommand(),
        new AppleTvHomeCommand(),
        new AppleTvLeftCommand(),
        new AppleTvPlayPauseCommand(),
        new AppleTvRightCommand(),
        new AppleTvSelectCommand(),
        new AppleTvUpCommand(),
        new AppleTvVolumeDownCommand(),
        new AppleTvVolumeUpCommand()
    );
    private static final int REMOTE_LAYOUT_HEIGHT = 8;
    private static final int REMOTE_LAYOUT_WIDTH = 3;
    private static final int[][] REMOTE_LAYOUT = new int[][] {
        {Command.ON.ordinal(), -1, Command.OFF.ordinal()},
        {-1, -1, -1},
        {-1, Command.UP.ordinal(), -1},
        {Command.LEFT.ordinal(), Command.SELECT.ordinal(), Command.RIGHT.ordinal()},
        {-1, Command.DOWN.ordinal(), -1},
        {Command.HOME.ordinal(), -1, Command.VOLUME_UP.ordinal()},
        {Command.BACK.ordinal(), -1, Command.VOLUME_DOWN.ordinal()},
        {-1, Command.PLAY_PAUSE.ordinal(), -1}
    };

    private final String deviceId;

    public AppleTvDeviceDriver(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public List<AppleTvDeviceCommand> getCommands() {
        return COMMANDS;
    }

    @Override
    public int getRemoteLayoutHeight() {
        return REMOTE_LAYOUT_HEIGHT;
    }

    @Override
    public int getRemoteLayoutWidth() {
        return REMOTE_LAYOUT_WIDTH;
    }

    @Override
    public int[][] getRemoteLayout() {
        return REMOTE_LAYOUT;
    }

    @Override
    public void execute(AppleTvDeviceCommand command) {
        command.execute(this.deviceId);
    }

    @Override
    public boolean isDeviceReady() {
        return true;
    }
}
