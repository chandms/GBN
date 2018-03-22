import java.lang.Math;

public class window {
	
	int size;
	int sf,sn,rf;
	public window(int m)
	{
		Double f=Math.pow(2, m);
		int y=f.intValue()-1;
		size=y;
		sf=0;
		sn=-1;
		rf=size-1;
	}
   public void shift(int t)
   {
	   sf=(t+1)%size;
	   sn=(sn+1)%size;
	   rf=(sf+size-1)%size;
	   System.out.println("Window is shifted, sf= "+sf+"and rf= "+rf);
	   
   }
}
