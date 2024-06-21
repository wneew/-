package com.his.test;

import com.his.entity.Doctor;
import com.his.entity.Registinfo;
import com.his.io.FileIO;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        List<Registinfo> list = new ArrayList<Registinfo>();
//        FileIO.writeObject("registinfo.txt",list);
        List<Registinfo> rlist = (List<Registinfo>) FileIO.readObject("registinfo.txt");
        for (Registinfo reg:rlist){
            System.out.println(reg);
        }
//         List<Doctor> list =(List<Doctor>)  FileIO.readObject("doctor.txt");
//         for (Doctor d:list){
//             System.out.println(d);
//         }
//        Doctor d1 = new Doctor();
//        d1.setId("1001");
//        d1.setPassword("111");fdsgerrrrrrrrrrrrrrrw
//        d1.setRealname("华佗");
//        d1.setDeptname("骨科");
//        d1.setRegistlevel("普通");
//        d1.setRegistfee(10.00);
//        Doctor d2 = new Doctor();
//        d2.setId("1002");
//        d2.setPassword("222");
//        d2.setRealname("扁鹊");
//        d2.setDeptname("骨科");
//        d2.setRegistlevel("主任");
//        d2.setRegistfee(70.00);
//        Doctor d3 = new Doctor();
//        d3.setId("1003");
//        d3.setPassword("333");
//        d3.setRealname("安道全");
//        d3.setDeptname("呼吸内科");
//        d3.setRegistlevel("副主任");
//        d3.setRegistfee(50.00);
//        Doctor d4 = new Doctor();
//        d4.setId("1004");
//        d4.setPassword("444");
//        d4.setRealname("韩亚玲");
//        d4.setDeptname("呼吸内科");
//        d4.setRegistlevel("专家");
//        d4.setRegistfee(100.00);
//        Doctor d5 = new Doctor();
//        d5.setId("1005");
//        d5.setPassword("555");
//        d5.setRealname("张仲景");
//        d5.setDeptname("神经内科");
//        d5.setRegistlevel("主任");
//        d5.setRegistfee(80.00);
//        Doctor d6 = new Doctor();
//        d6.setId("1006");
//        d6.setPassword("666");
//        d6.setRealname("孙思邈");
//        d6.setDeptname("心胸外科");
//        d6.setRegistlevel("普通");
//        d6.setRegistfee(10.00);
//        Doctor d7 = new Doctor();
//        d7.setId("1007");
//        d7.setPassword("777");
//        d7.setRealname("李时珍");
//        d7.setDeptname("消化科");
//        d7.setRegistlevel("副主任");
//        d7.setRegistfee(50.00);
//        List<Doctor> list = new ArrayList<Doctor>();
//        list.add(d1);
//        list.add(d2);
//        list.add(d3);
//        list.add(d4);
//        list.add(d5);
//        list.add(d6);
//        list.add(d7);
//        FileIO.writeObject("doctor.txt",list);
    }
}
