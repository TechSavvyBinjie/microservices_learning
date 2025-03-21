const mysql = require("mysql2");
const config = require("./config").db;

const connection = mysql.createConnection(config);

connection.connect((err) => {
  if (err) {
    console.error("数据库连接失败：", err);
  } else {
    console.log("数据库连接成功！");
  }
});

connection.end((err) => {
  if (err) {
    console.error("关闭数据库连接失败：", err);
  } else {
    console.log("数据库连接已关闭。");
  }
});
