/*
 * Password Generator 
 */
package passwordgenerator;

/**
 *
 * @author Petar Kanev
 */

import java.util.* ;

public class PasswordGenerator {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<>();         // Array List that holds the current string.
        ArrayList<String> fullList = new ArrayList<>();         // Array List that holds all string.

        char [] specialChars = {'!', '@','#','$','%', '&', '*', '?'};           // Array that holds the special characters we want (!,@,#,$,%,&,*,?).
        
        int i,j,k;                                          // Initialize integers needed in "for" loops.
        
        for(i = 0; i < 50; i++){                            
            for(j = 0; j < 20; j++){
                Random rand = new Random();
                
                int upper = rand.nextInt(0x005A - 0x0041) + 0x0041;     // Pick a random letter from A-Z. 
                int lower = rand.nextInt(0x007A - 0x0061) + 0x0061;     // Pick a random letter from a-z.
                int number = rand.nextInt(9) + 1;                       // Pick a random integer from 1-9.
                int special = rand.nextInt(specialChars.length);        // Pick a random special character 
                
                String u = Character.toString((char)upper);             // Initialize chosen upper case letter.
                String l = Character.toString((char)lower);             // Initialize chosen lower case letter.
                String n = Integer.toString(number);                    // Initialize chosen integer.
                String s = Character.toString((char) specialChars[special]);             // Initialize chosen Special character.
                
                    for (k = 0; k < 1; k++){

                        int random = rand.nextInt(4) + 1;               // Pick a random number from 1-4.
                        
                        switch(random){                                 // The switch statement randomly selects an upper case or lower case letter                          
                            case 1:                                     // or an integer to add to the Array List. 
                            list.add(u);
                            break;
                                
                            case 2:                                     
                            list.add(l);
                            break;
                                
                            case 3: 
                            list.add(n);
                            break;
                                
                            case 4:
                            list.add(s);
                            break;
                        } 
                }
            }
            
            /* 
             * Checks to see if the full Array List is empty, 
             * if not, check for duplicates.
             */
            
            if(!fullList.isEmpty()){                                        
                int c;
                for(c = 0; c < fullList.size(); c++){
                    if(fullList.get(c).equals(getStringRepresentation(list))) {
                        fullList.remove(c);
                        System.out.println("Duplicate!");
                    }
                }
            }
            
            String full = getStringRepresentation(list);
            fullList.add(full);
            System.out.println(full);                   
            list.clear();                            
        }
    }
    
    /*
     * Method for getting a string representation of the array list. 
     */
    
    public static String getStringRepresentation(ArrayList<String> list){    
    StringBuilder builder = new StringBuilder(list.size());
    for(String s: list)
    {
        builder.append(s);
    }
    return builder.toString();
    }
    
}
