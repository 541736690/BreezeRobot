package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDirectTurningCommand extends Command {
	double targetTurningAngle = 0;
	double driveDirection = Robot.driveSubsystem.driveDirection;
    public DriveDirectTurningCommand(double i) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    	this.targetTurningAngle = i;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double direction = targetTurningAngle / 90;
    	double targetAngle = (Robot.gyroSubsystem.getAngle() % 360 + 360) % 360 + targetTurningAngle;
    	double currentLeftAngle = Math.abs((Robot.gyroSubsystem.getAngle() % 360 + 360) % 360 - targetAngle);
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
