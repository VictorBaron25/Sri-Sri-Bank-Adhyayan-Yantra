import java.io.*;
class Sri_Sri_Bank_Adhyayan_Yojna extends Exception
{
    Sri_Sri_Bank_Adhyayan_Yojna(String KK)
    {
        super(KK);
        
    }
    Sri_Sri_Bank_Adhyayan_Yojna()
    {
        
    }
     
    static boolean checkdate(int d,int m,int y)
    {
        boolean k=false; int dmax=0;
        if(!(m>0 && m<=12))
        return false;
        if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)
        dmax=31;
        else if(m==4||m==6||m==9||m==11)
        dmax=30;
        if(y%100==0)
        {
            if(y%400==0)
            {
                k=true;
            }
        }
        else if(y%4==0)
        k=true;
        if(k==true && m==2)
        dmax=29;
        else if(m==2)
        dmax=28;
        if(d>0 && d<=dmax)
        return true;
        else
        return false;
    }
    public static void main() throws IOException
    {
        InputStreamReader ir=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ir);
        
        
        String acc="",name="",pan="",adhno="",add="",gen="",acc2="",name2="",pan2="",adhno2="",add2="",gen2="",temp="";
        long mob=0l,stab=0l,mob2=0l,stab2=0l;
        int r=0,age=0,r2=0,age2=0,dd=0,mm=0,yy=0,dd2=0,mm2=0,yy2=0,type=0,type2=0,ch=0;
        boolean f1=true,f2=false,f3=false;
        Sri_Sri_Bank_Adhyayan_Yojna ob=new Sri_Sri_Bank_Adhyayan_Yojna();
        boolean get=false; boolean fm;
        
        File fl12=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/Bank.dat");
        FileOutputStream fout12=new FileOutputStream(fl12,true);
        DataOutputStream dout12=new DataOutputStream(fout12);
        int cho=1;
        do
        {
            fm=false;
            System.out.println("==================================================");
            System.out.println("SRI SRI BANK ADHYAYAN YOJNA");
            System.out.println("==================================================");
            System.out.println("MAIN MENU:\n");
            System.out.println("1)Account Creation\n2)Account Amendment\n3)Account Deletion\n4)Transactions\n5)Display\n6)Exit");
            do
            {
            System.out.println("Enter choice:");
            f1=true;
            try
            {
                cho=Integer.parseInt(br.readLine());
                if(cho!=1&&cho!=2&&cho!=3&&cho!=4&&cho!=5&&cho!=6)
                {
                    System.out.println("Invalid choice");
                    f1=false;
                }
            }
            catch(Exception e)
            {
                System.out.println("Enter digits");
            }
            }while(f1==false);
            switch(cho)
            {
                case 1:
                System.out.println("\fWELCOME TO ACCOUNT CREATION SECTION...");
        
        do
        {
            File fl11=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/Bank.dat");
            FileInputStream fin11=new FileInputStream(fl11);
            DataInputStream din11=new DataInputStream(fin11);
            System.out.println("Enter Account Number:");
            acc=br.readLine();
            f1=true;
            do
            {
                try{
                acc2=din11.readUTF();
                name2=din11.readUTF();
                age2=din11.readInt();
                add2=din11.readUTF();
                gen2=din11.readUTF();
                mob2=din11.readLong();
                dd2=din11.readInt();
                mm2=din11.readInt();
                yy2=din11.readInt();
                adhno2=din11.readUTF();
                pan2=din11.readUTF();
                type2=din11.readInt();
                stab2=din11.readLong();
                if(acc2.equals(acc))
                {
                    f1=false;//agar pehle se present ho to na maane
                    break;
                }
                  }
                  catch(Exception e)
                  {
                break;//khatam hone pe
                   }
                }while(true);
            if(f1==false)
            {
                System.out.println("Account number already present! Try:"+(Integer.parseInt(acc2)+1));
            }
        }while(f1==false);
        dout12.writeUTF(acc);
        System.out.println("Enter name:");
        name=br.readLine();
        dout12.writeUTF(name);
        do
        {
            f1=true;
            System.out.println("Enter age:");
            try
            {
                age=Integer.parseInt(br.readLine());
                if(age<=0)
                {
                    System.out.println("Age not possible");
                    f1=false;
                }
            }
            catch(Exception e)
            {
                System.out.println("Enter in digits");
                f1=false;
            }
        }while(f1==false);
        dout12.writeInt(age);
        System.out.println("Enter address:");
        add=br.readLine();
        dout12.writeUTF(add);
        System.out.println("Enter gender:");
        gen=br.readLine();
        dout12.writeUTF(gen);
        do
        {
            f2=true;
            try
            {
                do
                {
            System.out.println("Enter Mobile number:");
            temp=br.readLine();
            if(temp.length()!=10)
            {
            f1=false;
            System.out.println("Mobile number should be of ten digits");
            }
            else
            {
            f1=true;
            }
            }while(f1==false);
            mob=Long.parseLong(temp);
            }
            catch(Exception e)
            {
                f2=false;
                System.out.println("Mobile number not valid.");
            }
        }while(f2==false);
        dout12.writeLong(mob);
        System.out.println("Enter Date of opening:");
        do
        {
            f3=true;
            do
            {
            f1=true;
            try
            {
                System.out.println("Enter date");
                dd=Integer.parseInt(br.readLine());
                System.out.println("Enter month:");
                mm=Integer.parseInt(br.readLine());
                System.out.println("Enter year:");
                yy=Integer.parseInt(br.readLine());
            }
            catch(Exception e)
            {
                System.out.println("Date not possible");
                f1=false;
            }
            }while(f1==false);
            f2=checkdate(dd,mm,yy);
            if(f2==false)
            {
                f3=false;
                System.out.println("Entered date is invalid");
            }
            else
            f3=true;
        }while(f3==false);
        dout12.writeInt(dd);
        dout12.writeInt(mm);
        dout12.writeInt(yy);
        System.out.println("Enter Aadhar number:");
        adhno=br.readLine();
        dout12.writeUTF(adhno);
        System.out.println("Enter Pan number:");
        pan=br.readLine();
        dout12.writeUTF(pan);
        f2=true;
        System.out.println("Account Type:\n1) Savings Account\n2) Recurring Deposit Account\n3) Current Account");
        do
        {
            f1=true;
            System.out.println("Enter choice:");
            try
            {
                type=Integer.parseInt(br.readLine());
            }
            catch(Exception e)
            {
                System.out.println("Enter in digits");
                f1=false;
            }
            if(f1==true)
            {
                if(type!=1 && type!=2 && type!=3)
                {
                System.out.println("Enter only 1,2 or 3");
                f2=false;
                }
                else    
                {
                    f2=true;
                }
            }
        }while(f1==false||f2==false);
        dout12.writeInt(type);
        do
        {
            f1=true;
            System.out.println("Enter initial balance:");
            try
            {
                stab=Long.parseLong(br.readLine());
                if(stab<500.0)
                {
                    System.out.println("Initial balance should be greater than Rs. 500");
                    f1=false;
                }
            }
            catch(Exception e)
            {
                System.out.println("Enter in digits:");
                f1=false;
            }
            
        }while(f1==false);
        dout12.writeLong(stab);
        System.out.println("\f\n\n\n\n\n\t\t\t ACCOUNT SUCCESSFULLY CREATED!!!");
        do
        {
            f1=true;
            try
            {
                System.out.println("1)Return\n2)Exit\nEnter choice:");
                ch=Integer.parseInt(br.readLine());
            }
            catch(Exception e)
            {
                f1=false;
                System.out.println("Enter 1 or 2");
            }
            if(ch!=1 && ch!=2)
            {
                f1=false;
                System.out.println("Enter 1 or 2");
            }
        }while(f1==false);
        if(ch==1)
        get=true;
        else
        get=false;
        if(get==false)
        fm=true;
        break;
                case 2:
                boolean flag=false;
                
                File fl23=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/temp.dat");
                FileOutputStream fout23=new FileOutputStream(fl23);
                DataOutputStream dout23=new DataOutputStream(fout23);
                System.out.println("\fWELCOME TO ACCOUNT AMENDMENT SECTION...");
        do
        {
            File fl21=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/Bank.dat");
            FileInputStream fin21=new FileInputStream(fl21);
            DataInputStream din21=new DataInputStream(fin21);
            System.out.println("Enter Account number:");
        do
        {
            try
            {
                
                acc=br.readLine();
                acc2=din21.readUTF();
                name2=din21.readUTF();
                age2=din21.readInt();
                add2=din21.readUTF();
                gen2=din21.readUTF();
                mob2=din21.readLong();
                dd2=din21.readInt();
                mm2=din21.readInt();
                yy2=din21.readInt();
                adhno2=din21.readUTF();
                pan2=din21.readUTF();
                type2=din21.readInt();
                stab2=din21.readLong();
                if(acc.equals(acc2))
                {
                    flag=true;
                    System.out.println("Note: Leave the space blank if not interested in editing an entry\n Now enter new details:");
                    System.out.println("Enter new name:");
                    name=br.readLine();
                    if(name.equals(""))
                    name=name2;
                    dout23.writeUTF(name);
                    do
                    {
                        f1=true;
                        System.out.println("Enter new age:");
                    try
                    {
                        String age3=br.readLine();
                        if(age3.equals(""))
                        age=age2;
                        else
                        age=Integer.parseInt(age3);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Enter in digits");
                        f1=false;
                    }
                    }while(f1==false);
                    dout23.writeInt(age);
                    System.out.println("Enter new address:");
                    add=br.readLine();
                    if(add.equals(""))
                    add=add2;
                    dout23.writeUTF(add);
                    System.out.println("Enter new gender:");
                    gen=br.readLine();
                    if(gen.equals(""))
                    gen=gen2;
                    dout23.writeUTF(gen);
                    do
                    {
                        f2=true;
                        try
                        {
                            do
                            {
                                System.out.println("Enter new Mobile number:");
                                temp=br.readLine();
                                if(temp.equals(""))
                                {
                                    temp=Long.toString(mob2);
                                    break;
                                }
                                if(temp.length()!=10)
                                {
                                    f1=false;
                                    System.out.println("Mobile number should be of ten digits");
                                }
                                else
                                {
                                    f1=true;
                                }
                            }while(f1==false);
                            mob=Long.parseLong(temp);
                        }
                        catch(Exception e)
                        {
                            f2=false;
                            System.out.println("Mobile number not valid.");
                        }
                    }while(f2==false);
                    dout23.writeLong(mob);
                    System.out.println("Enter new Date of opening:");
                    do
                    {
                        f3=true;
                        do
                        {
                            f1=true;
                            try
                            {
                                System.out.println("Enter date");
                                String dd3=br.readLine();
                                if(dd3.equals(""))
                                dd=dd2;
                                else
                                dd=Integer.parseInt(dd3);
                                System.out.println("Enter month:");
                                String mm3=br.readLine();
                                if(mm3.equals(""))
                                mm=mm2;
                                else
                                mm=Integer.parseInt(mm3);
                                System.out.println("Enter year:");
                                String yy3=br.readLine();
                                if(yy3.equals(""))
                                yy=yy2;
                                else
                                yy=Integer.parseInt(yy3);
                            }
                            catch(Exception e)
                            {
                                System.out.println("Date not possible");
                                f1=false;
                            }
                        }while(f1==false);
                        f2=checkdate(dd,mm,yy);
                        if(f2==false)
                        {
                            f3=false;
                            System.out.println("Invalid date");
                        }
                        else
                        f3=true;
                    }while(f3==false);
                    dout23.writeInt(dd);
                    dout23.writeInt(mm);
                    dout23.writeInt(yy);
                    System.out.println("Enter new Aadhar number:");
                    adhno=br.readLine();
                    if(adhno.equals(""))
                    adhno=adhno2;
                    dout23.writeUTF(adhno);
                    System.out.println("Enter new Pan number:");
                    pan=br.readLine();
                    if(pan.equals(""))
                    pan=pan2;
                    dout23.writeUTF(pan);
                    f2=true;
                     System.out.println("Account Type:\n1) Savings Account\n2) Recurring Deposit Account\n3) Current Account");
                     do
                       {
                                  f1=true;
                                  System.out.println("Enter choice:");
                                  try
                                  {
                                      String type3=br.readLine();
                                      if(type3.equals(""))
                                      type=type2;
                                      else
                                      {
                                          type=Integer.parseInt(type3);
                                        }
                                    }
                                    catch(Exception e)
                                    {
                                        System.out.println("Enter 1,2 or 3 only");
                                        f1=false;
                                    }
                                    if(f1==true)
                                    {
                                        if(type!=1 && type!=2 && type!=3)
                                        {
                                            System.out.println("Enter only 1,2 or 3");
                                            f2=false;
                                        }
                                        else    
                                        {
                                            f2=true;
                                        }
                                    }
                                }while(f1==false||f2==false);
                                dout23.writeInt(type);
                                do
                                {
                                    f1=true;
                                    System.out.println("Enter initial balance:");
                                    try
                                    {
                                        String stab3=br.readLine();
                                        if(stab3.equals(""))
                                        {
                                            stab=stab2;
                                            break;
                                        }
                                        else
                                        {
                                            stab=Integer.parseInt(stab3);
                                        }
                                        if(stab<500.0)
                                        {
                                            System.out.println("Initial balance should be greater tha Rs. 500");
                                            f1=false;;
                                        }
                                    }
                                    catch(Exception e)
                                    {
                                        System.out.println("Enter in digits:");
                                        f1=false;
                                    }
            
                                }while(f1==false);
                                dout23.writeLong(stab);
                                System.out.println("\f\n\n\n\n\n\t\t\t ACCOUNT SUCCESSFULLY EDITED!!!");
                                do
                                {
                                    f1=true;
                                    try
                                    {
                                        System.out.println("1)Return\n2)Exit\nEnter choice:");
                                        ch=Integer.parseInt(br.readLine());
                                    }
                                    catch(Exception e)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1 or 2");
                                    }
                                    if(ch!=1 && ch!=2)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1 or 2");
                                    }
                                }while(f1==false);
                            }
                        }
                        catch(Exception ww)
                        {
                            break;
                        }
                        
                    }while(true);
                    if(flag==false)
                    System.out.println("Account not found");
                            if(flag==true)
                            {
                               
                             dout23.close();
                             din21.close();
                             fl21.delete();
                             fl23.renameTo(fl21);
                            }
                }while(flag==false);
                   

         
                if(ch==1)
        get=true;
        else
        get=false;
        if(get==false)
        fm=true;
                break;
                case 3:
                 flag=false;
                 File fl31=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/temp.dat");
        FileOutputStream fout31=new FileOutputStream(fl31);
        DataOutputStream dout31=new DataOutputStream(fout31);
        System.out.println("\fWELCOME TO ACCOUNT DELETION SECTION...");
        do
        {
            File fl32=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/Bank.dat");
        FileInputStream fin32=new FileInputStream(fl32);
        DataInputStream din32=new DataInputStream(fin32);
            System.out.println("Enter Account number:");
            acc=br.readLine();
        do
        {
            try
            {
                acc2=din32.readUTF();
                name2=din32.readUTF();
                age2=din32.readInt();
                add2=din32.readUTF();
                gen2=din32.readUTF();
                mob2=din32.readLong();
                dd2=din32.readInt();
                mm2=din32.readInt();
                yy2=din32.readInt();
                adhno2=din32.readUTF();
                pan2=din32.readUTF();
                type2=din32.readInt();
                stab2=din32.readLong();
                if(acc2.equals(acc))
                {
                    flag=true;
                }
                else
                {
                    dout31.writeUTF(acc2);
                    dout31.writeUTF(name2);
                    dout31.writeInt(age2);
                    dout31.writeUTF(add2);
                    dout31.writeUTF(gen2);
                    dout31.writeLong(mob2);
                    dout31.writeInt(dd2);
                    dout31.writeInt(mm2);
                    dout31.writeInt(yy2);
                    dout31.writeUTF(adhno2);
                    dout31.writeUTF(pan2);
                    dout31.writeInt(type2);
                    dout31.writeLong(stab2);
                }
            }
            catch(Exception e)
            {
                break;
            }
        }while(true);
        if(flag==false)
        System.out.println("Account not present");
        if(flag==true)
        {
        dout31.close();
            din32.close();
        fl32.delete();
        fl31.renameTo(fl32);
        }
        }while(flag==false);
        
        System.out.println("\f\n\n\n\n\n\t\t\t ACCOUNT SUCCESSFULLY DELETED!!!");
        do
                                {
                                    f1=true;
                                    try
                                    {
                                        System.out.println("1)Return\n2)Exit\nEnter choice:");
                                        ch=Integer.parseInt(br.readLine());
                                    }
                                    catch(Exception e)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1 or 2");
                                    }
                                    if(ch!=1 && ch!=2)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1 or 2");
                                    }
         }while(f1==false);
         if(ch==1)
        get=true;
        else
        get=false;
        if(get==false)
        fm=true;
                break;
                case 4:
                ch=0;long amt=0,tt=0;
                File fl41=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/temp.dat");
        FileOutputStream fout41=new FileOutputStream(fl41);
        DataOutputStream dout41=new DataOutputStream(fout41);
        System.out.println("\fWELCOME TO TRANSACTIONS SECTION...");
        do
        {
            File fl42=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/Bank.dat");
            FileInputStream fin42=new FileInputStream(fl42);
            DataInputStream din42=new DataInputStream(fin42);
            System.out.println("Enter account number");
            acc=br.readLine();
            do
            {
                f1=false;
               try{
                
                acc2=din42.readUTF();
                name2=din42.readUTF();
                age2=din42.readInt();
                add2=din42.readUTF();
                gen2=din42.readUTF();
                mob2=din42.readLong();
                dd2=din42.readInt();
                mm2=din42.readInt();
                yy2=din42.readInt();
                adhno2=din42.readUTF();
                pan2=din42.readUTF();
                type2=din42.readInt();
                stab2=din42.readLong();
                if(acc2.equals(acc))
                {
                    f1=true;
                    break;
                }
                else
                {
                    f1=false;
                }
                  }
                  catch(Exception e)
                  {
                break;//khatam hone pe
                   }
                }while(true);
            if(f1==false)
            {
                System.out.println("Account not found. Try again");
            }
        }while(f1==false);
        do
                                {
                                    f1=true;
                                    try
                                    {
                                        System.out.println("1)Deposit\n2)Withdraw\n3)Return\nEnter choice:");
                                        ch=Integer.parseInt(br.readLine());
                                    }
                                    catch(Exception e)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1,2 or 3");
                                    }
                                    if(ch!=1 && ch!=2 && ch!=3)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1,2 or 3");
                                    }
         }while(f1==false);
        if(ch==1)
        {
            do
            {
                f1=true;
                try
                {
                    System.out.println("Enter deposit amount");
                    amt=Long.parseLong(br.readLine());
                }
                catch(Exception e)
                {
                    f1=false;
                    System.out.println("Enter in digits");
                }
            }while(f1==false);
            tt=stab2+amt;
            File fl43=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/Bank.dat");
            FileInputStream fin43=new FileInputStream(fl43);
            DataInputStream din43=new DataInputStream(fin43);
            do
            {
                try
                {
                    acc2=din43.readUTF();
                name2=din43.readUTF();
                age2=din43.readInt();
                add2=din43.readUTF();
                gen2=din43.readUTF();
                mob2=din43.readLong();
                dd2=din43.readInt();
                mm2=din43.readInt();
                yy2=din43.readInt();
                adhno2=din43.readUTF();
                pan2=din43.readUTF();
                type2=din43.readInt();
                stab2=din43.readLong();
                if(acc2.equals(acc))
                {
                    stab2=tt;
                }
                dout41.writeUTF(acc2);
                dout41.writeUTF(name2);
                dout41.writeInt(age2);
                dout41.writeUTF(add2);
                dout41.writeUTF(gen2);
                dout41.writeLong(mob2);
                dout41.writeInt(dd2);
                dout41.writeInt(mm2);
                dout41.writeInt(yy2);
                dout41.writeUTF(adhno2);
                dout41.writeUTF(pan2);
                dout41.writeInt(type2);
                dout41.writeLong(stab2);
            }
            catch(Exception e)
            {
                break;
            }
        }while(true);
        dout41.close();
        din43.close();
        fl43.delete();
        fl41.renameTo(fl43);
        System.out.println("\f\n\n\n\n\n\t\t\t TRANSACTION SUCCESSFUL!!!");
    }
    if(ch==2)
    {
         do
            {
                f1=true;
                try
                {
                    System.out.println("Enter Withdraw amount");
                    amt=Long.parseLong(br.readLine());
                    tt=stab2-amt;
                    if(tt<0)
                    {
                        System.out.println("Withdrawn amount exceeding present amount. Present amount is:"+stab2);
                        f1=false;
                    }
                }
                catch(Exception e)
                {
                    f1=false;
                    System.out.println("Enter in digits");
                }
            }while(f1==false);
            File fl44=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/Bank.dat");
                FileInputStream fin44=new FileInputStream(fl44);
                DataInputStream din44=new DataInputStream(fin44);
            do
            {
                
                try
                {
                    acc2=din44.readUTF();
                name2=din44.readUTF();
                age2=din44.readInt();
                add2=din44.readUTF();
                gen2=din44.readUTF();
                mob2=din44.readLong();
                dd2=din44.readInt();
                mm2=din44.readInt();
                yy2=din44.readInt();
                adhno2=din44.readUTF();
                pan2=din44.readUTF();
                type2=din44.readInt();
                stab2=din44.readLong();
                if(acc2.equals(acc))
                {
                    stab2=tt;
                }
                dout41.writeUTF(acc2);
                dout41.writeUTF(name2);
                dout41.writeInt(age2);
                dout41.writeUTF(add2);
                dout41.writeUTF(gen2);
                dout41.writeLong(mob2);
                dout41.writeInt(dd2);
                dout41.writeInt(mm2);
                dout41.writeInt(yy2);
                dout41.writeUTF(adhno2);
                dout41.writeUTF(pan2);
                dout41.writeInt(type2);
                dout41.writeLong(stab2);
            }
            catch(Exception e)
            {
                break;
            }
        }while(true);
        dout41.close();
        din44.close();
        fl44.delete();
        fl41.renameTo(fl44);
        System.out.println("\f\n\n\n\n\n\t\t\t TRANSACTION SUCCESSFUL!!!");
    }
    if(ch==3)
    get= true;
    
    do
                                {
                                    f1=true;
                                    try
                                    {
                                        System.out.println("1)Return\n2)Exit\nEnter choice:");
                                        ch=Integer.parseInt(br.readLine());
                                    }
                                    catch(Exception e)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1 or 2");
                                    }
                                    if(ch!=1 && ch!=2)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1 or 2");
                                    }
         }while(f1==false);
         if(get==true)
         {
             fm=false;
             break;
            }
         if(ch==1)
        get=true;
        else
        get=false;
        if(get==false)
        fm=true;
                break;
                case 5:
                System.out.println("\fWELCOME TO DISPLAY SECTION...");
                ch=0;
        do
                                {
                                    f1=true;
                                    try
                                    {
                                        System.out.println("1)Display particular account \n2)Display All Accounts \n3)Return\nEnter choice:");
                                        ch=Integer.parseInt(br.readLine());
                                    }
                                    catch(Exception e)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1,2 or 3");
                                    }
                                    if(ch!=1 && ch!=2 && ch!=3)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1,2 or 3");
                                    }
         }while(f1==false);
         if(ch==1)
         {
             do
             {
                 File fl51=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/Bank.dat");
                 FileInputStream fin51=new FileInputStream(fl51);
                 DataInputStream din51=new DataInputStream(fin51);
                 f1=false;
            System.out.println("Enter account number");
            acc=br.readLine();
            do
            {
                
               try{
                
                acc2=din51.readUTF();
                name2=din51.readUTF();
                age2=din51.readInt();
                add2=din51.readUTF();
                gen2=din51.readUTF();
                mob2=din51.readLong();
                dd2=din51.readInt();
                mm2=din51.readInt();
                yy2=din51.readInt();
                adhno2=din51.readUTF();
                pan2=din51.readUTF();
                type2=din51.readInt();
                stab2=din51.readLong();
                if(acc2.equals(acc))
                {
                    f1=true;
                    break;
                }
                  }
                  catch(Exception e)
                  {
                break;//khatam hone pe
                   }
                }while(true);
            if(f1==false)
            {
                System.out.println("Account not found. Try again");
            }
            }while(f1==false);
            File fl52=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/Bank.dat");
            FileInputStream fin52=new FileInputStream(fl52);
            DataInputStream din52=new DataInputStream(fin52);
            do
            {
               try{
                
                acc2=din52.readUTF();
                name2=din52.readUTF();
                age2=din52.readInt();
                add2=din52.readUTF();
                gen2=din52.readUTF();
                mob2=din52.readLong();
                dd2=din52.readInt();
                mm2=din52.readInt();
                yy2=din52.readInt();
                adhno2=din52.readUTF();
                pan2=din52.readUTF();
                type2=din52.readInt();
                stab2=din52.readLong();
                if(acc2.equals(acc))
                {
                    System.out.println("Account number: "+acc2);
                    System.out.println("Name: "+name2);
                    System.out.println("Age: "+age2);
                    System.out.println("Address: "+add2);
                    System.out.println("Gender: "+gen2);
                    System.out.println("Mobile number: "+mob2);
                    System.out.println("Date of creation: "+dd2+"/"+mm2+"/"+yy2);
                    System.out.println("Aadhar number: "+adhno2);
                    System.out.println("Pan card number: "+pan2);
                    System.out.println("Type of account: "+type2);
                    System.out.println("Balance: "+stab2);
                }
               }
               catch(Exception e)
               {
                   break;
                }
            }while(true);
        }
        if(ch==2)
        {
            File fl53=new File("C:/Users/khushi/Documents/blue j/FileHandling/Files/Bank.dat");
            FileInputStream fin53=new FileInputStream(fl53);
            DataInputStream din53=new DataInputStream(fin53);
            do
            {
               try{
                
                acc2=din53.readUTF();
                name2=din53.readUTF();
                age2=din53.readInt();
                add2=din53.readUTF();
                gen2=din53.readUTF();
                mob2=din53.readLong();
                dd2=din53.readInt();
                mm2=din53.readInt();
                yy2=din53.readInt();
                adhno2=din53.readUTF();
                pan2=din53.readUTF();
                type2=din53.readInt();
                stab2=din53.readLong();
                    System.out.println("Account number: "+acc2);
                    System.out.println("Name: "+name2);
                    System.out.println("Age: "+age2);
                    System.out.println("Address: "+add2);
                    System.out.println("Gender: "+gen2);
                    System.out.println("Mobile number: "+mob2);
                    System.out.println("Date of creation: "+dd2+"/"+mm2+"/"+yy2);
                    System.out.println("Aadhar number: "+adhno2);
                    System.out.println("Pan card number: "+pan2);
                    System.out.println("Type of account: "+type2);
                    System.out.println("Balance: "+stab2+"\n");
                }
               catch(Exception e)
               {
                   break;
                }
            }while(true);
        }
        if(ch==3)
        get= true;
        do
                                {
                                    f1=true;
                                    try
                                    {
                                        System.out.println("1)Return\n2)Exit\nEnter choice:");
                                        ch=Integer.parseInt(br.readLine());
                                    }
                                    catch(Exception e)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1 or 2");
                                    }
                                    if(ch!=1 && ch!=2)
                                    {
                                        f1=false;
                                        System.out.println("Enter 1 or 2");
                                    }
         }while(f1==false);
         if(get==true)
         {
             fm=false;
             break;
            }
         if(ch==1)
        get=true;
        else
        get=false;
        if(get==false)
        fm=true;
                break;
                case 6:
                fm=true;
            }
            System.out.print("\f");
        }while(fm==false);
        System.out.println("\f\n\n\n\n\n\t\t\t HAVE A NICE DAY!!!");
    }
}
            