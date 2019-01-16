package txt;
import java.util.*;

import txt.Soba.Izlazi;

public class Soba 
{
	String opis;
	String naziv;
	public HashMap<Izlazi, Soba> sviIzlazi = new HashMap<Izlazi, Soba>();
	
	public Soba(String n, String o)
	{
		naziv = n;
		opis = o;
	}
	
	public void opisi()
	{
		System.out.println(naziv);
		System.out.println("========");
		System.out.println(opis);
		moguciIzlazi();
	}
	
	public void moguciIzlazi()
	{
		String izl = "Izlazi iz sobe su: ";
		for (Izlazi izla: sviIzlazi.keySet())
		{
			izl += izla + "  ";
		}
		System.out.println(izl);
	}
	
	public enum Izlazi
	{
		istok,
		zapad,
		sever,
		jug
	}
}

