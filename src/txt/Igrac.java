package txt;
import java.util.*;

import txt.Soba.Izlazi;

public class Igrac 
{
	Soba lokacija;
	Vector<String> inventar;
	
	public Igrac(Soba start)
	{
		lokacija = start;
	}
	
	public Soba dajLokaciju()
	{
		return lokacija;
	}
	
	public void pomeriSe(Izlazi izlaz)
	{
		if (lokacija.sviIzlazi.containsKey(izlaz))
		{
			this.lokacija = lokacija.sviIzlazi.get(izlaz);
			this.lokacija.opisi();
		} else
		{
			System.out.println("Nije moguce pomeriti se na tu stranu!");
		}
	}
}
