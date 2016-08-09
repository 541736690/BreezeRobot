package org.usfirst.frc.team9036.robot.commands.drive;

import org.usfirst.frc.team9036.robot.Robot;

public class GyroAbsoluteTurningCommand extends GyroTurningCommand {

	public GyroAbsoluteTurningCommand(double targetAngle) {
		super(targetAngle);
	}

	protected void initialize() {
		double currentAngle = Robot.gyroSubsystem.getAngle();
		double __lAngle = GyroTurningCommand.getLowerBound(currentAngle, targetAngle),
				__rAngle = GyroTurningCommand.getUpperBound(currentAngle, targetAngle);

		if (currentAngle - __lAngle >= __rAngle - currentAngle) {
			direction = -1;
			finalAngle = __lAngle;
		} else {
			direction = 1;
			finalAngle = __rAngle;
		}
	}
}
