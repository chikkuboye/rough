import javax.swing.*;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Random;


public class Service {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("select option");
            System.out.println("1.add");
            System.out.println("2.search");
            System.out.println("3.view");
            System.out.println("4.update");
            System.out.println("5.delete");
            System.out.println("6.generate bill");
            System.out.println("7.view all bill");
            System.out.println("8.top 2 bill");
            System.out.println("9.exit");

            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("name");
                    String name = sc.next();
                    System.out.println("address");
                    String address = sc.next();
                    System.out.println("phone");
                    String phone = sc.next();
                    System.out.println("cust code");
                    int custCode = sc.nextInt();
                    System.out.println("email");
                    String email = sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                        String sql = "INSERT INTO `customer`(`Name`, `Address`, `Phone_num`, `Cust_code`, `Email`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setString(2,address);
                        stmt.setString(3,phone);
                        stmt.setInt(4,custCode);
                        stmt.setString(5,email);
                        stmt.executeUpdate();

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("1.search using name");
                    System.out.println("2.search using phone number");
                    System.out.println("3.search using code");
                    System.out.println("4.Exit");
                    System.out.println("enter the choice");
                    int choice1 = sc.nextInt();
                    switch (choice1){
                        case 1:
                            System.out.println("enter the name");
                            name = sc.next();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                                String sql = "SELECT `Name`, `Address`, `Phone_num`, `Cust_code`, `Email` FROM `customer` WHERE `Name`='"+name+"'";
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("Name");
                                    address = rs.getString("Address");
                                    phone = rs.getString("Phone_num");
                                    custCode = rs.getInt("Cust_code");
                                    email = rs.getString("Email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phone number = "+phone);
                                    System.out.println("customer code = "+custCode);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            System.out.println("enter the phone number");
                            phone = sc.next();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                                String sql = "SELECT `Name`, `Address`, `Phone_num`, `Cust_code`, `Email` FROM `customer` WHERE `Phone_num`='"+phone+"'";
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("Name");
                                    address = rs.getString("Address");
                                    phone = rs.getString("Phone_num");
                                    custCode = rs.getInt("Cust_code");
                                    email = rs.getString("Email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phone number = "+phone);
                                    System.out.println("customer code = "+custCode);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;

                        case 3:
                            System.out.println("enter the customer code ");
                            custCode = sc.nextInt();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                                String sql = "SELECT `Name`, `Address`, `Phone_num`, `Cust_code`, `Email` FROM `customer` WHERE `Cust_code`='"+custCode+"'";
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("Name");
                                    address = rs.getString("Address");
                                    phone = rs.getString("Phone_num");
                                    custCode = rs.getInt("Cust_code");
                                    email = rs.getString("Email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phone number = "+phone);
                                    System.out.println("customer code = "+custCode);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;

                        case 4:
                            System.exit(0);

                    }
                    break;
                case 3:
                    System.out.println("view the details");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                        String sql = "SELECT `Name`, `Address`, `Phone_num`, `Cust_code`, `Email` FROM `customer` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            name = rs.getString("Name");
                            address = rs.getString("Address");
                            phone = rs.getString("Phone_num");
                            custCode = rs.getInt("Cust_code");
                            email = rs.getString("Email");
                            System.out.println("name = "+name);
                            System.out.println("address = "+address);
                            System.out.println("phone number = "+phone);
                            System.out.println("customer code = "+custCode);
                            System.out.println("Email id = "+email+'\n');
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                case 4:
                    System.out.println("Update the details");
                    System.out.println("enter the cust code");
                    custCode = sc.nextInt();
                    System.out.println("entre the name");
                    name = sc.next();
                    System.out.println("enter the address");
                    address = sc.next();
                    System.out.println("entre the phone number");
                    phone = sc.next();
                    System.out.println("enter the mail");
                    //custCode = sc.nextInt();
                    email = sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                        String sql = "UPDATE `customer` SET `Name`='"+name+"',`Address`='"+address+"',`Phone_num`='"+phone+"',`Cust_code`='"+custCode+"',`Email`='"+email+"' WHERE `Cust_code`='"+custCode+"'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Updated successfully");

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                case 5:
                    System.out.println("Delete the details");
                    System.out.println("enter the cust code ");
                    custCode = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                        String sql = "DELETE FROM `customer` WHERE `Cust_code`='"+custCode+"'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Deleted successfully");

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                case 6:
                    System.out.println("Generate the bill");
                    Date dt=new Date();
                    Calendar cal= Calendar.getInstance();
                    cal.setTime(dt);
                    System.out.println(dt);
                    Random rand = new Random();
                    int month=cal.get(Calendar.DAY_OF_MONTH);
                    int year=cal.get(Calendar.YEAR);

                    System.out.println(month);
                    System.out.println(year);
                    int status = 0;
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                        String sql = "DELETE FROM `bill` WHERE `month`= '" + month + "'AND `year`= '" + year + "'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        String sql1 = "SELECT `id` FROM `customer` ";
                        //String sql = "SELECT `id` FROM `customer`;
                        Statement stmt1 = con.createStatement();
                        ResultSet rs = stmt1.executeQuery(sql1);
                        while (rs.next()) {
                            int id = rs.getInt("id");

                            String sql2 = "SELECT SUM(`Unit`) FROM `usage` WHERE `User_Id`='" + id + "'  AND MONTH(`Date`)='" + month + "' AND YEAR(`Date`)='" + year + "'";
                            Statement stmt2 = con.createStatement();
                            ResultSet rs1 = stmt2.executeQuery(sql2);
                            while (rs1.next()) {
                                int add = rs1.getInt("SUM(`Unit`)");
//                                int status = 0;
                                int totalBill = add * 5;
                                int num = rand.nextInt(1000,10000);
                                String sql3 = "INSERT INTO `bill`(`User_Id`, `month`, `year`, `bill`, `paid status`,`total_unit`,`invoice_num`,`bill date`, `due_date`) VALUES (?,?,?,?,?,?,?,now(),now()+interval 14 day)";
                                PreparedStatement stmt3 = con.prepareStatement(sql3);
                                stmt3.setInt(1, id);
                                stmt3.setInt(2, month);
                                stmt3.setInt(3, year);
                                stmt3.setInt(4, totalBill);
                                stmt3.setInt(5, status);
                                //stmt3.setInt(6, dt);
                                stmt3.setInt(6, add);
                                stmt3.setInt(7,num);
                                stmt3.executeUpdate();

                            }

                        }
                    }
                    catch (Exception e){
                        System.out.println(e);

                    }
                    break;

                case 7:
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                        String sql = "SELECT  c.Name,c.Address,b.`month`, b.`year`, b.`bill`, b.`paid status`, b.`bill date`, b.`due_date`, b.`total_unit`, b.`invoice_num` FROM `bill` b JOIN customer c ON b.User_Id=c.id";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            name = rs.getString("c.Name");
                            address = rs.getString("c.Address");
                            int month1 = rs.getInt("b.month");
                            int year1 = rs.getInt("b.year");
                            int bill = rs.getInt("b.bill");
                            String sta = rs.getString("b.paid status");
                            String date1 = rs.getString("b.bill date");
                            String date2 = rs.getString("b.due_date");
                            int total = rs.getInt("b.total_unit");
                            int invoice = rs.getInt("b.invoice_num");
                            System.out.println("name ="+name);
                            System.out.println("address ="+address);
                            System.out.println("month ="+month1);
                            System.out.println("year = "+year1);
                            System.out.println("total bill = "+bill);
                            System.out.println("status="+sta);
                            System.out.println("bill date="+date1);
                            System.out.println("due date="+date2);
                            System.out.println("total unit ="+total);
                            System.out.println("invoice ="+invoice+'\n');
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 8:
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                        String sql = "SELECT c.Name,c.Address,b.`bill`, b.`total_unit` FROM `bill` b JOIN customer c ON b.User_Id=c.id ORDER BY b.`bill`DESC LIMIT 2";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            name = rs.getString("c.Name");
                            address = rs.getString("c.Address");
                            int bill = rs.getInt("b.bill");
                            int total = rs.getInt("total_unit");
                            System.out.println("name ="+name);
                            System.out.println("address ="+address);
                            System.out.println("total bill = "+bill);
                            System.out.println("total unit ="+total+'\n');

                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }
}
