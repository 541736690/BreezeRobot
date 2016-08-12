package org.usfirst.frc.team9036.robot.commands.autonomous;

import org.usfirst.frc.team9036.robot.commands.drive.GyroRotateCommand;
import org.usfirst.frc.team9036.robot.commands.drive.GyroStraightDrivingCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossAndRotate extends CommandGroup {
    
    public CrossAndRotate() {
        addSequential(new GyroStraightDrivingCommand(0.4, 10));
        addSequential(new GyroRotateCommand(60));
    }
}
