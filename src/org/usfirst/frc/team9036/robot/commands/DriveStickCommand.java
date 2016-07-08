package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStickCommand extends Command {

    public DriveStickCommand() {
    	requires(Robot.driveSubsystem);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	Robot.driveSubsystem.drive(Robot.oi.mainJoystick.getMagnitude() * RobotMap.driveStickSpeedDelta, 0);
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
