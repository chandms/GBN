

import java.io.Serializable;

public class Frame implements Serializable{
	private static final long serialVersionUID = -5399605122490343339L;
	int kind;
	String s;
	public Frame(int k)
	{
		kind=k;
		s=Integer.toString(k);
		
	}
	public Frame(int k,String st)
	{
		kind=k;
		s=st;
	}
	public Frame()
	{
		kind=0;
		s="0";
	}
	

}
