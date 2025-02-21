var createError = require("http-errors");
var express = require("express");
var path = require("path");
var cookieParser = require("cookie-parser");
var logger = require("morgan");

var indexRouter = require("./routes/index");
var usersRouter = require("./routes/users");
const testRouter = require("./routes/test");

const { NacosNamingClient } = require("nacos");
const { address } = require("ip");
const logger1 = console;
// 动态获取本机 IP 地址
const ipAddr = address();
const port = 3001; // 当前应用的端口号
const username = "nacos";
const password = "nacos";
const providerServiceName = "edsp-component-app1"; // 服务名称
const nacosServerAddress = "localhost:8848"; // Nacos 服务地址

var app = express();

// view engine setup
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "jade");

app.use(logger("dev"));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, "public")));

app.use("/", indexRouter);
app.use("/users", usersRouter);
app.use(testRouter);

// catch 404 and forward to error handler
app.use(function (req, res, next) {
  next(createError(404));
});

// error handler
app.use(function (err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get("env") === "development" ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render("error");
});
const client = new NacosNamingClient({
  logger: logger1,
  serverList: nacosServerAddress,
  username: username,
  password: password,
  namespace: "public",
});
console.log("[Nacos] 注册Nacos服务");
async () => {
  const allinstance = await client.getAllInstances();
  console.log("[Nacos]----allinstance----", allinstance);
};
(async () => {
  try {
    await client.ready();
    // 注册服务和实例
    await client.registerInstance(providerServiceName, {
      ip: ipAddr,
      port,
    });
    // 这里也可以传入group，不传默认就是 DEFAULT_GROUP
    // const groupName = 'nodejs';
    // await client.registerInstance(providerServiceName, {
    // ip: ipAddr,
    // port
    // }, groupName);
    console.log(`[Nacos] Nacos服务注册实例成功: ${ipAddr}:${port}`);
  } catch (err) {
    console.log("[Nacos] Nacos服务注册实例失败: " + err.toString());
  }
})();
module.exports = app;
