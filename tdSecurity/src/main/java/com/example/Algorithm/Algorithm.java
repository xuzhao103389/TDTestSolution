package com.example.Algorithm;

import java.time.LocalDate;

public class Algorithm {
    // MS-PC = the different between column UQL_OC_MMB_MS and UQL_OC_MMB_PC
    static public String calDifference(float ms, float pc){
        float result = 0.0f;
        if(ms >= pc){
            result = ms - pc;
        }else{
            result = pc - ms;
        }
        return String.valueOf(result);
    }

    // the difference in Absolute(MS-PC) as following buckets:
    static public String differenceInAbsolute(float difference){
        String result = "";
        if(difference < 0)
            return result;

        if(difference >= 0 && difference <= 99)
            result = "0-99";
        else if(difference >= 100 && difference <= 999)
            result = "100-999";
        else if(difference >= 1000 && difference <= 9999)
            result = "1000-9999";
        else if(difference >= 10000 && difference <= 99999)
            result = "10000-99999";
        else
            result = "100000+";

       return result;
    }
    //Term = Column MaturityDate - Today. If MaturityDate is blank or already matured, set it as blank
    static public String MaturityDateToToday(String maturityDate){
        String result = "";
        if(maturityDate == null ||  maturityDate.isBlank())
            return result;

        try {
            String[] split = LocalDate.now().toString().split("-");
            //the date is in the form of YYYY-MM-DD
            int currentYear = Integer.parseInt(split[0]);
            int currentMonth = Integer.parseInt(split[1]);
            int currentDay = Integer.parseInt(split[2]);
            //the date is in the form of YYYYMMDD from the source data
            int MaturityYear = Integer.parseInt(maturityDate.trim().substring(0, 4));
            int MaturityMonth = Integer.parseInt(maturityDate.trim().substring(4, 6));
            int MaturityDay = Integer.parseInt(maturityDate.trim().substring(6, 8));

            int monthGap = (MaturityYear * 12 + MaturityMonth) - (currentYear * 12 + currentMonth);

            if((MaturityYear == currentYear && MaturityMonth == currentMonth && MaturityDay > currentDay)
                    ||(MaturityYear == currentYear && (MaturityMonth == currentMonth + 1) && MaturityDay < currentDay)){
                return "0m-1m";
            }else if((monthGap >= 1 && monthGap < 6) || (monthGap ==6 && MaturityDay < currentDay)){
                return "1m-6m";
            }else if((monthGap >= 6 && monthGap < 12) || (monthGap ==12 && MaturityDay < currentDay)){
                return "6m-1yr";
            }else if((monthGap >= 12 && monthGap < 120) || (monthGap ==120 && MaturityDay < currentDay)){
                return "1yr-10yr";
            }else if((monthGap >= 120 && monthGap < 360) || (monthGap ==360 && MaturityDay < currentDay)){
                return "10yr-30yr";
            }else if((monthGap >= 360 && monthGap < 600) || (monthGap ==600 && MaturityDay < currentDay)){
                return "30yr-50yr";
            }else if(monthGap >= 600){
                return "50yr+";
            }
        } catch (Exception e){

        }
        //by default return blank
        return result;
    }
}
