var createError = require("http-errors");
var express = require("express");
var path = require("path");
var cookieParser = require("cookie-parser");
var logger = require("morgan");

var indexRouter = require("./routes/index");
var usersRouter = require("./routes/users");
const testRouter = require("./routes/test");

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

module.exports = app;
// 导出启动服务器的异步函数
module.exports.startServer = async function () {
  const registerService = require("./service-discovery");

  try {
    // 调用 registerService 注册服务
    await registerService();
    console.log("服务已成功注册到 Nacos");

    // 服务注册成功后，启动 Express 服务器
    const PORT = process.env.PORT || 3001;
    app.listen(PORT, () => {
      console.log(`Express 服务器运行在 http://localhost:${PORT}`);
    });
  } catch (error) {
    console.error("服务注册失败：", error);
    process.exit(1); // 如果注册失败，退出进程
  }
};
