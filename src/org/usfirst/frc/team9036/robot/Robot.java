
package org.usfirst.frc.team9036.robot;

import org.usfirst.frc.team9036.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team9036.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team9036.robot.commands.autonomous.Chooser;
import org.usfirst.frc.team9036.robot.commands.autonomous.SlowCross;
import org.usfirst.frc.team9036.robot.subsystems.BallCollectorSubsystem;
import org.usfirst.frc.team9036.robot.subsystems.BallShooterSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static final BallCollectorSubsystem ballCollectorSubsystem = new BallCollectorSubsystem();
	public static final BallShooterSubsystem ballShooterSubsystem = new BallShooterSubsystem();
	public static final GyroSubsystem gyroSubsystem = new GyroSubsystem();
	

	public static OI oi;
	
	Chooser chooser;
	
	public void robotInit() {
		oi = new OI();
		chooser = new Chooser();
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		chooser.run();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		chooser.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
