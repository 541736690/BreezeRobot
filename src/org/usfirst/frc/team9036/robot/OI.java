package org.usfirst.frc.team9036.robot;

import org.usfirst.frc.team9036.robot.commands.BallCollectorCommand;
import org.usfirst.frc.team9036.robot.commands.drive.GyroAbsoluteRotateCommand;
import org.usfirst.frc.team9036.robot.commands.drive.GyroRotateCommand;
import org.usfirst.frc.team9036.robot.commands.drive.GyroStraightDrivingCommand;
import org.usfirst.frc.team9036.robot.commands.drive.ReverseDriveDirectionCommand;
import org.usfirst.frc.team9036.robot.commands.drive.VisionAutoAimCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	Joystick mainJoystick;
	Joystick shootJoystick;

	Button gyroTurningButton;
	
	Button forwardTurningButton;
	Button backwardTurningButton;
	Button leftTurningButton;
	Button rightTurningButton;
	Button leftShooterTurningButton;
	Button rightShooterTurningButton;
	Button ballAutoAimButton;
	
	public OI() {
		// Initialize Joysticks
		mainJoystick = new Joystick(RobotMap.DriverJoystickPort);
		shootJoystick = new Joystick(RobotMap.ShooterJoystickPort);

		// Main Joystick Button
		gyroTurningButton = new JoystickButton(mainJoystick, RobotMap.GyroTurningButtonID);
		forwardTurningButton = new JoystickButton(mainJoystick, RobotMap.ForwardTurningButtonID);
		backwardTurningButton = new JoystickButton(mainJoystick, RobotMap.BackwardTurningButtonID);
		leftTurningButton = new JoystickButton(mainJoystick, RobotMap.LeftTurningButtonID);
		rightTurningButton = new JoystickButton(mainJoystick, RobotMap.RightTurningButtonID);

		// Shoot Joystick Button
		ballAutoAimButton = new JoystickButton(shootJoystick, RobotMap.BallAutoAimButtonID);
		leftShooterTurningButton = new JoystickButton(shootJoystick, RobotMap.LeftShooterTurningButtonID);
		rightShooterTurningButton = new JoystickButton(shootJoystick, RobotMap.RightShooterTurningButtonID);
		
		// Main Button Command
		forwardTurningButton.toggleWhenPressed(new GyroAbsoluteRotateCommand(0));
		backwardTurningButton.toggleWhenPressed(new GyroAbsoluteRotateCommand(180));
		leftTurningButton.toggleWhenPressed(new GyroRotateCommand(-90));
		rightTurningButton.toggleWhenPressed(new GyroRotateCommand(90));
		
		// Shooter Button Command
		gyroTurningButton.whenPressed(new ReverseDriveDirectionCommand()); // TODO: Remove Test Button
		ballAutoAimButton.whileHeld(new VisionAutoAimCommand());
		leftShooterTurningButton.whenPressed(new GyroRotateCommand(-60));
		rightShooterTurningButton.whenPressed(new GyroRotateCommand(60));
	}

	public boolean getMainButton(int button) {
		return mainJoystick.getRawButton(button);
	}

	public boolean getShootButton(int button) {
		return shootJoystick.getRawButton(button);
	}

	public double getMainAxis(int axis) {
		return mainJoystick.getRawAxis(axis);
	}
	public double getPOV(int pov){
		return mainJoystick.getPOV(pov);
	}

	public double getShootAxis(int axis) {
		return shootJoystick.getRawAxis(axis);
	}
}
