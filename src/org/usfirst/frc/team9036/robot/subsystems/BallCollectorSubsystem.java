package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.RobotMap;
import org.usfirst.frc.team9036.robot.commands.BallCollectorCommand;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallCollectorSubsystem extends Subsystem {
	VictorSP ballCollectorMotor;

	public BallCollectorSubsystem() {
		ballCollectorMotor = new VictorSP(RobotMap.BallCollectorMotorPort);
	}
	
	public void collect(double speed) {
		ballCollectorMotor.set(speed);
	}

	public void stop() {
		ballCollectorMotor.stopMotor();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new BallCollectorCommand());
	}
}
