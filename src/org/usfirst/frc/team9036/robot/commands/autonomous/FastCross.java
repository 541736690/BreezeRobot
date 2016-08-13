package org.usfirst.frc.team9036.robot.commands.autonomous;

import org.usfirst.frc.team9036.robot.commands.drive.GyroStraightDrivingCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class FastCross extends CommandGroup {
    
    public FastCross() {
        addSequential(new GyroStraightDrivingCommand(Profile.FastCrossSpeed, Profile.FastCrossTime));
    }
}
