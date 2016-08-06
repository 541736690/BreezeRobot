package org.usfirst.frc.team9036.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	// RobotDrive Motor Settings
	public static final int DriverFrontLeftPort = 1;
	public static final int DriverFrontRightPort = 2;
	public static final int DriverRearLeftPort = 0;
	public static final int DriverRearRightPort = 3;
	
	
	
	public static final int BallArmSubsystemPort1 = 0;
	public static final int BallArmSubsystemPort2 = 1;
	
	
	public static final int BallAutoAimMotor = 9;

	
	// Other Motors
	public static final int BallArmPort = 6;
	public static final int BallCollectorMotor = 5;
	public static final int BallShooterMotor = 7;
	
	
	public static double BallShooterMotorSpeed = 1;
	public static double BallArmMotorSpeed = 1.0;
	public static double BallCollectorMotorSpeed = 1.0;
	
	// Drive Settings
	public static final double DriveAutoSpeed = 0.1;
	public static final double DriveStickSpeedDelta = 0.1;
	
	public static boolean DriveDirectionInversed = true;
	public static final double DriveButtonMaxSpeed = 0.5;
	public static final double DriveButtonMaxCurve = 0.5;
	
	public static final double DriveSpeedDelta = 0.5;
	public static final double DriveDirectionDelta = 0.5;
	
	public static final double DriveSafetyRate = 0.6;
	public static final double DriveSafetyOffset = 0.4;
	
	public static final double DriveGyroRotateMinSpeed = 0.5;
	public static final double DriveGyroRotateMaxSpeed = 1;
	public static final double DriveGyroAutoRotateDelta = 180;
	public static final double DriveDirectionTolerance = 5;
	public static final double DriveDirectionMinSpeed = 0.3;
	
	public static final int DriverJoystickPort = 0;
	public static final int ShooterJoystickPort = 1;
	
	
	// Drive Joystick Buttons

	public static final int LeftDriveButtonID = 5;
	public static final int RightDriveButtonID = 6;
	
	// Drive Joystick Axis
	public static final int DriveLeftAxisPort = 2;
	public static final int DriveRightAxisPort = 3;
	public static final int GyroTurningAxisPort = 4;
	public static final int LeftTurningButtonID = 7;
	public static final int RightTurningButtonID = 8;
	public static final int ForwardTurningButtonID = 1;
	public static final int BackwardTurningButtonID = 5;
	public static final int DriveSpeedAxis = 6;
	public static final int DriveDirectionAxis = 9;
	
	// Shooter Joystick Button
	public static final int BallCollectorButtonID = 3;
	public static final int LeftBallShooterButtonID = 4;
	public static final int RightBallShooterButtonID = 5;
	
	// Shooter Joystick Axis
	public static final int BallShootererAdjustingAxisPort = 1;
}

