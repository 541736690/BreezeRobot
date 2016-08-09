package org.usfirst.frc.team9036.robot;

import org.usfirst.frc.team9036.robot.commands.BallCollectorCommand;
import org.usfirst.frc.team9036.robot.commands.drive.GyroAbsoluteTurningCommand;
import org.usfirst.frc.team9036.robot.commands.drive.GyroRelativeTurningCommand;
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

	Button ballCollectorButton;
	Button ballAutoAimButton;

	public OI() {
		// Initialize Joysticks
		mainJoystick = new Joystick(RobotMap.DriverJoystickPort);
		shootJoystick = new Joystick(RobotMap.ShooterJoystickPort);

		// Main Joystick
		gyroTurningButton = new JoystickButton(mainJoystick, RobotMap.GyroTurningButtonID);

		forwardTurningButton = new JoystickButton(mainJoystick, RobotMap.ForwardTurningButtonID);
		backwardTurningButton = new JoystickButton(mainJoystick, RobotMap.BackwardTurningButtonID);
		leftTurningButton = new JoystickButton(mainJoystick, RobotMap.LeftTurningButtonID);
		rightTurningButton = new JoystickButton(mainJoystick, RobotMap.RightTurningButtonID);

		// Shoot Joystick
		ballCollectorButton = new JoystickButton(shootJoystick, RobotMap.BallCollectorButtonID);
		ballAutoAimButton = new JoystickButton(shootJoystick, RobotMap.BallAutoAimButtonID);

		// Assign
		ballCollectorButton.whileHeld(new BallCollectorCommand());
		forwardTurningButton.toggleWhenPressed(new GyroAbsoluteTurningCommand(0));
		backwardTurningButton.toggleWhenPressed(new GyroAbsoluteTurningCommand(180));
		leftTurningButton.toggleWhenPressed(new GyroRelativeTurningCommand(-90));
		rightTurningButton.toggleWhenPressed(new GyroRelativeTurningCommand(90));
		gyroTurningButton.whenPressed(new ReverseDriveDirectionCommand());
		ballAutoAimButton.whileHeld(new VisionAutoAimCommand());
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

	public double getShootAxis(int axis) {
		return shootJoystick.getRawAxis(axis);
	}
}
