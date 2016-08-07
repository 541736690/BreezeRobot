package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class VisionAutoAimCommand extends Command {

	NetworkTable visionTable;
    public VisionAutoAimCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	visionTable = NetworkTable.getTable("vision");
    	visionTable.putNumber("manual_exposure", RobotMap.VisionCommandEnabled);
    	visionTable.putNumber("auto_enabled", RobotMap.VisionCommandEnabled);
    }

    // Called repeatedly when thiable
    protected void execute(){
    	double distanceX = visionTable.getNumber("distanceX", 0);
    	double distanceY = visionTable.getNumber("distanceY", 0);
    	if (distanceX < 0){

    	} else if (distanceX > 0){
    		
    	} else {
    		Robot.driveSubsystem.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	visionTable.putNumber("manual_exposure", RobotMap.VisionCommandDisabled);
    	visionTable.putNumber("auto_enabled", RobotMap.VisionCommandDisabled);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end()
    }
}
