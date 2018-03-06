/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.weatherComponent;

import de.exxcellent.challenge.entity.AbstractEntity;

/**
 *
 * @author Nabztastic
 */
public class WeatherEntity extends AbstractEntity {
    private
            int iDay;
            int mxT;
            int mnT;
            int avT;
            double avDP;
            int oneHrPTPcpn;
            int pDir;
            double avSP;
            int dir;
            int mxS;
            double skyC;
            int mxR;
            int mn;
            double rAvSLPR;
        public double getAvSP(){
            return this.avSP;
        }
        public int getDay(){
            return iDay;
        }
    /**
     * Constructor for a Weather Entity
     * @param iDay the day nr
     * @param mxT the maximum Temperature
     * @param mnT the minimum Temperature
     * @param avT the average Temperature
     * @param avDP
     * @param oneHrPTPcpn
     * @param pDir
     * @param avSP
     * @param dir
     * @param mxS
     * @param skyC
     * @param mxR
     * @param mn
     * @param rAvSLPR 
     */
    public WeatherEntity(int iDay, int mxT, int mnT, int avT,
            double avDP, int oneHrPTPcpn, int pDir, double avSP,
            int dir, int mxS, double skyC, int mxR, int mn , double rAvSLPR){
        super();
        this.iDay = iDay;
        this.mxT = mxT;
        this.mnT = mnT;
        this.avT = avT;
        this.avDP = avDP;
        this.oneHrPTPcpn = oneHrPTPcpn;
        this.pDir = pDir;
        this.avSP = avSP;
        this.dir = dir;
        this.mxS = mxS;
        this.skyC = skyC;
        this.mxR = mxR;
        this.mn = mn;
        this.rAvSLPR = rAvSLPR;

    }
    public WeatherEntity(){
        super();
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
                        iDay = Integer.parseInt(attributeString);
                        break;
                    case 1:
                        mxT = Integer.parseInt(attributeString);
                        break;
                    case 2:
                        mnT = Integer.parseInt(attributeString);
                        break;
                    case 3:
                        avT = Integer.parseInt(attributeString);
                        break;
                    case 4:
                        avDP = Double.parseDouble(attributeString);
                        break;
                    case 5:
                        oneHrPTPcpn = Integer.parseInt(attributeString);
                        break;
                    case 6:
                        pDir = Integer.parseInt(attributeString);
                        break;
                    case 7:
                        avSP = Double.parseDouble(attributeString);
                        break;
                    case 8:
                        dir = Integer.parseInt(attributeString);
                        break;
                    case 9:
                        mxS = Integer.parseInt(attributeString);
                        break;
                    case 10:
                        skyC = Double.parseDouble(attributeString);
                        break;
                    case 11:
                        mxR = Integer.parseInt(attributeString);
                        break;
                    case 12:
                        mn = Integer.parseInt(attributeString);
                        break;
                    case 13:
                        rAvSLPR = Double.parseDouble(attributeString);
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
