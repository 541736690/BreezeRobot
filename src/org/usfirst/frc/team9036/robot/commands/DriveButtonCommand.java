package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveButtonCommand extends Command {

    public DriveButtonCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSubsystem.setDirectionInversed(RobotMap.DriveDirectionInversed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean isLeftHeld = Robot.oi.mainJoystick.getRawButton(RobotMap.ButtonLeftDrivePort);
    	boolean isRightHeld = Robot.oi.mainJoystick.getRawButton(RobotMap.ButtonRightDrivePort);
        double lefttrigger = Robot.oi.mainJoystick.getRawAxis(RobotMap.DriveLeftAxisPort);
        double righttrigger = -Robot.oi.mainJoystick.getRawAxis(RobotMap.DriveRightAxisPort);
    	double finaltrigger=lefttrigger+righttrigger;
        if (isLeftHeld && isRightHeld) {
    	    Robot.driveSubsystem.drive(RobotMap.DriveButtonMaxSpeed*finaltrigger, 0);
    	} else if (isLeftHeld) {    
    	    Robot.driveSubsystem.drive(RobotMap.DriveButtonMaxSpeed*finaltrigger, -RobotMap.DriveButtonMaxCurve);
    	} else if (isRightHeld) {
    	    Robot.driveSubsystem.drive(RobotMap.DriveButtonMaxSpeed*finaltrigger,RobotMap.DriveButtonMaxCurve);
    	}    
        }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
