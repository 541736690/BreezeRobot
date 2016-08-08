package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;
import org.usfirst.frc.team9036.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveAdjustTurningCommand extends Command {
	double targetRotateAngle = 0;
	boolean _isFin = false;
	int driveDirection = DriveSubsystem.driveDirection;
    public DriveAdjustTurningCommand(double i) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    	i = i % 360;
    	if (i >= 180) i = i - 360;
    	this.targetRotateAngle = i;
    }
    
    double final_angle;
    int direction;
    // Called just before this Command runs the first time
    protected void initialize() {
    	double __angle = Robot.gyroSubsystem.getAngle();
    	double __leftAngle = Math.floor(__angle / 360.0) * 360 + this.targetRotateAngle;
    	double __rightAngle = __leftAngle + 360;
    	while (__leftAngle > __angle) {
    		__leftAngle -= 360; __rightAngle -= 360;
    	}
    	while (__rightAngle < __angle) {
    		__rightAngle += 360; __leftAngle += 360;
    	}
    	double __leftAngleDelta = Math.abs(__leftAngle - __angle);
    	double __rightAngleDelta = Math.abs(__rightAngle - __angle);
    	direction = 0;
    	if (__leftAngleDelta > __rightAngleDelta) {
    		direction = 1;
    		final_angle = __rightAngle;
    	} else {
    		direction = -1;
    		final_angle = __leftAngle;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double __angleDelta = Math.abs(Robot.gyroSubsystem.getAngle() - final_angle);
    	if (__angleDelta <= RobotMap.DriveGyroTolerance) {
    		Robot.driveSubsystem.stop();
    		this._isFin = true;
    	}
    	else if (__angleDelta <= RobotMap.DriveGyroRotateLimitAngle) {
    		Robot.driveSubsystem.arcadeDrive(0, direction * RobotMap.DriveGyroRotateMinSpeed);
    	} else {
    		Robot.driveSubsystem.arcadeDrive(0, direction * RobotMap.DriveGyroRotateMaxSpeed);
    	}
    	System.out.println("RUNNING");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this._isFin;
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
