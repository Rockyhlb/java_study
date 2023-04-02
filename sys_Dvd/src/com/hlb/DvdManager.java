package com.hlb;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;

public class DvdManager {
    public static Dvd[] dvds = new Dvd[100];
    Scanner input = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    public void  menu() throws ParseException {
        init();
        do{
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.print("***** DVD出租管理信息系统 *****\n");
            System.out.print("*****  1       显示      *****\n");
            System.out.print("*****  2       上架      *****\n");
            System.out.print("*****  3       下架      *****\n");
            System.out.print("*****  4       出租      *****\n");
            System.out.print("*****  5       归还      *****\n");
            System.out.print("*****  6       查找      *****\n");
            System.out.print("*****  7       排序      *****\n");
            System.out.print("*****  8       退出      *****\n");
            System.out.print("******************************\n");
            System.out.print("请输入选项:>>");
            int choice = input.nextInt();

            switch (choice)
            {
                case 1:
                {
                    print_dvdArray(dvds);
                    continue;
                }
                case 2:
                {
                    upline(dvds);
                    continue;
                }
                case 3:
                {
                    print_dvdArray(dvds);
                    downline(dvds);
                    continue;
                }
                case 4:
                {
                    print_dvdArray(dvds);
                    borrowDvd(dvds);
                    continue;
                }
                case 5:
                {
                    print_dvdArray(dvds);
                    returnDvd(dvds);
                    continue;
                }
                case 6:
                {
                    search_menu();
                    input = new Scanner(System.in);
                    System.out.print("请输入查找方式:>>");

                    int choice_sea = input.nextInt();
                    switch (choice_sea)
                    {
                        case 1:
                            searchById(dvds);
                            break;
                        case 2:
                            searchByName(dvds);
                            break;
                        case 3:
                            input = new Scanner(System.in);
                            System.out.print("请输入目标影片的状态( 0: '在店'，1: '出租',2: '坏碟',3: '预定'):>");

                            int search_flag = input.nextInt();
                            switch (search_flag)
                            {
                                case 0:
                                    search(DvdStatus.INSTORE);
                                    break;
                                case 1:
                                    search(DvdStatus.OUTSTORE);
                                    break;
                                case 2:
                                    search(DvdStatus.BADDISK);
                                    break;
                                case 3:
                                    search(DvdStatus.SUBSCRIPT);
                                    break;
                                default:
                                    System.out.println("输入非法！");
                                    break;
                            }
                            break;
                        case 4:
                            searchByFire(dvds);
                            break;
                        default:
                            System.out.print("请输入有效选项:>>");
                            continue;
                    }

                    continue;
                }
                case 7:
                {
                    sort_menu();
                    input = new Scanner(System.in);

                    System.out.print("请输入排序方式:>>");
                    int choice_sor = input.nextInt();

                    switch (choice_sor)
                    {
                        case 1:
                            sortById();
                            print_dvdArray(dvds);
                            break;
                        case 2:
                            sortByName();
                            print_dvdArray(dvds);
                            break;
                        case 3:
                            sortByFire();
                            print_dvdArray(dvds);
                            break;
                        case 4:
                            sortByProfit();
                            print_dvdArray(dvds);
                            break;
                        default:
                            System.out.print("请输入有效选项:>>");
                            continue;
                    }

                    continue;
                }
                case 8:
                {
                    System.out.println("退出成功~~");
                    break;
                }
                default:
                    System.out.print("输入非法，请重新输入：\n");
                    continue;
            }
            break;
        }while(true);
    }

    public void search_menu()
    {
        System.out.println("************************************");
        System.out.println("********* 1   按 id 查找 ***********");
        System.out.println("********* 2   按name查找 ***********");
        System.out.println("********* 3   按状态查找 ***********");
        System.out.println("********* 4   按热度查找 ***********");
        System.out.println("************************************");
    }

    public void sort_menu()
    {
        System.out.println("************************************");
        System.out.println("********* 1   按 id 排序 ***********");
        System.out.println("********* 2   按name排序 ***********");
        System.out.println("********* 3   按热度排序 ***********");
        System.out.println("********* 4   按利润排序 ***********");
        System.out.println("************************************");
    }

    // 初始化方法  --  实例化三张dvd,放入容器（dvds）
    public void init() throws ParseException {
        Dvd dvd1 = new Dvd();
        Dvd dvd2 = new Dvd();
        Dvd dvd3 = new Dvd();

        dvd1.id = UUID.randomUUID().toString().replace("-","").substring(0,6);
        dvd1.name = "西游记";
        dvd1.cost = 45.5;
        dvd1.status = DvdStatus.INSTORE;
        dvd1.sum_times = 3;
        dvd1.borrow_date = "2023-03-31 06:12";
        dvd1.return_date = "2023-04-02 12:21";
        dvd1.profit = cal_Cost(dvd1.borrow_date,dvd1.return_date)*dvd1.cost;

        // --upline(dvd1) 可达到一样的效果
        dvds[0] = dvd1;

        dvd2.id = UUID.randomUUID().toString().replace("-","").substring(0,6);
        dvd2.name = "水浒传";
        dvd2.cost = 55.5;
        dvd2.status = DvdStatus.INSTORE;
        dvd2.sum_times = 1;
        dvds[1] = dvd2;

        dvd3.id = UUID.randomUUID().toString().replace("-","").substring(0,6);
        dvd3.name = "三国演义";
        dvd3.cost = 65.5;
        dvd3.status = DvdStatus.INSTORE;
        dvd3.sum_times = 2;
        dvds[2] = dvd3;
        dvd3.borrow_date = "2023-03-30 06:12";
        dvd3.return_date = "2023-04-04 12:21";
        dvd3.profit = cal_Cost(dvd3.borrow_date,dvd3.return_date)*dvd3.cost;
    }

    // 上架
    boolean upline(Dvd[] arr)
    {
        input = new Scanner(System.in);
        Dvd dvd = new Dvd();

        System.out.println("开始上架DVD信息>>:");

        //产生随机id
        dvd.id = UUID.randomUUID().toString().replace("-","").substring(0,6);

        System.out.print("请输入片名：");
        //next()方法会过滤掉有效字符前面的无效字符,不能得到带空格的字符串
        //有扫描一整行的意思，它的结束符只能是Enter键，所以返回的是Enter键之前没有被读取的所有字符
        dvd.name = input.nextLine();
        dvd.status = DvdStatus.INSTORE;

        System.out.print("请输入日租金单价：");
        dvd.cost = input.nextDouble();

        int index = getFreePosition();
        arr[index] = dvd;
        System.out.println("上架成功！");

        return true;
    }

    // 下架
    boolean downline(Dvd[] arr)
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
    boolean borrowDvd(Dvd[] arr)
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
            if(dvds[index].status == DvdStatus.OUTSTORE)
            {
                System.out.println("抱歉，该影片正处于出租中~~");
            }
            else
            {
                Date date = new Date();
                //获取系统当前时间
                arr[index].borrow_date = sdf.format(date);
                arr[index].status = DvdStatus.OUTSTORE;
                arr[index].sum_times++;
            }
        }
        return true;
    }

    // 归还
    boolean returnDvd(Dvd[] arr) throws ParseException {
        System.out.println("归还:>>");
        input = new Scanner(System.in);

        System.out.print("请输入归还的影片名：");
        String ret_name = input.nextLine();

        int index = getPositionByName(ret_name);
        if(arr[index].status == DvdStatus.OUTSTORE)
        {
            Date date = new Date();

            arr[index].return_date = sdf.format(date);
            arr[index].status = DvdStatus.INSTORE;
            arr[index].profit += cal_Cost(arr[index].return_date,arr[index].borrow_date);
        }
        else
        {
            System.out.println("状态异常，不支持归还！");
        }
        return true;
    }


    // 查找 -- 重载各种参数的查找方法
    // 按id查找
    Dvd searchById(Dvd[] arr)
    {
        input = new Scanner(System.in);

        System.out.print("请输入目标影片的id:>");
        String search_id = input.nextLine();

        int times = 0,i = 0;
        for (i = 0;i < arr.length && arr[i] != null;i++)
        {
            if(arr[i].id.equals(search_id))
            {
                System.out.println(" id\t\t|\tname\t|\tcost\t|\tborrow_data\t\t|\treturn_time\t|\tsum_times\t|\tstatus");
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
    Dvd searchByName(Dvd... arr)
    {
        input = new Scanner(System.in);

        System.out.print("请输入目标影片的name:>");
        String search_name = input.nextLine();

        int times = 0,i = 0;
        for (i = 0;i < arr.length && arr[i] != null;i++)
        {
            if(arr[i].name.equals(search_name))
            {
                System.out.println(" id\t\t|\tname\t|\tcost\t|\tborrow_data\t\t|\treturn_time\t|\tsum_times\t|\tstatus");
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
    Dvd search(DvdStatus status)
    {
        int times = 0;
        System.out.println(" id\t\t|\tname\t|\tcost\t|\tborrow_data\t\t|\treturn_time\t|\tsum_times\t|\tstatus");
        int i;
        for(i = 0;i < dvds.length && dvds[i] != null;i++)
        {
            if (dvds[i].status.code == status.code)
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
    Dvd searchByFire(Dvd[] arr)
    {
        input = new Scanner(System.in);

        System.out.print("请输入目标影片的热度:>");
        int search_fire = input.nextInt();

        int times = 0,i = 0;
        System.out.println(" id\t\t|\tname\t|\tcost\t|\tborrow_data\t\t|\treturn_time\t|\tsum_times\t|\tstatus");
        for(i = 0;i < arr.length && arr[i] != null;i++)
        {
            if (arr[i].sum_times == search_fire)
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
            if (dvds[i].name.equals(name))
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
    void maxProfit()
    {
        int i = 0;
        String max_pos_name = " ";
        for (i = 0;i < dvds.length && dvds[i] != null;i++)
        {
            dvds[i].maxProfit = (double) (dvds[i].profit/dvds[i].sum_times);
        }

        //找到最大边际利润
        for (i = 0;i < dvds.length && dvds[i] != null && dvds[i+1] != null;i++)
        {
            if (dvds[i].maxProfit > dvds[i+1].maxProfit)
            {
                max_pos_name = dvds[i].name;
            }
            else
            {
                max_pos_name = dvds[i+1].name;
            }
        }
        i = getPositionByName(max_pos_name);
        System.out.printf("最大边际利润的是影片：%s,最大边际利润为：%.3f",dvds[i].name,dvds[i].maxProfit);
    }


    //排序
    void sortById()
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
                    res = dvds[i].id.compareTo(dvds[j].id);
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

    void sortByName()
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
                        res = dvd.name.compareTo(dvds[j].name);
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

    void sortByFire()
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
                      if(dvd.sum_times < dvds[j].sum_times)
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

    void sortByProfit()
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
                    if (dvds[j].profit < dvds[j+1].profit)
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

    void print_dvd(Dvd dvd)
    {
        System.out.printf("%-6s\t\t",dvd.id);
        System.out.printf("%3s\t\t",dvd.name);
        System.out.printf("%2.2f\t\t",dvd.cost);
        System.out.printf("%18s\t\t",dvd.borrow_date);
        System.out.printf("%18s\t\t",dvd.return_date);
        System.out.printf("%8d\t\t\t",dvd.sum_times);
        System.out.printf("%6s\t\t",dvd.status);
        System.out.printf("%4.2f\t\t",dvd.profit);
    }

    void print_dvdArray(Dvd[] arr) {
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
