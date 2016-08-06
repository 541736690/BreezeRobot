package org.usfirst.frc.team9036.robot;

import org.usfirst.frc.team9036.robot.commands.BallCollectorCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	public Joystick mainJoystick = new Joystick(RobotMap.DriverJoystickPort);
	public Joystick shootJoystick = new Joystick(RobotMap.ShooterJoystickPort);
	
	public Button gyroTurningAxis = new JoystickButton(mainJoystick, RobotMap.GyroTurningAxisPort);
	
	public Button ballCollectorButton = new JoystickButton(shootJoystick, RobotMap.BallCollectorMotor);

	public OI() {
		ballCollectorButton.whileHeld(new BallCollectorCommand());
	}
}

