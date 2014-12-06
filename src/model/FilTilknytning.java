package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FilTilknytning {
	
	private BufferedImage vaerSymbol;
	
	String symbolFilNavn;
	
	public Image knyttSymbolnummerTilBilde(String symbolNummer) {
		
		try {
		
			if(symbolNummer.equals("1")) {
				symbolFilNavn="./symboler/01d.png";				
			}
			
			if(symbolNummer.equals("2")) {
				symbolFilNavn="./symboler/02d.png";				
			}
			
			if(symbolNummer.equals("3")) {
				symbolFilNavn="./symboler/03d.png";				
			}
			
			if(symbolNummer.equals("4")) {
				symbolFilNavn="./symboler/04d.png";				
			}
			
			if(symbolNummer.equals("5")) {
				symbolFilNavn="./symboler/05d.png";				
			}
			
			if(symbolNummer.equals("6")) {
				symbolFilNavn="./symboler/06d.png";				
			}
			
			if(symbolNummer.equals("7")) {
				symbolFilNavn="./symboler/07d.png";				
			}
			
			if(symbolNummer.equals("8")) {
				symbolFilNavn="./symboler/08d.png";				
			}
			
			if(symbolNummer.equals("9")) {
				symbolFilNavn="./symboler/09.png";				
			}
			
			if(symbolNummer.equals("10")) {
				symbolFilNavn="./symboler/10.png";				
			}
			
			if(symbolNummer.equals("11")) {
				symbolFilNavn="./symboler/11.png";				
			}
			
			if(symbolNummer.equals("12")) {
				symbolFilNavn="./symboler/12.png";				
			}
			
			if(symbolNummer.equals("13")) {
				symbolFilNavn="./symboler/13.png";				
			}
			
			if(symbolNummer.equals("14")) {
				symbolFilNavn="./symboler/14.png";				
			}
			
			if(symbolNummer.equals("16")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("17")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("18")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("19")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("20")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("21")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("22")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("23")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("24")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("25")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("26")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("27")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("28")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("29")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("30")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("31")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("32")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("33")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("34")) {
				symbolFilNavn="/symboler/15.png";				
			}
			
			if(symbolNummer.equals("40")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("41")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("42")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("43")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("44")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("45")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("46")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("47")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("48")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			if(symbolNummer.equals("49")) {
				symbolFilNavn="./symboler/15.png";				
			}	
			
			if(symbolNummer.equals("50")) {
				symbolFilNavn="./symboler/15.png";				
			}
			
			else {
				symbolFilNavn="./symboler/noimage.png";
			}
			
			vaerSymbol = ImageIO.read(new File(symbolFilNavn));
		} catch (IOException e) {
			System.out.println("Klarte ikke lese bildefil!");
			String symbolFilNavn = "./symboler/noimage.png";		
			try {
				vaerSymbol = ImageIO.read(new File(symbolFilNavn));
			} catch (IOException e1) {
				System.out.println("Klarte ikke lese default feil-ikon heller!");
				e1.printStackTrace();
			}						
			e.printStackTrace();
			return vaerSymbol;
		}		
		
		return vaerSymbol;
	}
}
