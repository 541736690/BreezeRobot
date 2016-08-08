package org.usfirst.frc.team9036.robot;

import org.usfirst.frc.team9036.robot.commands.BallCollectorCommand;
import org.usfirst.frc.team9036.robot.commands.DriveAdjustTurningCommand;
import org.usfirst.frc.team9036.robot.commands.DriveDirectTurningCommand;
import org.usfirst.frc.team9036.robot.commands.DriveDirectionChangeCommand;
import org.usfirst.frc.team9036.robot.commands.VisionAutoAimCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	public Joystick mainJoystick = new Joystick(RobotMap.DriverJoystickPort);
	public Joystick shootJoystick = new Joystick(RobotMap.ShooterJoystickPort);
	
	public Button gyroTurningButton = new JoystickButton(mainJoystick, RobotMap.GyroTurningButtonID);
	
	public Button forwardTurningButton = new JoystickButton(mainJoystick, RobotMap.ForwardTurningButtonID);
	public Button backwardTurningButton = new JoystickButton(mainJoystick, RobotMap.BackwardTurningButtonID);
	public Button leftTurningButton = new JoystickButton(mainJoystick, RobotMap.LeftTurningButtonID);
	public Button rightTurningButton = new JoystickButton(mainJoystick, RobotMap.RightTurningButtonID);
	
	public Button ballCollectorButton = new JoystickButton(shootJoystick, RobotMap.BallCollectorButtonID);
	public Button ballAutoAimButton = new JoystickButton(shootJoystick, RobotMap.BallAutoAimButtonID);
	

	public OI() {
		ballCollectorButton.whileHeld(new BallCollectorCommand());
		forwardTurningButton.whileHeld(new DriveAdjustTurningCommand(0));
		backwardTurningButton.whileHeld(new DriveAdjustTurningCommand(180));
		leftTurningButton.whileHeld(new DriveDirectTurningCommand(-90));
		rightTurningButton.whileHeld(new DriveDirectTurningCommand(90));
		gyroTurningButton.whileHeld(new DriveDirectionChangeCommand());
		ballAutoAimButton.whileHeld(new VisionAutoAimCommand());
		
	}
}

