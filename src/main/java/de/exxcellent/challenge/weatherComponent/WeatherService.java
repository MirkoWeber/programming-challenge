/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.weatherComponent;

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
public class WeatherService {
    private final WeatherEntityManager weatherManager;
    public WeatherService(){
        weatherManager = new WeatherEntityManager();
        initialise();
    }
    /**
     * 
     * @return the day with minimum avSP attribute in WeatherEntityManager
     */
    public WeatherEntity getDayWithSmallestTemperatureSpread(){
        return weatherManager.getEntities().stream().min((first, second) -> Double.compare(first.getAvSP(), second.getAvSP())).get();
        //return weatherManager.getEntities().stream().mapToDouble(WeatherEntity::getAvSP).min().orElse(-1);
    }
    /**
     * fills the entitymanager with contents of a file
     */
    private void initialise(){
        Logger LOGGER = Logger.getLogger(WeatherService.class.getName());
        IFileReader fileReader = new CSVFileReader();
        try{
            for( String line : fileReader.readFile("weather.csv")){
                WeatherEntity wE = new WeatherEntity();
                wE.parseString(line);
                weatherManager.addEntityFromObject(wE);
            }
        }catch(FileNotFoundException e){
            LOGGER.log(Level.SEVERE, "file not found");
        }catch(IOException e){
            LOGGER.log(Level.SEVERE, "ioException");
        }
    }
}
