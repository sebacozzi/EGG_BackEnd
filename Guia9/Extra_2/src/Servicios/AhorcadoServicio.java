/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Ahorcado;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class AhorcadoServicio {
    
    public void dibujaOrca(Ahorcado ahorcado){
        String[][] orca ={{"___________  ","___________  ","___________  ","___________  ","___________  ","___________  ","___________  "},
                          {"|         |  ","|         |  ","|         |  ","|         |  ","|         |  ","|         |  ","|         |  "},
                          {"|            ","|         O  ","|         O  ","|         O  ","|         O  ","|         O  ","|         O  "},
                          {"|            ","|            ","|         |  ","|        /|  ","|        /|\\","|        /|\\","|        /|\\"},
                          {"|            ","|            ","|         |  ","|         |  ","|         |  ","|         |  ","|         |  "},
                          {"|            ","|            ","|            ","|            ","|            ","|        /   ","|        / \\"},
                          {"|            ","|            ","|            ","|            ","|            ","|            ","|            "},
                          {"=============","=============","=============","=============","=============","=============","============="}};
        for (int i = 0; i < 8; i++) {
            System.out.println(orca[i][ahorcado.getErrados()]);
        }
    }
   
    
    public static void cls() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(100);
        } catch (AWTException e) {
        }
    }
    public static void esperaTecla(){
        Scanner leer=new Scanner(System.in);
        System.out.println("Presione Intro/Enter para continuar...");
        leer.nextLine();
    }
}
