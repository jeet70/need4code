package com.sandbox.challenge.cc.core;

import java.util.Scanner;

public class CodesCyphers {

	public static void main(String[] args) {
		
		String msg = "SharanSingh";
		String key ="jeet";
		Scanner scan;
		
		char[] msgCase = msg.toCharArray();
		int[] caseCode = new int[msgCase.length];
		char[] msgArray =msg.toLowerCase().toCharArray();
		char[] keyArray =key.toLowerCase().toCharArray();
		int[] msgCode = new int[msgArray.length] ;
		int[] keyCode =new int[msgArray.length];
		int[] cipherCode = new int[msgArray.length];
		char[] cipherArray = new char[msgArray.length];
		int[] decipherCode = new int[cipherArray.length];
		char[] decipherArray = new char[cipherArray.length];
		int counter = 0;
		
		System.out.println("");
		
		/*for(int i =0;i<msgCase.length;i++)
		{
			if(((int)msgCase[i])>64 && ((int)msgCase[i])< 91)
			{
				caseCode[i]=1;
			}
		}*/
		
		for(int i=0;i<msgArray.length;i++)
		{
			if(((int)msgArray[i])>95 && ((int)msgArray[i])<123)
				msgCode[i]=((int)msgArray[i])-96;
			else
				msgCode[i]=((int)msgArray[i]);
			System.out.print(msgCode[i]+" ");
		}
		
		System.out.println();
		
		for(int i=0;i<msgArray.length&&counter<msgArray.length;i++)
		{
			if(((int)msgArray[counter])>95 && ((int)msgArray[counter])<123)
			{
				keyCode[counter]=((int)keyArray[i])-96;
				System.out.print(keyCode[counter]+" ");
			}
			else
			{
				keyCode[counter]=((int)msgArray[counter]);
				System.out.print(keyCode[counter]+" ");
				i=i-1;
			}
			if(i==keyArray.length-1)
			{
				i=-1;
			}
				counter++;
				
		}
		
		System.out.println();
		
		for(int i=0;i<msgArray.length;i++)
		{
			if(((int)msgArray[i])>95 && ((int)msgArray[i])<123)
			{
				cipherCode[i]=(msgCode[i]+keyCode[i])%26+1;
			}
			else
			{
				cipherCode[i] = msgCode[i];
			}
			System.out.print(cipherCode[i]+" ");
			
		}
		
		System.out.println();
		
		for(int i=0;i<msgArray.length;i++)
		{
			if(((int)msgArray[i])>95 && ((int)msgArray[i])<123)
			{
				cipherArray[i]=(char)(cipherCode[i]+96);
			}
			else
			{
				cipherArray[i]=(char)(cipherCode[i]);
			}
			
			System.out.print(cipherArray[i]+" ");
			
		}
		
		/*String cipherText = cipherArray.toString();
		
		for(int i =0;i<msgCase.length;i++)
		{
			if(caseCode[i]==1)
			{
				cipherText =Character.toUpperCase(i)+cipherText.substring(i+1);
			}
		}*/
		
		System.out.println();
		
		for(int i=0;i<msgArray.length;i++)
		{
			if(((int)cipherArray[i])>95 && ((int)cipherArray[i])<123)
			{
				decipherCode[i]=(cipherCode[i]-keyCode[i])>0?(cipherCode[i]-keyCode[i])%26-1:(cipherCode[i]-keyCode[i])+25;
				decipherArray[i] =(char)(decipherCode[i]+96);
			}
			else
			{
				decipherCode[i]=cipherCode[i];
				decipherArray[i]=(char)(decipherCode[i]);
			}
			System.out.print(decipherArray[i]);
		}

	}

}
