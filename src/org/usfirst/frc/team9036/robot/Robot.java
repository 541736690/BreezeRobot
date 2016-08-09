
package org.usfirst.frc.team9036.robot;

import org.usfirst.frc.team9036.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team9036.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team9036.robot.subsystems.BallCollectorSubsystem;
import org.usfirst.frc.team9036.robot.subsystems.BallShooterSubsystem;
import org.usfirst.frc.team9036.robot.subsystems.DebugSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static final BallCollectorSubsystem ballCollectorSubsystem = new BallCollectorSubsystem();
	public static final BallShooterSubsystem ballShooterSubsystem = new BallShooterSubsystem();
	public static final GyroSubsystem gyroSubsystem = new GyroSubsystem();
	public static final DebugSubsystem debugSubsystem = new DebugSubsystem();

	public static OI oi;

	Command autonomousCommand;
	SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		/*
		 * chooser = new SendableChooser(); chooser.addDefault("Default Auto",
		 * new ExampleCommand()); // chooser.addObject("My Auto", new
		 * MyAutoCommand()); SmartDashboard.putData("Auto mode", chooser);
		 */
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = null;

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
