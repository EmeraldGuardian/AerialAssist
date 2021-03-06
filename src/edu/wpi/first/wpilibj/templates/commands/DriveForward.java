package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.SpeedControllerPID;


public class DriveForward extends CommandBase {

    double start;
    double goal;
    SpeedControllerPID a;
    
    public DriveForward(double dist, SpeedControllerPID a) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.a = a;
        requires(a);
        start = a.getD();
        goal = start + dist;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        a.setSetpoint(goal);
        a.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return a.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
        a.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}