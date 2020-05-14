package com.st.smartsecurity.util;

/**
 * 公司城市util
 * @author lhm
 */
public class CompanyCityUtil {

    /**
     * 获取城市名
     * @param cityId
     * @return
     */
    public static String getCity(String cityId){
        switch (cityId){
            case "1": return "南京市";
            case "2": return "无锡市";
            case "3": return "徐州市";
            case "4": return "常州市";
            case "5": return "苏州市";
            case "6": return "南通市";
            case "7": return "连云港市";
            case "8": return "淮安市";
            case "9": return "盐城市";
            case "10": return "扬州市";
            case "11": return "镇江市";
            case "12": return "泰州市";
            case "13": return "宿迁市";
            default: return "未知";
        }
    }

    /**
     * 获取城市经纬度
     * @param cityId
     * @return
     */
    public static Double[] getCoordinates(String cityId){
        Double[] coordinates = new Double[2];
        switch (cityId){
            case "1": coordinates[0] = 118.796539d; coordinates[1] = 32.058441d; return coordinates;
            case "2": coordinates[0] = 120.312332d; coordinates[1] = 31.491756; return coordinates;
            case "3": coordinates[0] = 117.284042d; coordinates[1] = 34.206741d; return coordinates;
            case "4": coordinates[0] = 119.59794d; coordinates[1] = 31.72322d; return coordinates;
            case "5": coordinates[0] = 120.585297d; coordinates[1] = 31.29904d; return coordinates;
            case "6": coordinates[0] = 120.894287d; coordinates[1] = 31.98078d; return coordinates;
            case "7": coordinates[0] = 119.1773D; coordinates[1] = 34.84065d; return coordinates;
            case "8": coordinates[0] = 119.021263d; coordinates[1] = 33.597507d; return coordinates;
            case "9": coordinates[0] = 120.50102d; coordinates[1] = 33.20107d; return coordinates;
            case "10": coordinates[0] = 119.43157d; coordinates[1] = 32.39463d; return coordinates;
            case "11": coordinates[0] = 119.43396d; coordinates[1] = 32.13188d; return coordinates;
            case "12": coordinates[0] = 119.922981d; coordinates[1] = 32.45615d; return coordinates;
            case "13": coordinates[0] = 118.241703d; coordinates[1] = 33.964418d; return coordinates;
            default: coordinates[0] = 0.0d; coordinates[1] = 0.0d; return coordinates;
        }
    }
}
