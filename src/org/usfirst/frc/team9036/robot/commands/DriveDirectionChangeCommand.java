package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.RobotMap;
import org.usfirst.frc.team9036.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class DriveDirectionChangeCommand extends Command {
	
	NetworkTable visionTable;
    
	public DriveDirectionChangeCommand() {
    }

    protected void initialize() {
    	visionTable = NetworkTable.getTable("vision");
    	DriveSubsystem.driveDirection = DriveSubsystem.driveDirection * -1;
    	if (DriveSubsystem.driveDirection == 1){
    		visionTable.putNumber("camera_id", 0);
    	} else if ( DriveSubsystem.driveDirection == -1){
    		visionTable.putNumber("camera_id", 1);
    	}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	end();
    }
}
