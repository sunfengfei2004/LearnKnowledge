package degisnPatterns;

interface Target
{
	void adapteeMethod();
	void adapterMethod();
}
class Adaptee
{
	public void adapteeMethod()
	{
		System.out.println("Adaptee method!");
	}
}
class Adapter implements Target
{
	private Adaptee adaptee;
	public Adapter (Adaptee adaptee)
	{
		this.adaptee = adaptee;
	}
	public void adapteeMethod()
	{
		adaptee.adapteeMethod();
	}
	public void adapterMethod()
	{
		System.out.println("Adapter method!");
	}
}
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Target target = new Adapter(new Adaptee());
		target.adapterMethod();
		target.adapteeMethod();
	}

}
