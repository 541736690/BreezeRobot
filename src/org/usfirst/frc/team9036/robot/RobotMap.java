package org.usfirst.frc.team9036.robot;

public class RobotMap {
	// RobotDrive Motor Settings
	public static final int DriverFrontLeftPort = 1;
	public static final int DriverFrontRightPort = 2;
	public static final int DriverRearLeftPort = 0;
	public static final int DriverRearRightPort = 3;

	// Other Motors
	public static final int BallCollectorMotorPort = 5;
	public static final int LeftBallShooterMotorPort = 7;
	public static final int RightBallShooterMotorPort = 8;

	// Motor Settings
	public static final double LeftBallShooterMotorSpeed = 1;
	public static final double RightBallShooterMotorSpeed = -1;
	public static final double BallArmMotorSpeed = 1.0;
	public static final double BallCollectorMotorSpeed = 1; 
	
	// Collector Settings
	public static final int BallCollectorEncoderChannelA = 1;
	public static final int BallCollectorEncoderChannelB = 2;

	// Drive Settings
	public static final boolean IsDirectionInversed = false;
	public static final boolean IsSquareInput = true;
	public static final double DriveButtonMaxSpeed = 1;
													
	public static double DriveButtonMaxCurve = 0.6; 
	public static double ShootAdjustSpeed = 0.7;
	public static double ShootAdjustCurve = 0.5;
	
	
	// Gyro Drive Settings
	public static final double GyroDegreeTolerance = 3;
	public static final double GyroDegreeReduce = 30;
	public static final double GyroTurnSpeedMinimum = 0.1;
	public static final double GyroTurnSpeedMaximum = 0.65;
	public static final double GyroStraightRotateAdjust = 0.2;
	public static final double GyroStraightRotateTolerance = 1;

	// Vision Drive Settings
	public static final double VisionTolerance = 0.02;
	public static final double VisionSpeed = 0.4;

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
	
    // Drive Joystick POV
	public static final int DriveShiftPOV = 0;

	// Shooter Joystick Button
	public static final int BallCollectorButtonID = 2;
	public static final int LeftBallShooterButtonID = 5;
	public static final int RightBallShooterButtonID = 6;
	public static final int BallAutoAimButtonID = 1;
	public static final int LeftShooterTurningButtonID = 3;
	public static final int RightShooterTurningButtonID = 4;

	// Shooter Joystick Axis
	public static final int BallShootererAdjustingAxis = 9;
	public static final int BallCollectorLeftAxis = 2;
	public static final int BallCollectorRightAxis = 3;
	public static final int DriveSlightSpeedAxis = 1;
	public static final int DriveSlightCurveAxis = 4;

	// Vision Constants
	public static final int VisionCommandEnabled = 0;
	public static final int VisionCommandDisabled = 2;
	public static final int VisionCommandInProgress = 1;
}
