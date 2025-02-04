package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

@Autonomous
public class Auto2 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Pose2d startPose = new Pose2d(-36,-60, Math.toRadians(90));

        drive.setPoseEstimate(startPose);

        Trajectory Start = drive.trajectoryBuilder(new Pose2d(-36,-60,Math.toRadians(90)), false)
                .splineTo(
                        new Vector2d(-30,-35),130,
                        SampleMecanumDrive.getVelocityConstraint(20, DriveConstants.MAX_ANG_VEL,DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL)

                )
                .build();



        waitForStart();

        if (isStopRequested()) return;

        drive.followTrajectory(Start);

    }
}
