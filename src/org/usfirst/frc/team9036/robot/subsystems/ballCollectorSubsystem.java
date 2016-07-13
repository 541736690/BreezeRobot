package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.Robot;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ballCollectorSubsystem extends Subsystem {
	VictorSP collectorControl = Robot.oi.ballCollectorMotor;

    public void initDefaultCommand() {
    }
    public void drive(double speed) {
    	collectorControl.set(speed);
    }
    public void stop(){
    	collectorControl.stopMotor();
    }
}

