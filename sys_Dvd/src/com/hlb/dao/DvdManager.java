package com.hlb.dao;

import com.hlb.entity.Dvd;
import com.hlb.enums.DvdStatus;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;

public class DvdManager {
    public static Dvd[] dvds = new Dvd[100];
    Scanner input = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    // 初始化方法  --  实例化三张dvd,放入容器（dvds）
    public void init() throws ParseException {
        Dvd dvd1 = new Dvd();
        Dvd dvd2 = new Dvd();
        Dvd dvd3 = new Dvd();

        dvd1.setId(UUID.randomUUID().toString().replace("-","").substring(0,6));
        dvd1.setName("西游记");
        dvd1.setCost(45.5);
        dvd1.setStatus(DvdStatus.INSTORE);
        dvd1.setSum_times(3);
        dvd1.setBorrow_date("2023-03-31 06:12");
        dvd1.setReturn_date("2023-04-02 12:21");
        dvd1.setProfit(cal_Cost(dvd1.getBorrow_date(),dvd1.getReturn_date())*dvd1.getCost());

        // --upline(dvd1) 可达到一样的效果
        dvds[0] = dvd1;

        dvd2.setId(UUID.randomUUID().toString().replace("-","").substring(0,6));
        dvd2.setName("水浒传");
        dvd2.setCost(55.5);
        dvd2.setStatus(DvdStatus.INSTORE);
        dvd2.setSum_times(1);
        dvds[1] = dvd2;

        dvd3.setId(UUID.randomUUID().toString().replace("-","").substring(0,6));
        dvd3.setName("三国演义");
        dvd3.setCost(65.5);
        dvd3.setStatus(DvdStatus.INSTORE);
        dvd3.setSum_times(2);
        dvds[2] = dvd3;
        dvd3.setBorrow_date("2023-03-30 06:12");
        dvd3.setReturn_date("2023-04-04 12:21");
        dvd3.setProfit(cal_Cost(dvd3.getBorrow_date(),dvd3.getReturn_date())*dvd3.getCost());
    }

    // 上架
    public boolean upline(Dvd[] arr)
    {
        input = new Scanner(System.in);
        Dvd dvd = new Dvd();

        System.out.println("开始上架DVD信息>>:");

        //产生随机id
        dvd.setId(UUID.randomUUID().toString().replace("-","").substring(0,6));

        System.out.print("请输入片名：");
        //next()方法会过滤掉有效字符前面的无效字符,不能得到带空格的字符串
        //有扫描一整行的意思，它的结束符只能是Enter键，所以返回的是Enter键之前没有被读取的所有字符
        dvd.setName(input.nextLine());
        dvd.setStatus(DvdStatus.INSTORE);

        System.out.print("请输入日租金单价：");
        dvd.setCost(input.nextDouble());

        int index = getFreePosition();
        arr[index] = dvd;
        System.out.println("上架成功！");

        return true;
    }

    // 下架
    public boolean downline(Dvd[] arr)
    {
        System.out.print("请输入您需要下架的影片名:>>");
        input = new Scanner(System.in);
        String del_name = input.nextLine();

        int index;
        int i = 0,j = 0;
        if (dvds[0] == null)
        {
            System.out.println("当前存档里面无可下架的影片！");
        }
        else
        {
            //查找目标位置的下标
            index = getPositionByName(del_name);
            if(-1 == index)
            {
                System.out.print("库存当中没有该影片！");
            }
            else
            {
                //删除操作
                for (j = index + 1;j<arr.length;j++)
                {
                    arr[j-1] = arr[j];
                }
                System.out.println("下架成功！");
            }
        }
        return true;
    }

    // 出租
    public boolean borrowDvd(Dvd[] arr)
    {
        System.out.println("出租:>>");
        input = new Scanner(System.in);

        System.out.print("请输入出租的影片名：");
        String bor_name = input.nextLine();

        int index = getPositionByName(bor_name);
        if (-1 == index)
        {
            System.out.println("库存中没有该影片~~");
        }
        else
        {
            if(dvds[index].getStatus() == DvdStatus.OUTSTORE)
            {
                System.out.print("抱歉，该影片正处于出租中~~是否预定?(Y or F)：");
                String flag = input.nextLine();
                if (flag.equals("Y"))
                {
                    dvds[index].setStatus(DvdStatus.SUBSCRIPT);
                }
                else
                {
                    System.out.println("取消成功~~");
                }
            }
            else
            {
                Date date = new Date();
                //获取系统当前时间
                arr[index].setBorrow_date(sdf.format(date));
                arr[index].setStatus(DvdStatus.OUTSTORE);
                arr[index].setSum_times(arr[index].getSum_times()+1);
            }
        }
        return true;
    }

    // 归还
    public boolean returnDvd(Dvd[] arr) throws ParseException {
        System.out.println("归还:>>");
        input = new Scanner(System.in);

        System.out.print("请输入归还的影片名：");
        String ret_name = input.nextLine();

        int index = getPositionByName(ret_name);
        if(arr[index].getStatus() == DvdStatus.OUTSTORE)
        {
            Date date = new Date();

            arr[index].setReturn_date(sdf.format(date));
            arr[index].setStatus(DvdStatus.INSTORE);
            arr[index].setProfit(arr[index].getProfit() + cal_Cost(arr[index].getBorrow_date(),arr[index].getReturn_date())*arr[index].getCost());
        }
        else
        {
            System.out.println("状态异常，不支持归还！");
        }
        return true;
    }


    // 查找 -- 重载各种参数的查找方法
    // 按id查找
    public Dvd searchById(Dvd[] arr)
    {
        input = new Scanner(System.in);

        System.out.print("请输入目标影片的id:>");
        String search_id = input.nextLine();

        int times = 0,i = 0;
        for (i = 0;i < arr.length && arr[i] != null;i++)
        {
            if(arr[i].getId().equals(search_id))
            {
                System.out.println("\n******************************************************搜索到的 DVD 信息********************************************************");
                System.out.println(" Id\t\t|\tName\t|\tCost\t|\t\tBorrow_data\t\t|\t\tReturn_time \t\t|\tSum_times\t|\tStatus\t|\tProfit");
                print_dvd(arr[i]);
                times = 1;
            }
        }
        if (0 == times)
        {
            System.out.println("没有该影片信息~~");
        }
        return arr[i];
    }

    // 按名称查找
    public Dvd searchByName(Dvd... arr)
    {
        input = new Scanner(System.in);

        System.out.print("请输入目标影片的name:>");
        String search_name = input.nextLine();

        int times = 0,i = 0;
        for (i = 0;i < arr.length && arr[i] != null;i++)
        {
            if(arr[i].getName().equals(search_name))
            {
                System.out.println("\n******************************************************搜索到的 DVD 信息********************************************************");
                System.out.println(" Id\t\t|\tName\t|\tCost\t|\t\tBorrow_data\t\t|\t\tReturn_time \t\t|\tSum_times\t|\tStatus\t|\tProfit");
                print_dvd(arr[i]);
                System.out.println();
                times = 1;
                break;
            }
        }
        if (0 == times)
        {
            System.out.println("没有该影片信息~~");
        }
        return dvds[i];
    }

    // 按状态查找
    public Dvd search(DvdStatus status)
    {
        int times = 0;
        System.out.println("\n******************************************************搜索到的 DVD 信息********************************************************");
        System.out.println(" Id\t\t|\tName\t|\tCost\t|\t\tBorrow_data\t\t|\t\tReturn_time \t\t|\tSum_times\t|\tStatus\t|\tProfit");
        int i;
        for(i = 0;i < dvds.length && dvds[i] != null;i++)
        {
            if (dvds[i].getStatus().getCode() == status.getCode())
            {
                print_dvd(dvds[i]);
                System.out.println("");
                times++;
            }
        }
        if (0 == times)
        {
            System.out.println("没有可查询的信息~~");
        }
        return dvds[i];
    }

    // 按热度查找
    public Dvd searchByFire(Dvd[] arr)
    {
        input = new Scanner(System.in);

        System.out.print("请输入目标影片的热度:>");
        int search_fire = input.nextInt();

        int times = 0,i = 0;
        System.out.println("\n******************************************************搜索到的 DVD 信息********************************************************");
        System.out.println(" Id\t\t|\tName\t|\tCost\t|\t\tBorrow_data\t\t|\t\tReturn_time \t\t|\tSum_times\t|\tStatus\t|\tProfit");
        for(i = 0;i < arr.length && arr[i] != null;i++)
        {
            if (arr[i].getSum_times() == search_fire)
            {
                print_dvd(arr[i]);
                System.out.println("");
                times++;
            }
        }

        if (0 == times)
        {
            System.out.println("没有可查询的信息~~");
        }
        return arr[i];
    }

    // 根据影片名找出目标数组的下标
    int getPositionByName(String name)
    {
        for (int i = 0;i < dvds.length && dvds[i] != null;i++)
        {
            if (dvds[i].getName().equals(name))
            {
                return i;
            }
        }
        return -1;
    }

    // 找出数组空闲位置
    int getFreePosition()
    {
        int position = 0;
        for (int i = 0; i < dvds.length;i++ )
        {
            if (dvds[i] == null)
            {
                position = i;
                break;
            }
        }
        return position;
    }

    // 租金计算
    double cal_Cost(String borrow_date,String return_date) throws ParseException {
        Date d1 = sdf.parse(return_date);
        Date d2 = sdf.parse(borrow_date);
        return (double) (d1.getTime() - d2.getTime())/(24*60*60*1000);
    }

    // 计算最大边际利润
    //通过将利润与租出次数相除得出最大边际利润
    public void maxProfit()
    {
        int i = 0;
        String max_pos_name = " ";
        for (i = 0;i < dvds.length && dvds[i] != null;i++)
        {
            dvds[i].setMaxProfit((double) (dvds[i].getProfit()/dvds[i].getSum_times()));
        }

        //找到最大边际利润
        for (i = 0;i < dvds.length && dvds[i] != null && dvds[i+1] != null;i++)
        {
            if (dvds[i].getMaxProfit() > dvds[i+1].getMaxProfit())
            {
                max_pos_name = dvds[i].getName();
            }
            else
            {
                max_pos_name = dvds[i+1].getName();
            }
        }
        i = getPositionByName(max_pos_name);
        System.out.printf("最大边际利润的是影片：%s,最大边际利润为：%.3f",dvds[i].getName(),dvds[i].getMaxProfit());
    }


    //排序
    public void sortById()
    {
        int i = 0,j = 0,res = 0;
        int insert_index = 0;
        //接收compareTo的返回值
        int index = getFreePosition();

        if (0 == index)
        {
            System.out.print("当前无存档信息~~");
        }
        else if (1 == index)
        {
            print_dvdArray(dvds);
        }
        else
        {
            for (i = 1;i < dvds.length;i++)
            {
                // 插入排序中需要和前面的数做对比的次数
                insert_index = i;
                for (j = insert_index - 1;j >= 0 && dvds[j] != null && dvds[i] != null;j--)
                {
                    res = dvds[i].getId().compareTo(dvds[j].getId());
                    if (res < 0)
                    {
                        Dvd dvd_tmp = new Dvd();
                        dvd_tmp = dvds[j];
                        dvds[j] = dvds[i];
                        dvds[i] = dvd_tmp;
                        break;
                    }
                }
            }
        }
    }

    public void sortByName()
    {
        int i = 0,j = 0,res = 0;
        int min_index = 0;//记录最小值的下标
        int index = getFreePosition();
        if (0 == index)
        {
            System.out.print("当前无存档信息~~");
        }
        else if (1 == index)
        {
            print_dvdArray(dvds);
        }
        else
        {
            //选择排序
            for(i = 0;i < dvds.length-1;i++)
            {
                Dvd dvd = new Dvd();
                dvd = dvds[i];
                min_index = 0;

                if(dvd != null)
                {
                    for (j = 0;j < dvds.length && dvds[j] != null;j++)
                    {
                        res = dvd.getName().compareTo(dvds[j].getName());
                        if (res >0)
                        {
                            min_index = j;
                            dvd = dvds[j];
                        }
                    }
                    if (min_index != 0)
                    {
                        Dvd dvd_temp = dvds[min_index];
                        dvds[min_index] = dvds[i];
                        dvds[i] = dvd_temp;
                    }
                }
            }
        }
    }

    public void sortByFire()
    {
        int i = 0,j = 0,min_pos = 0;
        int index = getFreePosition();
        if (0 == index)
        {
            System.out.print("当前无存档信息~~");
        }
        else if (1 == index)
        {
            print_dvdArray(dvds);
        }
        else
        {
            // --选择排序--
              Dvd dvd = new Dvd();
              for (i = 0;i < dvds.length - 1 && dvds[i] != null;i++)
              {
                  dvd = dvds[i];
                  min_pos = 0;;
                  {

                  }
                  for (j = i + 1; j < dvds.length && dvds[j] != null; j++)
                  {
                      if(dvd.getSum_times() < dvds[j].getSum_times())
                      {
                          //查找比原来的dvd更小的值
                          dvd = dvds[j];
                          //存储下标
                          min_pos = j;
                      }
                  }
                  if (min_pos != 0)
                  {
                      Dvd dvd_temp = dvds[min_pos];
                      dvds[min_pos] = dvds[i];
                      dvds[i] = dvd_temp;
                  }
              }
        }
    }

    public void sortByProfit()
    {
        int i = 0,j = 0,min_pos = 0;
        int index = getFreePosition();
        if (0 == index)
        {
            System.out.print("当前无存档信息~~");
        }
        else if (1 == index)
        {
            print_dvdArray(dvds);
        }
        else
        {
            //冒泡排序
            for(i = 0;i < dvds.length-1 && dvds[i] != null;i++)
            {
                // 判断dvds[i] 是否为空，不然会报空指针异常
                for(j = 0;j < dvds.length-i-1 && dvds[j] != null && dvds[j+1] != null;j++)
                {
                    // 判断dvds[j] 和 dvds[j+1] 是否为空，不然会报空指针异常
                    if (dvds[j].getProfit() < dvds[j+1].getProfit())
                    {
                        Dvd dvd = new Dvd();
                        dvd = dvds[j];
                        dvds[j] = dvds[j + 1];
                        dvds[j + 1] = dvd;
                    }
                }
            }
        }
    }

    public void print_dvd(Dvd dvd)
    {
        System.out.printf("%-6s\t\t",dvd.getId());
        System.out.printf("%3s\t\t",dvd.getName());
        System.out.printf("%2.2f\t\t",dvd.getCost());
        System.out.printf("%18s\t\t",dvd.getBorrow_date());
        System.out.printf("%18s\t\t",dvd.getReturn_date());
        System.out.printf("%8d\t\t\t",dvd.getSum_times());
        System.out.printf("%6s\t\t",dvd.getStatus());
        System.out.printf("%4.2f\t\t",dvd.getProfit());
    }

    public void print_dvdArray(Dvd[] arr) {
        if (arr[0] == null)
        {
            System.out.println("当前无存档的影片信息！");
        }
        else
        {
            System.out.println("\n******************************************************当前 DVD 信息********************************************************");
            System.out.println(" Id\t\t|\tName\t|\tCost\t|\t\tBorrow_data\t\t|\t\tReturn_time \t\t|\tSum_times\t|\tStatus\t|\tProfit");
            for (Dvd dvd : arr)
            {
                if (dvd != null)
                {
                    print_dvd(dvd);
                    System.out.println();
                }
                else
                {
                    maxProfit();
                    System.out.println("");
                    break;
                }
            }
        }
    }
}
