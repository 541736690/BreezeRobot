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
		double __speed = (Robot.oi.getMainAxis(RobotMap.DriveLeftAxis) - Robot.oi.getMainAxis(RobotMap.DriveRightAxis))
				* RobotMap.DriveButtonMaxSpeed + Robot.oi.getShootAxis(RobotMap.DriveSlightSpeedAxis) 
				* RobotMap.ShootAdjustSpeed;
		double __curve = ((isLeftHeld ? -1 : 0) + (isRightHeld ? 1 : 0)) * RobotMap.DriveButtonMaxCurve 
				+ Robot.oi.getShootAxis(RobotMap.DriveSlightCurveAxis) * RobotMap.ShootAdjustCurve;
		Robot.driveSubsystem.arcadeDrive(__speed, __curve);
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
