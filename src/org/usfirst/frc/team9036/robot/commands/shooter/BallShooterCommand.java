package org.usfirst.frc.team9036.robot.commands.shooter;

import org.usfirst.frc.team9036.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallShooterCommand extends Command {

	public BallShooterCommand() {
		requires(Robot.ballShooterSubsystem);
		requires(Robot.ballCollectorSubsystem);
	}

	protected void initialize() {
		setTimeout(3);
	}

	protected void execute() {
		Robot.ballCollectorSubsystem.collect(1);
		Robot.ballShooterSubsystem.move();
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.ballCollectorSubsystem.stop();
		Robot.ballShooterSubsystem.stop();
	}

	protected void interrupted() {
		end();
	}
}
