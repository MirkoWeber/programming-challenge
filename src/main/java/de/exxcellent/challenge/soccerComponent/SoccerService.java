/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.soccerComponent;

import de.exxcellent.challenge.filereader.CSVFileReader;
import de.exxcellent.challenge.filereader.IFileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nabztastic
 */
public class SoccerService {
    private final SoccerEntityManager soccerManager;
    public SoccerService(){
        soccerManager = new SoccerEntityManager();
        initialise();
    }
    /**
     * 
     * @return the day with minimum avSP attribute in WeatherEntityManager
     */
    public SoccerEntity getTeamWithSmallestGoalDifference(){
        return soccerManager.getEntities().stream().min((first, second) -> 
                Double.compare(first.getGoalsAllowed() - first.getGoals(),
                        second.getGoalsAllowed() - first.getGoals())).get();
        //return weatherManager.getEntities().stream().mapToDouble(WeatherEntity::getAvSP).min().orElse(-1);
    }
    private void initialise(){
        Logger LOGGER = Logger.getLogger(SoccerService.class.getName());
        IFileReader fileReader = new CSVFileReader();
        try{
            for( String line : fileReader.readFile("football.csv")){
                SoccerEntity wE = new SoccerEntity();
                wE.parseString(line);
                soccerManager.addEntityFromObject(wE);
            }
        }catch(FileNotFoundException e){
            LOGGER.log(Level.SEVERE, "file not found");
        }catch(IOException e){
            LOGGER.log(Level.SEVERE, "ioException");
        }
    }
}
