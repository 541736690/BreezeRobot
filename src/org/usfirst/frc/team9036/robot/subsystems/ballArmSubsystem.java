package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.Robot;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ballArmSubsystem extends Subsystem {
    VictorSP armControl = Robot.oi.ballArmMotor;

    public void initDefaultCommand() {

    }
    public void drive(double speed) {
    	armControl.set(speed);
    }
    public void stop(){
    	armControl.stopMotor();
    }
}

