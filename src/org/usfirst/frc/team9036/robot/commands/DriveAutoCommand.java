package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAutoCommand extends Command {

    public DriveAutoCommand() {
        requires(Robot.driveSubsystem);
    }
    
    protected void initialize() {
    	Robot.driveSubsystem.drive(RobotMap.driveAutoSpeed, 0);
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	Robot.driveSubsystem.stop();
    }
    
    protected void interrupted() {
    	end();
    }
}
