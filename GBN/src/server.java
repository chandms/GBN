
import java.io.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.*;

import java.net.*;

public class server

{
static int g=0;
static int f=0;
public static void main(String args[])throws Exception

{

server swr = new server();
TimerTask task = new TimerTask() {
	@Override
	public void run()
	{
	   g=1;
	   System.out.println("hi"+f);
	   try {
	   Thread.sleep(3000);
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   f++;
	   g=0;
	}
};
Timer timer = new Timer();
long delay=0;
long intervalPeriod=10000;
timer.scheduleAtFixedRate(task, delay,intervalPeriod);
swr.run();



}


public void run() throws Exception
{

String temp="any message",str="exit";

ServerSocket myss=new ServerSocket(9999);

Socket ss_accept=myss.accept();




PrintStream ms=new PrintStream(ss_accept.getOutputStream());



BufferedReader bf=new BufferedReader(new InputStreamReader(ss_accept.getInputStream()));
int expected=0;
int ni=Integer.parseInt(bf.readLine());
System.out.println("window size is :"+ni);


while(temp.compareTo(str)!=0)

{

Thread.sleep(2000);
int got=Integer.parseInt(bf.readLine());

if(temp.compareTo(str)==0)

{ break;}

System.out.println("Frame "+got+" was received and expected is "+expected);

String st=new String();
if(g==1 || got!=expected) {
	st="#"+g;
	if(g==1)
		System.out.println("Time out");
	System.out.println("ACK is not sent");
}
else if(g==0 && got==expected)
{
	st=Integer.toString(got);
	Random ran = new Random();
	int r1=ran.nextInt(3);
	st=st+r1;
	System.out.println("ACK sent");
	expected=(expected+1)%ni;
	
}
ms.println(st);


}

System.out.println("ALL FRAMES  WERE RECEIVED SUCCESSFULLY");

myss.close();

}

}

