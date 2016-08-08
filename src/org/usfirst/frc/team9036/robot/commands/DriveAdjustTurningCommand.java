package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;
import org.usfirst.frc.team9036.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAdjustTurningCommand extends Command {
	double targetRotateAngle = 0;
	double targetAngle1 = 0;
	double targetAngle2 = 0;
	double targetAngle = 0;
	double currentLeftAngle = 0;
	double currentAngle = 0;
	int driveDirection = DriveSubsystem.driveDirection;
    public DriveAdjustTurningCommand(double i) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    	this.targetRotateAngle = i;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int direction = 0;
    	currentAngle = Robot.gyroSubsystem.getAngle();
    	if (currentAngle >= 0){
    		targetAngle1 = targetAngle + 360 * Math.floor(currentAngle / 360);
    		targetAngle2 = targetAngle1 + 360;
    		direction = 1;
    	} else {
    		targetAngle1 = targetAngle + 360 * Math.floor(currentAngle / 360); 
    		targetAngle2 = targetAngle1 - 360;
    		direction = -1;
    	}
    	if (Math.abs(currentAngle - targetAngle1) >= Math.abs(targetAngle2 - currentAngle)){
    		direction = direction * 1;
    		currentLeftAngle = Math.abs(targetAngle2 - currentAngle);
    	} else {
    		direction = direction * -1;
    		currentLeftAngle = Math.abs(targetAngle1 - currentAngle);
    	}
    	if (currentLeftAngle >= RobotMap.DriveGyroRotateLimitAngle) {
			Robot.driveSubsystem.arcadeDrive(0, driveDirection * direction * RobotMap.DriveGyroRotateMaxSpeed);
		} else if (currentLeftAngle < RobotMap.DriveGyroRotateLimitAngle && currentLeftAngle > 0){
			Robot.driveSubsystem.arcadeDrive(0, driveDirection * direction * currentLeftAngle / (RobotMap.DriveGyroRotateLimitAngle * 2) + 0.5);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (currentLeftAngle <= RobotMap.DriveDirectionTolerance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
