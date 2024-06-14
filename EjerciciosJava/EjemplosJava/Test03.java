public class Test03
{
	public static void main(String[] args)
	{
		double d = 100.04;
		long l = ( long )d;  //casting de tipo
		int i = ( int )l;   // casting de tipo
		System.out.println("Valor Double "+d);
		System.out.println("Valor Long " +l); // parte fraccionaria perdida
		System.out.println("Valor Int " +i); // parte fraccionaria perdida
	}
}