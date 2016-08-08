package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;
import org.usfirst.frc.team9036.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveButtonCommand extends Command {
	
    public DriveButtonCommand() {
    	requires(Robot.driveSubsystem);
    }

    protected void initialize() {
    	Robot.driveSubsystem.setDirectionInversed(RobotMap.DriveDirectionInversed);
    }

    protected void execute() {
    	int direction = DriveSubsystem.driveDirection;
    	boolean isLeftHeld = Robot.oi.mainJoystick.getRawButton(RobotMap.LeftDriveButtonID);
    	boolean isRightHeld = Robot.oi.mainJoystick.getRawButton(RobotMap.RightDriveButtonID);
        double lefttrigger = Robot.oi.mainJoystick.getRawAxis(RobotMap.DriveLeftAxis);
        double righttrigger = Robot.oi.mainJoystick.getRawAxis(RobotMap.DriveRightAxis);
    	double finaltrigger = lefttrigger - righttrigger;
        if (isLeftHeld && isRightHeld) {
    	    Robot.driveSubsystem.drive(RobotMap.DriveButtonMaxSpeed * finaltrigger, 0);
    	} else if (isLeftHeld) {    
    	    Robot.driveSubsystem.drive(RobotMap.DriveButtonMaxSpeed * finaltrigger, direction * RobotMap.DriveButtonMaxCurve);
    	} else if (isRightHeld) {
    	    Robot.driveSubsystem.drive(RobotMap.DriveButtonMaxSpeed * finaltrigger, -direction * RobotMap.DriveButtonMaxCurve);
    	} else {
    		Robot.driveSubsystem.stop();
    	}
        System.out.println("DRIVING");
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
