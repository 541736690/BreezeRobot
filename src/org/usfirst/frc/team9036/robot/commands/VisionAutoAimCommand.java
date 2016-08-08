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
    	double cX = visionTable.getNumber("cX", 0);
    	double cY = visionTable.getNumber("cY", 0);
    	double targetRotate = Math.abs(cX);
    	double speed = 0;
    	if (targetRotate >= 0.4){
    		speed = 0.5;
    	} else if (targetRotate < 0.4 && targetRotate >= 0){
    		speed = 0.3;
    	}
    	if (cX < -RobotMap.DriveGyroTolerance){
    		Robot.driveSubsystem.drive(0, speed);
    	} else if (cX > RobotMap.DriveGyroTolerance){
    		Robot.driveSubsystem.drive(0, -speed);
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
    	end();
    }
}
