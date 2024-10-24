/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="BasicTeleOp", group="Linear OpMode")
//Numele trebuie sa fie acelasi cu denumirea fisierului

//@Autonomous pentru a muta fisierul in sectiunea pentru programele de autonomii

// Daca @Disabled nu este comentat, nu veti putea rula programul
//@Disabled


public class BasicTeleOp extends LinearOpMode {

    // Declare OpMode members.

    DcMotor leftMotor = null;
    DcMotor rightMotor = null;



    @Override
    public void runOpMode() {

        //legatura dintre software si hardware
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        //CTRL + D (apasate in acelasi timp) copiaza ultima linie si apoi doar modificati
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();


        // Wait for the game to start (driver presses START)
        waitForStart();
        //runtime.reset();



        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // aici se scrie codul pentru TeleOP

            //fata - spate
            double drive = gamepad1.left_stick_y;

            double turn = gamepad1.right_stick_x;

            leftMotor.setPower(drive + turn);
            rightMotor.setPower(drive + turn);


            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
