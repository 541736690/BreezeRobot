package org.usfirst.frc.team9036.robot;

public class RobotMap {
	// RobotDrive Motor Settings
	public static final int DriverFrontLeftPort = 1;
	public static final int DriverFrontRightPort = 2;
	public static final int DriverRearLeftPort = 0;
	public static final int DriverRearRightPort = 3;
	
	// Other Motors
	public static final int BallCollectorMotorPort = 4;
	public static final int LeftBallShooterMotorPort = 7;
	public static final int RightBallShooterMotorPort = 8;
	
	// Motor Settings
	public static double LeftBallShooterMotorSpeed = 1;
	public static double RightBallShooterMotorSpeed = -1;
	public static double BallArmMotorSpeed = 1.0;
	public static double BallCollectorMotorSpeed = 1.0;
	
	// Drive Settings
	public static boolean IsDirectionInversed = false;
	public static boolean IsSquareInput = true;
	public static double DriveButtonMaxSpeed = 0.8;  //TODO: Remove this limit before competition.
	
	// Gyro Drive Settings
	public static double GyroDegreeTolerance = 3;
	public static double GyroDegreeReduce = 30;
	public static double GyroTurnSpeedMinimum = 0.3;
	public static double GyroTurnSpeedMaximum = 1;
	
	// Vision Drive Settings
	public static double VisionTolerance = 0.02;
	public static double VisionSpeed = 0.4;
	
	
	// Joystick Settings
	public static final int DriverJoystickPort = 0;
	public static final int ShooterJoystickPort = 1;
	
	// Drive Joystick Buttons
	public static final int LeftDriveButtonID = 5;
	public static final int RightDriveButtonID = 6;
	public static final int LeftTurningButtonID = 3;
	public static final int RightTurningButtonID = 2;
	public static final int ForwardTurningButtonID = 4;
	public static final int BackwardTurningButtonID = 1;
	public static final int GyroTurningButtonID = 9;
	
	// Drive Joystick Axis
	public static final int DriveLeftAxis = 2;
	public static final int DriveRightAxis = 3;
    public static final int DriveSpeedAxis = 6;
	public static final int DriveDirectionAxis = 9;
	
	// Shooter Joystick Button
	public static final int BallCollectorButtonID = 3;
	public static final int LeftBallShooterButtonID = 5;
	public static final int RightBallShooterButtonID = 6;
	public static final int BallAutoAimButtonID = 1;
	
    // Shooter Joystick Axis
	public static final int BallShootererAdjustingAxis = 9;

	
	// Vision Constants
	public static final int VisionCommandEnabled = 0;
	public static final int VisionCommandDisabled = 2;
	public static final int VisionCommandInProgress = 1;
}

