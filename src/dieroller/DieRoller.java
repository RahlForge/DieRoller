/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dieroller;

import java.util.Scanner;
import java.io.File;

/**
 *
 * @author david.rahl
 */
public class DieRoller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here               
        try
        {                     
            Scanner userInput = new Scanner(System.in);                     
            int dieType = 0;
            
            do
            {                
                Scanner fileOutput = new Scanner(new File("dieTypes.txt"));                                                                    
                
                while (fileOutput.hasNext())
                    System.out.println(fileOutput.nextLine());      
                fileOutput.close();                

                dieType = userInput.nextInt();
                int sidesOnDice;

                switch(dieType)
                {
                    case 1 : 
                        sidesOnDice = 2;
                        break;
                    case 2: 
                        sidesOnDice = 4;
                        break;
                    case 3 : 
                        sidesOnDice = 6;
                        break;
                    case 4 : 
                        sidesOnDice = 8;
                        break;
                    case 5 : 
                        sidesOnDice = 10;
                        break;
                    case 6 : 
                        sidesOnDice = 12;
                        break;
                    case 7 :
                        sidesOnDice = 20;
                        break;
                    case 8 : 
                        sidesOnDice = 100;
                        break;
                    case 9: return;
                    default : throw new Exception("Unknown die type");
                }

                System.out.print("Enter the number of dice to roll: ");        
                int numberOfDice = userInput.nextInt();

                System.out.println("Rolling " + numberOfDice + "d" + sidesOnDice);
                int[] dieRolls = new int[numberOfDice];
                for (int i = 0; i < numberOfDice; i++)
                {
                    double rnd = Math.random();                        
                    dieRolls[i] = (int)Math.ceil(rnd * sidesOnDice);
                    System.out.print("Die " + (i + 1) + ": " + dieRolls[i] + " ");
                    if(dieType == 7)
                    {
                        if(dieRolls[i] == 20)
                            System.out.print("CRITICAL");
                        else if(dieRolls[i] == 1)
                           System.out.print("FUMBLE");
                    }
                    
                    System.out.println("\n");
                }                            
            }while(dieType != 9);
            
            userInput.close();             
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());            
        }   
        finally
        {            
        }               
    }
    
}
