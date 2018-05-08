package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;

public class TimeConvertorImpl implements TimeConverter{

	@Override
	public String convertTime(String aTime) {
		String result=getConcateSting(aTime);
		
		return result;
	}
	
	String getConcateSting(String aTime){
		StringBuffer result=new StringBuffer();
		
		String [] timeSlice=aTime.split(":");
		List<String> list=new ArrayList<String>();
		list.add(getSecondRow(Integer.parseInt(timeSlice[2])));
		int hour=Integer.parseInt(timeSlice[0]);
		int min=Integer.parseInt(timeSlice[1]);
		list.add(getFirstHourRow(hour));
		list.add(getSecondHourRow(hour,getRemaingTime(hour)));
		list.add(getFirstMinRow(min));
		list.add(getSecondMinRow(min,getRemaingTime(min)));
		for(String row:list){
			result.append(row+"\r\n");
		}
		return result.toString().trim();
		
	}

   String  getFirstHourRow(int hour){
	   String firstRow="";
	   int quotient =hour/5;
	   for(int i=1;i<=4;i++){
		   if(quotient>0){
		   firstRow= firstRow+"R";
		   quotient=quotient-1;
		   }else{
			   firstRow= firstRow+"O";
		   }
	   }
	   return firstRow;
    }
   
   String  getSecondHourRow(int hour,int consumedHour){
	   String secondRow="";
	   int remainingHour=hour-consumedHour;
	   for(int i=1;i<=4;i++){
		   if(remainingHour>0){
		   secondRow= secondRow+"R";
		   remainingHour=remainingHour-1;
		   }
		   else{
			   secondRow= secondRow+"O"; 
		   }
	   }
	   return secondRow;
    }
   
   String  getFirstMinRow(int min){
	   String firstRow="";
	   int quotient =min/5;
	   for(int i=1;i<=11;i++){
		   if(quotient>0){
		   if(i==3||i==6||i==9){
		   firstRow= firstRow+"R";
		   }else{
			   firstRow= firstRow+"Y";
		   }
		   quotient=quotient-1;
		   }else{
			   firstRow= firstRow+"O"; 
		   }
	   }
	   return firstRow;
    }
   
   String  getSecondMinRow(int min,int consumedMin){
	   String secondRow="";
	   int remainingMin=min-consumedMin;
	   
	   for(int i=1;i<=4;i++){
		   if(remainingMin>0){
		   secondRow= secondRow+"Y";
		   remainingMin=remainingMin-1;
	   }else{
		   secondRow= secondRow+"O";
	   }
	   }
	   return secondRow;
    }
   
   String  getSecondRow(int sec){
	   String firstRow="";
	   if( (sec % 2)==0){
		   firstRow=firstRow+"Y";
	   }else{
		   firstRow=firstRow+"O";
	   }
	   return firstRow;
    }
   
   int getRemaingTime(int qu){
	   int result=0;
	  int quotient =qu/5;
	  result=quotient*5;
	  return result;
   }
	
}
