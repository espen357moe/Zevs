package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FilTilknytning24 {
private BufferedImage vaerSymbol;
	
	String symbolFilNavn;
	
	public Image knyttSymbolNummerTilBilde24(int symbolNummer24) {
		
		try {
			
				if(symbolNummer24==0) {
					symbolFilNavn="./symboler/01d.png";				
				}
		
				if(symbolNummer24==1) {
					symbolFilNavn="./symboler/01d.png";				
				}
				
				if(symbolNummer24==2) {
					symbolFilNavn="./symboler/02d.png";				
				}
				
				if(symbolNummer24==3) {
					symbolFilNavn="./symboler/03d.png";				
				}
				
				if(symbolNummer24==4) {
					symbolFilNavn="./symboler/04.png";				
				}
				
				if(symbolNummer24==5) {
					symbolFilNavn="./symboler/05d.png";				
				}
				
				if(symbolNummer24==6) {
					symbolFilNavn="./symboler/06d.png";				
				}
				
				if(symbolNummer24==7) {
					symbolFilNavn="./symboler/07d.png";				
				}
				
				if(symbolNummer24==8) {
					symbolFilNavn="./symboler/08d.png";				
				}
				
				if(symbolNummer24==9) {
					symbolFilNavn="./symboler/09.png";				
				}
				
				if(symbolNummer24==10) {
					symbolFilNavn="./symboler/10.png";				
				}
				
				if(symbolNummer24==11) {
					symbolFilNavn="./symboler/11.png";				
				}
				
				if(symbolNummer24==12) {
					symbolFilNavn="./symboler/12.png";				
				}
				
				if(symbolNummer24==13) {
					symbolFilNavn="./symboler/13.png";				
				}
				
				if(symbolNummer24==14) {
					symbolFilNavn="./symboler/14.png";				
				}
				
				if(symbolNummer24==15) {
					symbolFilNavn="./symboler/15.png";				
				}
				
				if(symbolNummer24==20) {
					symbolFilNavn="./symboler/20d.png";				
				}
				
				if(symbolNummer24==21) {
					symbolFilNavn="./symboler/21d.png";				
				}
				
				if(symbolNummer24==22) {
					symbolFilNavn="./symboler/22d.png";				
				}
				
				if(symbolNummer24==23) {
					symbolFilNavn="./symboler/23d.png";				
				}
				
				if(symbolNummer24==24) {
					symbolFilNavn="./symboler/24d.png";				
				}
				
				if(symbolNummer24==25) {
					symbolFilNavn="./symboler/25d.png";				
				}
				
				if(symbolNummer24==26) {
					symbolFilNavn="./symboler/26d.png";				
				}
				
				if(symbolNummer24==27) {
					symbolFilNavn="./symboler/27d.png";				
				}
				
				if(symbolNummer24==28) {
					symbolFilNavn="./symboler/28d.png";				
				}
				
				if(symbolNummer24==29) {
					symbolFilNavn="./symboler/29d.png";				
				}
				
				if(symbolNummer24==30) {
					symbolFilNavn="./symboler/30.png";				
				}
				
				if(symbolNummer24==31) {
					symbolFilNavn="./symboler/31.png";				
				}
				
				if(symbolNummer24==32) {
					symbolFilNavn="./symboler/32.png";				
				}
				
				if(symbolNummer24==33) {
					symbolFilNavn="./symboler/33.png";				
				}
				
				if(symbolNummer24==34) {
					symbolFilNavn="./symboler/34.png";				
				}
				
				if(symbolNummer24==40) {
					symbolFilNavn="./symboler/40d.png";				
				}
				
				if(symbolNummer24==41) {
					symbolFilNavn="./symboler/41d.png";				
				}
				
				if(symbolNummer24==42) {
					symbolFilNavn="./symboler/42d.png";				
				}
				
				if(symbolNummer24==43) {
					symbolFilNavn="./symboler/43d.png";				
				}
				
				if(symbolNummer24==44) {
					symbolFilNavn="./symboler/44d.png";				
				}
				
				if(symbolNummer24==45) {
					symbolFilNavn="./symboler/45d.png";				
				}
				
				if(symbolNummer24==46) {
					symbolFilNavn="./symboler/46.png";				
				}
				
				if(symbolNummer24==47) {
					symbolFilNavn="./symboler/47.png";				
				}
				
				if(symbolNummer24==48) {
					symbolFilNavn="./symboler/48.png";				
				}
				
				if(symbolNummer24==49) {
					symbolFilNavn="./symboler/49.png";				
				}
				
				if(symbolNummer24==50) {
					symbolFilNavn="./symboler/50.png";				
				}
							
			vaerSymbol = ImageIO.read(new File(symbolFilNavn));
			
		} catch (IOException e) {
			System.out.println("Klarte ikke lese bildefil!");
			System.out.println(symbolFilNavn);
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
