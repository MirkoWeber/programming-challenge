/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nabztastic
 */
public class CSVFileReader implements IFileReader {


    /**
     * reads all files from a csv file
     * @param filePathToRead speciefies the file to read from
     * @return returns a list of Strings containing the data from the csv file,
     * header is removed
     * @throws FileNotFoundException
     * @throws IOException 
     */
    @Override
    public List<String> readFile(String filePathToRead) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(filePathToRead));
        List<String> results = new ArrayList<>();
        String content;
        do {
            content = br.readLine();
            if (content != null) {
                results.add(content);
            }
        } while (content != null);
        results.remove(0);
        return results;
    }
}
