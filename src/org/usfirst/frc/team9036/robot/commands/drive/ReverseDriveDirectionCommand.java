package org.usfirst.frc.team9036.robot.commands.drive;

import org.usfirst.frc.team9036.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReverseDriveDirectionCommand extends Command {

	private static boolean isInversed = false;

	public ReverseDriveDirectionCommand() {
	}

	protected void initialize() {
		Robot.driveSubsystem.setDriveDirection(isInversed);
		isInversed = !isInversed;
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
