package task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class konkurs {

	public static void main(String[] args) {
		// Program liczy ilosc papieru potrzebna na opakowanie paczek, ktorych dane zaciagane sa z plikow.

		//stworzenie listy, do ktorej zostana zaimportowane dane z pliku.
		List<String[]> data = new ArrayList<String[]>();
		
		//sciezka do pliku
		String filename = "D:\\IT\\test_input.txt";
		String testRow;
		
		//deklaracje zmiennych
		int papier = 0, bok1 = 0, bok2 = 0, bok3 = 0, pow1 = 0, pow2 = 0, pow3 = 0, index = 0;

		//import danych z pliku do listy. Kazda linia z pliku zostaje podzielona na 
		//3 wymiary oddzielone przez "x"
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while((testRow = br.readLine()) != null) {
				String[] line = testRow.split("x");
				data.add(line);
			}			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//1 string z listy = dane dla 1 paczki. 
		for(String[] lin : data) {
			int kart = 0;
			index++;
			
			//dlugosci krawedzi prostopadloscianow
			bok1 = Integer.parseInt(lin[0]);
			bok2 = Integer.parseInt(lin[1]);
			bok3 = Integer.parseInt(lin[2]);
			
			//powierznichnia bokow
			pow1 = bok1*bok2;
			pow2 = bok2*bok3;
			pow3 = bok3*bok1;
			
			//powierzchnia calego kartonu
			kart = 2 * (pow1 + pow2 + pow3);
			
			//dodatkowa powierzchnia najmniejszego boku
			if(pow1 < pow2 && pow1 < pow3) {
				kart += pow1;
			}
			else if(pow2 < pow3) {
				kart += pow2;
			}
			else {
				kart += pow3;
			}
			System.out.println("Papier potrzebny na " + index + " karton: " + kart);
			
			//sumowanie ilosci potrzebnego papieru
			papier += kart;
		}			
		//wyswietlanie wyniku
		System.out.println("Ilosc papieru potrzebna na wszystkie kartony: " + papier + " dm2");
	}

}
