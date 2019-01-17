package txt;
import java.util.*;
import java.io.*;
import txt.Soba.Izlazi;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader ucitaj = new  BufferedReader(new FileReader("sobe.txt"));
		Vector<String> podaci = new Vector<String>();
		Vector<Soba> sobe = new Vector<Soba>();
		
		while (ucitaj.ready())
		{
			podaci.add(ucitaj.readLine());
		}

		for (int i = 0; i < podaci.size(); i += 3)
		{
			sobe.add(new Soba(podaci.get(i), podaci.get(i+1)));
		}
		
		for (int i = 0; i < sobe.size(); i++)
		{
			String[] izlazi = podaci.get(i*3 + 2).split("\\+");
			for (int j = 0; j < izlazi.length; j += 2)
			{
				Izlazi izl = Izlazi.valueOf(izlazi[j]);
				Soba gde = sobe.get(Integer.parseInt(izlazi[j+1]));
				sobe.get(i).sviIzlazi.put(izl, gde);
			}
			
		}
		
		Igrac probni = new Igrac(sobe.get(0));
		
		while(true)
		{
			System.out.println("\nIzaberite komandu: ");
			System.out.println("p - pogledaj, izsj - pravac");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String ulaz = br.readLine();
			switch (ulaz)
			{
			case "p":
				probni.dajLokaciju().opisi();
				break;
			case "z":
				probni.pomeriSe(Izlazi.zapad);
				break;
			case "i":
				probni.pomeriSe(Izlazi.istok);
				break;
			case "s":
				probni.pomeriSe(Izlazi.sever);
				break;
			case "j":
				probni.pomeriSe(Izlazi.jug);
				break;
			}
		}
	}
}
