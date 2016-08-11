package org.usfirst.frc.team9036.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chooser {
	
	SendableChooser chooser;
	Command autonomousCommand;
	public Chooser() {
		chooser = new SendableChooser();
		
		// Add autonomous commands here
		chooser.addDefault("什么也不干", null);
		chooser.addObject("跨越障碍并面向 60°", new CrossAndRotate());
		// chooser.addObject("另一个指令", new Command1());
		// chooser.addObject("另一个指令", new Command1());
		// chooser.addObject("另一个指令", new Command1());
		// chooser.addObject("另一个指令", new Command1());
		// chooser.addObject("另一个指令", new Command1());
		
		SmartDashboard.putData("Auto selector", chooser);
	}
	
	public void run() {
		autonomousCommand = (Command) chooser.getSelected();
		
		 if (autonomousCommand != null)
			 autonomousCommand.start();
	}
}
