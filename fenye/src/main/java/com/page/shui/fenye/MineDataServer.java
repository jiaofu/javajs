package com.page.shui.fenye;

import com.page.shui.fenye.dto.*;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class MineDataServer {


    public static UserMineDTO getUserData(long userId) {
        UserMineDTO userMineDTO = new UserMineDTO();

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setUsername("测试账号");
        userMineDTO.setUser(userDTO);
        List<CurrentLockDTO> currentLockDTOS = currentLock(userId, 20, 0);
        userMineDTO.setCurrentLockDTOS(currentLockDTOS);
        return userMineDTO;
    }

    /**
     * 当期锁仓
     *
     * @param userId
     * @param size            页面条数大小
     * @param preTotal        已取到的条数
     * @return
     */
    public static List<CurrentLockDTO> lockDTOS = new ArrayList<>();

    public static List<CurrentLockDTO> currentLock(Long userId, int size, long preTotal) {
        if (lockDTOS.size() == 0) {

            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 500; i++) {
                CurrentLockDTO currentLockDTO = new CurrentLockDTO();
                currentLockDTO.setUserId(i);
                currentLockDTO.setLockAmount(i+"amount");
                calendar.add(Calendar.DATE,1);
                currentLockDTO.setLockDate(calendar.getTime());
                currentLockDTO.setLockPoints("point "+i);
                currentLockDTO.setStoreNum("storeNum"+i);
                currentLockDTO.setLoyaltyPoints("LoyaltyPoints"+i);
                lockDTOS.add(currentLockDTO);
            }
        }
      return   lockDTOS.stream().skip(preTotal).limit(size).collect(Collectors.toList());
    }


    /**
     * 锁仓记录
     *
     * @param userId
     * @param size            页面条数大小
     * @param preTotal        已取到的条数
     * @return
     */
    public static List<LockRecordDTO> lockRecordDTOS = new ArrayList<>();

    public static List<LockRecordDTO> lockRecord(long userId, int size, long preTotal) {
        if (lockRecordDTOS.size() == 0) {

            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 500; i++) {
                LockRecordDTO currentLockDTO = new LockRecordDTO();

                currentLockDTO.setLockAmount(i+"amount");
                calendar.add(Calendar.DATE,1);
                currentLockDTO.setLockDate(calendar.getTime());

                currentLockDTO.setStoreNum("storeNum"+i);
                currentLockDTO.setApplicationDate(new Date());
                lockRecordDTOS.add(currentLockDTO);
            }
        }
        return   lockRecordDTOS.stream().skip(preTotal).limit(size).collect(Collectors.toList());
    }

    /**
     * 解锁记录
     *
     * @param userId
     * @param size            页面条数大小
     * @param preTotal        已取到的条数
     * @return
     */
    public static List<UnlockRecordDTO> unlockRecordDTOS = new ArrayList<>();

    public static List<UnlockRecordDTO> unlockRecord(long userId, int size, long preTotal) {
        if (unlockRecordDTOS.size() == 0) {

            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 500; i++) {
                UnlockRecordDTO currentLockDTO = new UnlockRecordDTO();
                currentLockDTO.setApplicationDate(new Date());
                currentLockDTO.setLockedDay(i);
                calendar.add(Calendar.DATE,1);
                currentLockDTO.setApplicationDate(calendar.getTime());
                currentLockDTO.setLockPoints("point "+i);
                currentLockDTO.setStoreNum("storeNum"+i);
                currentLockDTO.setLoyaltyPoints("LoyaltyPoints"+i);
                unlockRecordDTOS.add(currentLockDTO);
            }
        }
        return   unlockRecordDTOS.stream().skip(preTotal).limit(size).collect(Collectors.toList());
    }


    /**
     * 分红记录
     *
     * @param size
     * @param preTotal
     * @param userId
     * @return
     */
    public static List<BonusRecordDTO> userBonusRecords = new ArrayList<>();

    public static List<BonusRecordDTO> userBonusRecord(long userId, int size, long preTotal) {
        if (userBonusRecords.size() == 0) {

            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 500; i++) {
                BonusRecordDTO currentLockDTO = new BonusRecordDTO();
                currentLockDTO.setBonusPoints("BonusPoints"+i);
                currentLockDTO.setDestroyReduce(i+"deducs");
                calendar.add(Calendar.DATE,1);
                currentLockDTO.setBonusDate(calendar.getTime());
                currentLockDTO.setLockPoints("point "+i);
                currentLockDTO.setFeeAmount("storeNum"+i);
                currentLockDTO.setLoyaltyPoints("LoyaltyPoints"+i);
                userBonusRecords.add(currentLockDTO);
            }
        }
        return   userBonusRecords.stream().skip(preTotal).limit(size).collect(Collectors.toList());
    }

    /**
     * 市场挖矿记录
     *
     * @param size     页面条数大小
     * @param preTotal 已取到的条数
     * @return
     */
    public static List<MineRecordDTO> mineRecord = new ArrayList<>();

    public static List<MineRecordDTO> mineRecord(long userId, int size, long preTotal) {
        if (mineRecord.size() == 0) {

            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 500; i++) {
                MineRecordDTO currentLockDTO = new MineRecordDTO();
                currentLockDTO.setFeeAmount("FeeAmount"+i);
                currentLockDTO.setMineAmount(i+"Mineamount");
                calendar.add(Calendar.DATE,1);
                currentLockDTO.setBonusDate(calendar.getTime());
                currentLockDTO.setMinePrice("Price "+i);
                currentLockDTO.setStatus(i);
                mineRecord.add(currentLockDTO);
            }
        }
        return   mineRecord.stream().skip(preTotal).limit(size).collect(Collectors.toList());
    }

    /**
     * 申请记录
     *
     * @param userId
     * @param size            页面条数大小
     * @param preTotal        已取到的条数
     * @return
     */
    public static List<ApplicationRecordDTO> applicationRecord = new ArrayList<>();

    public static List<ApplicationRecordDTO> applicationRecord(long userId, int size, long preTotal) {
        if (applicationRecord.size() == 0) {

            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 500; i++) {
                ApplicationRecordDTO currentLockDTO = new ApplicationRecordDTO();

                currentLockDTO.setAmount(i+"amount");
                calendar.add(Calendar.DATE,1);
                currentLockDTO.setApplicationDate(calendar.getTime());
                currentLockDTO.setId(Long.parseLong(String.valueOf(i)));
                currentLockDTO.setStatus(i%4);
                currentLockDTO.setType(i%3);
                applicationRecord.add(currentLockDTO);
            }
        }
        return   applicationRecord.stream().skip(preTotal).limit(size).collect(Collectors.toList());
    }

    public static List<RecordBean> recordBeans = new ArrayList<>();
    public static List<RecordBean> getRecordBeans(String symbolName, int size, long preTotal){
        if (recordBeans.size() == 0) {

            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 500; i++) {
                RecordBean currentLockDTO = new RecordBean();

                currentLockDTO.setPeriod(i);
                calendar.add(Calendar.DATE,1);
                currentLockDTO.setCreatedDate(calendar.getTime());
                currentLockDTO.setPrice( String.valueOf(i/4));
                currentLockDTO.setSymbolName("BTCUSDT");
                currentLockDTO.setPosition("当前位置"+i);
                recordBeans.add(currentLockDTO);
            }
        }
        return   recordBeans.stream().skip(preTotal).limit(size).collect(Collectors.toList());

    }



    /**
     *
     * @param size
     * @return
     */

    public static List<BonusStatisticsDTO> bonusStatisticsDTOs = new ArrayList<>();
    public static  List<BonusStatisticsDTO> userBonusRecord(int size, long preTotal,Date start,Date end){
        if (bonusStatisticsDTOs.size() == 0) {

            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 500; i++) {
                BonusStatisticsDTO currentLockDTO = new BonusStatisticsDTO();
                currentLockDTO.setFeeAmount("feeAmount"+i);
                calendar.add(Calendar.DATE,1);
                currentLockDTO.setBonusDate(calendar.getTime());
                currentLockDTO.setReduceAmount( "reduceAmount"+i);
                currentLockDTO.setUserId(i);
                bonusStatisticsDTOs.add(currentLockDTO);
            }
        }
        return   bonusStatisticsDTOs.stream().filter(q->q.getBonusDate().getTime()>=start.getTime() && q.getBonusDate().getTime()<=end.getTime()).skip(preTotal).limit(size).collect(Collectors.toList());
    }


    public static List<MineStatisticsDTO> mineStatisticsDTOs = new ArrayList<>();
    public static  List<MineStatisticsDTO> mineRecord(int size,long preTotal,Date start,Date end){
        if (mineStatisticsDTOs.size() == 0) {

            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 500; i++) {
                MineStatisticsDTO currentLockDTO = new MineStatisticsDTO();
                currentLockDTO.setUserId(i);
                currentLockDTO.setAmount("amount"+i);
                calendar.add(Calendar.DATE,1);
                currentLockDTO.setMineData(calendar.getTime());
                mineStatisticsDTOs.add(currentLockDTO);
            }
        }
        return   mineStatisticsDTOs.stream().filter(q->q.getMineData().getTime()>=start.getTime() && q.getMineData().getTime()<=end.getTime()).skip(preTotal).limit(size).collect(Collectors.toList());
    }

    /**
     *
     * @param size
     * @param preTotal
     * @param start
     * @param end
     * @return
     */

    public static  List<CurrentLockDTO> currentLock(int size,long preTotal,Date start,Date end){

        return   lockDTOS.stream().filter(q->q.getLockDate().getTime()>=start.getTime() && q.getLockDate().getTime()<=end.getTime()).skip(preTotal).limit(size).collect(Collectors.toList());
    }

    /**
     * @param list
     * @return
     */
    public static List<Map<String, Object>> exportData(List list)throws Exception {

        List<Map<String, Object>> maps = new ArrayList<>();
        for(Object obj : list){
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                String key = propertyDescriptors[i].getName();
                if (!key.equals("class")) {
                    PropertyDescriptor property = propertyDescriptors[i];
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj, new Object[0]);
                    map.put(key, value);
                }
                maps.add(map);
            }
        }
        return maps;
    }
}
