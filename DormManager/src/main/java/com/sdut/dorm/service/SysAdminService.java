package com.sdut.dorm.service;

import com.sdut.dorm.bean.Dorm;
import com.sdut.dorm.bean.Room;
import com.sdut.dorm.bean.Student;
import com.sdut.dorm.bean.SysAdmin;
import com.sdut.dorm.dao.DormDao;
import com.sdut.dorm.dao.RoomDao;
import com.sdut.dorm.dao.StudentDao;
import com.sdut.dorm.dao.SysAdminDao;
import com.sdut.dorm.util.Result;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.executor.ReuseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysAdminService {
    @Autowired(required = false)
    private SysAdminDao sysAdminDao;
    @Autowired(required = false)
    private DormDao dormDao;
    @Autowired(required = false)
    private RoomDao roomDao;
    @Autowired(required = false)
    private StudentDao studentDao;

    public Result sysLogin(SysAdmin sysAdmin, HttpServletRequest request){
        //System.out.println(sysAdmin.getSysAdminNum()+"sysadmin");
        Result result = new Result();
        result.setSuccess(true);
        SysAdmin sys = null;
        try {
            sys = sysAdminDao.login(sysAdmin.getSysAdminNum());
            //System.out.println(sys.getSysAdminPwd()+"service");
        }catch (Exception e){
            result.setSuccess(false);
            result.setCode(500);
            result.setMessage("服务器错误");
            return result;
        }
        if(sys!=null){
            if(StringUtils.isEmpty(sysAdmin.getSysAdminPwd())){
                result.setCode(500);
                result.setMessage("请输入密码");
                return result;
            }
            System.out.println(sys);
            System.out.println(sysAdmin.getSysAdminPwd());
            if(sys.getSysAdminPwd().equals(sysAdmin.getSysAdminPwd())){
                result.setMessage("登陆成功");
                result.setCode(2);
                result.setSuccess(true);
                result.setData(sys);
                request.getSession().setAttribute(sys.getSysAdminNum()+"",sys);
                return result;
            }
            result.setCode(0);
            result.setSuccess(false);
            result.setMessage("密码错误");
            return result;
        }
        result.setCode(1);
        result.setSuccess(false);
        result.setMessage("用户名不存在");
        return result;
    }

    public Boolean sysRegist(SysAdmin sysAdmin,HttpServletRequest request){
        return sysAdminDao.regist(sysAdmin);
    }
    public Result autoInDorm(List<Student>stuList){
        List<Room> roomList = roomDao.getNotFullRoom();
        ArrayList<Room>manRoom = new ArrayList<>();
        ArrayList<Room>womanRoom = new ArrayList<>();
        Integer number=0;
        //区分男女宿舍
        for(int i=0;i<roomList.size();i++){
            Room room = roomList.get(i);
            if(room.getRoomGender().equals(1)){
                manRoom.add(room);
            }else{
                womanRoom.add(room);
            }
        }
        //按性别分配宿舍
        for(int i=0;i<stuList.size();i++){
            Student student = stuList.get(i);
            if(student.getStuGender()==1){
                for(int j=0;j<manRoom.size();j++){
                    Room room = manRoom.get(j);
                    if(room.getState().equals("1")){
                        stuInRoom(student,room);
                        number++;
                        j=womanRoom.size();
                    }
                }
            }else{
                for(int j=0;j<womanRoom.size();j++){
                    Room room = womanRoom.get(j);
                    if(room.getState().equals("1")){
                        stuInRoom(student,room);
                        number++;
                        j=womanRoom.size();
                    }
                }
            }
        }
        Result result = new Result();
        result.setData(number);
        result.setSuccess(true);
        result.setMessage("成功安排"+number+"个学生入住");
        return result;
    }
    //学生入宿
    public Result stuInRoom(Student student,Room room){
        Result result = new Result();
        if(student.getIsInDorm() == 0){
            student.setStuDorm(room.getDormNum());
            student.setStuRoom(room.getRoomNum());
            student.setIsInDorm(1);
            //更新学生信息
            studentDao.update(student);
            room.setCheckedInNum(room.getCheckedInNum()+1);
            room.setState(room.getBedsNum()==room.getCheckedInNum()?"0":"1");
            //更新宿舍信息
            roomDao.updateRoom(room);
            result.setSuccess(true);
            result.setMessage("入住成功");
            return result;
        }else{
            result.setSuccess(false);
            result.setMessage("此学生已经入住宿舍");
            return result;
        }

    }
    public Result getInDorm(){
        Result result = new Result();
        ArrayList<Student> arr = studentDao.getInDorm();
        result.setMessage("查询共有"+arr.size()+"条学生信息");
        result.setSuccess(true);
        result.setData(arr);
        return result;
    }
    public Result checkOut(List<Student>list){
        for(int i=0;i<list.size();i++){
            Student student = list.get(i);
            Room room = roomDao.getRoomById(student.getStuRoom());
            room.setCheckedInNum(room.getCheckedInNum()-1);
            room.setState(room.getState().equals('0')?"1":"1");
            roomDao.updateRoom(room);
            studentDao.checkOutStu(student);
        }
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage(list.size()+"名学生退宿成功");
        return result;
    }
    public Result selectAll(){
        Result result = new Result();
        List<Room>  arr =roomDao.selectAll();
        result.setMessage("查询共有"+arr.size()+"间宿舍房间信息");
        result.setSuccess(true);
        result.setData(arr);
        return result;
    }
    public Result deleteAny(List<Room> list){
        Result result =new Result();
        for(int i=0;i<list.size();i++){
            roomDao.deleteById(list.get(i).getRoomNum());
        }
        result.setMessage("删除共有"+list.size()+"间宿舍房间信息");
        return result;

    }
    public Result getNotFullRoom(String stuNum){
        Student stu = studentDao.getStuById(stuNum);
        Result result = new Result();
        if(stu == null){
            result.setMessage("查无此人，请检查学号是否输入错误");
            result.setSuccess(false);
            result.setData(null);
            return result;
        }else{
            List<Room> list = roomDao.getNotFullRoom();
            result.setSuccess(true);
            result.setData(list);
            result.setMessage("查询成功，共查询出"+list.size()+"条数据");
            return result;
        }
    }
    public Result change(Student student,Room room){
        Room room1 = roomDao.getRoomById(student.getStuRoom());
//        更新旧宿舍
        room1.setCheckedInNum(room1.getCheckedInNum()-1);
        room1.setState("1");
        roomDao.updateRoom(room1);
//        更新新宿舍
        room.setCheckedInNum(room.getCheckedInNum()+1);
        room.setState(room.getBedsNum()==room.getCheckedInNum()?"0":"1");
        roomDao.updateRoom(room);
//        更新学生信息
        student.setIsInDorm(1);
        student.setStuRoom(room.getRoomNum());
        studentDao.update(student);

        Result result = new Result();
        result.setMessage("成功将"+student.getStuName()+"调换宿舍"+room1.getRoomNum()+"至"+room.getRoomNum());
        return result;
    }
}
