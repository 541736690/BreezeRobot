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
    	int means=0; double i=0;
    	if (Robot.oi.mainJoystick.getRawButton(RobotMap.LeftTurningButtonPort)==true){
    		i=-1;
    	}else if (Robot.oi.mainJoystick.getRawButton(RobotMap.RightTurningButtonPort)==true){
    		i=1;
    	}
    	double startAngle = Math.abs(Robot.gyroSubsystem.getAngle());
    	double finalAngle = Math.abs(startAngle + i*90.0);
    	double currentAngle = Math.abs(Robot.gyroSubsystem.getAngle());
    	double leftAngle = Math.abs(finalAngle - currentAngle);
    	double speed=0;
    	if (leftAngle>=40){
    		speed=1;
    	}else if (leftAngle<40 && leftAngle>0){
    		speed=0.5;
    	}
    	Robot.driveSubsystem.drive(0,speed);
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
    	end();
    }
}
