package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ballArmDown extends Command {
	private int time;
    public ballArmDown(int t) {
    	requires(Robot.armControl);
    	time = t;
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    	Robot.armControl.drive(-Robot.oi.mainJoystick.getMagnitude() * RobotMap.motorArmSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armControl.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
