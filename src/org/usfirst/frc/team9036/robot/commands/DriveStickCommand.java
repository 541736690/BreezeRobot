package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStickCommand extends Command {
	
    public DriveStickCommand() {
    	requires(Robot.driveSubsystem);
    }
    
    protected void initialize() {
    	Robot.driveSubsystem.setDirectionInversed(RobotMap.DriveDirectionInversed);
    }
    
    protected void execute() {
    	Robot.driveSubsystem.customDrive(Robot.oi.mainJoystick);
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
