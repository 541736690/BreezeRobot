package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.RobotMap;
import org.usfirst.frc.team9036.robot.commands.BallCollectorCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallCollectorSubsystem extends Subsystem {
	VictorSP ballCollectorMotor;
	Encoder ballCollectorEncoder;
	
	public BallCollectorSubsystem() {
		ballCollectorMotor = new VictorSP(RobotMap.BallCollectorMotorPort);
		ballCollectorEncoder = new Encoder(RobotMap.BallCollectorEncoderChannelA, RobotMap.BallCollectorEncoderChannelA);
	}
	
	public void collect(double speed) {
		ballCollectorMotor.set(speed);
	}
	
	public double getDistance() {
		return ballCollectorEncoder.getDistance();
	}

	public void stop() {
		ballCollectorMotor.stopMotor();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new BallCollectorCommand());
	}
}
