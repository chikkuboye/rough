import java.sql.*;
import java.util.Scanner;
import java.util.Date;
import java.time.Month;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Service {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("select option");
            System.out.println("1.add");
            System.out.println("2.search");
            System.out.println("3.delete");
            System.out.println("4.update");
            System.out.println("5.view all");
            System.out.println("6.generate bill");
            System.out.println("7.view all bill");
            System.out.println("8.top 2 bill");
            System.out.println("9.exit");

            choice = sc.nextInt();

            switch (choice){
                case 1:
                    String name = sc.next();
                    String address = sc.next();
                    String phone = sc.next();
                    int custCode = sc.nextInt();
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
                    int choice1 = sc.nextInt();
                    switch (choice1){
                        case 1:
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

                    }
                    break;
                case 3:
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
                    custCode = sc.nextInt();
                    name = sc.next();
                    address = sc.next();
                    phone = sc.next();
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
                    custCode = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                        String sql = "DELETE FROM `customer` WHERE `Cust_code`='"+custCode+"'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Updated successfully");

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                case 6:
                    String date = "2022-11-10";
                    LocalDate currentDate = LocalDate.parse(date);
                    Month month = currentDate.getMonth();

                    int year = currentDate.getYear();
                    custCode = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kseb_db", "root", "");
                        String sql = "SELECT `id` FROM `customer` WHERE `Cust_code`="+custCode;
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()) {
                            int id = rs.getInt("id");

                            String sql1 = "SELECT SUM(`Unit`) FROM `usage` WHERE `User_Id`='" + id + "'  AND MONTH(`Date`)='" + month + "' AND YEAR(`Date`)='" + year + "'";
                            Statement stmt1 = con.createStatement();
                            ResultSet rs1 = stmt1.executeQuery(sql1);
                            while(rs1.next()){
                                int add = rs.getInt("SUM(`Unit`)");
                                int status = 0;
                                int totalBill = add * 5;

                                String sql2 = "INSERT INTO `bill`(`User_Id`, `month`, `year`, `bill`, `paid status`, `bill date`, `total_unit`) VALUES (%s,%s,%s,%s,%s,now(),%s)";
                                PreparedStatement stmt2 = con.prepareStatement(sql2);
                                stmt2.setInt(1,id);
                                //stmt2.setInt(2,month);
                                stmt2.setInt(3,year);
                                stmt2.setInt(4,totalBill);
                                stmt2.setInt(5,status);
                                stmt2.setInt(6,add);

                            }
                        }

                    }
                    catch (Exception e){

                    }



            }
        }
    }
}
