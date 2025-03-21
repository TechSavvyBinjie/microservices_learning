//api.js

const connection = require("./db");

//查询
const getAccount = () => {
  return new Promise((resolve, reject) => {
    //第一个参数：sql语句
    //第二个参数：回调函数（err：查询错误，data：查询结果）
    connection.query("select * from student", (err, data) => {
      resolve(data);
    });
  });
};
//添加
const insertAccount = (param) => {
  return new Promise((resolve, reject) => {
    connection.query(
      "insert into student(name,class) values(?,?)",
      [param.name, param.class],
      (err, data) => {
        //如果err为null则成功
        resolve(err);
      }
    );
  });
};
//改
const updateAccount = (param) => {
  return new Promise((resolve, reject) => {
    connection.query(
      "update student set class = ? where name = ?",
      [param.class, param.name],
      (err, data) => {
        //如果err为null则成功
        resolve(data);
      }
    );
  });
};

//删除
const deleteAccount = (param) => {
  return new Promise((resolve, reject) => {
    connection.query("delete from student where id = ?", param, (err, data) => {
      resolve(data);
    });
  });
};
//导出方法，在需要使用到的模块中导入
module.exports = {
  getAccount,
  insertAccount,
  updateAccount,
  deleteAccount,
};
