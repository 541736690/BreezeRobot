package org.usfirst.frc.team9036.robot.commands.drive;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ButtonDriveCommand extends Command {

	public ButtonDriveCommand() {
		requires(Robot.driveSubsystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		boolean isLeftHeld = Robot.oi.getMainButton(RobotMap.LeftDriveButtonID);
		boolean isRightHeld = Robot.oi.getMainButton(RobotMap.RightDriveButtonID);
		double __speed = Robot.oi.getMainAxis(RobotMap.DriveLeftAxis) - Robot.oi.getMainAxis(RobotMap.DriveRightAxis);

		Robot.driveSubsystem.arcadeDrive(RobotMap.DriveButtonMaxSpeed * __speed,
				((isLeftHeld ? -1 : 0) + (isRightHeld ? 1 : 0)) * RobotMap.DriveButtonMaxCurve);
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
