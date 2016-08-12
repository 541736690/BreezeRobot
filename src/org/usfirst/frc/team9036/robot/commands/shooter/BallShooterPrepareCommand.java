package org.usfirst.frc.team9036.robot.commands.shooter;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class BallShooterPrepareCommand extends Command {

	boolean _isFin;

	public BallShooterPrepareCommand() {
		requires(Robot.ballShooterSubsystem);
	}

	protected void initialize() {
		this._isFin = false;
	}

	protected void execute() {
		boolean isLeftPressed = Robot.oi.getShootButton(RobotMap.LeftBallShooterButtonID);
		boolean isRightPressed = Robot.oi.getShootButton(RobotMap.RightBallShooterButtonID);
		if (isLeftPressed || isRightPressed) {
			Robot.ballShooterSubsystem.move();
		} else {
			Robot.ballShooterSubsystem.stop();
		}
		if (isLeftPressed && isRightPressed) {
			this._isFin = true;
		}
	}

	protected boolean isFinished() {
		return this._isFin;
	}

	protected void end() {
		Robot.ballShooterSubsystem.stop();
	}

	protected void interrupted() {
		end();
	}
}
