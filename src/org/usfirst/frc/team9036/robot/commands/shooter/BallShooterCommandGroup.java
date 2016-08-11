package org.usfirst.frc.team9036.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BallShooterCommandGroup extends CommandGroup {

	public BallShooterCommandGroup() {
		addSequential(new BallShooterPrepareCommand());
		addSequential(new BallShooterCommand());
	}
}
