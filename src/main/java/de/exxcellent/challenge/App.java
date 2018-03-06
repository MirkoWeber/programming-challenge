package de.exxcellent.challenge;

import de.exxcellent.challenge.filereader.CSVFileReader;
import de.exxcellent.challenge.soccerComponent.SoccerService;
import de.exxcellent.challenge.weatherComponent.WeatherEntity;
import de.exxcellent.challenge.weatherComponent.WeatherEntityManager;
import de.exxcellent.challenge.weatherComponent.WeatherService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {
    private static final Logger LOGGER = Logger.getLogger( App.class.getName() );
    public static void main(String... args) {

        WeatherService weatherService = new WeatherService();
        SoccerService soccerService = new SoccerService();
        // used AvSP from weather.csv here...
        String dayWithSmallestTempSpread = String.valueOf(weatherService.getDayWithSmallestTemperatureSpread().getDay());     // Your day analysis function call …
        // what is meant with smallest goal spread? 
        // I did output the team with the smallest goal difference ( goals allowed - goals )
        String teamWithSmallesGoalSpread = soccerService.getTeamWithSmallestGoalDifference().getTeamName(); // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
