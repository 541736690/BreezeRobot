package org.usfirst.frc.team9036.robot.commands.autonomous;

import org.usfirst.frc.team9036.robot.commands.drive.GyroRotateCommand;
import org.usfirst.frc.team9036.robot.commands.drive.GyroStraightDrivingCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SlowCross extends CommandGroup {
    
    public SlowCross() {
        addSequential(new GyroStraightDrivingCommand(Profile.SlowCrossSpeed, Profile.SlowCrossTime));
    }
}
