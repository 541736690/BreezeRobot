package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;
import org.usfirst.frc.team9036.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAdjustTurningCommand extends Command {
	double targetAngle = 0;
	int driveDirection = DriveSubsystem.driveDirection;
    public DriveAdjustTurningCommand(double i) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    	this.targetAngle = i;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double CurrentAngle = Math.abs(Robot.gyroSubsystem.getAngle() % 360);
    	double direction = 0;
    	if (CurrentAngle <180 && targetAngle == 0){
    		direction = -1;
    	} else if (CurrentAngle >= 180 && targetAngle == 0){
    		direction = 1;
    	} else if (CurrentAngle < 180 && targetAngle == 180){
    		direction = 1;
    	} else if (CurrentAngle >= 180 && targetAngle == 180){
    		direction = -1;
    	}
    	double currentLeftAngle = Math.abs(Robot.gyroSubsystem.getAngle() % 360-targetAngle);
    	if (currentLeftAngle >= RobotMap.DriveGyroRotateLimitAngle){
			Robot.driveSubsystem.arcadeDrive(0, driveDirection * direction * RobotMap.DriveGyroRotateMaxSpeed);
		}else if (currentLeftAngle < RobotMap.DriveGyroRotateLimitAngle && currentLeftAngle > 0){
			Robot.driveSubsystem.arcadeDrive(0, driveDirection * direction * currentLeftAngle / RobotMap.DriveGyroRotateLimitAngle * 2);
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
