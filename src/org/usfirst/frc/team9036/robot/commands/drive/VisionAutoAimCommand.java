package org.usfirst.frc.team9036.robot.commands.drive;

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
		requires(Robot.driveSubsystem);
		visionTable = NetworkTable.getTable("vision");
	}

	protected void initialize() {
		visionTable.putNumber("auto_enabled", RobotMap.VisionCommandEnabled);
	}

	protected void execute() {
		double cX = visionTable.getNumber("cX", 0);
		double cY = visionTable.getNumber("cY", 0);
		double delta = Math.abs(cX);
		double speed = delta > RobotMap.VisionTolerance ? RobotMap.VisionSpeed * Math.signum(cX) : 0;

		Robot.driveSubsystem.arcadeDrive(0, speed);

		if (delta > RobotMap.VisionTolerance) {
			visionTable.putNumber("robotdrive_status", RobotMap.VisionCommandInProgress);
		} else {
			visionTable.putNumber("robotdrive_status", RobotMap.VisionCommandEnabled);
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.driveSubsystem.stop();

		visionTable.putNumber("auto_enabled", RobotMap.VisionCommandDisabled);
		visionTable.putNumber("robotdrive_status", RobotMap.VisionCommandDisabled);
	}

	protected void interrupted() {
		end();
	}
}
