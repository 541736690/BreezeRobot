package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveGyroCommand extends Command {

    public DriveGyroCommand() {
    	requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double __delta = Math.abs(Robot.gyroSubsystem.getAngle() - 180.0);
    	double __finalSpeed = __delta / RobotMap.DriveGyroAutoRotateDelta + RobotMap.DriveDirectionMinSpeed;
    	if (__finalSpeed > RobotMap.DriveGyroAutoRotateSpeed) __finalSpeed = RobotMap.DriveGyroAutoRotateSpeed;
    	if (__delta < RobotMap.DriveDirectionTolerance) __finalSpeed = 0;
    	if (Robot.gyroSubsystem.getAngle() < 180) {
        	Robot.driveSubsystem.arcadeDrive(0, __finalSpeed);    		
    	} else {
        	Robot.driveSubsystem.arcadeDrive(0, -__finalSpeed);    		    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
