package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class VisionExposureCommand extends Command {

	NetworkTable visionTable;
	
    public VisionExposureCommand() {
		visionTable = NetworkTable.getTable("vision");
   }

    // Called just before this Command runs the first time
    protected void initialize() {
		visionTable.putNumber("manual_exposure", RobotMap.VisionCommandEnabled);
     }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("TARGETING");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
		visionTable.putNumber("manual_exposure", RobotMap.VisionCommandDisabled);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
