/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.filereader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Nabztastic
 */
public interface IFileReader {
    List<String> readFile(String filePathToRead ) throws FileNotFoundException, IOException;
    
}
