package org.usfirst.frc.team9036.robot.commands.shooter;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallShooterCommand extends Command {

	public BallShooterCommand() {
		requires(Robot.ballShooterSubsystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.ballShooterSubsystem.move();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.ballShooterSubsystem.stop();
	}

	protected void interrupted() {
		end();
	}
}
