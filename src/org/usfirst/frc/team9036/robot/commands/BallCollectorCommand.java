package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BallCollectorCommand extends Command {
	

	public BallCollectorCommand() {
		requires(Robot.ballCollectorSubsystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		double speed = (Robot.oi.getShootAxis(RobotMap.BallCollectorLeftAxis) 
				- Robot.oi.getShootAxis(RobotMap.BallCollectorRightAxis)) * RobotMap.BallCollectorMotorSpeed;
		SmartDashboard.putNumber("speed", -speed);
		System.out.println(-speed);
		Robot.ballCollectorSubsystem.collect(-speed);
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
