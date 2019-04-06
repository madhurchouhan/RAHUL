package Github;

/*class MyThread extends Thread
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println("child Thread");
		}
	}
}
*/
public class AnonymousInnerClassTest1 
{
	 public static void main(String args[])
	{
		Thread t=new Thread(){                  //Anonymous Inner Class  extends Thread Class
			                                    // t is not the Object of Thread Class ,it the Object Of Anonymous class that extends Thread class 
		                                          
			                  public void run()
			               {
		                       for(int i=1;i<=5;i++)
		                     {
			                    System.out.println("Child Thread");
		                      }
		                     //t.start();
			               }
	                   };
	                   t.start();
	         for(int i=1;i<=5;i++ )
	         {
	        	 System.out.println("Main Thread");
	         }
	}
}
