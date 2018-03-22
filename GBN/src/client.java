//SENDER//

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class client

{
int g=0;
int cv=0;

public static void main(String args[]) throws Exception

{

client sws = new client();

sws.run();

}

public void run() throws Exception

{

Scanner sc=new Scanner(System.in);
Socket myskt=new Socket("localhost",9999);
PrintStream ms= new PrintStream(myskt.getOutputStream());
System.out.println("Enter value of m:");

int n=sc.nextInt();
int r=n;
Double f=Math.pow(2, n);
f=f-1;
n=f.intValue();
System.out.println("window size is : "+f);
ms.println(n);
sc.close();
window win= new window(r);
/////
/*File file = new File("C:/Users/Pupul/Desktop/Read");
int count = 0;
for (File fj : file.listFiles()) {
        if (fj.isFile()) {
                count++;
        }
}
System.out.println(count);
for(int gh=0;gh<count;gh++)
{
	Scanner fileScanner = new Scanner(file);

    int lineNumber = 0;
    while(fileScanner.hasNextLine()){
        System.out.println(fileScanner.nextLine());
        int x=lineNumber%win.size;
        String ns= x+fileScanner.nextLine();
        
        lineNumber++;
    }
}*/
////////
int y=-1;
while(true)
{
Thread.sleep(3000);
if(y==-1)
	win.shift(y);

ms.println(win.sn);
System.out.println("Frame no "+win.sn+" is sent");
BufferedReader bf=new BufferedReader(new InputStreamReader(myskt.getInputStream()));

String ack=bf.readLine();
System.out.println(ack+" is receieved in client");

if(!ack.equals("#0") && !ack.equals("#1"))

{
int l=ack.length();
char w=ack.charAt(l-1);

ack=ack.substring(0, l-1);
System.out.println(ack+" is receieved in client");

int ackGot=Integer.parseInt(ack);
System.out.println(w+"!");
if(w=='0')
{
	System.out.println("Acknowledgement was Received from receiver");
	y=ackGot;
	win.shift(y);

}
else
{
	//int u=win.sn;
	//int e=win.sf;
	//int d=(Math.abs(u-e+1))%n;
	if(win.sn==win.rf)
	{
		System.out.println("case1: Sending window again.........");
		win.sn=win.sf;
		y=67;
	}
	else
	{
		win.sn=(win.sn+1)%n;
		y=786;
	}
}
}

else

{
int gv=0;
System.out.println("Acknowledgement was not recieved");
if(ack.charAt(1)=='1')
{
	System.out.println("Timeout");
	gv=1;
}
int u=win.sn;
int e=win.sf;
int d=(Math.abs(u-e+1))%n;

if(gv==1)
{
	System.out.println("case2: Sending the window again..........");
	win.sn=win.sf;
	y=500;
	gv=0;
}
else
{
if(win.sn==win.rf)
{
	System.out.println("case3: Sending the window again..........");
	win.sn=win.sf;
	y=78;
}
else
{
	win.sn=(win.sn+1)%n;
	y=1000;
}


}
}
}


}


}
