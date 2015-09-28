package com.sandbox.challenge.cc.core;

import java.util.Scanner;

/**
 * 
 * @author Team sandboX
 *
 */
public class CodesCyphers {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Key: ");
		String key = scan.nextLine();

		System.out.print("Is message plaintext (Y/N): ");
		String selection = scan.nextLine();
		char[] keyArray =key.toLowerCase().toCharArray();
		
		if(selection.equalsIgnoreCase("y"))
		{
			
			System.out.print("Plaintext: ");
			String msg = scan.nextLine();
			char[] msgArray =msg.toLowerCase().toCharArray();
			char[] caseArray = msg.toCharArray();
			int[] caseCode = new int[caseArray.length];
			int[] msgCode = new int[msgArray.length] ;
			int[] keyCode =new int[msgArray.length];
			int[] cipherCode = new int[msgArray.length];
			char[] cipherArray = new char[msgArray.length];
			
			for(int i =0;i<caseArray.length;i++)
    			{
    				if(((int)caseArray[i])>64 && ((int)caseArray[i])< 91)
    				{
    					caseCode[i]=1;
    				}
    			}
			
			for(int i=0;i<msgArray.length;i++)
			{
				if(((int)msgArray[i])>95 && ((int)msgArray[i])<123)
					msgCode[i]=((int)msgArray[i])-96;
				else
					msgCode[i]=((int)msgArray[i]);
			}
			
			for(int i=0,counter = 0;i<msgArray.length&&counter<msgArray.length;i++,counter++)
			{
				if(((int)msgArray[counter])>95 && ((int)msgArray[counter])<123)
				{
					keyCode[counter]=((int)keyArray[i])-96;
				}
				else
				{
					keyCode[counter]=((int)msgArray[counter]);
					i=i-1;
				}
				if(i==keyArray.length-1)
				{
					i=-1;
				}
					
			}
			
			for(int i=0;i<msgArray.length;i++)
			{
				if(((int)msgArray[i])>95 && ((int)msgArray[i])<123)
				{
					cipherCode[i]=(msgCode[i]+keyCode[i])%26+1;
					cipherCode[i]=(cipherCode[i]+96);
					if(caseCode[i]==1)
					{
						cipherCode[i]=(cipherCode[i]-32);
					}
					cipherArray[i]=(char)(cipherCode[i]);
				}
				else
				{
					cipherCode[i] = msgCode[i];
					cipherArray[i]=(char)(cipherCode[i]);
				}
			}
			
			String cipherText = new String(cipherArray);
			System.out.println("Output message: "+cipherText);
			
		}
		
		if(selection.equalsIgnoreCase("n"))
		{	
			
			System.out.print("Ciphertext: ");
			String cipher = scan.nextLine();
			char[] cipherArray = cipher.toLowerCase().toCharArray();
			int[] cipherCode = new int[cipherArray.length];
			char[] caseArray = cipher.toCharArray();
			int[] caseCode = new int[caseArray.length];
			int[] keyCode =new int[cipherArray.length];
			int[] decipherCode = new int[cipherArray.length];
			char[] decipherArray = new char[cipherArray.length];
			
			for(int i =0;i<caseArray.length;i++)
    			{
    				if(((int)caseArray[i])>64 && ((int)caseArray[i])< 91)
    				{
    					caseCode[i]=1;
    				}
    			}
			
			for(int i=0;i<cipherArray.length;i++)
			{
				if(((int)cipherArray[i])>95 && ((int)cipherArray[i])<123)
					cipherCode[i]=((int)cipherArray[i])-96;
				else
					cipherCode[i]=((int)cipherArray[i]);
			}
	
			for(int i=0,counter = 0;i<cipherArray.length&&counter<cipherArray.length;i++,counter++)
			{
				if(((int)cipherArray[counter])>95 && ((int)cipherArray[counter])<123)
				{
					keyCode[counter]=((int)keyArray[i])-96;
				}
				else
				{
					keyCode[counter]=((int)cipherArray[counter]);
					i=i-1;
				}
				if(i==keyArray.length-1)
				{
					i=-1;
				}
					
			}
			
			for(int i=0;i<cipherArray.length;i++)
			{
				if(((int)cipherArray[i])>95 && ((int)cipherArray[i])<123)
				{
					decipherCode[i]=(cipherCode[i]-keyCode[i])>0?(cipherCode[i]-keyCode[i])%26-1:(cipherCode[i]-keyCode[i])+25;
					decipherCode[i]=(decipherCode[i]+96);
					if(caseCode[i]==1)
					{
						decipherCode[i]=(decipherCode[i]-32);
					}
					decipherArray[i]=(char)(decipherCode[i]);
				}
				else
				{
					decipherCode[i]=cipherCode[i];
					decipherArray[i]=(char)(decipherCode[i]);
				}
			}
			
			String decipherText = new String(decipherArray);
			System.out.println("Output message: "+decipherText);
	
			}
		
		}

}
