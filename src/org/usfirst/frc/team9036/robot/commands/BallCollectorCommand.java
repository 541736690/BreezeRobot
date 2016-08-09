package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class BallCollectorCommand extends Command {
	public BallCollectorCommand() {
		requires(Robot.ballCollectorSubsystem);
	}

	protected void initialize() {
		Robot.ballCollectorSubsystem.collect();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.ballCollectorSubsystem.stop();
	}

	protected void interrupted() {
		end();
	}
}
