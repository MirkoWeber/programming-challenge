/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.soccerComponent;
import de.exxcellent.challenge.entity.AbstractEntity;

/**
 *
 * @author Nabztastic
 */
public class SoccerEntity extends AbstractEntity {
    private
        String teamName;
        int games;
        int wins;
        int losses;
        int draws;
        int goals;
        int goalsAllowed;
        int points;

    public SoccerEntity(){
        super();
    }
    public int getGoals(){
        return goals;
    }
    public int getGoalsAllowed(){
        return goalsAllowed;
    }
    public String getTeamName(){
        return teamName;
    }
    /**
     * parses all attributes a weather object needs from a string line
     * String line has to be in a fixed format for this.
     * @param weatherLine a String line containing weather data
     */
    public void parseString( String weatherLine ){
        int iAttribute = 0;
        String attributeString = "";
        for( char c: weatherLine.toCharArray()){
            if( c == ','){
                switch(iAttribute){
                    case 0:
                        teamName = attributeString;
                        break;
                    case 1:
                        games = Integer.parseInt(attributeString);
                        break;
                    case 2:
                        wins = Integer.parseInt(attributeString);
                        break;
                    case 3:
                        losses = Integer.parseInt(attributeString);
                        break;
                    case 4:
                        draws = Integer.parseInt(attributeString);
                        break;
                    case 5:
                        goals = Integer.parseInt(attributeString);
                        break;
                    case 6:
                        goalsAllowed = Integer.parseInt(attributeString);
                        break;
                    case 7:
                        points = Integer.parseInt(attributeString);
                        break;
                }
                iAttribute++;   
                attributeString = "";
            }
            else{
                attributeString += c;
            }

        }
    }
    
}
